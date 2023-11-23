package design_patterns_2.struct.templatemethod;

import design_patterns_2.struct.templatemethod.util.Bitmap;
import design_patterns_2.struct.templatemethod.util.BitmapFactory;
import design_patterns_2.struct.templatemethod.util.BitmapRequest;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class NetLoader extends AbsLoader{
    @Override
    protected Bitmap onLoadImage(BitmapRequest request) {
        InputStream is = null;
        Bitmap bitmap = null;
        try{
            URL url = new URL(request.getUrl());
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
            conn.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bitmap;
    }
}
