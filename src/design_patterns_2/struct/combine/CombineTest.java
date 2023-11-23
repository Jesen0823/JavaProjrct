package design_patterns_2.struct.combine;

/**
 * 组合模式
 * 组合模式可以清楚地定义分层次的复杂对象，表示对象的全部或部分层次，它让高层模块忽略
 * 了层次的差异，方便对整个层次结构进行控制。
 *
 * View和ViewGroup就属于组合模式
 *
 */
public class CombineTest {

    public static void main(String[] args) {
        Dir diskC = new Folder("C");

        diskC.addDir(new File("image_test.png"));

        Dir dirWin = new Folder("Windows32");
        Dir download = new Folder("download");
        diskC.addDir(dirWin);
        diskC.addDir(download);

        Dir dirLog = new File("log.txt");
        dirWin.addDir(dirLog);

        Dir user = new Folder("user");
        Dir info = new File("info.txt");
        user.addDir(info);

        download.addDir(user);

        // 打印出文件结构
        diskC.print();
    }
}
