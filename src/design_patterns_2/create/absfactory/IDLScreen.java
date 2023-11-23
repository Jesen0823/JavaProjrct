package design_patterns_2.create.absfactory;

public class IDLScreen implements IScreen {
    @Override
    public void screen() {
        System.out.println("IDL屏幕");
    }
}
