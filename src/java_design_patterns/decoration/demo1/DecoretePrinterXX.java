package java_design_patterns.decoration.demo1;

/**
 * 抽象装饰的实现 升级打印机速度
 * */
public class DecoretePrinterXX extends AbsDecorate {

    public DecoretePrinterXX(Printer printer) {
        super(printer);
    }

    @Override
    public void print() {
        super.print();
        extendSpeed();
    }

    public void extendSpeed(){
        System.out.println("速度提升，40%");
    }
}
