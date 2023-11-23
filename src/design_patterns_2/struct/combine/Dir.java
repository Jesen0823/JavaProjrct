package design_patterns_2.struct.combine;

import java.util.ArrayList;
import java.util.List;

/**
 *  目录
 */
public abstract class Dir {
    protected List<Dir> dirs = new ArrayList<>();

    // 当前文件或文件夹名
    private String name;

    public Dir(String name){
        this.name = name;
    }

    public abstract void addDir(Dir dir);

    public abstract void removeDir(Dir dir);

    // 清空文件夹下所有元素
    public abstract void clear();

    // 输出文件夹目录结构
    public abstract void print();

    // 获取当前文件夹下所有子目录或子文件
    public abstract List<Dir> getFileFlat();

    public String getName(){
        return name;
    }
}
