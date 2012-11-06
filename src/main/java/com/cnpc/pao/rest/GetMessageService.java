package com.cnpc.pao.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import com.cnpc.pao.service.TestService;

 @Path("/messages")
 @Stateless
public class GetMessageService {
	 @Inject
	 TestService testService;
	 @GET
	   @Produces("application/json")
	    public List<com.cnpc.pao.model.Test> getAll(@Context UriInfo uriInfo) {
	        return getAll(uriInfo.getQueryParameters());
	    }
	 public List<com.cnpc.pao.model.Test> getAll(MultivaluedMap<String, String> queryParameters) {
		 return testService.getAllTests();
	    }


}
