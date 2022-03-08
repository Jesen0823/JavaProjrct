package javabasereview.io;

import java.io.*;

/**
 * 合并流
 * */
public class SequenceInputStreamDemo10 {
    private static String PATH_FILES = "d:" + File.separator + "files_io"+File.separator;
    private static final String PATH_FILE_1= PATH_FILES  + "test.text";
    private static final String PATH_FILE_2= PATH_FILES  + "test2.txt";
    private static final String PATH_FILE_RESULT= PATH_FILES  + "test2_test.txt";

    public static void main(String[] args) throws IOException {
        SequenceInputStream sis = null;
        InputStream ins1 = new FileInputStream(PATH_FILE_1);
        InputStream ins2 = new FileInputStream(PATH_FILE_2);
        OutputStream os  = new FileOutputStream(PATH_FILE_RESULT);
        sis = new SequenceInputStream(ins1,ins2);
        int temp = 0;
        while ((temp = sis.read() )!= -1){
            os.write(temp);
        }
        sis.close();
        ins1.close();
        ins2.close();
        os.close();
    }
}
