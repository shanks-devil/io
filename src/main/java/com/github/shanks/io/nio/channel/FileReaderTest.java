package com.github.shanks.io.nio.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

public class FileReaderTest {

  @Test
  public void readFile() {
    File file = new File("helloword");
    try (FileInputStream is = new FileInputStream(file)) {
      FileChannel channel = is.getChannel();
      ByteBuffer buffer = ByteBuffer.allocate(1024);
      channel.read(buffer);
      buffer.flip();
      while (buffer.hasRemaining()) {
        byte value = buffer.get();
        System.out.println(value);
      }
    } catch (IOException e1) {
      e1.printStackTrace();
    }
  }
}
