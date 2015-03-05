package exercise_07.empire;

import exercise_07.gameboard.AbstractFactionMember;

public abstract class GalacticEmpireMember extends AbstractFactionMember {

  @Override
  public String getFactionName() {
    return "Empire";
  }
}
