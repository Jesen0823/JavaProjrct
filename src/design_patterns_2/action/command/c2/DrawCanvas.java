package design_patterns_2.action.command.c2;

import design_patterns_2.action.command.c2.android.*;

public class DrawCanvas extends SurfaceView implements SurfaceHolder.Callback {
    public boolean canDrawing;
    public boolean isDrawThreadRunning;
    // 要绘制到的位图
    private Bitmap mBitmap;
    // 绘制命令请求对象
    private Drawer mDrawer;
    private DrawThread mThread;

    public DrawCanvas(){
        mDrawer = new Drawer();
        mThread = new DrawThread();

        getHolder().addCallback(this);
    }

    public void add(DrawPathCmd pathCmd){
        mDrawer.add(pathCmd);
    }

    public void redo(){
        canDrawing = true;
        mDrawer.redo();
    }

    public void undo(){
        canDrawing = true;
        mDrawer.undo();
    }

    public boolean canUndo(){
        return mDrawer.canUndo();
    }

    public boolean canRedo(){
        return mDrawer.canRedo();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isDrawThreadRunning = true;
        mThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        mBitmap = Bitmap.createBitmap(width,height,Bitmap.Config.RGB_565);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        isDrawThreadRunning = false;
        while (retry){
            try {
                mThread.join();
                retry = false;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    private class DrawThread extends Thread{
        @Override
        public void run() {
            Canvas canvas = null;
            while (isDrawThreadRunning){
                if (canDrawing){
                    try{
                        canvas = getHolder().lockCanvas(null);
                        if (mBitmap ==null){
                            mBitmap = Bitmap.createBitmap(1,1,Bitmap.Config.RGB_8888);
                        }
                        Canvas c = new Canvas(mBitmap);
                        c.drawColor(0, PorterDuff.Mode.CLEAR);

                        canvas.drawColor(0,PorterDuff.Mode.CLEAR);
                        mDrawer.execute(c);
                        canvas.drawBitmap(mBitmap,0,0,null);
                    }finally {
                        getHolder().unlockCanvasAndPost(canvas);
                    }
                    canDrawing = false;
                }
            }
            super.run();
        }
    }
}
