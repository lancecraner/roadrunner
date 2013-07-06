package com.craner.cromwellmarstonmoor;

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
	is stacked with. Cannot add more points than Unit’s printed strength.
	Defending strength total: 
	- Add command rating of one eligible leader stacked with Unit in each defending hex. Leader is eligible if of same force as Unit he 
	is stacked with. Cannot add more points than Unit’s printed strength.
	- Roll 1d6 on CRT using row corresponding to best defending terrain. 
	 - -2 DRM the 1st time an unmodified 6 was rolled during Visibility check*/
	
	public void loadCombatTable(){
		
	}
	
	
	public void markUnitsToAttack(){
		
	}
	
	
	public void markUnitsThatMustBeAttacked(){
		
	}
	
	public void markUnitsThatCouldBeAttacked(){
		
	}
	
	public void totalAttackStrength(){
		
	}
	
	public void totalDefendStrength(){
		
	}
	
	public void combatResult(){
		
	}
	
	

}
