package org.javatigers.jersey.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.javatigers.jersey.model.DummyModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;;

@Api( value = "/sayhello")
@Path("/sayhello")
public class DemoService {

	
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "success"),
            @ApiResponse(code = 500, message = "error")
    })
	@ApiOperation(value = "Find pet by ID", 
		    notes = "Returns a single pet", 
		    response = DummyModel.class)
    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sayHello(@ApiParam(value ="Name of the person") @PathParam("name") String msg) {
    	DummyModel dummyModel = new DummyModel();
    	dummyModel.setName(msg);
    	dummyModel.setId(null);
        return Response.status(200).entity(dummyModel).build();
    }

}