package rpg.enums;

public enum ReputationLevel {
    HERO("Герой", 80 ,Integer.MAX_VALUE),
    NEUTRAL("Нейтральний", 31 , 79),
    ANTAGONIST("Антагоніст", Integer.MIN_VALUE , 30);

    private final String displayName;
    private final int maxValue;
    private final int minValue;

    ReputationLevel(String displayName, int maxValue, int minValue) {
        this.displayName = displayName;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    public static ReputationLevel fromScore(int score) {
        if (score >= 80) return HERO;
        if (score >= 31)  return NEUTRAL;
        return ANTAGONIST;
    }

    public String getDisplayName() {return displayName;}
    public int getMaxValue() {return maxValue;}
    public int getMinValue() {return minValue;}

    @Override
    public String toString() {
        return displayName;
    }
}
