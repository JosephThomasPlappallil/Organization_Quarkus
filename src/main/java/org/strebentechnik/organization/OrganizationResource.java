package org.strebentechnik.organization;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/organization")
@Tag(name="Organizations")
public class OrganizationResource {

     // Create Organization
     @POST
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.APPLICATION_JSON)
     @Transactional
     public Response createOrganization(OrganizationEntity organizationEntity) {
         organizationEntity.persist();
         return Response.status(Status.CREATED).build();
     }
     
 
     // Get all Organizations
     @GET
     @Produces(MediaType.APPLICATION_JSON)
     public Response listAllOrganiations() {
         return Response.ok(OrganizationEntity.listAll()).build();
     }
 
     // Get Organization by ID
     @Path("/{id}")
     @GET
     @Produces(MediaType.APPLICATION_JSON)
     public Response getOrganizationById(@PathParam("id") Long id) {
         OrganizationEntity organizationEntity = OrganizationEntity.findById(id);
         return Response.ok(organizationEntity).build();
     }
 
     // Delete Organization by ID
     @Path("/{id}")
     @DELETE
     @Produces(MediaType.APPLICATION_JSON)
     @Transactional
     public Response deleteOrganization(@PathParam("id") Long id) {
         OrganizationEntity.deleteById(id);
         return Response.noContent().build();
     }


    
}
