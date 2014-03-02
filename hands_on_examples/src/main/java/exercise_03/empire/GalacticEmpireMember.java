package exercise_03.empire;

import exercise_03.gameboard.AbstractFactionMember;

public abstract class GalacticEmpireMember extends AbstractFactionMember {

  private static final String FACTION_NAME = "Empire";
  
  @Override
  public String getFactionName() {
    return FACTION_NAME;
  }
}
