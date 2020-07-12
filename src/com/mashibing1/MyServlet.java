package com.mashibing1;

public class MyServlet extends MyHttpServlet{
    @Override
    public void doGet(MyRequest request, MyResponse response) throws Exception {
        response.writer("mytomcat get");
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) throws Exception {
        response.writer("post tomcat");
    }
}
