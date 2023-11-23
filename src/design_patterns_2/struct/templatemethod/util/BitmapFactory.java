package design_patterns_2.struct.templatemethod.util;

import java.io.InputStream;

public class BitmapFactory {

    public static Bitmap decodeStream(InputStream is) {
        return new Bitmap();
    }

    public static Bitmap decodeFile(String imagePath, Object o) {
        return new Bitmap();
    }
}
