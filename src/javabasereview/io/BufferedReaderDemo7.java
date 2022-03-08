package javabasereview.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 键盘输入
 * */
public class BufferedReaderDemo7 {
    private BufferedReader bufferedReader = null;

    BufferedReaderDemo7(){
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    }

    public String getString(String info) throws IOException {
        String temp = null;
        System.out.println(info);
        temp = this.bufferedReader.readLine();
        return temp;
    }

    public float getFloat(String info, String err) throws IOException {
        float temp = 0;
        String str = null;
        boolean flag =false;
        while (flag){
            str = this.getString(info);
            if (str.matches("^\\d+.?\\d+$")){
                temp = Float.parseFloat(str);
                flag = false;
            }else {
                System.out.println(err);
            }
        }
        return temp;
    }

    public Date getDate(String info, String err) throws IOException {
        Date date = null;
        String str = null;
        boolean flag = true;
        while (flag){
            str = this.getString(info);
            if (str.matches("^\\d{4}-\\d{2}-\\d{2}$")){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    date = sdf.parse(str);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                flag = false;
            }else {
                System.out.println(err);
            }
        }
        return date;
    }

    public static void main(String[] args) throws IOException {
        float i =0;
        float j = 0;
        BufferedReaderDemo7 bufferedReaderDemo7 = new BufferedReaderDemo7();
        i = bufferedReaderDemo7.getFloat("first number:","ERROR! please input again");
        j = bufferedReaderDemo7.getFloat("second number:","ERROR! please input again");
        System.out.println("相加等于："+(i+j));

    }
}
