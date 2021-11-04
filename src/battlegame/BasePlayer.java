package battlegame;

/**
 * interface with the basic structure of a Battle.Player. It acts as a foundation of a player to be
 * implemented.
 */
public interface BasePlayer {

  /**
   * To get the strength of a player.
   *
   * @return integer Strength
   */
  public int getStrength();

  /**
   * To get the constitution of a player.
   *
   * @return integer Constitution
   */
  public int getConstitution();

  /**
   * To get Dexterity of a player.
   *
   * @return integer Dexterity
   */
  public int getDexterity();

  /**
   * To get Charisma of a player.
   *
   * @return integer Charisma
   */
  public int getCharisma();

  /**
   * To get the Health of the player based ibn his stats and the gear equipped.
   *
   * @return Striking power calculated in realtime
   */
  int getHealth();

  /**
   * To get the striking power of the player based ibn his stats and the gear equipped.
   *
   * @return Striking power calculated in realtime
   */
  int getStrikingPower();

  /**
   * To get the Avoidance power of the player based ibn his stats and the gear equipped.
   *
   * @return Striking power calculated in realtime
   */
  int getAvoidance();
}
