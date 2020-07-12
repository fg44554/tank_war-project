package com.mashibing2;

import java.io.IOException;
import java.io.InputStream;

public class Myrequest {
        private String method;
        private String url;
    public  Myrequest(InputStream inputStream) throws IOException {
        byte[] bytes = new byte[1024];
        int len=0;
        String str=null;
        if((len=inputStream.read(bytes))>0){
           str= new String(bytes,0,len);
        }
        String data = str.split("\n")[0];
        String[] msg = data.split(" ");
        this.method = msg[0];
        this.url = msg[1];
    }

    public String getUrl() {
        return url;
    }
    public String getMethod() {
        return method;
    }
}
