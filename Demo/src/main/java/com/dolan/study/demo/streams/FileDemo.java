package com.dolan.study.demo.streams;

import com.dolan.study.demo.Person;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.nio.file.CopyOption;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;
import java.util.zip.CRC32;

/**
 * Created by fangqj on 2017/7/13.
 */
public class FileDemo {

    public  void go() throws IOException, ClassNotFoundException {
        Person person = new Person("he",12);
        Person person1 = new Person("hua",25);
        Person person2 = new Person("lan",67);

        Person[] staff = new Person[3];
        staff[0] = person;
        staff[1]=person1;
        staff[2]=person2;

        //unix文件系统用 / Windows用\
        Path absolute = Paths.get("/data11","my");
        Path relative1 = Paths.get("data","my");
        Path relative2 = Paths.get("data","my1");
        Path relative = Paths.get("data","my","user.txt");
        Path parent = relative.getParent();
        Path file = relative.getFileName();
        Path root = relative.getRoot();
        File file1 = file.toFile();//io
        Path file2 = file1.toPath();//nio
        relative.normalize();//移除诸如. ..等冗余路径元素

        //Files 文件操作
        if(Files.notExists(absolute)) {
            Files.createDirectories(absolute);
        }
        if(Files.notExists(relative1)) {
            Files.createDirectories(relative1);
        }
        if(Files.notExists(relative2)) {
            Files.createDirectories(relative2);
        }
        if(Files.notExists(relative)) {
            Files.createFile(relative);
        }

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/test_person.dat"))){
            out.writeObject(staff);
        }

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("data/test_person.dat"))){
            Person[] newStaff = (Person[])in.readObject();
            newStaff[1].setName("new hehe");
        }

        String data = "jofjoajweiojfoajeofjaoijfojawioejfiajweioj";
        //适合处理中等长度文本文件Files.write readAllBytes readAllLines
        //写
        Files.write(relative,data.getBytes(Charset.defaultCharset()), StandardOpenOption.APPEND);
        //取
        byte[] bytes = Files.readAllBytes(relative);
        String content = new String(bytes, Charset.defaultCharset());
        List<String> lines = Files.readAllLines(relative);

        //处理较大文件或二进制文件 还是用流或读入器写出器
        Path streamPath = Paths.get("data/userstream.txt");
        if(Files.notExists(streamPath)) {
            Files.createFile(streamPath);
        }
        InputStream in = Files.newInputStream(streamPath);
        OutputStream out = Files.newOutputStream(streamPath);
        Reader reader = Files.newBufferedReader(streamPath);
        Writer writer = Files.newBufferedWriter(streamPath);
        Path copyto = relative2.resolve("copyto.txt");
        Path moveto = relative2.resolve("moveto.txt");
        Files.copy(relative,copyto,StandardCopyOption.REPLACE_EXISTING);
        Files.move(relative,moveto,StandardCopyOption.REPLACE_EXISTING);

        //
        Files.createTempFile(relative2,"temp",".txt");
        long size = Files.size(copyto);
        UserPrincipal owner =  Files.getOwner(copyto);
        FileTime fileTime = Files.getLastModifiedTime(copyto);
        //文件尺寸，创建时间 修改时间 等
        BasicFileAttributes basicFileAttributes = Files.readAttributes(copyto,BasicFileAttributes.class);
        //兼容POSIX  组拥有者，拥有者，组 访问权限
        //PosixFileAttributes attributes = Files.readAttributes(copyto,PosixFileAttributes.class);
        System.out.println(basicFileAttributes);
        //System.out.println(attributes);

        //zip
        /*
        String zipName = "a.zip";
        FileSystem fs = FileSystems.newFileSystem(Paths.get(zipName),null);
        Files.walkFileTree(fs.getPath("/"),new SimpleFileVisitor<Path>(){
            public FileVisitResult visitFile(Path file,BasicFileAttributes attrs){
                System.out.println(file);
                return FileVisitResult.CONTINUE;
            }
            public FileVisitResult visitFileFailed(Path file,BasicFileAttributes attrs){
                return FileVisitResult.CONTINUE;
            }
        });
        */

        //内存映射文件
        //内存映射比使用缓冲的顺序输入快一点，比使用RandomAccessFile快很多
        //Nio
        //从文件获取通道，通道是磁盘文件的一种抽象
        FileChannel fileChannel = FileChannel.open(copyto);
        //通过调用通道的map方法 从通道获取一个ByteBuffer
        //FileChannel.MapMode.PRIVATE 缓冲区可写，但修改对缓冲区私有，不会反应到文件中
        //FileChannel.MapMode.READ_WRITE 缓冲区可写，修改会在某时刻写回文件
        //FileChannel.MapMode.READ_ONLY 缓冲区只读，任何写入都抛ReadOnlyBufferException
        ByteBuffer byteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE,0,fileChannel.size());
        //写入
        byteBuffer.putInt(14);
        //CRC32 java.util.zip.CRC32 计算一个字节序列的校验和
        CRC32 crc32 = new CRC32();
        while(byteBuffer.hasRemaining()){
            byte b = byteBuffer.get();
            crc32.update(b);
        }
        long checksum = crc32.getValue();
        int recordSize = 1000;
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(recordSize);
        FileChannel fileChannel1 = FileChannel.open(moveto);

        FileLock fileLock = fileChannel1.lock();
        fileChannel1.tryLock();
        fileLock.isShared();//共享锁 独占锁

        fileChannel1.read(byteBuffer1);
        int newpos = 10;
        fileChannel1.position(newpos);
        byteBuffer1.flip();//将界限设置到当前位置，把位置复位到0
        fileChannel1.write(byteBuffer1);
        byteBuffer1.capacity();//容量






    }

}
