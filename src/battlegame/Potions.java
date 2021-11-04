package battlegame;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to denote a potion as an addon to a player. Potions can act on any of the 4 stats and
 * any number of potions can be consumed by a player.
 */
public class Potions extends AddOns {
  List<String> nameList;

  /**
   * Constructor to initialize Battle.Potions addons.
   */
  public Potions(int seed) {
    super();
    nameList = new ArrayList<String>(List.of("Guam tar", "Coffee", "Chai", "Latte", "Ice Tea",
        "Pepsi", "Coke", "Soup", "Coco"));
    super.name = nameList.get(getRandom(nameList.size(), 0));
    super.priority = 2;
    chooseAbility(seed);

  }

  /**
   * To choose the ability that the potion acts on. One potion can act on maximum 2 stats.
   */
  void chooseAbility(int seed) {
    int c = getRandom(3, seed);
    switch (c) {
      case 1:
        impactStrength(4);
        break;
      case 2:
        impactConstitution(4);
        break;
      case 3:
        impactDexterity(4);
        break;
      default:
        impactCharisma(4);
        break;
    }
  }


  @Override
  public int compareTo(AddOnInterface o) {
    if (!o.getType().equals("Battle.Potions")) {
      return this.priority - ((AddOns) o).priority;
    } else {
      return this.compareToPotions((Potions) o);
    }
  }

  @Override
  public int compareToPotions(Potions o) {
    return this.getName().compareTo(o.getName());
  }

  /**
   * To get the type of the Addon.
   */
  public String getType() {
    return this.getClass().getSimpleName();
  }

}
