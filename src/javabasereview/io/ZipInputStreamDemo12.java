package javabasereview.io;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * 解压ZIP
 * */
public class ZipInputStreamDemo12 {
    private static final String PATH_FILES = "d:" + File.separator + "files_io" + File.separator;
    private static final String FILE_PATH_FIRST_ZIP = PATH_FILES + "Logcat.zip";
    private static final String FILE_PATH_FIRST = PATH_FILES + "Logcat";

    public static void main(String[] args) throws Exception{
        File file = new File(FILE_PATH_FIRST_ZIP);
        ZipFile zipFile = new ZipFile(file);
        ZipInputStream zipIs = new ZipInputStream(new FileInputStream(file));
        ZipEntry entry = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        File outFile = null;
        while ((entry = zipIs.getNextEntry())!=null){
            System.out.println("解压"+entry.getName());
            outFile = new File(PATH_FILES+File.separator+entry.getName());
            // 判断是否有文件夹
            if (!outFile.getParentFile().exists()){
                outFile.getParentFile().mkdir();
            }
            if (!outFile.exists()){
                outFile.createNewFile();
            }
            inputStream = zipFile.getInputStream(entry);
            outputStream = new FileOutputStream(outFile);
            int temp = 0;
            while ((temp = inputStream.read()) != -1){
                outputStream.write(temp);
            }
            inputStream.close();
            outputStream.close();
        }
    }
}
