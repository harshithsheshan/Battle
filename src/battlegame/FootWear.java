package battlegame;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for addon of type footwear which can be equipped by the player. Footwear can effect the
 * dexterity of a player and at a time one player can wear only one pair of footwear.
 */
public class FootWear extends AddOns {
  List<String> nameList;

  /**
   * Constructor to initialize the Footwear.
   */
  public FootWear(int seed) {
    super();
    nameList = new ArrayList<String>(List.of("Clogs", "Flip-Flops", "Wedges", "Peep-Toe Shoes",
        "Mules", "Slide Sandals", "Hiker Shoes", "Snow Boots"));

    super.name = nameList.get(getRandom(nameList.size(), seed));
    impactDexterity(getRandom(4, seed));
    super.priority = 4;
  }

  @Override
  public String getType() {
    return this.getClass().getSimpleName();
  }

  @Override
  public int compareTo(AddOnInterface o) {
    if (!o.getType().equals("Battle.FootWear")) {
      return this.priority - ((AddOns) o).priority;
    } else {
      return this.compareToFootWear((FootWear) o);
    }
  }

  @Override
  public int compareToFootWear(FootWear o) {
    return this.getName().compareTo(o.getName());
  }

}
