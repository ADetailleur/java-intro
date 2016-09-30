package example_08.alliance;

import example_08.gameboard.AbstractFactionMember;
import example_08.gameboard.Position;

public abstract class RebelAllianceMember extends AbstractFactionMember {

  public RebelAllianceMember(Position position) {
		super(position);
	}

  @Override
  public String getFactionName() {
    return "Rebels";
  }
}
