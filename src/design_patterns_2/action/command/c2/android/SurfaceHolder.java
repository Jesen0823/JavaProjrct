package design_patterns_2.action.command.c2.android;

import sun.font.SunFontManager;

public class SurfaceHolder {
    private Callback callback;

    public void addCallback(Callback callback){
        this.callback = callback;
    }

    public Canvas lockCanvas(Object o) {
        return new Canvas();
    }

    public void unlockCanvasAndPost(Canvas canvas) {

    }

    public interface Callback{
        void surfaceCreated(SurfaceHolder holder);
        void surfaceChanged(SurfaceHolder holder, int format, int width, int height);
        void surfaceDestroyed(SurfaceHolder holder);
    }
}
