package com.craner.cromwellmarstonmoor;

import java.util.ArrayList;

public class Combat {
	
	/*- All ordered Units exert ZOC into surrounding 6 hexes. 
	- Disordered Units have no ZOC 
	- All ordered friendly Units in EZOC must attack 
	- Friendly disordered Units cannot attack. 
	- All ordered enemy Units in friendly ZOC must be attacked 
	- Disordered enemy Units in Friendly ZOC may be attacked. 
	- Unlike bombardment, enemy Units can only be attacked once per combat phase. 
	- Combat does not affect Arty. 
	- Combat does not directly affect Leaders (they may contribute to it if stacked with a Unit, and may be eliminated if the Unit they 
	are stacked with is). 
	Attacking strength total:
	- Double strength of Hvy Cav charging disordered enemy Inf . 
	- Halve strength of Units attacking out of marsh, across ditch/stream, or up slope (drop fractions for each Unit before combining 
	Units). 
	- Add command rating of one eligible leader stacked with Unit in each attacking hex. Leader is eligible if of same force as Unit he 
<<<<<<< HEAD
	is stacked with. Cannot add more points than Unit's printed strength.
	Defending strength total: 
	- Add command rating of one eligible leader stacked with Unit in each defending hex. Leader is eligible if of same force as Unit he 
	is stacked with. Cannot add more points than Unit's printed strength.
	- Roll 1d6 on CRT using row corresponding to best defending terrain. 
	 - -2 DRM the 1st time an unmodified 6 was rolled during Visibility check*/
	private ArrayList<Unit> unitsDefending;
	private ArrayList<Unit> unitsAttacking;
=======
	is stacked with. Cannot add more points than Unit’s printed strength.
	Defending strength total: 
	- Add command rating of one eligible leader stacked with Unit in each defending hex. Leader is eligible if of same force as Unit he 
	is stacked with. Cannot add more points than Unit’s printed strength.
	- Roll 1d6 on CRT using row corresponding to best defending terrain. 
	 - -2 DRM the 1st time an unmodified 6 was rolled during Visibility check*/
>>>>>>> branch 'master' of https://github.com/lancecraner/roadrunner.git
	
	public void loadCombatTable(){
		
	}
<<<<<<< HEAD
	
	public void markUnitsThatMustDefendorAttack(ArrayList<Terrain> wholeMap, String attackingArmy, String defendingArmy){
		
		// Loop through Map and mark each defending unit adjacent to enemy
		for (Terrain terrain : wholeMap){
			// Check if Unit in Tile
			if (terrain.isUnitAlreadyinHex()){
				// Check if defending Unit
				if (terrain.getUnitInTile().getArmy().equals(defendingArmy)){
					// Check what units are adjacent hexes
					// Get adjacent hexes
					ArrayList<Integer>hexesToCheck = terrain.getUnitInTile().getAllowableMoveHexChoice();
					// Loop through map to find the correct hexes
					for (Terrain unitCheck : wholeMap){
						for (Integer hexNumber : hexesToCheck){
							if (hexNumber == unitCheck.getTerrainNumber()){
								// Check if unit in the adjacent hex being checked
								if (unitCheck.getUnitInTile() != null){
									// If found and if attacking unit then mark 
									if (unitCheck.getUnitInTile().getArmy().equals(attackingArmy)){
										terrain.getUnitInTile().setMustBeAttacked(true);
										unitsDefending.add(terrain.getUnitInTile());
										// If attacking unit not yet marked as must attack then set true
										if (!unitCheck.getUnitInTile().isMustAttack()){
											unitCheck.getUnitInTile().setMustAttack(true);
											unitsAttacking.add(unitCheck.getUnitInTile());
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	public void markUnitsThatCouldBeAttacked(){
		
	}
=======
>>>>>>> branch 'master' of https://github.com/lancecraner/roadrunner.git
	
	public void totalAttackStrength(){
		
	}
	
<<<<<<< HEAD
=======
	public void markUnitsToAttack(){
		
	}
	
	
	public void markUnitsThatMustBeAttacked(){
		
	}
	
	public void markUnitsThatCouldBeAttacked(){
		
	}
	
	public void totalAttackStrength(){
		
	}
	
>>>>>>> branch 'master' of https://github.com/lancecraner/roadrunner.git
	public void totalDefendStrength(){
		
	}
	
	public void combatResult(){
		
	}
	
	

}
