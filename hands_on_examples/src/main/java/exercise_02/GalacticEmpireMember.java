package exercise_02;

public abstract class GalacticEmpireMember extends AbstractFactionMember {

  private static final String FACTION_NAME = "Empire";
  
  @Override
  public String getFactionName() {
    return FACTION_NAME;
  }
}
