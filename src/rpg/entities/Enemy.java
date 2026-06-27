package rpg.entities;
import rpg.enums.ReputationLevel;
import rpg.interfaces.ReputationReactive;
public class Enemy extends Character implements ReputationReactive {


    private final String accusativeName;

    public Enemy(String name, int hp) {
        super(name, hp);
        this.accusativeName = name;
    }

    public Enemy(String name, String accusativeName, int hp) {
        super(name, hp);
        this.accusativeName = accusativeName;
    }

    public String getAccusativeName() {
        return accusativeName;
    }

    @Override
    public String getDescription(){
        return "Ворог: " +getName() + " ХП: " + getHp();
    }

    @Override
    public String getReaction(ReputationLevel heroLevel) {
        return switch (heroLevel) {
            case HERO ->  "Ворог: " + getName() + " боїться тебе!";
            case NEUTRAL ->  "Ворог: " + getName() + " обережний навколо тебе.";
            case ANTAGONIST -> "Ворог: " + getName() + " ворожий до тебе!";
        };
    }

}
