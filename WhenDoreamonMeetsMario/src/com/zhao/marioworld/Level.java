package com.zhao.marioworld;


import Util.Sprite;
import Util.ReadMap;
import java.util.ArrayList;
import android.content.Context;
import android.graphics.Bitmap;


import com.zhao.Activities.LoadActivity;
import com.zhao.Activities.LoadResource;
import com.zhao.whendoreamonmeetsmario.R;

public class Level 
{
	int Level;

	private String level_name;
	
	int time;
	
	

	private ArrayList <Tile>b_tile = new ArrayList<Tile>();
	

	private ArrayList <Tile>q_tile = new ArrayList<Tile>();
	
	private ArrayList <Background>map = new ArrayList<Background>();
	
	private ArrayList <Enemy>enemy = new ArrayList<Enemy>();
	
	private ArrayList <Enemy>saveenemy = new ArrayList<Enemy>();
	
	private ArrayList <Coin>coin = new ArrayList <Coin>();
		
	private ArrayList <Coin>savecoin = new ArrayList <Coin>();
	
	
	
	static ArrayList <Sprite>food = new ArrayList<Sprite>();
	
	
	
	boolean isWin;
	
	private int goToNextLevelTime = 120;
	
	
	
	
	
	
	public ArrayList<Coin> getCoin()
	{
		return coin;
	}
	public ArrayList<Coin> getSavecoin() 
	{
		return savecoin;
	}
	public void setTime(int time)
	{
		this.time = time;
	}

	public ArrayList<Enemy> getSaveenemy() 
	{
		return saveenemy;
	}
	public ArrayList<Tile> getB_tile() 
	{
		return b_tile;
	}
	public ArrayList<Tile> getQ_tile() 
	{
		return q_tile;
	}
	public String getLevel_name()
	{
		return level_name;
	}
	public int getTime() 
	{
		return time;
	}
	public ArrayList<Background> getMap() 
	{
		return map;
	}
	public ArrayList<Enemy> getEnemy() 
	{
		return enemy;
	}
	
	
	
	public Level(){
		
	}
	
	public Level(int level,Context context)
	{
		Level = level;
		
		switch(level)
		{
		case 1:
		
			this.CreatTile(ReadMap.ReadMap(context, "dmapdata/b1.dat"),0);
			this.CreatTile(ReadMap.ReadMap(context, "mapdat/1.dat"),1);

			
			this.map.add(new Background(0,0,LoadResource.map.get(1),1));
			this.map.add(new Background(LoadActivity.ScreenWidth,0,LoadResource.map.get(1),2));
			
			this.coin.add(new Coin(29*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(30*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(31*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(32*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(62*32, 7*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(63*32, 7*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(64*32, 7*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(65*32, 7*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(101*32, 2*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(113*32, 6*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(114*32, 6*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(115*32, 6*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(116*32, 6*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(158*32, 7*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(159*32, 7*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(160*32, 7*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(249*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(250*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(251*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(252*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(253*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(261*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(262*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(263*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(264*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(265*32, 8*8, LoadResource.coin.get(0),2));
			
			
			savecoin.addAll(coin);
			
			this.enemy.add(new Chestnut(29*32 ,  12*8, LoadResource.enemy.get(0)));
			this.enemy.add(new Tortoise(46*32 ,  12*8, LoadResource.enemy.get(7)));
			this.enemy.add(new Piranha (59*32+8, 20*8, LoadResource.enemy.get(10)));
		
			this.enemy.add(new Chestnut(115*32 , 10*8, LoadResource.enemy.get(0)));
			this.enemy.add(new Chestnut(147*32 , 12*8, LoadResource.enemy.get(0)));
			this.enemy.add(new Tortoise(158*32 , 12*8, LoadResource.enemy.get(7)));
			this.enemy.add(new Thorn   (167*32 ,  7*8, LoadResource.enemy.get(3)));
			this.enemy.add(new Tortoise(221*32 , 12*8, LoadResource.enemy.get(7)));
			this.enemy.add(new Piranha (240*32+8,20*8, LoadResource.enemy.get(10)));
			this.enemy.add(new Piranha (272*32+8,20*8, LoadResource.enemy.get(10)));

		
			this.saveenemy.addAll(enemy);
			
			this.level_name = "1-1";
			this.time = 160;
			
		
		
			this.SetTileY();
			
		break;
		
		case 2:

			this.CreatTile(ReadMap.ReadMap(context, "dmapdata/b1.dat"),0);
			this.CreatTile(ReadMap.ReadMap(context, "dmapdata/q3.dat"),1);
			

			
		
			this.map.add(new Background(0,0,LoadResource.map.get(2),1));
			this.map.add(new Background(LoadActivity.ScreenWidth,0,LoadResource.map.get(2),2));
			
			
			this.coin.add(new Coin(52*32, 9*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(53*32, 9*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(54*32, 9*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(55*32, 9*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(56*32, 9*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(57*32, 9*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(58*32, 9*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(59*32, 9*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(60*32, 9*8, LoadResource.coin.get(0),2));
			
			this.coin.add(new Coin(102*32, 2*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(103*32, 2*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(104*32, 2*8, LoadResource.coin.get(0),2));
			
			this.coin.add(new Coin(114*32, 7*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(115*32, 7*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(116*32, 7*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(117*32, 7*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(118*32, 7*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(119*32, 7*8, LoadResource.coin.get(0),2));
			
			this.coin.add(new Coin(123*32, 2*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(124*32, 2*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(125*32, 2*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(126*32, 2*8, LoadResource.coin.get(0),2));
			
			this.coin.add(new Coin(214*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(215*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(216*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(217*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(218*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(219*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(220*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(221*32, 10*8, LoadResource.coin.get(0),2));
			
			this.coin.add(new Coin(257*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(258*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(259*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(260*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(261*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(262*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(263*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(264*32, 10*8, LoadResource.coin.get(0),2));
			

			
		
			savecoin.addAll(coin);
			
			this.enemy.add(new Chestnut(25*32 ,  13*8, LoadResource.enemy.get(0)));
			this.enemy.add(new Tortoise(60*32 ,  13*8, LoadResource.enemy.get(7)));
			this.enemy.add(new Tortoise(160*32 ,  13*8, LoadResource.enemy.get(7)));
			this.enemy.add(new Tortoise(260*32 ,  13*8, LoadResource.enemy.get(7)));
			this.enemy.add(new Tortoise(169*32 ,  13*8, LoadResource.enemy.get(7)));
			this.enemy.add(new Thorn   (130*32 , 13*8,  LoadResource.enemy.get(3)));
			this.enemy.add(new Chestnut(146*32 , 13*8, LoadResource.enemy.get(0)));
			this.enemy.add(new Chestnut(176*32 , 10*8, LoadResource.enemy.get(7)));
			this.enemy.add(new Chestnut(246*32 , 10*8, LoadResource.enemy.get(7)));
			this.enemy.add(new Chestnut(46*32 , 10*8, LoadResource.enemy.get(7)));
			this.enemy.add(new Thorn   (160*32 ,  13*8, LoadResource.enemy.get(3)));
			this.enemy.add(new Tortoise(170*32 , 13*8, LoadResource.enemy.get(7)));
			this.enemy.add(new Piranha (85*32+8, 20*8, LoadResource.enemy.get(10)));
			this.enemy.add(new Piranha (174*32+8,20*8, LoadResource.enemy.get(10)));
			this.enemy.add(new Piranha (203*32+8,20*8, LoadResource.enemy.get(10)));
			this.enemy.add(new Piranha (286*32+8,20*8, LoadResource.enemy.get(10)));
			this.enemy.add(new Piranha (292*32+8, 20*8,LoadResource.enemy.get(10)));


			
			this.saveenemy.addAll(enemy);

			
			this.level_name = "1-2";
			this.time = 160;
			
			
			
			this.SetTileY();
		break;
		
		case 3:
			
			this.CreatTile(ReadMap.ReadMap(context, "dmapdata/b1.dat"),0);
			this.CreatTile(ReadMap.ReadMap(context, "mapdat/map_q_3.dat"),1);
			
			this.level_name = "1-3";
			this.time = 160;
			
			
			
			this.coin.add(new Coin(26*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(27*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(28*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(88*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(89*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(90*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(139*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(140*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(141*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(142*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(143*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(144*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(145*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(146*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(147*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(163*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(164*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(165*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(166*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(167*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(168*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(169*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(170*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(171*32, 10*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(206*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(207*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(208*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(209*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(210*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(211*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(212*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(213*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(235*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(236*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(237*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(238*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(239*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(240*32, 8*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(286*32, 7*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(288*32, 7*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(292*32, 5*8, LoadResource.coin.get(0),2));
			this.coin.add(new Coin(293*32, 5*8, LoadResource.coin.get(0),2));


			
			savecoin.addAll(coin);
			
			
			this.enemy.add(new Piranha (85*32+8, 13*8, LoadResource.enemy.get(10)));
			this.enemy.add(new Piranha (174*32+8,12*8, LoadResource.enemy.get(10)));
			this.enemy.add(new Piranha (203*32+8,13*8, LoadResource.enemy.get(10)));
			this.enemy.add(new Piranha (286*32+8,12*8, LoadResource.enemy.get(10)));
			this.enemy.add(new Piranha (292*32+8, 10*8,LoadResource.enemy.get(10)));

			this.saveenemy.addAll(enemy);

		
			this.SetTileY();
			
		break;
		}
	}
	
	
	
	

	

		
		

	

	public void GotoNextLevel(MarioWorld mv)
	{
		if(!this.isWin) return;
		
		mv.getMario().xSpeed  = 0 ;
		
		
		this.goToNextLevelTime --;
		
		if(this.goToNextLevelTime <= 0)
		{
			
			if(mv.getNowLevel().Level != 3)
			{
				Tile.count = 0;
			
				mv.setPass();
				mv.isallreadyingame = false;
				mv.gameState = MarioWorld.GAME_PANNEL;
				mv.getMario().x = mv.getMario().startX;
				mv.getMario().y = mv.getMario().startY;
				mv.getMario().xSpeed  = 4 ;
				mv.getMario().state = "срмё";
			}
			else
			{
				mv.gameState = MarioWorld.GAME_WIN;
			}
		}
		
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void SetTileY()
	{
		if(LoadActivity.ScreenHeight == 240) return;
		
		int k = (LoadActivity.ScreenHeight - 240);
		for(int i=0; i<this.q_tile.size(); i++)
		{
			Tile t = this.q_tile.get(i);
			t.y +=k;
		}
		for(int i=0; i<this.b_tile.size(); i++)
		{
			Tile t = this.b_tile.get(i);
			t.y +=k;
		}
		for(int i=0; i<this.coin.size(); i++)
		{
			Coin c = this.coin.get(i);
			c.y +=k;
		}
		for(int i=0; i<this.enemy.size(); i++)
		{
			Enemy e = this.enemy.get(i);
			e.y +=k;
		}
		
		
	}
	
	

	public Bitmap SelectImage(int index)
	{
		if(index == 130)  return LoadResource.tile.get(0);
		if(index == 146)  return LoadResource.tile.get(1);
		if(index == 11 )  return LoadResource.tile.get(2);
		if(index == 12 )  return LoadResource.tile.get(3);
		if(index == 27 )  return LoadResource.tile.get(4);
		if(index == 28 )  return LoadResource.tile.get(5);
		if(index == 37 )  return LoadResource.tile.get(6);
		if(index == 21 )  return LoadResource.tile.get(8);
		if(index == 15 )  return LoadResource.tile.get(12);	
		if(index == 31 )  return LoadResource.tile.get(13);
		if(index == 47 )  return LoadResource.tile.get(14);
		if(index == 77 )  return LoadResource.tile.get(15);
		if(index == 93 )  return LoadResource.tile.get(17);
		if(index == 10 )  return LoadResource.tile.get(19);
		if(index == 131 ) return LoadResource.tile.get(20);
		if(index == 145 ) return LoadResource.tile.get(21);
		if(index == 129 ) return LoadResource.tile.get(22);
		if(index == 133 ) return LoadResource.tile.get(23);
		if(index == 134 ) return LoadResource.tile.get(24);
		if(index == 135 ) return LoadResource.tile.get(25);
		if(index == 149 ) return LoadResource.tile.get(26);
		if(index == 150 ) return LoadResource.tile.get(27);
		if(index == 151 ) return LoadResource.tile.get(28);
		if(index == 147 ) return LoadResource.tile.get(29);
		if(index == 152 ) return LoadResource.tile.get(30);
		if(index == 17 )  return LoadResource.tile.get(31);
		if(index == 18 )  return LoadResource.tile.get(32);
		if(index == 19 )  return LoadResource.tile.get(33);
		if(index == 20 )  return LoadResource.tile.get(34);
		return null;
	}
	
	
	public void CreatTile(int map[][], int k)
	{
		for(int i=0; i<map.length; i++)
		{
			for(int j=0; j<map[i].length; j++)
			{
				if(map[i][j] > 0)
				{
					Tile t = new Tile((j)*32, i*16-16,SelectImage(map[i][j]),map[i][j]);
					if(k > 0)
					{
						this.q_tile.add(t);
					}
					else
					{
						this.b_tile.add(t);
					}
				}
			}
		}
	}
	
	
}
