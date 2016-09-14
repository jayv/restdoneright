package com.livefyre.rest


import javax.ws.rs.core.MediaType
import javax.ws.rs.{GET, Path, Produces}

@Path("/demo/")
@Produces(Array(MediaType.APPLICATION_JSON))
trait DemoResource {

  @GET
  @Path("/status/")
  def status(): StatusModel

}
