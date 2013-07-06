package com.craner.cromwellmarstonmoor;



import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.content.Context;



/**
 * Created by Lance on 10/06/13.
 */

public class Terrain {

    private String tilenumber;
    private int terrainNumber;
    private String terrainType;

    private int terrainEffectFoot;
    private int terrainEffectLightHorse;
    private int terrainEffectHeavyHorse;

    private String terrainEffectAttackFoot;
    private String terrainEffectAttackLightHorse;
    private String terrainEffectAttackHeavyHorse;

    private String TerrainHexSideModifier0; 
    private String TerrainHexSideModifier1;
    private String TerrainHexSideModifier2;
    private String TerrainHexSideModifier3;
    private String TerrainHexSideModifier4;
    private String TerrainHexSideModifier5;
    
    private Rect displayRect;
    
    private Unit unitInTile = null;
    
    ArrayList<Unit> leaders; 

    Bitmap bitmap;
   

    // Constructor
    public Terrain(String properties, Context context){

        String[] splits = properties.split(",");
        setTerrainEffectFoot(Integer.parseInt(splits[0]));
        setTerrainEffectLightHorse(Integer.parseInt(splits[1]));
        setTerrainEffectHeavyHorse(Integer.parseInt(splits[2]));
        setTerrainEffectAttackFoot(splits[3]);
        setTerrainEffectAttackLightHorse(splits[4]);
        setTerrainEffectAttackHeavyHorse(splits[5]);
        
        TerrainHexSideModifier0= (splits[6]);
        TerrainHexSideModifier1= (splits[7]);
        TerrainHexSideModifier2= (splits[8]);
        TerrainHexSideModifier3= (splits[9]);
        TerrainHexSideModifier4= (splits[10]);
        TerrainHexSideModifier5= (splits[11]);
        setTileNumber(splits[12]);

        int resourceID = context.getResources().getIdentifier(splits[12], "drawable",context.getPackageName());
        bitmap = BitmapFactory.decodeResource(context.getResources(), resourceID);
        
        
        splits = null;
    }
    
    // Copy constructor
    // Allows copy of class and not reference to this class
    public Terrain(Terrain source){
    	
    	this.bitmap = source.bitmap;
    	this.terrainEffectFoot = source.terrainEffectFoot;
    	this.terrainEffectLightHorse = source.terrainEffectLightHorse;
    	this.terrainEffectHeavyHorse = source.terrainEffectHeavyHorse;
    	this.terrainEffectAttackFoot = source.terrainEffectAttackFoot;
    	this.terrainEffectAttackLightHorse = source.terrainEffectAttackLightHorse;
    	this.terrainEffectAttackHeavyHorse = source.terrainEffectAttackHeavyHorse;
    	this.tilenumber = source.tilenumber;
    	this.terrainNumber = source.terrainNumber;
    	this.displayRect = source.displayRect;
    	
    	this.TerrainHexSideModifier0 = source.TerrainHexSideModifier0;
    	this.TerrainHexSideModifier1 = source.TerrainHexSideModifier1;
    	this.TerrainHexSideModifier2 = source.TerrainHexSideModifier2;
    	this.TerrainHexSideModifier3 = source.TerrainHexSideModifier3;
    	this.TerrainHexSideModifier4 = source.TerrainHexSideModifier4;
    	this.TerrainHexSideModifier5 = source.TerrainHexSideModifier5;
    }

    public void setBitmap(Bitmap bitmap){
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap(){
        return this.bitmap;
    }

    public int getTerrainEffectFoot(){
        return this.terrainEffectFoot;
    }

    public void setTerrainEffectFoot(int terrainEffectFoot){
        this.terrainEffectFoot = terrainEffectFoot;
    }

    public int getTerrainEffectLightHorse(){
        return this.terrainEffectLightHorse;
    }

    public void setTerrainEffectLightHorse(int terrainEffectLightHorse){
        this.terrainEffectLightHorse = terrainEffectLightHorse;
    }

    public int getTerrainEffectHeavyHorse(){
        return this.terrainEffectHeavyHorse;
    }

    public void setTerrainEffectHeavyHorse(int terrainEffectHeavyHorse){
        this.terrainEffectHeavyHorse = terrainEffectHeavyHorse;
    }

    public String getTerrainEffectAttackFoot(){
        return this.terrainEffectAttackFoot;
    }

    public void setTerrainEffectAttackFoot(String terrainEffectAttackFoot){
        this.terrainEffectAttackFoot = terrainEffectAttackFoot;
    }

    public String getTerrainEffectAttackLightHorse(){
        return this.terrainEffectAttackLightHorse;
    }

    public void setTerrainEffectAttackLightHorse(String terrainEffectAttackLightHorse){
        this.terrainEffectAttackLightHorse = terrainEffectAttackLightHorse;
    }

    public String getTerrainEffectAttackHeavyHorse(){
        return this.terrainEffectAttackHeavyHorse;
    }

    public void setTerrainEffectAttackHeavyHorse(String terrainEffectAttackHeavyHorse){
        this.terrainEffectAttackHeavyHorse = terrainEffectAttackHeavyHorse;
    }

    public String getHexSideModifier0(){
        return this.TerrainHexSideModifier0;
    }

    public void setHexSideModifier0(String terrainHexSideModifier){
        this.TerrainHexSideModifier0 = terrainHexSideModifier;
    }
    
    public String getHexSideModifier1(){
        return this.TerrainHexSideModifier1;
    }

    public void setHexSideModifier1(String terrainHexSideModifier){
        this.TerrainHexSideModifier1 = terrainHexSideModifier;
    }
    
    public String getHexSideModifier2(){
        return this.TerrainHexSideModifier2;
    }

    public void setHexSideModifier2(String terrainHexSideModifier){
        this.TerrainHexSideModifier2 = terrainHexSideModifier;
    }
    
    public String getHexSideModifier3(){
        return this.TerrainHexSideModifier3;
    }

    public void setHexSideModifier3(String terrainHexSideModifier){
        this.TerrainHexSideModifier3 = terrainHexSideModifier;
    }
    
    public String getHexSideModifier4(){
        return this.TerrainHexSideModifier4;
    }

    public void setHexSideModifier4(String terrainHexSideModifier){
        this.TerrainHexSideModifier4 = terrainHexSideModifier;
    }
    
    public String getHexSideModifier5(){
        return this.TerrainHexSideModifier5;
    }

    public void setHexSideModifier5(String terrainHexSideModifier){
        this.TerrainHexSideModifier5 = terrainHexSideModifier;
    }
    
    public void setTileNumber(String tilenumber){
        this.tilenumber = tilenumber;
    }

    public String getTileNumber(){
        return this.tilenumber;
    }
    
    public void setTerrainNumber(int terrainNumber){
        this.terrainNumber = terrainNumber;
    }

    public int getTerrainNumber(){
        return this.terrainNumber;
    }
    
    public void setDisplayRect(Rect displayRect){
        this.displayRect = displayRect;
    }

    public Rect getDisplayRect(){
        return this.displayRect;
    }
    
    public void setUnitInTile(Unit unitInTile){
    	
        this.unitInTile = unitInTile;
        int left = this.displayRect.left + 7;
        int top = this.displayRect.top + 3;
        int right = this.displayRect.left + 79;
        int bottom = this.displayRect.top + 73;
        Rect rect = new Rect(left, top, right, bottom);
        this.unitInTile.setDisplayRect(rect);
    }
    
public void setUnitInTileRect(){
    	
        
        int left = this.displayRect.left + 7;
        int top = this.displayRect.top + 3;
        int right = this.displayRect.left + 79;
        int bottom = this.displayRect.top + 73;
        Rect rect = new Rect(left, top, right, bottom);
        this.unitInTile.setDisplayRect(rect);
    }

    public Unit getUnitInTile(){
        return this.unitInTile;
    }
    
    public void deleteUnitInTile(){
    	this.unitInTile = null;
    }
    
    public boolean isUnitAlreadyinHex(){
    	if (this.unitInTile != null){
    		return true;
    	}
    	return false;
    }
    
    public int getTerrainMovementCost(String unitType){
    	
    	int movementCost = 0;
    	
    	if (unitType.equals("HeavyHorse")){
    		movementCost = this.terrainEffectHeavyHorse;
    	} else if(unitType.equals("LightHorse")){
    		movementCost = this.terrainEffectLightHorse;
    	}else if(unitType.equals("Foot")){
    		movementCost = this.terrainEffectFoot;
    	}
    		
    	return movementCost;
    }
    
    public int getHexsideMovementModifier(int hexSide, String unitType){
    	
    	String sideMod = "0";
    	switch (hexSide){
    		case 0:
    			sideMod = this.TerrainHexSideModifier0;
    			break;
    		case 1:
    			sideMod = this.TerrainHexSideModifier1;
    			break;
    		case 2:
    			sideMod = this.TerrainHexSideModifier2;
    			break;
    		case 3:
    			sideMod = this.TerrainHexSideModifier3;
    			break;
    		case 4:
    			sideMod = this.TerrainHexSideModifier4;
    			break;
    		case 5:
    			sideMod = this.TerrainHexSideModifier5;
    			break;
    		
    	}
    	
    	return hexsideMovementModifier(sideMod,unitType);
    	
    }
    
    private int hexsideMovementModifier(String sideMod, String unitType){
    	
    	int modifier = 0;
    	if (sideMod == "0"){
    		modifier = 0;
		} else if (sideMod.equals("R")){
			if (unitType.equals("HeavyHorse")){
				modifier = 3;
			} else{
				modifier = 2;
			}
			
		} else if (sideMod.equals("D")){
			if (unitType.equals("HeavyHorse")){
				modifier = 4;
			} else if(unitType.equals("LightHorse")){
				modifier = 3;
			} else{
				modifier = 2;
			}
			
		} else if (sideMod.equals("S")){
			if (unitType.equals("Foot")){
				modifier = 0;
			} else{
				modifier = 1;
			}
		}
    	
    	return modifier;
    }
}
