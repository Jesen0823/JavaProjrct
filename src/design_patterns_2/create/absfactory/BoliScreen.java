package design_patterns_2.create.absfactory;

public class BoliScreen implements IScreen {
    @Override
    public void screen() {
        System.out.println("玻璃屏幕");
    }
}
