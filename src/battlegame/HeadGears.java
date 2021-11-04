package battlegame;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for addon of type Headgear which can be equipped by the player. Headgear has the ability
 * to impacts the constitution of the player and one player can wear only one headgear at a time.
 */
public class HeadGears extends AddOns {

  List<String> nameList;

  /**
   * Constructor to initialize the Addons.
   */
  public HeadGears(int seed) {
    super();
    nameList = new ArrayList<String>(List.of("Baseball Cap", "Bowler Hat",
        "Cowboy Hat", "Homburg Hat", "Top Hat", "Sun Hat", "Vagabond Hat", "Cloche Hat", "Bonnet"));
    super.priority = 1;
    super.name = nameList.get(getRandom(nameList.size(), seed));
    impactConstitution(getRandom(5, seed));
  }

  @Override
  public int compareTo(AddOnInterface o) {
    if (!o.getType().equals("Battle.HeadGears")) {
      return this.priority - ((AddOns) o).priority;
    } else {
      return this.compareToHeadGears((HeadGears) o);
    }
  }

  @Override
  public int compareToHeadGears(HeadGears o) {
    return this.getName().compareTo(o.getName());
  }

  @Override
  public String getType() {
    return this.getClass().getSimpleName();
  }
}
