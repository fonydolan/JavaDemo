package com.dolan.common.utility.Stream;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class InOutputStream {

	public void test() throws IOException
	{
		InputStream inStream;
		OutputStream outStream;
		
		PrintWriter outPW;
		outPW = new PrintWriter("test.txt");
		outPW = new PrintWriter(new FileWriter("test.txt"));
		
		
	}
	
}
