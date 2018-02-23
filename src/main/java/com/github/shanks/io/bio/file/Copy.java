package com.github.shanks.io.bio.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class Copy {

  @Test
  public void copy() throws IOException {
    File source = new File("source");
    File target = new File("copy");
    target.createNewFile();
    FileInputStream is = new FileInputStream(source);
    FileOutputStream os = new FileOutputStream(target);
    while (true) {
      int i = is.read();
      if (i == -1) {
        break;
      }
      os.write(i);
    }
    is.close();
    os.close();
  }

  @Test
  public void bufferCopy() throws IOException {
    long start = System.currentTimeMillis();
    File source = new File("source");
    File target = new File("copy");
    target.createNewFile();
    BufferedReader br = new BufferedReader(new FileReader(source));
    BufferedWriter bw = new BufferedWriter(new FileWriter(target));
    String line = null;
    while ((line = br.readLine()) != null) {
      bw.write(line, 0, line.length());
      bw.newLine();
    }
    bw.flush();
    br.close();
    bw.close();
    long cost = System.currentTimeMillis() - start;
    System.out.println("使用：" + cost + "毫秒");
  }
}
