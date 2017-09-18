/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.javaee.byron.jpa.empresas.rest.service;

import co.javaee.byron.jpa.empresas.entities.RegimenEmpresa;
import co.javaee.byron.jpa.empresas.sessions.RegimenEmpresaFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author adsi1199561
 */
@Path("RegimenEmpresas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RegimenEmpresaRest {
    
        @EJB
    private RegimenEmpresaFacade detalleComprasEJB;
    
    
    
    @GET
    public List<RegimenEmpresa> findAll(){
       return detalleComprasEJB.findAll(); 
    }
    
    @GET
    @Path("{id}")
    public RegimenEmpresa findById(@PathParam("id")Integer id){
       return detalleComprasEJB.find(id); 
    }
    @POST
    public Response create(RegimenEmpresa regimenEmpresa){
        
                    GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

       

        try {
            detalleComprasEJB.create(regimenEmpresa);
            return Response.status(Response.Status.OK)
                    .entity(gson.toJson("El regimen fue creado  exitosamente!"))
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(gson.toJson("Error el regimen no fue creado!"))
                    .build();
        }

        
    }
}
