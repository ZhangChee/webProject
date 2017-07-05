// Copyright 2017, Luminate Wireless
// All rights reserved.
package com.cheez.hello;

import com.google.inject.Module;

import com.cheez.BaseTest;
import com.cheez.hello.HelloModule;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class HelloServiceTest extends BaseTest {
  @Test
  public void testHello() {
    Client client = Client.create(new DefaultClientConfig());
    WebResource service = client.resource(BASE_URI);
    ClientResponse resp = service.path("hello").get(ClientResponse.class);
    String text = resp.getEntity(String.class);
    Assert.assertEquals(200, resp.getStatus());
    Assert.assertEquals("hello", text);
  }

  @Override
  protected List<Module> getModules() {
    return Collections.singletonList(new HelloModule());
  }
}
