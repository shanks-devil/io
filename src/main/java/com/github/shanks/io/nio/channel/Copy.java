package com.github.shanks.io.nio.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

public class Copy {
  public static void main(String[] args) {}

  @Test
  public void copy() throws IOException {
    File source = new File("source");
    File target = new File("copy");
    target.createNewFile();
    try {
      FileInputStream is = new FileInputStream(source);
      ByteBuffer buffer = ByteBuffer.allocate(1024);
      FileChannel readChannel = is.getChannel();
      FileOutputStream os = new FileOutputStream(target);
      FileChannel writeChannel = os.getChannel();
      while (true) {
        buffer.clear();
        int r = readChannel.read(buffer);
        if (r == -1) {
          break;
        }
        buffer.flip();
        writeChannel.write(buffer);
      }
      os.close();
      is.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
