package javabasereview.io;

import java.io.*;

/**
 * 字符流操作
 * 一个字符=两个字节
 * */
public class WriterReaderDemo3 {
    private static final String FILES_PATH = "D:"+ File.separator + "files_io";
    private static final String FILE_TEST_PATH = FILES_PATH+File.separator+"test.text";

    public static void main(String[] args) throws Exception{
        File file = new File(FILE_TEST_PATH);

        System.out.println("使用FileWriter追加内容 -->");
        Writer writer = new FileWriter(file,true);
        String str = "\r\n This is Writer function";
        writer.write(str);
        writer.close();

        System.out.println("使用FileReader读取内容 -->");
        Reader reader = new FileReader(file);
        char c[] = new char[1024];
        int length = reader.read(c);
        reader.close();
        System.out.println("内容读取结果：\r\n"+new String(c,0,length));

        System.out.println("使用循环的方式读取：-->");
        Reader reader1 = new FileReader(file);
        int len =0;
        char c1[] = new char[1024];
        int temp = 0;
        while ((temp = reader1.read())!=-1){
            c1[len] = (char) temp;
            len++;
        }
        reader1.close();
        System.out.println("内容为：\r\n"+new String(c1,0,len));
    }
}
