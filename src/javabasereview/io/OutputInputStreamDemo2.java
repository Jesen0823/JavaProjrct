package javabasereview.io;

import java.io.*;

/**
 * 字节流操作
 */
public class OutputInputStreamDemo2 {
    private static String PATH_FILES = "d:" + File.separator + "files_io";
    private static final String PATH_FILE_TEST = PATH_FILES + File.separator + "test";
    private static final String FILE_TYPE = ".text";

    public static void main(String[] args) throws IOException {
        /**
         * OutputStream写入硬盘
         * */
        File file = new File(PATH_FILE_TEST + FILE_TYPE);
        OutputStream ops = new FileOutputStream(file);
        String input = "Today is Sunday.";
        byte b[] = input.getBytes();
        ops.write(b);
        ops.close();
        System.out.println("整个byte数组写入完成");

        System.out.println("一个字节一个字节地写入：-->");
        // 追加写入
        OutputStream ops2 = new FileOutputStream(file, true);
        String input2 = "\r\n one byte and one byte.";
        byte b2[] = input2.getBytes();
        for (int i = 0; i < b2.length; i++) {
            ops2.write(b2[i]);
        }
        ops2.close();

        /**
         * InputStream 读入内存
         * */
        InputStream ips = new FileInputStream(file);
        // 根据文件长度开辟数组大小
        byte b3[] = new byte[(int) file.length()];
        int length = ips.read(b3);
        ips.close();
        System.out.println("读取结果：\n" + new String(b3, 0, length));

        System.out.println("也可以一个字节一个字节读取：-->");
        InputStream ips2 = new FileInputStream(file);
        byte b4[] = new byte[(int) file.length()];
        for (int i = 0; i < b4.length; i++) {
            b4[i] = (byte) ips2.read();
        }
        ips2.close();
        System.out.println("内容为：" + new String(b4));

        System.out.println("不知道文件大小的时候，可以判断是否读到文件末尾：-->");
        InputStream ips3 = new FileInputStream(file);
        int len = 0;
        int temp = 0;
        byte b5[] = new byte[1024];
        while ((temp = ips3.read()) != -1) {
            b5[len] = (byte) temp;
            len++;
        }
        ips3.close();
        System.out.println("结果：\r\n" + new String(b5, 0, len));

    }
}
