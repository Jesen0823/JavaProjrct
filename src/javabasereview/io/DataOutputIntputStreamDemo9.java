package javabasereview.io;

import java.io.*;

/**
 * 平台无关数据操作流DataOutputStream DataInputStream
 * */
public class DataOutputIntputStreamDemo9 {
    private static final String FILE_PATH = "D:"+ File.separator+"files_io"+File.separator+"test2.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(FILE_PATH);
        if (!file.exists()){
            file.createNewFile();
        }
        // 保存
        DataOutputStream dos = null;
        dos = new DataOutputStream(new FileOutputStream(file));
        String names[] = {"你爸","尼玛","你姐"};
        float weights[] = {70.f,65.f,58.f};
        int nums[] = {3,2,1};
        for (int i = 0; i < names.length;i++){
            dos.writeChars(names[i]);
            dos.writeChar('\t');
            dos.writeFloat(weights[i]);
            dos.writeChar('\t');
            dos.writeInt(nums[i]);
            dos.writeChar('\t');
        }
        dos.close();

        // 读取
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        String name = null;
        float weight = 0.0f;
        int num = 0;
        char temp[] = null;
        char c = 0;
        int len = 0;
        while (true){
            temp = new char[1024];
            len = 0;
            while ((c = dis.readChar())!='\t'){
                temp[len] = c;
                len++;
            }
            name = new String(temp,0,len);
            weight = dis.readFloat();
            char c1 = dis.readChar();
            num = dis.readInt();
            dis.readChar();
            System.out.printf("人物：%s\t体重：%5.2f\t数量：%d\n",name,weight,num);
        }
    }
}
