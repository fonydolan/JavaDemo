package com.dolan.study.demo.networkdemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.util.Scanner;


/**
 * Created by fangqj on 2017/7/13.
 */
public class SocketDemo {

    public  void serverGo() throws IOException {
        //使用流读取，简单网络可以使用。复杂的网络服务器中可能会服务器响应结束时并不立刻断开连接
        try(Socket s = new Socket("127.0.0.1",13)){
            s.setSoTimeout(10000);
            InputStream inputStream = s.getInputStream();
            Scanner in = new Scanner(inputStream);
            while(in.hasNextLine()){
                String line = in.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1",8088),10000);
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        byte[] addressBytes = inetAddress.getAddress();
        InetAddress[] inetAddresses = InetAddress.getAllByName("www.baidu.com");
        InetAddress.getLocalHost();

        //服务器端
        ServerSocket serverSocket = new ServerSocket(8088);
        Socket incoming = serverSocket.accept();//监测
        InputStream inStream = incoming.getInputStream();
        OutputStream outStream = incoming.getOutputStream();

        Scanner scanner = new Scanner(inStream);
        PrintWriter out = new PrintWriter(outStream,true/* autoFlush */);
        out.println("Hello Enter bye to exit");
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            out.println("Echo:" + line);
            if (line.trim().equals("bye")) {
                incoming.close();
                break;
            }
        }

        //d多服务
        Socket incoming1 = serverSocket.accept();
        Runnable runnable = new SocketRunnable(incoming1);
        Thread t = new Thread(runnable);
        t.start();

        //半关闭 half-close 一端终止输出 但可以接收来自另一端的数据

    }

    public void clientGo() throws IOException {
        //可中断套接字 利用SocketChannel channel缓冲区
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8088));
        //转成输出流
        Scanner in = new Scanner(channel);
        OutputStream outputStream = Channels.newOutputStream(channel);
    }


}
