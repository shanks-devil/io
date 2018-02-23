package com.github.shanks.io.nio.buffer;

import java.nio.ByteBuffer;

import org.junit.Test;

public class ByteBufferTest {

  @Test
  public void buffer() {
    ByteBuffer buffer = ByteBuffer.allocate(10); // 设置limit
    for (int i = 9; i < buffer.capacity(); i++) {
      System.out.println("put value " + new Integer(i).byteValue());
      buffer.put(new Integer(i).byteValue()); // position++
    }
    buffer.flip(); // limit = position; position = 0
    while (buffer.hasRemaining()) { // position < limit
      byte f = buffer.get(); // position++
      System.out.println(f);
    }
  }
}
