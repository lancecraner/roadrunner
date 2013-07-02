package com.craner.cromwellmarstonmoor;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class Leader {
	
	private int commandRating = 0;
	private int movementAllowance = 0;
	private String type;
	private String name;
	private int startHex = 0;
	
	private Rect displayRect;

    Bitmap bitmap;
	
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
