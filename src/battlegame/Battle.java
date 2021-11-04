package battlegame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class to depict a battle duel between two players and creates a war transcript
 * It has the options for a rematch which is the only input from the user.
 */
public class Battle {

  private Player p1;
  private Player p2;
  private Player p3;
  private Player p4;
  private Player first;
  private Player second;
  private String warTranscript;

  /**
   * Constructor for battle.
   */
  public Battle() {

    warTranscript = "Welcome to the game of Battle";
    Integer[] seed1 = new Integer[] {1, 2, 3, 4};
    Integer[] seed2 = new Integer[] {2, 3, 4, 5};
    try {
      p1 = new Player(seed1);
      p3 = new Player(seed1);
      p2 = new Player(seed2);
      p4 = new Player(seed2);
    } catch (IllegalStateException e) {
      warTranscript += "Illegal State";
    }
  }

  /**
   * Helper to testing Battle class methods as they are in different packages. Used to get
   * equipped gears of player1.
   */
  public List<AddOnInterface> getEquippedGearP1(int seed) {
    return (new ArrayList<AddOnInterface>(p1.equipGear(seed)));
  }

  /**
   * Helper to testing Battle class methods as they are in different packages. Used to get
   * equipped gears of player2.
   */
  public List<AddOnInterface> getEquippedGearP2(int seed) {
    return (new ArrayList<AddOnInterface>(p2.equipGear(seed)));
  }

  /**
   * Helper to testing Battle class methods as they are in different packages.Used to
   * check the consequences of player1 striking.
   */
  public int strikeP1() {
    return strike(p1, p2);
  }

  /**
   * Helper to testing Battle class methods as they are in different packages.Used to calculate
   * the potential damage to player 1.
   */
  public int calculatePotentialDamageP1() {
    return calculatePotentialDamage(p1, 0);
  }

  /**
   * Helper to testing Battle class methods as they are in different packages. Used to determine
   * if game is done after p1 strikes.
   */
  public boolean isGameDoneP1() {
    return isGameDone(p1, p2);
  }

  /**
   * Helper to testing Battle class methods as they are in different packages. Used to get Health
   * of player1.
   */
  public int getHealthP1() {
    return p1.getHealth();
  }

  /**
   * Helper to testing Battle class methods as they are in different packages. Used to get Health
   * of player2.
   */
  public int getHealthP2() {
    return p1.getHealth();
  }


  /**
   * To let a player strike is opponent.
   */
  public int strike(Player p, Player op) {
    if (p.getStrikingPower() > op.getAvoidance()) {
      warTranscript += String.format("\n %s Strikes Successfully in the round\n", p.getName());
      int potentialDamage = calculatePotentialDamage(op, 0);
      int actualDamage = potentialDamage - op.getConstitution();
      if (actualDamage > 0) {
        op.loseHealth(actualDamage);
      }
    } else {
      warTranscript += String.format("\n %s fails to strike in the round\n", p.getName());
    }
    if (isGameDone(p, op)) {
      return 1;
    }
    return 0;
  }

  /**
   * To calculate potential damage for a strike.
   */
  public int calculatePotentialDamage(Player p, int seed) {
    Random random = new Random(seed);
    return p.getStrength() + random.nextInt(p.getWeaponDamage(seed));
  }

  /**
   * To check if game is decided.
   */
  public boolean isGameDone(Player p, Player op) {
    return p.getHealth() <= 0 || op.getHealth() <= 0;
  }

  /**
   * get the war Transcript.
   */
  public String getWarTranscript() {
    return warTranscript;
  }

  /**
   * To print the gear/equipment for  a player.
   */
  public List<AddOns> listGear() {
    return p1.equipGear(0);
  }

  /**
   * To have a battle with no gear.
   */
  public int boutNoGear() {
    int countNoDamage = 0;
    p3.resetHealth();
    p4.resetHealth();
    int oldHealth1;
    int oldHealth2;
    int i = 0;
    int won = 0;

    warTranscript += "\n\nBattle without gears and weapons\n\n";
    warTranscript += String.format("\n\nPlayer 1: Stats\n%s", p3.toString());
    warTranscript += String.format("\n\nPlayer 2: Stats\n%s", p4.toString());
    if (p3.getCharisma() >= p4.getCharisma()) {
      first = p3;
      second = p4;
    } else {
      first = p4;
      second = p3;
    }
    warTranscript += String.format("\n%s gets to strike First", first.getName());
    while (true) {
      i++;
      warTranscript += String.format("\n%s gets to strike First", first.getName());
      oldHealth1 = first.getHealth();
      oldHealth2 = second.getHealth();
      if (strike(first, second) == 1) {
        won = 1;
        warTranscript += String.format("\n\n Playing Round %d", i);
        break;
      } else if (strike(second, first) == 1) {
        won = 2;
        warTranscript += String.format("\n%s Won the Match", second.getName());
        break;
      }
      if (oldHealth1 == first.getHealth() && oldHealth2 == second.getHealth()) {
        countNoDamage++;
      }

      warTranscript += String.format("\n\nStats after Round %d", i);
      warTranscript += String.format("\n\nPlayer 1: Health\t%s\n", p3.getHealth());
      warTranscript += String.format("\n\nPlayer 2: Health\t%s\n", p4.getHealth());

      if (countNoDamage >= 6) {
        warTranscript += "\n\nMatch Ended Draw\n\n\n";
        break;
      }
    }
    return won;
  }


  /**
   * To start the bout(round) of battle and report the events that take place and also the result.
   */
  public int bout() {
    int i = 0;
    List<AddOnInterface> eq1 = new ArrayList<>();
    List<AddOnInterface> eq2 = new ArrayList<>();
    int countNoDamage = 0;
    p1.resetHealth();
    p2.resetHealth();
    int oldHealth1;
    int oldHealth2;
    warTranscript += "\n\n\nPlayer stats before equipping with addons";
    warTranscript += String.format("\n\nPlayer 1: Stats\n%s", p1.toString());
    warTranscript += String.format("\n\nPlayer 2: Stats\n%s", p2.toString());
    warTranscript += "\n\nAfter Equipping \n\n";
    int won = 0;
    warTranscript += "\nEquipment used by Player 1 \n";
    eq1 = getEquippedGearP1(0);
    eq2 = getEquippedGearP2(0);
    for (AddOnInterface a : eq1) {
      warTranscript += String.format("\n %s\n", a.toString());
    }
    warTranscript += "\nEquipment used by Player 2 \n";
    for (AddOnInterface b : eq2) {
      warTranscript += String.format("\n %s\n", b.toString());
    }
    warTranscript += String.format("\nPlayers Start with the following stats\n\n"
        + "Player 1: Stats\n%s", p1.toString());
    warTranscript += String.format("\nWeapon Damage= %d", p1.getWeaponDamage(0));
    warTranscript += String.format("\n\nPlayer 2: Stats\n%s", p2.toString());
    warTranscript += String.format("\nWeapon Damage= %d", p2.getWeaponDamage(0));
    if (p1.getCharisma() >= p2.getCharisma()) {
      first = p1;
      second = p2;
    } else {
      first = p2;
      second = p1;
    }
    warTranscript += String.format("\n%s Strikes First", first.getName());
    while (true) {
      i++;
      warTranscript += String.format("\n\n Playing Round %d", i);
      oldHealth1 = first.getHealth();
      oldHealth2 = second.getHealth();
      if (strike(first, second) == 1) {
        won = 1;
        warTranscript += String.format("\n%s Won the Match", first.getName());
        break;
      } else if (strike(second, first) == 1) {
        won = 2;
        warTranscript += String.format("\n%s Won the Match", second.getName());
        break;
      }
      if (oldHealth1 == first.getHealth() && oldHealth2 == second.getHealth()) {
        countNoDamage++;
      }

      warTranscript += String.format("\n\nStats after Round %d", i);
      warTranscript += String.format("\n\nPlayer 1: Health\t%s\n", p1.getHealth());
      warTranscript += String.format("\n\nPlayer 2: Health\t%s\n", p2.getHealth());

      if (countNoDamage >= 6) {
        warTranscript += "\n\nMatch Ended Draw\n";
        break;
      }
    }
    return won;
  }

  /**
   * Used to reset health of both players before a rematch.
   */
  public void rematch() {
    p1.resetHealth();
    p2.resetHealth();
  }


}
