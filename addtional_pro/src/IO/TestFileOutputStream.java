package IO;

import java.io.*;
//把f:/java/TestInput.txt中的内容读出后写入f:/java/TestOutput.txt
public class TestFileOutputStream {
	public static void main(String[] args) {
		int b = 0;
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			try {
				in = new FileInputStream("h:/ftp/allChannelMonitor.jsp");
			} catch (FileNotFoundException e2) { 
				System.out.println("Original File not found"); System.exit(-1);
			}
			try {
				out = new FileOutputStream("f:/java/TestOutput.txt");
			} catch (FileNotFoundException e3) { 
				System.out.println("Aim File not found"); System.exit(-1);
			}
			while ((b = in.read())!= -1){
				out.write(b);
			}
			in.close();
			out.close();
		} catch (IOException e1) {
			System.out.println("Wrong copy operation"); System.exit(-1);
			// TODO: handle exception
		}
		System.out.println("Copy finished");
	}
}
