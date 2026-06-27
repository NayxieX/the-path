package rpg.enums;
import rpg.exceptions.InvalidChoiceException;

public enum CombatAction {

    KILL(5, "[1] Атакувати і вбити", true),
    SUBDUE(10, "[2] Знешкодити і зв'язати", false),
    SCARE(3, "[3] Залякати і відпустити", false),
    AMBUSH(0, "[4] Вдарити ззаду без попередження", true),
    LOOT(-5, "[5] Вбити і обшукати тіло", true);


    private final int repChange;
    private final String description;
    private final boolean alwaysAvailable;

    CombatAction(int repChange, String description, boolean alwaysAvailable) {
        this.repChange = repChange;
        this.description = description;
        this.alwaysAvailable = alwaysAvailable;
    }
    public int getRepChange() {
        return repChange;
    }
    public String getDescription() {
        return description;
    }
    public boolean isAlwaysAvailable() {
        return alwaysAvailable;
    }

    public static CombatAction fromInput(int input) {
        return  switch (input) {
        case  1 -> KILL;
        case 2 -> SUBDUE;
        case 3 -> SCARE;
        case 4 -> AMBUSH;
        case 5 -> LOOT;
        default -> throw new InvalidChoiceException(input);
        };
    }
    @Override
    public String toString() {
        return description;
    }
}
