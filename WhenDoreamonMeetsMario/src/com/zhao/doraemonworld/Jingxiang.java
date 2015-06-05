package com.zhao.doraemonworld;

import com.zhao.Activities.LoadResourceOfDore;

import android.graphics.Bitmap;

public class Jingxiang extends Enemy 
{

	private int index2 = 5;
	
	public Jingxiang(float x, float y, Bitmap image)
	{
		super(x, y, image);
		this.hp = 1;
		this.name = "thorn";
		this.index = 3;
		this.changeTime = 4;
		this.dir = 2;
		this.xSpeed = 2;
	}
	
	
	public void ChangeImage()
	{
		this.changeTime -- ;
		if(this.onLand)
		{
			this.image = LoadResourceOfDore.enemy.get(index);
			this.IsTimeOver();
			if(this.index == 5) this.index = 3;
		}
		else
		{
			this.image = LoadResourceOfDore.enemy.get(index2++);
			if(this.index2 == 7) this.index2 = 5;
		}
	}
	
	
	public void Back()
	{
		this.x = startX;
		this.y = startY;
		this.index = 3;
		this.xSpeed = 2;
		this.changeTime = 4;
		this.dir = 2;
		this.hp = 1;
		this.hit_bullet_or_tortois_dir = 0;
		this.hitbullet_or_tortoise = false;
		this.udindex = 0;
	}


}
