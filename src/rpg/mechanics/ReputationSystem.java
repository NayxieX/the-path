package rpg.mechanics;

import rpg.entities.Hero;
import rpg.enums.EndingType;

public class ReputationSystem {
    public static EndingType determineEnding(Hero hero) {
        return EndingType.fromReputationLevel(hero.getReputationReaction());
    }
}
