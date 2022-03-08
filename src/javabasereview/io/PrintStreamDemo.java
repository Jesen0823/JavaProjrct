package javabasereview.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 字节打印流输出
 * */
public class PrintStreamDemo{
    private static final String FILE_PATH = "D:"+ File.separator + "files_io"+File.separator+"test.text";

    public static void main(String[] args) throws Exception {
        PrintStream ps = new PrintStream(new FileOutputStream(new File(FILE_PATH)));
        ps.printf("省份：%S|代号：%d|GDP:%f(万元)","重庆",1001,42.3f);
        ps.close();
    }
}
