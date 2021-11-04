package battlegame;

import java.util.Random;

/**
 * Class to denote the Weapon equipped by the player. The enumeration also includes the scenario
 * when a player fights Bare Handed.
 */
public enum Swords {
  KATANA, BROADSWORDS, TWOHANDED, AXES, FLAILS, BAREHANDED;

  /**
   * To Get a random sword from the collection on demand.
   *
   * @return enum Sword
   */
  public static Swords getRandomSword(int seed) {
    Random random;
    if (seed != 0) {
      random = new Random(seed);
    } else {
      random = new Random();
    }
    return values()[random.nextInt(values().length)];
  }

  /**
   * Function to return the strength of the sword.
   *
   * @return Strength in integer
   */
  public int getSwordStrength(int seed) {
    Random random;
    int res;
    if (seed != 0) {
      random = new Random(seed);
    } else {
      random = new Random();
    }

    switch (this.name()) {
      case "KATANA":
      case "TWOHANDED":
      case "FLAILS":
        res = random.nextInt(4) + 3;
        //System.out.println(this.name() + res);
        break;
      case "BROADSWORDS":
      case "AXES":
        res = random.nextInt(4) + 6;
        //System.out.println(this.name() + res);
        break;
      //System.out.println(this.name() + res);
      default:
        res = 0;
        break;
    }
    return res;

  }
}
