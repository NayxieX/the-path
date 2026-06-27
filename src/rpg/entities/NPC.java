package rpg.entities;

public class NPC extends Character {
    
    public NPC(String name) {
        super(name, 5);
    }

    @Override
    public String getDescription() {
        return "NPC: " + getName() + " ХП: " + getHp();
    }
}
