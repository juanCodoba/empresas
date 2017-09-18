/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.javaee.byron.jpa.empresas.rest.service;

import co.javaee.byron.jpa.empresas.entities.DetalleCompras;
import co.javaee.byron.jpa.empresas.entities.Empresa;
import co.javaee.byron.jpa.empresas.sessions.DetalleComprasFacade;
import co.javaee.byron.jpa.empresas.sessions.EmpresaFacade;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adsi1199561
 */
@Path("detalleCompras")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DetalleComprasRest {
    
    @EJB
    private DetalleComprasFacade detalleComprasEJB;
    
    
    @EJB
    private  EmpresaFacade empresasEJB;
    
    @GET
    public List<DetalleCompras> findAll(){
       return detalleComprasEJB.findAll(); 
    }
    
    @GET
    @Path("{id}")
    public DetalleCompras findById(@PathParam("id")Integer id){
       return detalleComprasEJB.find(id); 
    }
    @POST
    public void create(@QueryParam("valorUnitario")double valorUnitario,
            @QueryParam("cantidad")Integer cantidad,
            @QueryParam("empresasId")Integer empresasId){

        try {
                    
        DetalleCompras newDetalleCompras = new DetalleCompras();
        Empresa empresa = empresasEJB.find(empresasId);
        //set 
        newDetalleCompras.setValorUnitario(valorUnitario);
        newDetalleCompras.setCantidad(cantidad);
        newDetalleCompras.setEmpresasId(empresa);
        
        
        //VALOR_COMPRA​ ​ = ​ ​ ​ CANTIDAD​ ​ * ​ ​ VALOR_UNITARIO
        newDetalleCompras.setValorCompra(newDetalleCompras.getCantidad() * newDetalleCompras.getValorUnitario());
        
        //VALOR_RETENCIÓN​ ​ = ​ ​ ​ VALOR_COMPRA​ ​ * ​ ​ PORCENTAJE_RETENCIÓN
        newDetalleCompras.setValorRetencion(calcularValorRetencion(newDetalleCompras.getValorCompra(),empresa.getIdRegimen().getId()));
        
        //VALOR_IMPUESTOS​ ​ = ​ ​ VALOR_COMPRA​ ​ * ​ ​ 19%
        newDetalleCompras.setValorIva(newDetalleCompras.getValorCompra() * 0.19);
        
        //VALOR_NETO_PAGAR​ ​ = ​ ​ VALOR_COMPRA​ ​ + ​ ​ VALOR_IVA​ ​ - ​ ​ VALOR_RETENCION
        
        newDetalleCompras.setValorNetoPagar(newDetalleCompras.getValorCompra()+
                newDetalleCompras.getValorIva()-
                newDetalleCompras.getValorRetencion()
                );
        
      
        detalleComprasEJB.create(newDetalleCompras);

        } catch (Exception e) {
            System.out.println("error"+  e);
        }

        
        
    }


    private double calcularValorRetencion(double valorCompra, String idTipoRegimen){
        double porcentajeDescuento = 0 ;
        
        if("SIMPLIFICADO".equals(idTipoRegimen)){
            porcentajeDescuento = valorCompra * 0.03;
        }
        if("COMUN".equals(idTipoRegimen)){
            porcentajeDescuento = valorCompra * 0.1;
       }
        if("GRAN CONTRIBUYENTE".equals(idTipoRegimen)){
            porcentajeDescuento = valorCompra * 0.11;
    }
       return porcentajeDescuento;
    }
      
}
