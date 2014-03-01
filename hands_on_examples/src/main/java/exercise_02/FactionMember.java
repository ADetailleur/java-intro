package exercise_02;

/**
 * Faction members belong to a faction, and are able to fight with each other.
 */
public interface FactionMember extends GameBoardElement {

  int getPower();
  
  void setPower(int newPower);
  
  void fightWith(FactionMember f);
  
  boolean isInTheSameFaction(FactionMember f);
  
  boolean isDead();
  
  String getFactionName();
  
}
