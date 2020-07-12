package com.mashibing2;

import java.io.IOException;

public class serverlet implements Httpserverlet {
    @Override
   public void doGet(Myresponse myresponse) throws IOException {
        myresponse.writer("getMethod");
    }
    @Override
   public void doPost(Myresponse myresponse) throws IOException {
        myresponse.writer("post");
    }
    public void service(Myrequest myrequest,Myresponse myresponse) throws IOException {
        if(GET.equals(myrequest.getMethod())){
            doGet(myresponse);
        }else if(POST.equals(myrequest.getMethod())){
            doPost(myresponse);
        }
    }
}
