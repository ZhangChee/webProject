// Copyright 2017, Luminate Wireless
// All rights reserved.
package com.cheez;

import com.google.inject.AbstractModule;

import com.cheez.hello.HelloModule;

public class AppModule extends AbstractModule {
  @Override
  protected void configure() {
    install(new HelloModule());
  }
}
