// Copyright 2017, Luminate Wireless
// All rights reserved.
package com.cheez;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.ServletModule;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.DefaultResourceConfig;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.core.spi.component.ioc.IoCComponentProviderFactory;
import com.sun.jersey.guice.spi.container.GuiceComponentProviderFactory;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.UriBuilder;

public abstract class BaseTest {
  private static final int SERVER_PORT = TestUtils.pickUnusedPort();
  protected static final URI BASE_URI = getBaseURI();
  private HttpServer server;

  private static URI getBaseURI() {
    return UriBuilder.fromUri("http://localhost/").port(SERVER_PORT).build();
  }

  @Before
  public void startServer() throws Exception {
    Injector injector = Guice.createInjector(getModules());
    ResourceConfig rc = new DefaultResourceConfig();
    IoCComponentProviderFactory ioc = new GuiceComponentProviderFactory(rc, injector);
    server = GrizzlyServerFactory.createHttpServer(BASE_URI, rc, ioc);
  }

  @After
  public void stopServer() throws Exception {
    server.stop();
  }

  protected abstract List<Module> getModules();
}
