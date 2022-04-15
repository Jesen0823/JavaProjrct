package java_design_patterns.decoration;

/**
 * 抽象装饰的实现 升级打印机功能
 * */
public class DecoretePrinterX extends AbsDecorate{

    public DecoretePrinterX(Printer printer){
        super(printer);
    }

    @Override
    public void print() {
     super.print();
     extendFunction();
    }

    /**
     * 扩展功能
     * */
    public void extendFunction(){
        System.out.println("支持扫描文件");
        System.out.println("支持彩色复印文件");
    }
}
