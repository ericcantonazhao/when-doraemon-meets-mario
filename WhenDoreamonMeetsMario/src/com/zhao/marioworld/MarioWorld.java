package com.zhao.marioworld;

import Util.GameButton;
import Util.Sprite;
import Util.GameView;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;



import com.zhao.Activities.GameOverActivity;
import com.zhao.Activities.LoadActivity;
import com.zhao.Activities.LoadResource;
import com.zhao.Activities.MenuActivity;
import com.zhao.Activities.WinActivity;
import com.zhao.marioworld.Tile;
import com.zhao.whendoreamonmeetsmario.R;

public class MarioWorld extends GameView implements Runnable
{
	ArrayList <Level>level = new ArrayList<Level>();
	
	Level nowLevel;
	String message="com.mario.nextlevel";
	Doraemon mario;
	
	private GameButton B;
	
	public static final int GAME_ING = 0;
	public static final int GAME_PAUSE = 1;
	public static final int GAME_WIN = 2;
	public static final int GAME_OVER = 3;
	public static final int GAME_PANNEL = 4;
	
	int gameState = GAME_PANNEL;
	
	private Panel panel;
	
	boolean isallreadyingame;


	
	private int gameoverTime = 170;
	
	private int pass=0;
	public int getPass(){
		return pass;
	}
	public void setPass(){
		pass=1;
	}
	
	public Doraemon getMario()
	{
		return mario;
	}

	public Level getNowLevel() 
	{
		return nowLevel;
	}
	public int getGameState() 
	{
		return gameState;
	}

	public MarioWorld(Context context,int gamelevel)
	{
		super(context);
		this.setKeepScreenOn(true);
		this.setFocusableInTouchMode(true);
	
		
	
		for(int i=1; i<=3; i++)
		{
			level.add(new Level(i,context));
		}	
		
		this.nowLevel = level.get(gamelevel);
		
		mario = new Doraemon(80,0,LoadResource.mario.get(0),context);
		
		this.panel = new Panel();
		
		
		this.B          = new GameButton(LoadActivity.ScreenWidth  - LoadResource.button.get(4).getWidth(), 
										 LoadActivity.ScreenHeight - LoadResource.button.get(4).getHeight(),
										 LoadResource.button.get(4));
		
	}
	

	
	
	
	@Override
	public void surfaceCreated(SurfaceHolder holder)
	{
		this.flag = true;
		this.t = new Thread(this);
		this.t.start();
	}


	
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) 
	{
		this.flag = false;
		
	}



	
	public void Draw() 
	{
		this.canvas = sh.lockCanvas();
		if(canvas != null)
		{
			canvas.drawColor(Color.BLACK);
			
			if(this.mario.y > LoadActivity.ScreenHeight*2.5 && this.mario.lifevalue > 0)
			{
				this.gameState = GAME_PANNEL;
			}
			
			switch(gameState)
			{
			
			
			
			
			case GAME_PANNEL:
						
						if(this.isallreadyingame)
						{
							
							this.RemoveAllSprite();
							
							
							this.nowLevel.time = 160;
							
							
							mario.Back();
							
							
							this.nowLevel.getEnemy().addAll(this.nowLevel.getSaveenemy());
							for(int i=0; i<this.nowLevel.getEnemy().size(); i++)
							{
								Enemy e = this.nowLevel.getEnemy().get(i);
								e.Back();
							}
							
							
							for(int i=0; i<this.nowLevel.getB_tile().size(); i++)
							{
								Tile t = this.nowLevel.getB_tile().get(i);
								t.Back();
							}
							for(int i=0; i<this.nowLevel.getQ_tile().size(); i++)
							{
								Tile t = this.nowLevel.getQ_tile().get(i);
								t.Back();
							}
							Tile.count = 0;
							
							
							this.nowLevel.getCoin().addAll(this.nowLevel.getSavecoin());
							for(int i=0; i<this.nowLevel.getCoin().size(); i++)
							{
								Coin c = this.nowLevel.getCoin().get(i);
								c.Back();
							}
							
							
							
							
							if(this.nowLevel.getMap().size() > 0)
							{
								for(int i=0; i<this.nowLevel.getMap().size(); i++)
								{
									Background map = this.nowLevel.getMap().get(i);
									map.Back();
								}
							}
							
							this.nowLevel.SetTileY();
							
							this.isallreadyingame = false;
						}	
				if(!this.isallreadyingame) this.gameState = GAME_ING;
			
			
			case GAME_ING:
				
					
						
						this.isallreadyingame = true;
						
						paint.setColor(Color.YELLOW);
						paint.setTextSize(13);
						
						
						for(int i=0; i<this.nowLevel.getMap().size(); i++)
						{
							Background map = this.nowLevel.getMap().get(i);
							map.Draw(canvas);
						}
						
						for(int i=0; i<this.nowLevel.getB_tile().size(); i++)
						{
							Tile tile = this.nowLevel.getB_tile().get(i);
							
							
							if(tile.x >= -16 && tile.x <= LoadActivity.ScreenWidth)
							{
								tile.Draw(canvas);
								tile.ChangeImage();
							}
						}
						
					
						for(int i=0; i<Level.food.size(); i++)
						{
							Sprite s = Level.food.get(i);
							if(s.hp > 0)
							{
								if(s instanceof Dorayaki)
								{
									Dorayaki mr = (Dorayaki) s;
									mr.Move();
									mr.Draw(canvas);
									mr.Logic(this);
								}
							}
							else
							{
								Level.food.remove(i);
							}
			
						}
						
						
						for(int i=0; i<this.nowLevel.getCoin().size(); i++)
						{
							Coin c = this.nowLevel.getCoin().get(i);
							if(c.hp > 0)
							{
								c.Draw(canvas);
								c.Jump();
								c.ChangeImage();
							}
							else
							{
								this.nowLevel.getCoin().remove(i);
							}
						}
						
						for(int i=0; i<this.nowLevel.getEnemy().size(); i++)
						{
							Enemy e = this.nowLevel.getEnemy().get(i);
							if(e.name.equals("piranha"))
							{
								if(e.hp > 0)
								{
									e.Draw(canvas);
									e.Move();
									e.ChangeImage();
									e.Dead2();
								}
								else
								{
									this.nowLevel.getEnemy().remove(i);
								}
							}
						}
						
						
						for(int i=0; i<this.nowLevel.getQ_tile().size(); i++)
						{
							Tile tile = this.nowLevel.getQ_tile().get(i);
							
							if(tile.getType() != 15)
							{
								
								if(tile.x >= -16 && tile.x <= LoadActivity.ScreenWidth)
								{
									tile.Draw(canvas);
									tile.ChangeImage();
									tile.Jump();
								}
							}
						}
						
					
					
						
						
						for(int i=0; i<this.nowLevel.getQ_tile().size(); i++)
						{
							Tile tile = this.nowLevel.getQ_tile().get(i);
							
							if(tile.getType() == 15)
							{
								
								if(tile.x >= -16 && tile.x <= LoadActivity.ScreenWidth)
								{
									tile.Draw(canvas);
									tile.Fril(mario);
								}
							}
						}
						
						
						for(int i=0; i<this.nowLevel.getEnemy().size(); i++)
						{
							Enemy e = this.nowLevel.getEnemy().get(i);
							if(!e.name.equals("piranha"))
							{
								if(e.hp > 0)
								{
									e.Logic(this);
									e.Draw(canvas);
									
										e.Move();
								
									e.ChangeImage();
									e.ChangeStateTime();
									e.Dead2();
								}
								else
								{
									this.nowLevel.getEnemy().remove(i);
								}
							}
						}
						
						
						panel.Draw(this, canvas, paint);
						panel.Logic(this);
						
						
						
			
					
						mario.Draw(canvas,paint);
						mario.Move(this);
						mario.ChangeImage(this);
						if(this.mario.coin_value >= 100)
						{
							this.mario.lifevalue++;
							this.mario.coin_value = 0;
							
						}
						
					
						
						
						
						
						
					
						B.Draw(canvas, paint);
						
						if(this.mario.lifevalue == 0 && this.mario.hp == 0 && this.mario.y > LoadActivity.ScreenHeight*2.5) this.gameState = GAME_OVER;
						this.nowLevel.GotoNextLevel(this);			
						//pass=1;
			break;
			
			case GAME_OVER:
				if(this.nowLevel.getTime() > 0)
				{
				
				}
				paint.setColor(Color.YELLOW);
				panel.Draw(this, canvas, paint);
			
				this.nowLevel.setTime(0);
				this.BackToMenuReady();
			break;
			
			case GAME_WIN:
				paint.setColor(Color.YELLOW);
				Tile.count = 0;
				SaveName();
				SaveScore();
				RemoveStaticSprite();
				Intent i = new Intent(this.getContext(),WinActivity.class);
				this.getContext().startActivity(i);
				Activity a = (Activity) this.getContext();
				a.finish();		
			break;
			
			}
			this.sh.unlockCanvasAndPost(canvas);
		}
		
	}
	
	
	
	public void Logic()
	{
		if(this.gameState != GAME_ING) return;
		
		mario.ChangeRectSize();
		
		mario.Logic(this);
		
		this.mario.state = "runright";
		
		for(int i=0; i<this.nowLevel.getEnemy().size(); i++)
		{
			Enemy e = this.nowLevel.getEnemy().get(i);
			if(e.name.equals("tortoise") && e.state.equals("tor") && e.xSpeed >0)
			{
				if(e.SpriteAtScreen(e, LoadActivity.ScreenWidth, LoadActivity.ScreenHeight))
				{
					e.CollisionWithEnemy(this);
				}
			}
		}
		
		if(this.mario.hp > 0 && this.mario.getNoCheckCoiiisionTime() <= 0 && !this.nowLevel.isWin)
		{
			for(int i=0; i<this.nowLevel.getEnemy().size(); i++)
			{
				Enemy e = this.nowLevel.getEnemy().get(i);
				
				if(e.SpriteAtScreen(e, LoadActivity.ScreenWidth, LoadActivity.ScreenHeight))
				{
					if(!e.hitbullet_or_tortoise)
					{
						if(e.MoreRectangle_CollisionWithSprite(mario, mario.getRect()))
						{
							if(e.name.equals("chestnut"))
							{
								if(this.mario.level == 1)
								{
									if(mario.y + mario.getRect().top < e.y && !mario.isOnLand())
									{
										mario.score+=10;
										mario.setJumpTime(mario.getySpeed());
										e.Dead();
										
									}
									else
									{
										mario.Dead(this);
									}
								}
								
							}
							else if(e.name.equals("tortoise"))
							{
								if(e.xSpeed != 0)
								{
									if(mario.y < e.y && !mario.isOnLand())
									{
										mario.setJumpTime(mario.getySpeed());
										e.ChangeState();
									}
									else
									{
										mario.Dead(this);
									}
								}
								else
								{
									e.xSpeed = 5;
									if(mario.x > e.x)
									{
										e.dir = 1;
									}
									else
									{
										e.dir = 2;
									}
								}
							}
						
							else
							{
								mario.Dead(this);
							}
						}
					}
				}
			}
		}
		
		
		
		
		
		
		
		if(this.mario.hp > 0)
		{
			for(int i=0; i<Level.food.size(); i++)
			{
				Sprite s = Level.food.get(i);
				if(s instanceof Dorayaki)
				{
					Dorayaki mr = (Dorayaki) s;
					
					if(mr.getCount() == 18)
					{
						if(mr.MoreRectangle_CollisionWithSprite(mario, mario.getRect()))
						{
							mario.score+=10;
							mr.hp = 0;
							if(this.mario.level < 3)
							{
								this.mario.level+=1;
							}
							
							
						}
					}
				}
			
			}
		}
		
	
		for(int i=0; i<this.nowLevel.getCoin().size(); i++)
		{
			Coin coin = this.nowLevel.getCoin().get(i);
			if(coin.getType() == 2)
			{
				if(coin.MoreRectangle_CollisionWithSprite(mario, mario.getRect()) && coin.hp > 0)
				{
					mario.score+=10;
					coin.hp = 0;
					
					mario.coin_value++;
				}
			}
		}
		
	
		
		
		
		
	}
	
	

	public void RemoveStaticSprite()
	{
		Level.food.removeAll(Level.food);
		
	
	}
	
	public void RemoveAllSprite()
	{
		Level.food.removeAll(Level.food);
		
		
		
		this.nowLevel.getEnemy().removeAll(this.nowLevel.getEnemy());
		this.nowLevel.getCoin().removeAll(this.nowLevel.getCoin());
	}
	

	public void SaveScore()
	{
		try
		{
			FileOutputStream fos = this.getContext().openFileOutput("score.txt", Context.MODE_APPEND);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			String score = Integer.toString(mario.score)+":";
			bos.write(score.getBytes());
			bos.flush();
			bos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void SaveName()
	{
		try
		{
			FileOutputStream fos = this.getContext().openFileOutput("save.txt", Context.MODE_APPEND);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			bos.write(mario.name.getBytes());
			bos.flush();
			bos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	public void BackToMenu()
	{
		this.gameoverTime --;
		if(this.gameoverTime == 0)
		{
			BackToMenuReady();
		}
	}
	
	
	public void BackToMenuReady()
	{
		Tile.count = 0;
		SaveName();
		SaveScore();
		RemoveStaticSprite();
		Intent i = new Intent(this.getContext(),GameOverActivity.class);
		this.getContext().startActivity(i);
		Activity a = (Activity) this.getContext();
		a.finish();		
	}
	
	  
	@Override
	public boolean onTouchEvent(MotionEvent event) 
	{
		switch(gameState)
		{
		case GAME_PANNEL:
			if(!this.isallreadyingame) this.gameState = GAME_ING;
		break;
		
		
		
		case GAME_ING:
		if(B.OnTouch(event.getX(), event.getY()))
			{
				if(!this.nowLevel.isWin) this.mario.Jump();
			}
			
		break;
		
		case GAME_WIN:
			Tile.count = 0;
			SaveName();
			SaveScore();
			RemoveStaticSprite();
			Intent i = new Intent(this.getContext(),WinActivity.class);
			this.getContext().startActivity(i);
			Activity a = (Activity) this.getContext();
			a.finish();		
		break;
		
		}
		if(this.gameState == GAME_ING)
		{
			return true;
		}
		else
		{
			return super.onTouchEvent(event);
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
		switch(gameState)
		{
		case GAME_ING:
			if(this.mario.hp > 0) this.mario.onKeyDown(keyCode, event,this);
			if(keyCode == KeyEvent.KEYCODE_BACK) 
			{
				
				Activity a = (Activity) this.getContext();
				a.finish();	
			}
		break;
		}
		return true;
	}
	
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) 
	{
		switch(gameState)
		{
		case GAME_ING:
			this.mario.onKeyUp(keyCode, event);
		break;
		}
		return true;
	}




	@Override
	public void run()
	{
		while(flag)
		{
			Long start = System.currentTimeMillis();
			this.Logic();
			this.Draw();
			Long end   = System.currentTimeMillis();
			try 
			{
				if(end - start < 50)
				{
					Thread.sleep(50 - (end - start));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


}
