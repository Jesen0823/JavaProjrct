package design_patterns_2.action.command.c2.android;

public class Bitmap {
    public interface Config{
        public static final int RGB_565 = 0x565;
        public static  final int RGB_8888=0x888;
    }

    public static Bitmap createBitmap(float width, float height,int format){
        return new Bitmap();
    }
}
