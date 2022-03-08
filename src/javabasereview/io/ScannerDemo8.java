package javabasereview.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerDemo8 {
    private static final String FILES_PATH = "D:"+ File.separator + "files_io";
    private static final String FILE_TEST_PATH = FILES_PATH+File.separator+"test.text";

    public static void main(String[] args) throws FileNotFoundException {
        /*Scanner scanner =new Scanner(System.in);
        int arg1 = 0;
        float arg2 =0.0f;
        System.out.println("输入整数：-->");
        if (scanner.hasNextInt()){
            arg1 =scanner.nextInt();
            System.out.println("收到："+arg1);
        }else {
            System.out.println("重新输入");
            return;
        }
        System.out.println("请输入小数：-->");
        if (scanner.hasNextFloat()){
            arg2 = scanner.nextFloat();
            System.out.println("收到："+arg2);
        }else {
            System.out.println("输入数据非小数");
            return;
        }*/

        /**
         * 从文件得到数据
         * */
        File file = new File(FILE_TEST_PATH);
        Scanner scanner1 = new Scanner(file);
        StringBuffer buffer = new StringBuffer();
        while (scanner1.hasNext()){
            buffer.append(scanner1.next()).append("\n");
        }
        System.out.println("文件内容：-->\n");
    }
}
