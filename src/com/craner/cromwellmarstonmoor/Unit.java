package com.craner.cromwellmarstonmoor;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Unit {
	
	private int combatStrength = 0;
	private int moraleRating = 0;
	private int movementAllowance = 0;
	private int disruptedCombatStrength = 0;
	private int disruptedMoraleRating = 0;
	private int disruptedMovementAllowance = 0;
	private String type;
	private String name;
	private int Hex = 0;
	private boolean selected = false;
	private int remainingMovementPoints;
	private String Army;
	boolean disrupted = false;
	
	private Rect displayRect;

    Bitmap bitmap;
    Bitmap bitmapSelected;
    
    public Unit(String properties, Context context){

    	// 6,3,4,4,3,2,Foot,Newcastle,0517,u1,u1_sel
        String[] splits = properties.split(",");
        this.combatStrength = (Integer.parseInt(splits[0]));
        this.moraleRating = (Integer.parseInt(splits[1]));
        this.movementAllowance = (Integer.parseInt(splits[2]));
        this.remainingMovementPoints = this.movementAllowance;
        this.disruptedCombatStrength= Integer.parseInt(splits[3]);
        this.disruptedMoraleRating = Integer.parseInt(splits[4]);
        this.disruptedMovementAllowance = Integer.parseInt(splits[5]);
        this.type = splits[6];
        this.name = splits[7];
        this.Hex = (Integer.parseInt(splits[8]));
        

        int resourceID = context.getResources().getIdentifier(splits[9], "drawable",context.getPackageName());
        bitmap = BitmapFactory.decodeResource(context.getResources(), resourceID);
        resourceID = context.getResources().getIdentifier(splits[10], "drawable",context.getPackageName());
        bitmapSelected = BitmapFactory.decodeResource(context.getResources(), resourceID);
        
        Army = splits[11];
        
    }
	
	public void setcombatStrength(int combatStrength){
		this.combatStrength = combatStrength;
	}
	
	public int getcombatStrength(){
		return this.combatStrength;
	}

	public void setmoraleRating(int moraleRating){
		this.moraleRating = moraleRating;
	}
	
	public int getmoraleRating(){
		return this.moraleRating;
	}
	
	public void setmovementAllowance(int movementAllowance){
		this.movementAllowance = movementAllowance;
	}
	
	public int getmovementAllowance(){
		return this.movementAllowance;
	}
	
	public void setdisruptedCombatStrength(int disruptedCombatStrength){
		this.disruptedCombatStrength = disruptedCombatStrength;
	}
	
	public int getdisruptedCombatStrength(){
		return this.disruptedCombatStrength;
	}
	
	public void setdisruptedMoraleRating(int disruptedMoraleRating){
		this.disruptedMoraleRating = disruptedMoraleRating;
	}
	
	public int getdisruptedMoraleRating(){
		return this.disruptedMoraleRating;
	}
	
	public void setdisruptedMovementAllowance(int disruptedMovementAllowance){
		this.disruptedMovementAllowance = disruptedMovementAllowance;
	}
	
	public int getdisruptedMovementAllowance(){
		return this.disruptedMovementAllowance;
	}
	
	public void setHex(int Hex){
		this.Hex = Hex;
	}
	
	public int getHex(){
		return this.Hex;
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
    
    public void setSelected(boolean selected){
        this.selected = selected;
    }
    
    public void setDisrupted(boolean disrupted){
        this.disrupted = disrupted;
    }
    
    public boolean isDisrupted(){
    	return disrupted;
    }
    
    public int getRemainingMovementPoints(){
    	return this.movementAllowance;
    }
    
    public void updateRemainingMovementPoints(int movementAllowance){
    	this.movementAllowance = movementAllowance;
    }
    
    public void resetRemainingMovementPoints(){
    	this.remainingMovementPoints = this.movementAllowance;
    }
    
    

    public Bitmap getBitmap(){
    	if(selected){
    		return this.bitmapSelected;
    	}
    	else
    	{
    		return this.bitmap;
    	}
    }
    
    public ArrayList<Integer> getAllowableMoveHexChoice(){
    	
    	ArrayList<Integer> allowableMoveHexes = new ArrayList<Integer>();
    	
    	if (this.Hex%200 < 100){
    		allowableMoveHexes.add(0, this.Hex - 1);
        	allowableMoveHexes.add(1, this.Hex + 100);
        	allowableMoveHexes.add(2, this.Hex + 101);
        	allowableMoveHexes.add(3, this.Hex + 1);
        	allowableMoveHexes.add(4, this.Hex - 99);
        	allowableMoveHexes.add(5, this.Hex - 100);
    	}else{
    		allowableMoveHexes.add(0, this.Hex - 1);
        	allowableMoveHexes.add(1, this.Hex + 99);
        	allowableMoveHexes.add(2, this.Hex + 100);
        	allowableMoveHexes.add(3, this.Hex + 1);
        	allowableMoveHexes.add(4, this.Hex - 100);
        	allowableMoveHexes.add(5, this.Hex - 101);
    	}
    	
    	return allowableMoveHexes;
    }
    
    public void rally(){
    	
    	// Unit ineligible for a rally check if next to ordered enemy unit
    	// unless the unit is a foot unit in woods, close or train hex and the enemy is cavalry
    	
    	// Units that are part of demoralized army are ineligible for a rally check
    	// unless 
    	//	Unit is stacked with leader of same colour
    	//	Unit is horse in Manchesters force
    	//	Unit is foot unit in Newcastles force
    	
    	// Check Morale Rating of the unit
    	
    	// Add command rating of any leader stacked or adjacent to the unit
    	
    	// Add 2 if the unit is in a close hex
    	
    	// Or add 1 if the unit is in its own Train hex
    	
    	// Subtract 2 if in enemies Train
    	
    	// Roll die
    	
    	// Add 1 to die roll if visibility is obscured or minimal
    	
    	// If result is less than or equal to the modified morale rating the unit rallies.
    
    	
    	
    }
	
}