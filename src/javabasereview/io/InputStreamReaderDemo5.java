package javabasereview.io;

import java.io.*;

public class InputStreamReaderDemo5 {
    private static final String FILES_PATH = "D:"+ File.separator + "files_io";
    private static final String FILE_TEST_PATH = FILES_PATH+File.separator+"test.text";

    public static void main(String[] args) throws IOException {
        File file = new File(FILE_TEST_PATH);
        // 字节输入流转为字符输入流
        Reader reader = new InputStreamReader(new FileInputStream(file));
        char c[] = new char[1024];
        int len = reader.read(c);
        reader.close();
        System.out.println(new String(c,0,len));
    }
}
