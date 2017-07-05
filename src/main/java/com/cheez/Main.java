// Copyright 2017, Luminate Wireless
// All rights reserved.
package com.cheez;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

import com.cheez.app.AppModule;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class Main extends GuiceServletContextListener {
  static final String SERVLET_PATH = "/api/*";

  @Override
  protected Injector getInjector() {
    return Guice.createInjector(new AppModule(), new ServletModule() {
      @Override
      protected void configureServlets() {
        ResourceConfig rc = new PackagesResourceConfig("com.cheez.service");
        for (Class<?> resource : rc.getClasses()) {
          bind(resource);
        }
        serve(SERVLET_PATH).with(GuiceContainer.class);
      }
    });
  }
}
