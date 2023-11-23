package java_design_patterns.decoration.demo1;

/**
 * 抽象装饰者 持有抽象组件的引用 对其扩展
 * */
public abstract class AbsDecorate extends Printer {

    private Printer mPrinter;

    public AbsDecorate(Printer printer){
        this.mPrinter = printer;
    }

    @Override
    public void print() {
        mPrinter.print();
    }
}
