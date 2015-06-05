package Util;



import android.graphics.*;


public class Sprite
{
	 	public float x;
	    public float y;
	    public Bitmap image;
	    public float xSpeed;
	    public float ySpeed;
	    public float startX;
	    public float startY;
	    public int hp;
    public Sprite(float x, float y, Bitmap image)
    {
        this.x = x;
        this.y = y;
        startX = x;
        startY = y;
        this.image = image;
        hp = 1;
    }

    public void Draw(Canvas canvas)
    {
        if(image != null)
            canvas.drawBitmap(image, x, y, null);
    }

    public boolean SpriteAtScreen(Sprite s, int ScreenWidth, int ScreenHeight)
    {
        return s.x >= 0.0F && s.x <= (float)ScreenWidth && s.y >= 0.0F && s.y <= (float)ScreenHeight;
    }

    public boolean Rectangle_CollisionWithSprite(Sprite s)
    {
        if(x + (float)image.getWidth() < s.x)
            return false;
        if(y + (float)image.getHeight() < s.y)
            return false;
        if(s.x + (float)s.image.getWidth() < x)
            return false;
        return s.y + (float)s.image.getHeight() >= y;
    }

    public boolean MoreRectangle_CollisionWithSprite(Sprite s, Rect r)
    {
        float x = (float)r.left + s.x;
        float y = (float)r.top + s.y;
        float w = r.right - r.left;
        float h = r.bottom - r.top;
        if(this.x + (float)image.getWidth() < x)
            return false;
        if(this.y + (float)image.getHeight() < y)
            return false;
        if(x + w < this.x)
            return false;
        return y + h >= this.y;
    }

    

   
}
