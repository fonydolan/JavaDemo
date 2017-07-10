package com.dolan.study.demo.base;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by fangqj on 2017/7/10.
 */
public class FileUtils {
    public  static boolean search(File file,String keyword){
        try (Scanner in = new Scanner(file)){
            boolean found = false;
            while(!found && in.hasNextLine()){
                String line = in.nextLine();
                if(line.contains(keyword))found = true;
            }
            return found;
        } catch (IOException e) {
            return  false;
        }
    }
}
