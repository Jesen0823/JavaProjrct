package design_patterns_2.struct.combine;

import java.util.List;

public class File extends Dir {

    public File(String name) {
        super(name);
    }

    @Override
    public void addDir(Dir dir) {
        throw new UnsupportedOperationException("file 不支持添加内容");
    }

    @Override
    public void removeDir(Dir dir) {
        throw new UnsupportedOperationException("file 不支持移除内容");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("file 不支持清空内容");
    }

    @Override
    public void print() {
        System.out.println(getName());
    }

    @Override
    public List<Dir> getFileFlat() {
        throw new UnsupportedOperationException("file 不支持展开");
    }
}
