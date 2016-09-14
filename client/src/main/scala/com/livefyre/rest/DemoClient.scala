package com.livefyre.rest

import javax.annotation.PostConstruct
import javax.inject.{Inject, Singleton}
import javax.ws.rs.client.ClientBuilder

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider
import com.livefyre.tools.scala.Logging
import org.glassfish.jersey.client.proxy.WebResourceFactory

@Singleton
class DemoClient extends Logging {

  @Inject
  var jacksonJsonProvider:JacksonJsonProvider = _

  @PostConstruct
  def start(): Unit = {

    logger.info("com.livefyre.rest.DemoClient starting...")

    val client = ClientBuilder.newClient().register(jacksonJsonProvider, 0).target("http://localhost:9999/")
    val resource = WebResourceFactory.newResource(classOf[DemoResource], client)

    // will make a bunch of GET reqs to: http://localhost:9999/demo/status/
    for (i <- 1 to 20) {
      val status: StatusModel = resource.status()
      logger.info("Server response #{}: Code: {} Message: {}", i.toString, status.code.toString, status.message)
    }

  }

}
