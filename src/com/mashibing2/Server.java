package com.mashibing2;

import com.mashibing1.MyHttpServlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void port(int port)
            throws Exception{
        Httpserverlet serverlet1 = new serverlet();
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket=null;
        while(true) {
            socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            Myrequest myrequest = new Myrequest(inputStream);
            Myresponse myresponse = new Myresponse(outputStream);
//            String clazz = Mapping.getMap().get(myrequest.getUrl());
//            if(clazz!=null){
//                Class<serverlet> aClass = (Class<serverlet>) Class.forName(clazz);
//                serverlet serverlet = aClass.getDeclaredConstructor().newInstance();
                serverlet1.service(myrequest, myresponse);
            }
//        }
    }
    public static void main(String[] args) throws Exception {
        port(10087);
    }
}
