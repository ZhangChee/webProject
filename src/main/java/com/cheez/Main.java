// Copyright 2017, Luminate Wireless
// All rights reserved.
package com.cheez;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class Main extends GuiceServletContextListener {
  static final String SERVLET_PATH = "/api/*";

  @Override
  protected Injector getInjector() {
    return Guice.createInjector(new AppModule(), new ServletModule() {
      @Override
      protected void configureServlets() {
        serve(SERVLET_PATH).with(GuiceContainer.class);
      }
    });
  }
}
