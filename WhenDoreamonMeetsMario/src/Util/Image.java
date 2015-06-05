package Util;


import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import java.io.InputStream;

public class Image
{

    public Image()
    {
    }

    public static Bitmap FitTheScreenSizeImage(Bitmap m, int ScreenWidth, int ScreenHeight)
    {
        float width = (float)ScreenWidth / (float)m.getWidth();
        float height = (float)ScreenHeight / (float)m.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(width, height);
        return Bitmap.createBitmap(m, 0, 0, m.getWidth(), m.getHeight(), matrix, true);
    }

    public static Bitmap FitTheImage(Bitmap m, float width, float height)
    {
        Matrix matrix = new Matrix();
        matrix.postScale(width, height);
        return Bitmap.createBitmap(m, 0, 0, m.getWidth(), m.getHeight(), matrix, true);
    }

    public static Bitmap CreateMap(Bitmap m, int col, int w, int h)
    {
        Bitmap image = Bitmap.createBitmap(w * col, h, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(image);
        canvas.drawColor(-1);
        for(int i = 0; i < col; i++)
            canvas.drawBitmap(m, w * i, 0.0F, null);

        return image;
    }

    public static Bitmap BitmapClipBitmap(Bitmap bitmap, int x, int y, int w, int h)
    {
        return Bitmap.createBitmap(bitmap, x, y, w, h);
    }

    public static Bitmap ReadBitMap(Context context, String path)
    {
        InputStream is = null;
        android.graphics.BitmapFactory.Options opt = new android.graphics.BitmapFactory.Options();
        opt.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        try
        {
            is = context.getAssets().open(path);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return BitmapFactory.decodeStream(is, null, opt);
    }

    public static BitmapDrawable Drs(Context c, String path)
    {
        Bitmap bitmap = ReadBitMap(c, path);
        BitmapDrawable bd = new BitmapDrawable(bitmap);
        bd.setDither(true);
        return bd;
    }
}
