package Util;



import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView
    implements android.view.SurfaceHolder.Callback
{
	  public SurfaceHolder sh;
	    public Canvas canvas;
	    public Paint paint;
	    public boolean flag;
	    public Thread t;
    public GameView(Context context)
    {
        super(context);
        sh = super.getHolder();
        paint = new Paint(1);
        paint.setAntiAlias(true);
        setFocusable(true);
        sh.addCallback(this);
    }

    public GameView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        sh = super.getHolder();
        paint = new Paint(1);
        paint.setAntiAlias(true);
        setFocusable(true);
        sh.addCallback(this);
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
    }

  
}
