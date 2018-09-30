package com.alibaba.ClientDemo;

import java.io.*;
import java.net.Socket;

public class Main {
    /**
     * 客户端
     * 建立与服务器的连接
     * 向服务器传输数据
     * 输出服务器的返回
     */

    public static void main(String[] args) throws IOException {
        // 服务器主机地址
        String host = "127.0.0.1";
        // 服务器端口地址
        int port = 9527;
        // 建立socket
        Socket socket = new Socket(host, port);
        // 接受服务器的返回
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // 向服务器输出内容
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        // 客户端输入
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Boolean flag = true;
        while (flag) {
            String userInput = input.readLine();
            System.out.println("User input: " + userInput);
            // 用户退出客户端
            if (userInput.startsWith("quit")) {
                flag = false;
                input.close();
                in.close();
                out.close();
                continue;
            }
            // 向服务端输出
            out.println(userInput);
            String res = in.readLine();
            System.out.println("Server res: " + res);
        }
    }
}
