package com.dolan.study.demo.networkdemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by fangqj on 2017/7/13.
 */
public class SocketRunnable implements Runnable {

    public SocketRunnable(Socket in){
        socket = in;
    }
    Socket socket;
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override public void run() {
        try{
            try {
                InputStream inStream = socket.getInputStream();
                OutputStream outStream = socket.getOutputStream();

                Scanner in = new Scanner(inStream);
                PrintWriter out = new PrintWriter(outStream, true/*autoflush*/);

                out.println("Hello! Enter byte to exit");
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    out.println("Echo:" + line);
                    if (line.trim().equals("byte")) {
                        break;
                    }
                }
            }finally {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
