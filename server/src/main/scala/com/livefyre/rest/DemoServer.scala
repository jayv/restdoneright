
package com.livefyre.rest

import javax.annotation.{ManagedBean, PostConstruct}
import javax.inject.Singleton

import com.livefyre.tools.jersey.WebServer
import com.livefyre.tools.scala.Logging

@Singleton
@ManagedBean
class DemoServer extends DemoResource with Logging {

  private val startTime = System.currentTimeMillis()

  private var web: WebServer = new WebServer(9999)

  @PostConstruct
  def start(): Unit = {
    web.start()
    logger.info("REST Demo server started - Woop woop!")
  }

  def status(): StatusModel = {
    logger.info("Client requested status")
    StatusModel(200, s"This service started ${System.currentTimeMillis() - startTime}ms ago")
  }

}
