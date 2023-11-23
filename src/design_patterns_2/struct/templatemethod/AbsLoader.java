package design_patterns_2.struct.templatemethod;

import design_patterns_2.struct.templatemethod.util.Bitmap;
import design_patterns_2.struct.templatemethod.util.BitmapCache;
import design_patterns_2.struct.templatemethod.util.BitmapRequest;
import design_patterns_2.struct.templatemethod.util.SimpleImageLoader;

/**
 * 模板方法模式
 * 封装流程，使得固定的执行顺序不被子类随意修改
 * 子类只能替换某些具体的算法或实现
 * 做到代码复用，避免功能被随意破坏
 * */
public abstract class AbsLoader implements Loader {
    private static BitmapCache mCache = SimpleImageLoader.getInstance().getImageCache();

    @Override
    public final void loadImage(BitmapRequest request) {
        Bitmap resultBitmap = mCache.get(request);
        if (resultBitmap==null){
            showLoading(request);

            resultBitmap = onLoadImage(request);

            cacheBitmap(request,resultBitmap);
        }else {
            request.justCacheInMem = true;
        }

        deliveryToUIThread(request,resultBitmap);
    }

    private void deliveryToUIThread(BitmapRequest request, Bitmap resultBitmap) {

    }

    private void showLoading(BitmapRequest request) {
        System.out.println("----加载中-----");
    }

    protected final void cacheBitmap(BitmapRequest request, Bitmap resultBitmap) {
        mCache.save(request.getUrl(),resultBitmap);
    }

    protected abstract Bitmap onLoadImage(BitmapRequest request);
}
