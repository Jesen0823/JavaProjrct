package javabasereview.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 压缩文件生成zip
 */
public class ZipOutputStreamDemo11 {
    private static String PATH_FILES = "d:" + File.separator + "files_io" + File.separator;
    private static final String PATH_FILE = PATH_FILES + "test.text";
    private static final String PATH_FILE_ZIP = PATH_FILES + "test.zip";

    public static void main(String[] args) throws Exception {
        /**
         * 压缩单个文件
         * */
        File zipFile = new File(PATH_FILE_ZIP);
        if (!zipFile.exists()) {
            File file = new File(PATH_FILE);
            InputStream inputStream = new FileInputStream(file);
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));
            zos.putNextEntry(new ZipEntry(file.getName()));
            zos.setComment("you are zip");
            int temp = 0;
            while ((temp = inputStream.read()) != -1) {
                zos.write(temp);
            }
            inputStream.close();
            zos.close();
        }

        /**
         * 压缩文件包含文件夹及文件夹下所有目录
         * */
        // 判断文件是否存在不存在则创建
        String FILE_PATH_FIRST_ZIP = PATH_FILES + "Logcat.zip";
        String FILE_PATH_FIRST = PATH_FILES + "Logcat";
        String FILE_PATH_LOGCAT_KEY = "logcat.txt";
        File files = new File(FILE_PATH_FIRST);
        // 准备在文件夹下创建4个文件
        File fileChildren[] = new File[4];
        if (!files.exists()) {
            files.mkdir();
            for (int i = 0; i < 4; i++) {
                fileChildren[i] = new File(FILE_PATH_FIRST + File.separator + i + FILE_PATH_LOGCAT_KEY);
                fileChildren[i].createNewFile();
            }
        }

        File zipFile2 = new File(FILE_PATH_FIRST_ZIP);
        InputStream input = null;
        if (!zipFile2.exists()){
            ZipOutputStream zipOs = new ZipOutputStream(new FileOutputStream(zipFile2));
            zipOs.setComment("A directory has been zip");
            if (files.isDirectory()){
                File lists[] = files.listFiles();
                for (int i = 0;i <lists.length;i++){
                    input = new FileInputStream(lists[i]);
                    zipOs.putNextEntry(new ZipEntry(files.getName()+File.separator+lists[i].getName()));
                    int temp = 0;
                    while ((temp = input.read())!=-1){
                        zipOs.write(temp);
                    }
                    input.close();
                }
            }
            zipOs.close();
        }
    }
}
