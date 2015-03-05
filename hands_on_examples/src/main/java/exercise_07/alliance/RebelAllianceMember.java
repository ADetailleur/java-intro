package exercise_07.alliance;

import exercise_07.gameboard.AbstractFactionMember;

public abstract class RebelAllianceMember extends AbstractFactionMember {

  @Override
  public String getFactionName() {
    return "Rebels";
  }
}
