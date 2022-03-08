package javabasereview.io;

import javabasereview.io.bean.Person2;

import java.io.*;

/**
 * 自定义序列化反序列化的内容
 * */
public class ExternalizableDemo15 {
    private static final String PATH_FILE_PERSON = "d:" + File.separator + "files_io" + File.separator+"bean.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File(PATH_FILE_PERSON);
        if (!file.exists()){
            file.createNewFile();
        }

        // 序列化
        OutputStream ops = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(ops);
        oos.writeObject(new Person2("卡夫卡",70.2f,181));
        oos.close();

        //反序列化
        InputStream ins = new FileInputStream(file);
        ObjectInputStream oIns = new ObjectInputStream(ins);
        Object obj = oIns.readObject();
        Person2 person2 = (Person2) obj;
        person2.setName("丘吉尔");
        oIns.close();
        System.out.println(person2);
    }
}
