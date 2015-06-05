package Util;


import android.content.Context;
import android.graphics.*;
import android.media.SoundPool;



public class GameButton 
{
	 public float x;
	    public float y;
	    public Bitmap image;

   public int type;
    public int textSize;
    public String name;
    public GameButton(float x, float y, Bitmap image)
    {
        this.x = x;
        this.y = y;
        this.image = image;
        type = 1;
    }

 
    public void Draw(Canvas canvas, Paint paint)
    {
        if(type == 1)
        {
            canvas.drawBitmap(image, x, y, paint);
        } else
        {
            paint.setTextSize(textSize);
            canvas.drawText(name, x, y, paint);
        }
    }

  

    public boolean OnTouch(float onTouchX, float onTouchY)
    {
        if(type == 1)
        {
            if(onTouchX >= x && onTouchX <= x + (float)image.getWidth() && onTouchY >= y && onTouchY <= y + (float)image.getHeight())
            {
               
                return true;
            }
        } else
        if(onTouchX >= x && onTouchX <= x + (float)((name.length() / 2) * textSize) && onTouchY >= y - (float)textSize && onTouchY <= y)
        {
           
            return true;
        }
        return false;
    }

    

  
   
}
