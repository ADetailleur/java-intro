package exercise_02;

public abstract class RebelAllianceMember extends AbstractFactionMember {

  private static final String FACTION_NAME = "Rebels";
  
  @Override
  public String getFactionName() {
    return FACTION_NAME;
  }
}
