package com.craner.cromwellmarstonmoor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Leader {
	
	/*- Only affect Units of their own force for rally/combat purposes. 
	- Only one leader can affect a Unit at a time for rally/combat purposes. 
	- Move # hexes, rather than spending MP. 
	- Cannot enter enemy Unit hexes. 
	- Cannot enter enemy Arty hexes (unless already captured) 
	- Can move through (but not end movement in) enemy Leader hexes. 
	- Cannot participate in combat when alone. 
	- Any number of eligible Units may use a given leader for rally. 
	- If enemy Units enter a friendly Leaders hex, he is displaced to nearest friendly Unit (if none on board, he is eliminated). 
	- When Royalist Unit first enters allied train hex, Leven is removed from the map (does not count for demoralization/VP purposes)*/
	
	private int commandRating = 0;
	private int movementAllowance = 0;
	private String type;
	private String name;
	private String army;
	private String side;
	private int startHex = 0;
	
	private Rect displayRect;

    Bitmap bitmap;
    
    
	
	public Leader(String properties, Context context) {
		
		//6,8,Cromwell,Manchester,1307,c1,A
		String[] splits = properties.split(",");
        this.commandRating = (Integer.parseInt(splits[0]));
        this.movementAllowance = (Integer.parseInt(splits[1]));
        this.name = splits[2];
        this.army = splits[3];
        this.startHex = (Integer.parseInt(splits[4]));
        int resourceID = context.getResources().getIdentifier(splits[5], "drawable",context.getPackageName());
        bitmap = BitmapFactory.decodeResource(context.getResources(), resourceID);
        
        this.side = splits[6];
	}

	public void setcommandRating(int commandRating){
		this.commandRating = commandRating;
	}
	
	public int getcommandRating(){
		return this.commandRating;
	}

	public void setmovementAllowance(int movementAllowance){
		this.movementAllowance = movementAllowance;
	}
	
	public int getmovementAllowance(){
		return this.movementAllowance;
	}
	
	public void setstartHex(int startHex){
		this.startHex = startHex;
	}
	
	public int getstartHex(){
		return this.startHex;
	}
	
	public String getArmy() {
		return army;
	}

	public void setArmy(String army) {
		this.army = army;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}
	
	public String gettype(){
		return this.type;
	}
	
	public void settype(String type){
		this.type = type;
	}
	
	public void setname(String name){
		this.name = name;
	}
		
	public String getname(){
		return this.name;
	}
	
	public void setDisplayRect(Rect displayRect){
        this.displayRect = displayRect;
    }

    public Rect getDisplayRect(){
        return this.displayRect;
    }
    
    public void setBitmap(Bitmap bitmap){
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap(){
        return this.bitmap;
    }
	

}
