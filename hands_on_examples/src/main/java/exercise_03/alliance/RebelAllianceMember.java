package exercise_03.alliance;

import exercise_03.gameboard.AbstractFactionMember;

public abstract class RebelAllianceMember extends AbstractFactionMember {

  private static final String FACTION_NAME = "Rebels";
  
  @Override
  public String getFactionName() {
    return FACTION_NAME;
  }
}
