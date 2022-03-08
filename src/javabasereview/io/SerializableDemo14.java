package javabasereview.io;

import javabasereview.io.bean.Person;

import java.io.*;

/**
 * 序列化和反序列化
 * */
public class SerializableDemo14 {
    private static final String PATH_FILE_PERSON = "d:" + File.separator + "files_io" + File.separator+"bean.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File(PATH_FILE_PERSON);
        if (!file.exists()){
            file.createNewFile();
        }
        // 序列化
        OutputStream ops = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(ops);
        oos.writeObject(new Person("奥巴马",68.0f,178));
        oos.close();

        //反序列化
        ObjectInputStream oIns = null;
        InputStream ins = new FileInputStream(file);
        oIns = new ObjectInputStream(ins);
        Object obj = oIns.readObject();
        oIns.close();
        System.out.println(obj);


    }

}
