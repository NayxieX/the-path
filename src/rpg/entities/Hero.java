package rpg.entities;

import rpg.enums.ReputationLevel;

public class Hero extends Character {

    private static final int STARTING_REPUTATION = 50;
    private static final int MIN_REPUTATION = -50;
    private static final int MAX_REPUTATION = 100;

    private String heroAlias;
    private int reputation;

    // Ключові вибори глав 2-4 потрібні в наступних главах,
    // щоб показати наслідки конкретного рішення (а не лише сумарну репутацію).
    private int chapter2Choice;
    private int chapter3Choice;
    private int chapter4Choice;
    // Якого претендента (1 - Кейн, 2 - Сорін, 3 - Алан) гравець підтримав у Розділі 4 -
    // потрібно окремо від chapter4Choice, щоб пізніше посилатись на нього за іменем.
    private int claimantSupported;

    public Hero(String heroAlias, int hp) {
        super(heroAlias, hp);
        this.heroAlias = heroAlias;
        this.reputation = STARTING_REPUTATION;
    }

    public void addReputation(int amount) {
        this.reputation += amount;
        if (this.reputation > MAX_REPUTATION) this.reputation = MAX_REPUTATION;
        if (this.reputation < MIN_REPUTATION) this.reputation = MIN_REPUTATION;
    }

    public String getHeroAlias() {
        return heroAlias;
    }

    // Справжнього імені герой ніколи не дізнається. Цей метод лише фіксує
    // ЯКУ відповідь він дав охоронцю у Розділі 1 - НЕ ім'я в звичному сенсі.
    public void setHeroAlias(String heroAlias) {
        this.heroAlias = heroAlias;
        this.name = heroAlias;
    }

    public int getChapter2Choice() { return chapter2Choice; }
    public void setChapter2Choice(int chapter2Choice) { this.chapter2Choice = chapter2Choice; }

    public int getChapter3Choice() { return chapter3Choice; }
    public void setChapter3Choice(int chapter3Choice) { this.chapter3Choice = chapter3Choice; }

    public int getChapter4Choice() { return chapter4Choice; }
    public void setChapter4Choice(int chapter4Choice) { this.chapter4Choice = chapter4Choice; }

    public int getClaimantSupported() { return claimantSupported; }
    public void setClaimantSupported(int claimantSupported) { this.claimantSupported = claimantSupported; }

    public int getReputation() {
        return reputation;
    }

    public ReputationLevel getReputationReaction() {
        return ReputationLevel.fromScore(reputation);
    }

    @Override
    public String getDescription() {
        return heroAlias + " - мандрівник, що не пам'ятає власного імені.";
    }

    @Override
    public String toString() {
        return super.toString() + " | Реп: " + reputation + " (" + getReputationReaction() + ")";
    }
}
