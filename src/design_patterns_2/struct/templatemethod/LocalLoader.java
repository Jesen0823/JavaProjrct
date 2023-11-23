package design_patterns_2.struct.templatemethod;

import design_patterns_2.struct.templatemethod.util.Bitmap;
import design_patterns_2.struct.templatemethod.util.BitmapFactory;
import design_patterns_2.struct.templatemethod.util.BitmapRequest;

public class LocalLoader extends AbsLoader {

    @Override
    protected Bitmap onLoadImage(BitmapRequest request) {
        final String imagePath = request.getUrl();
        request.justCacheInMem = true;
        return BitmapFactory.decodeFile(imagePath,null);
    }
}
