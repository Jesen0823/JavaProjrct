package javabasereview.io;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class FileDemo1 {
    private static String PATH_FILES = "d:" + File.separator + "files_io";
    private static final String PATH_FILE_TEST = PATH_FILES + File.separator + "test";
    private static final String FILE_TYPE = ".text";
    private static String FILE_PATH_OTHER= PATH_FILES + File.separator;


    public static void main(String[] args) {
        System.out.print("创建文件夹files_io-->");
        File fs = new File(PATH_FILES);
        if (!fs.exists()){
            fs.mkdir();
        }
        System.out.println("创建文件test.txt-->");
        File f = new File(PATH_FILE_TEST+FILE_TYPE);
        if (f.exists()){
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd_HHmmss");
                String time = sdf.format(new Date());
                FILE_PATH_OTHER = FILE_PATH_OTHER+ time +FILE_TYPE;
                System.out.print("FILE_PATH_OTHER:"+FILE_PATH_OTHER);
                File fo = new File(FILE_PATH_OTHER);
                fo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("遍历D盘下的所有文件名：--->");
        File fileD = new File("D:"+File.separator);
        String fileNames[] = fileD.list();
        for (int i = 0; i < fileNames.length ; i++){
            System.out.println(fileNames[i]);
        }
        System.out.print("遍历D盘下的文件路径：-->");
        File files[] = fileD.listFiles();
        for (int i = 0; i < files.length; i++){
            System.out.println(files[i]);
        }
    }
}
