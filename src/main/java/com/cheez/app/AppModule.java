// Copyright 2017, Luminate Wireless
// All rights reserved.
package com.cheez.app;

import com.google.inject.AbstractModule;

import com.cheez.hello.modules.HelloModule;

public class AppModule extends AbstractModule {
  @Override
  protected void configure() {
    install(new HelloModule());
  }
}
