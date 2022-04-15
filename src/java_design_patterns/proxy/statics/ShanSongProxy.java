package java_design_patterns.proxy.statics;

public class ShanSongProxy implements IShop {

    private IShop mShop;

    public ShanSongProxy(IShop shop){
        this.mShop = shop;
    }

    @Override
    public void buy() {
        System.out.println("闪送代买");
        mShop.buy();
    }
}
