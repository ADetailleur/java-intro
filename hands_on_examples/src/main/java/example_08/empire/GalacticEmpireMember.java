package example_08.empire;

import example_08.gameboard.AbstractFactionMember;
import example_08.gameboard.Position;

public abstract class GalacticEmpireMember extends AbstractFactionMember {

  public GalacticEmpireMember(Position position) {
		super(position);
	}

  @Override
  public String getFactionName() {
    return "Empire";
  }
}
