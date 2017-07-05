// Copyright 2017, Luminate Wireless
// All rights reserved.
package com.cheez.hello;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class HelloModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(HelloService.class);
  }

  @Provides
  @Singleton
  public Hello provideHello() {
    return new Hello() {
      @Override
      public String getMsg() {
        return "hello";
      }
    };
  }
}
