package javabasereview.io;

import java.io.*;

public class OutputStreamWriterDemo4 {
    private static final String FILES_PATH = "D:"+ File.separator + "files_io";
    private static final String FILE_TEST_PATH = FILES_PATH+File.separator+"test.text";

    public static void main(String[] args) throws IOException {
        File file = new File(FILE_TEST_PATH);
        Writer writer = new OutputStreamWriter(new FileOutputStream(file));
        writer.append("字节输出流转为字符输出流保存到硬盘");
        writer.close();
    }
}
