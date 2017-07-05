// Copyright 2017, Luminate Wireless
// All rights reserved.
package com.cheez;

import java.io.IOException;
import java.net.ServerSocket;

public class TestUtils {
  public static int pickUnusedPort() {
    try {
      ServerSocket socket = new ServerSocket(0);
      int port = socket.getLocalPort();
      socket.close();
      return port;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
