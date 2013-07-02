package com.craner.cromwellmarstonmoor;

public class CourseofPlay {

	boolean visibilityPhase = true;
	boolean alliedRallyPhase = false;
	boolean alliedArtilleryPhase = false;
	boolean alliedMarchPhase = false;
	boolean alliedCombatPhase = false;
	boolean royalistRallyPhase = false;
	boolean royalistArtilleryPhase = false;
	boolean royalistMarchPhase = false;
	boolean royalistCombatPhase = false;
	int royalistArmyMorale = 100;
	int alliesArmyMorale = 115;
	/**
	 * @return the visibilityPhase
	 */
	public boolean isVisibilityPhase() {
		return visibilityPhase;
	}
	/**
	 * @param visibilityPhase the visibilityPhase to set
	 */
	public void setVisibilityPhase(boolean visibilityPhase) {
		this.visibilityPhase = visibilityPhase;
	}
	/**
	 * @return the alliedRallyPhase
	 */
	public boolean isAlliedRallyPhase() {
		return alliedRallyPhase;
	}
	/**
	 * @param alliedRallyPhase the alliedRallyPhase to set
	 */
	public void setAlliedRallyPhase(boolean alliedRallyPhase) {
		this.alliedRallyPhase = alliedRallyPhase;
	}
	/**
	 * @return the alliedArtilleryPhase
	 */
	public boolean isAlliedArtilleryPhase() {
		return alliedArtilleryPhase;
	}
	/**
	 * @param alliedArtilleryPhase the alliedArtilleryPhase to set
	 */
	public void setAlliedArtilleryPhase(boolean alliedArtilleryPhase) {
		this.alliedArtilleryPhase = alliedArtilleryPhase;
	}
	/**
	 * @return the alliedMarchPhase
	 */
	public boolean isAlliedMarchPhase() {
		return alliedMarchPhase;
	}
	/**
	 * @param alliedMarchPhase the alliedMarchPhase to set
	 */
	public void setAlliedMarchPhase(boolean alliedMarchPhase) {
		this.alliedMarchPhase = alliedMarchPhase;
	}
	/**
	 * @return the alliedCombatPhase
	 */
	public boolean isAlliedCombatPhase() {
		return alliedCombatPhase;
	}
	/**
	 * @param alliedCombatPhase the alliedCombatPhase to set
	 */
	public void setAlliedCombatPhase(boolean alliedCombatPhase) {
		this.alliedCombatPhase = alliedCombatPhase;
	}
	/**
	 * @return the royalistRallyPhase
	 */
	public boolean isRoyalistRallyPhase() {
		return royalistRallyPhase;
	}
	/**
	 * @param royalistRallyPhase the royalistRallyPhase to set
	 */
	public void setRoyalistRallyPhase(boolean royalistRallyPhase) {
		this.royalistRallyPhase = royalistRallyPhase;
	}
	/**
	 * @return the royalistArtilleryPhase
	 */
	public boolean isRoyalistArtilleryPhase() {
		return royalistArtilleryPhase;
	}
	/**
	 * @param royalistArtilleryPhase the royalistArtilleryPhase to set
	 */
	public void setRoyalistArtilleryPhase(boolean royalistArtilleryPhase) {
		this.royalistArtilleryPhase = royalistArtilleryPhase;
	}
	/**
	 * @return the royalistMarchPhase
	 */
	public boolean isRoyalistMarchPhase() {
		return royalistMarchPhase;
	}
	/**
	 * @param royalistMarchPhase the royalistMarchPhase to set
	 */
	public void setRoyalistMarchPhase(boolean royalistMarchPhase) {
		this.royalistMarchPhase = royalistMarchPhase;
	}
	/**
	 * @return the royalistCombatPhase
	 */
	public boolean isRoyalistCombatPhase() {
		return royalistCombatPhase;
	}
	/**
	 * @param royalistCombatPhase the royalistCombatPhase to set
	 */
	public void setRoyalistCombatPhase(boolean royalistCombatPhase) {
		this.royalistCombatPhase = royalistCombatPhase;
	}
	
	public void updateRoyalistArmyMorale(int change){
		this.royalistArmyMorale += change;
	}
	
	public void updateAlliesArmyMorale(int change){
		this.alliesArmyMorale += change;
	}
	
}
