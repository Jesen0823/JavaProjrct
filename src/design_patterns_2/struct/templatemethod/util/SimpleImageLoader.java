package design_patterns_2.struct.templatemethod.util;

public class SimpleImageLoader {

    private volatile static SimpleImageLoader simpleImageLoader;

    public static SimpleImageLoader getInstance(){
        if (simpleImageLoader==null){
            synchronized (SimpleImageLoader.class){
                if (simpleImageLoader==null){
                    simpleImageLoader = new SimpleImageLoader();
                }
            }
        }
        return simpleImageLoader;
    }

    public BitmapCache getImageCache(){
        return new BitmapCache();
    }
}
