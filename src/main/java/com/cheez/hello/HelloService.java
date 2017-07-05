// Copyright 2017, Luminate Wireless
// All rights reserved.
package com.cheez.hello;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("hello")
public class HelloService {
  private Hello hello;

  @Inject
  public HelloService(Hello hello) {
    this.hello = hello;
  }

  @GET
  public String getHelloMsg() {
    return hello.getMsg();
  }
}
