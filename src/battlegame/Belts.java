package battlegame;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for addon of type Battle.Belts which can be equipped by the player. Battle.
 * Belts have the ability to impacts any two stats of the player.
 * A player can at a time equip himself/herself with a max.
 * of 10 units.
 */
public class Belts extends AddOns {
  private int size;
  List nameList;

  /**
   * Constructor to initialize the Battle.Belts.
   */
  public Belts(int seed) {
    super();
    nameList = new ArrayList<String>(List.of("White belt", "Yellow belt", "Orange Belt",
        "Purple Belt", "Blue Belt", "Green Belt", "Brown Belt", "Black Belt", " Red Belt"));
    super.name = (String) nameList.get(getRandom(nameList.size(), seed));
    if (!nameList.contains(super.name)) {
      throw new IllegalStateException();
    }
    chooseAbility(seed);
    chooseAbility(seed + 1);
    super.priority = 3;
  }

  /**
   * To choose the ability that the addon impacts on.
   */
  void chooseAbility(int seed) {
    size = getRandom(3, seed);
    if (size == 3) {
      size = 4;
    }
    int c = getRandom(4, seed);
    switch (c) {
      case 1:
        impactStrength(size);
        break;
      case 2:
        impactConstitution(size);
        break;
      case 3:
        impactDexterity(size);
        break;
      default:
        impactCharisma(size);
        break;
    }
  }

  @Override
  public String getType() {
    return this.getClass().getSimpleName();
  }

  @Override
  public int compareTo(AddOnInterface o) {
    if (!o.getType().equals("Battle.Belts")) {
      return this.priority - ((AddOns) o).priority;
    } else {
      return this.compareToBelts((Belts) o);
    }
  }

  @Override
  public int compareToBelts(Belts o) {
    return this.getName().compareTo(o.getName());
  }

  /**
   * To get size of belt.
   */
  public int getSize() {
    return size;
  }
}
