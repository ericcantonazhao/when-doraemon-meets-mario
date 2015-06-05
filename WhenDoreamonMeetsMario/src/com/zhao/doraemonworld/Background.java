package com.zhao.doraemonworld;

import com.zhao.Activities.LoadActivity;

import android.graphics.Bitmap;
import Util.Sprite;



public class Background extends Sprite
{
	private int id;
	
	public Background(float x, float y, Bitmap image,int id)
	{
		super(x, y, image);
		this.id = id;
	}

	
	
	public void Move(int dir,DoraemonWorld mv)
	{
		if(dir == 1)
		{
			xSpeed = 2;
		}
		else 
		{
			xSpeed = -2;
		}
		
		if(this.x == -LoadActivity.ScreenWidth)
		{
			if(mv.getMario().state.equals("runright"))
			{
				this.x = LoadActivity.ScreenWidth;
			}
		}
		else if(this.x == LoadActivity.ScreenWidth)
		{
			
			if(mv.getMario().state.equals("runleft"))
			{
				this.x = -LoadActivity.ScreenWidth;
			}
			
		}
		
		this.x+=xSpeed;
	}
	
	
	
	
	
	
	
	
	
	public void Back()
	{
		if(this.id == 1)
		{
			this.x = 0;
		}
		else if(this.id == 2)
		{
			this.x = LoadActivity.ScreenWidth;
		}
	}

}

