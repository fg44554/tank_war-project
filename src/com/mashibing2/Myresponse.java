package com.mashibing2;

import java.io.IOException;
import java.io.OutputStream;

public class Myresponse {
    OutputStream outputStream;
    public Myresponse(OutputStream outputStream){
    this.outputStream=outputStream;
    }
    StringBuilder builder=new StringBuilder();
    public void writer(String s) throws IOException {
        builder.append("HTTP/1.1 200 OK\n")
                .append("CONTENT_TYPE:text/html  charset=utf8\n")
                .append("\r\n")
                .append("<html>")
                .append("<body>")
                .append("<h1>"+s+"</h1>")
                .append("</body>")
                .append("<html>");
        this.outputStream.write(builder.toString().getBytes());
        this.outputStream.flush();
        this.outputStream.close();
    }

}
