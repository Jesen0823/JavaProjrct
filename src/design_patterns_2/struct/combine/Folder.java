package design_patterns_2.struct.combine;

import java.util.Iterator;
import java.util.List;

/**
 * 文件夹
 */
public class Folder extends Dir {

    public Folder(String name) {
        super(name);
    }

    @Override
    public void addDir(Dir dir) {
        dirs.add(dir);
    }

    @Override
    public void removeDir(Dir dir) {
        dirs.remove(dir);
    }

    @Override
    public void clear() {
        dirs.clear();
    }

    @Override
    public void print() {
        System.out.println(getName()+"(");
        Iterator<Dir> iter= dirs.iterator();
        while (iter.hasNext()){
            Dir dir = iter.next();
            dir.print();
            if (iter.hasNext()){
                System.out.println(",  ");
            }
        }
        System.out.println(")");
    }

    @Override
    public List<Dir> getFileFlat() {
        return dirs;
    }
}
