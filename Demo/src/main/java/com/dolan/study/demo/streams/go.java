package com.dolan.study.demo.streams;

import javax.sound.sampled.AudioInputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.FilterReader;
import java.io.FilterWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.PushbackInputStream;
import java.io.PushbackReader;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.io.StringBufferInputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.jar.JarInputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by fangqj on 2017/7/11.
 */
public class go {
    public void process(){
        //读写单个字节或字节数组
        InputStream inputStream;//抽象类，描述流的输入
        OutputStream outputStream;
        //读取数字和字符串
        DataInputStream dataInputStream;//读取Java标准数据类型的输入流
        DataOutputStream dataOutputStream;
        //zip
        ZipInputStream zipInputStream;
        ZipOutputStream zipOutputStream;
        GZIPInputStream gzipInputStream;
        JarInputStream jarInputStream;
        //extra
        AudioInputStream audioInputStream;
        ByteArrayInputStream byteArrayInputStream;//字节数组读取的输入流
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;//文件读入的输入流
        FileOutputStream fileOutputStream;
        PrintStream printStream;//包含最常见的Print（）和Println（）的输出流
        PushbackInputStream pushbackInputStream;//返回一个字节到输入流，主要用于编译器的实现
        PipedInputStream pipedInputStream;
        PipedOutputStream pipedOutputStream;//输出管道
        FilterInputStream filterInputStream;//实现了InputStream Interface
        FilterOutputStream filterOutputStream;
        SequenceInputStream sequenceInputStream;//将n个输入流联合起来，一个接一个按一定顺序读取
        RandomAccessFile randomAccessFile;//
        StringBufferInputStream stringBufferInputStream;
        BufferedInputStream bufferedInputStream;//缓冲输入流
        BufferedOutputStream bufferedOutputStream;
        ObjectInputStream objectInputStream;
        //ObjectInputStream --> ObjectInput interface -> DataInput -->RandomAccessFile
        //ObjectOutputStream-->ObjectOutPut ->DataOutput-->RandomAccessFile


        //Unicode文本 0~65535(2^16 -1)  读写使用Reader Writer子类
        //Reader
        BufferedReader bufferedReader; LineNumberReader lineNumberReader;
        CharArrayReader charArrayReader;
        FilterReader filterReader; PushbackReader pushbackReader;
        InputStreamReader inputStreamReader;FileReader fileReader;
        PipedReader pipedReader;
        StringReader stringReader;

        //Writer
        BufferedWriter bufferedWriter;
        CharArrayWriter charArrayWriter;
        FilterWriter filterWriter;
        OutputStreamWriter outputStreamWriter;FileWriter fileWriter;
        PipedWriter pipedWriter;
        PrintWriter printWriter;
        StringWriter stringWriter;

        //Closeable Flushable Readable Appendable
        //获取当前目录
        System.getProperty("user.dir");








    }
}
