/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.javaee.byron.jpa.empresas.rest.service;


import co.javaee.byron.jpa.empresas.entities.Empresa;
import co.javaee.byron.jpa.empresas.sessions.EmpresaFacade;
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
@Path("Empresas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmpresaRest {
        @EJB
    private EmpresaFacade empresasEJB;
    
    
    
    @GET
    public List<Empresa> findAll(){
       return empresasEJB.findAll(); 
    }
    
    @GET
    @Path("{id}")
    public Empresa findById(@PathParam("id")Integer id){
       return empresasEJB.find(id); 
    }
    @POST
    public Response create(Empresa empresa){
            GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

       

        try {
            empresasEJB.create(empresa);
            return Response.status(Response.Status.OK)
                    .entity(gson.toJson("la empresa fue creada exitosamente!"))
                    .build();
        } catch (Exception e) {
            return  Response.status(Response.Status.BAD_REQUEST)
                    .entity(gson.toJson("Error la empresa  no fue creada!"))
                    .build();
        }

    }
}
