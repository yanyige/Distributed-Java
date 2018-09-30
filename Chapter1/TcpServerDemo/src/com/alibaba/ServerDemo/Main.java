package com.alibaba.ServerDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    /**
     * 服务端
     * 处理客户端的请求
     * 向客户端传输数据
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // 服务器监听的端口
        int port = 9527;
        ServerSocket serverSocket = new ServerSocket(port);
        // 服务器端socket
        Socket socket = serverSocket.accept();
        // 服务器端的输入
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // 服务器端的输出
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        while(true) {
            String line = in.readLine();
            if( line == null ) {
                Thread.sleep(100);
                continue;
            }
            if ("quit".equalsIgnoreCase(line.trim())) {
                in.close();
                out.close();
                serverSocket.close();
                System.out.println("Server has been done");
                System.exit(0);
            } else {
                System.out.println("Listen from client: " + line);
                out.println("server response" + line);
                Thread.sleep(100);
            }
        }
    }
}
