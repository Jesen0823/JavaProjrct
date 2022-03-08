package javabasereview.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 内存操作流
 * */
public class ByteArrayDemo6 {
    public static void main(String[] args) {
        String str = "HHHHHHHHH";
        ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes()); //保存到内存
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); // 从内存读取
        int temp = 0;
        while ((temp = bais.read() )!= -1){
            char c = (char) temp;
            baos.write(Character.toLowerCase(c));
        }
        String string = baos.toString();
        try {
            bais.close();
            baos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(string);
    }
}
