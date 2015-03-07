package example_07.alliance;

import example_07.gameboard.AbstractFactionMember;

public abstract class RebelAllianceMember extends AbstractFactionMember {

  @Override
  public String getFactionName() {
    return "Rebels";
  }
}
