package com.github.shanks.io.nio.channel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

public class FileWriterTest {

  @Test
  public void writeFile() throws IOException {
    File file = new File("helloword_2");
    file.createNewFile();
    try (FileOutputStream os = new FileOutputStream(file)) {
      FileChannel channel = os.getChannel();
      ByteBuffer buffer = ByteBuffer.allocate(1024);
      buffer.put("hello world NIO!!!".getBytes());
      buffer.flip();
      channel.write(buffer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
