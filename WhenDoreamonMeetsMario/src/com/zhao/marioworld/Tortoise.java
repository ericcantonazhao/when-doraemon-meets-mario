package com.zhao.marioworld;

import com.zhao.Activities.LoadResource;

import android.graphics.Bitmap;

public class Tortoise extends Enemy
{
	private int changeStateTime = 150;
	
	public Tortoise(float x, float y, Bitmap image)
	{
		super(x, y, image);
		this.name = "tortoise";
		this.state = "tortoise";
		this.hp = 1;
		this.index = 7;
		this.xSpeed = 2;
		this.changeTime = 4;
		this.dir = 2;
	}
	
	
	public void ChangeImage()
	{
		this.changeTime --;

		if(this.state.equals("tortoise"))
		{
			this.image = LoadResource.enemy.get(index);
			this.IsTimeOver();
			if(this.index == 9) this.index = 7;
		}
		else
		{
			this.image = LoadResource.enemy.get(9);
		}
	}

	
	@Override
	public void ChangeState()
	{
		this.xSpeed = 0;
		this.state = "torshell";
	}

	
	
	@Override
	public void ChangeStateTime() 
	{
		if(this.state.equals("tortoise") || this.xSpeed >= 8) return;
		
		if(this.changeStateTime > 0)
		{
			this.changeStateTime --;
		}
		else
		{
			this.state = "tortoise";
			this.changeStateTime = 150;
			this.xSpeed = 2;
		}
	}

	@Override
	public void CollisionWithEnemy(MarioWorld mv) 
	{
		for(int i=0; i<mv.getNowLevel().getEnemy().size(); i++)
		{
			Enemy e = mv.getNowLevel().getEnemy().get(i);
			
			if(this.name.equals("piranha")) continue;
			
			if(this != e)
			{
				if(this.Rectangle_CollisionWithSprite(e))
				{
					if(e.hit_bullet_or_tortois_dir == 0)
					{
						mv.getMario().score+=10;
						if(this.dir == 2)
						{
							e.hit_bullet_or_tortois_dir = 2;
						}
						else
						{
							e.hit_bullet_or_tortois_dir = 1;
						}
						e.hitbullet_or_tortoise = true;
					}
				}
			}
		}
	}
	
	
	
	@Override
	public void Back() 
	{
		this.x = startX;
		this.y = startY;
		this.state = "tortoise";
		this.hp = 1;
		this.index = 7;
		this.xSpeed = 2;
		this.changeStateTime = 150;
		this.changeTime = 4;
		this.dir = 2;
		this.hit_bullet_or_tortois_dir = 0;
		this.hitbullet_or_tortoise = false;
		this.udindex = 0;
	}
	
	
}
