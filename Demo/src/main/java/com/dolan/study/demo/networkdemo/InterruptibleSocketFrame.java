package com.dolan.study.demo.networkdemo;

import org.omg.CORBA.PUBLIC_MEMBER;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by fangqj on 2017/7/14.
 */
public class InterruptibleSocketFrame extends JFrame {
    public static final int TEXT_ROWS=20;
    public static final int TEXT_COLUMNS=60;

    private Scanner in;
    private JButton interruptibleButton;
    private JButton blockingButton;
    private JButton cancelButton;
    private JTextArea messages;
    private SocketDemo socketDemo;
    private  Thread connectThread;

    public InterruptibleSocketFrame(){
        JPanel northPanel = new JPanel();
        add(northPanel, BorderLayout.NORTH);

        messages = new JTextArea(TEXT_ROWS,TEXT_COLUMNS);
        add(new JScrollPane(messages));

        interruptibleButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                interruptibleButton.setEnabled(false);
                blockingButton.setEnabled(false);
                cancelButton.setEnabled(true);
                connectThread = new Thread(new Runnable() {
                    @Override public void run() {
                        try {
                            connectInterruptibly();
                        } catch (IOException e1) {
                            messages.append("\nInterruptibleSocketDemo.connectInterruptibly:"+e1);
                        }
                    }
                });
                connectThread.start();
            }
        });

        blockingButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                interruptibleButton.setEnabled(false);
                blockingButton.setEnabled(false);
                cancelButton.setEnabled(true);
                connectThread = new Thread(new Runnable() {
                    @Override public void run() {
                        try{
                            connectBlocking();
                        }catch (IOException e){
                            messages.append("\nInterruptibleSocketDemo.connectBlocking"+e);
                        }
                    }
                });
                connectThread.start();
            }
        });
        cancelButton = new JButton("Cacel");
        cancelButton.setEnabled(false);
        northPanel.add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                connectThread.interrupt();
                cancelButton.setEnabled(false);
            }
        });



    }

    public void connectInterruptibly() throws IOException {
        messages.append("Interruptible:\n");
        try(SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8081))){
            in = new Scanner(channel);
            while(!Thread.currentThread().isInterrupted()){
                messages.append("Reading");
                if(in.hasNextLine()){
                    String line = in.nextLine();
                    messages.append(line);
                    messages.append("\n");
                }
            }
        }finally {
            EventQueue.invokeLater(new Runnable() {
                @Override public void run() {
                    messages.append("channle closed\n");
                    interruptibleButton.setEnabled(true);
                    blockingButton.setEnabled(true);
                }
            });
        }
    }

    public void connectBlocking() throws IOException {
        messages.append("Blocking\n");
        try(Socket socket = new Socket("127.0.0.1",8071)){
            in = new Scanner(socket.getInputStream());
            while(!Thread.currentThread().isInterrupted()){
                messages.append("Reading ");
                if(in.hasNextLine()){
                    String line = in.nextLine();
                    messages.append(line);
                    messages.append("\n");
                }
            }
        }
        finally {
            EventQueue.invokeLater(new Runnable() {
                @Override public void run() {
                    messages.append("Socket closed\n");
                    interruptibleButton.setEnabled(true);
                    blockingButton.setEnabled(true);
                }
            });
        }
    }

    class SocketServerDemo implements Runnable {

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
                ServerSocket serverSocket = new ServerSocket(8081);
                while(true){
                    Socket incoming = serverSocket.accept();
                    Runnable runnable = new SocketRunnable(incoming);
                    Thread t = new Thread(runnable);
                    t.start();
                }
            }
            catch (IOException e) {
                messages.append("\nSocketServerDemo.run"+e);
            }
        }
    }

    class SocketServerHandler implements Runnable{

        public SocketServerHandler(Socket s){
            incoming = s;
        }
        private Socket incoming;
        private int counter;
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

            OutputStream outputStream = null;
            try {
                try {
                    outputStream = incoming.getOutputStream();
                    PrintWriter out = new PrintWriter(outputStream, true);
                    while (counter < 100) {
                        counter++;
                        if (counter <= 100) {
                            out.println(counter);
                        }
                        Thread.sleep(100);
                    }
                }
                finally {
                    if(incoming!=null) incoming.close();
                    messages.append("Closing server \n");
                }
            } catch (Exception e) {
                e.printStackTrace();
                messages.append("SocketServerHandler.run:"+e);
            }
        }
    }



}
