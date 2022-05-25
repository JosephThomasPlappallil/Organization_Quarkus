package org.strebentechnik.organization;

import java.util.Objects;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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

     // Update organization
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateOrganization(@PathParam("id") Long id, Organization organization) {
        OrganizationEntity organizationEntity = OrganizationEntity.findById(id);

        if (Objects.nonNull(organization.getName())) {
            organizationEntity.name = organization.getName();
        }
        if (Objects.nonNull(organization.getParentCode())) {
            organizationEntity.parentCode = organization.getParentCode();
        }
        if (Objects.nonNull(organization.getCode())) {
            organizationEntity.code = organization.getCode();
        }
        if (Objects.nonNull(organization.getParentId())) {
            organizationEntity.parentId = organization.getParentId();
        }
        if (Objects.nonNull(organization.getShortName())) {
            organizationEntity.shortName = organization.getShortName();
        }
        if (Objects.nonNull(organization.getTaxIdentifier())) {
            organizationEntity.taxIdentifier = organization.getTaxIdentifier();
        }
        if (Objects.nonNull(organization.getDetails())) {
            organizationEntity.details = organization.getDetails();
        }
        if (Objects.nonNull(organization.getCreatedBy())) {
            organizationEntity.createdBy = organization.getCreatedBy();
        }
        if (Objects.nonNull(organization.getUpdatedBy())) {
            organizationEntity.updatedBy = organization.getUpdatedBy();
        }
        if (Objects.nonNull(organization.getCreatedAt())) {
            organizationEntity.createdAt = organization.getCreatedAt();
        }
        if (Objects.nonNull(organization.getUpdatedAt())) {
            organizationEntity.updatedAt = organization.getUpdatedAt();
        }
        return Response.noContent().build();
    }

    
}
