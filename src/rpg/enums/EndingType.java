package rpg.enums;

public enum EndingType {

    HERO_END(ReputationLevel.HERO, """
    Правда про Морлока вийшла на світло.
    Люди не знали як реагувати. Плакали. Сварились. Мовчали.
    Твого імені ніхто не знає.
    Абігейл виросте і напише книгу про героя без імені.
    Вона присвятить її матері. І людині з лісу."""),
    NEUTRAL_END(ReputationLevel.NEUTRAL, """  
    Ні краще ні гірше. Просто інакше.
    Ти йдеш далі. Без мети. Без імені.
    Іноді в таверні хтось розповідає легенду про мандрівника
    який зупинив темряву. В кожній версії він виглядає по-різному.
    Може це і є безсмертя."""
          ),
    VILLAIN_END(ReputationLevel.ANTAGONIST, """
    Трон холодний. Вони бояться тебе.
    Вночі іноді чуєш лютню.
    Ніхто більше не грає — але звук є.
    Ти не шукаєш звідки він.
    Бо десь знаєш відповідь. І вона тобі не подобається.""");

    private final ReputationLevel requiredLevel;
    private final String endingText;

    EndingType(ReputationLevel requiredLevel, String endingText) {
        this.requiredLevel = requiredLevel;
        this.endingText = endingText;
    }

    public static EndingType fromReputationLevel(ReputationLevel level) {
        if (level == null) {return NEUTRAL_END;}
        return switch (level) {
            case HERO -> HERO_END;
            case NEUTRAL -> NEUTRAL_END;
            case ANTAGONIST -> VILLAIN_END;
        };
    }
    public ReputationLevel getRequiredLevel() { return requiredLevel; }
    public String getEndingText()             { return endingText; }

    @Override
    public String toString() { return requiredLevel.getDisplayName() + " кінцівка"; }
}