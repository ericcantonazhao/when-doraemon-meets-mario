package com.zhao.doraemonworld;

import com.zhao.Activities.LoadResourceOfDore;

import android.graphics.Bitmap;

public class Xiaofu extends Enemy implements Runnable
{

	private int deadTime = 20;
	
	public Xiaofu(float x, float y, Bitmap image) 
	{
		super(x, y, image);
		this.hp = 1;
		this.name = "chestnut";
		this.index = 0;
		this.changeTime = 4;
		this.state = "good";
		this.dir = 2;
		this.xSpeed = 2;
	}


	
	public void ChangeImage()
	{
		this.changeTime --;
		
		if(this.state.equals("good"))
		{
			this.image = LoadResourceOfDore.enemy.get(index);
			this.IsTimeOver();
			if(this.index == 2) this.index = 0;
		}
		else
		{
			this.image = LoadResourceOfDore.enemy.get(2);
		}
	}



	@Override
	public void Dead() 
	{
		this.xSpeed = 0;
		this.state = "bad";
		new Thread(this).start();
	}
	
	
	



	@Override
	public void Back()
	{
		this.x = startX;
		this.y = startY;
		this.dir = 2;
		this.hp = 1;
		this.index = 0;
		this.xSpeed = 2;
		this.state = "good";
		this.deadTime = 20;
		this.changeTime = 4;
		this.hit_bullet_or_tortois_dir = 0;
		this.hitbullet_or_tortoise = false;
		this.udindex = 0;
	}



	@Override
	public void run()
	{
		while(this.deadTime > 0)
		{
			this.deadTime --;
			
			if(this.deadTime <= 0)
			{
				this.hp = 0;
			}
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
	
}
