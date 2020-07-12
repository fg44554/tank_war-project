package com.mashibing2;

import java.io.IOException;

public interface  Httpserverlet {
     final String GET="GET";
     final String POST="POST";
   public void doGet(Myresponse myresponse) throws IOException ;
   public void doPost(Myresponse myresponse) throws IOException ;
    public void service(Myrequest myrequest,Myresponse myresponse) throws IOException ;
}
