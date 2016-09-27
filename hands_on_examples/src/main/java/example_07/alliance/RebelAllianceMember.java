package example_07.alliance;

import example_07.gameboard.AbstractFactionMember;
import example_07.gameboard.Position;

public abstract class RebelAllianceMember extends AbstractFactionMember {

  public RebelAllianceMember(Position position) {
		super(position);
	}

  @Override
  public String getFactionName() {
    return "Rebels";
  }
}
