package rpg.entities;

public abstract class Character {

    protected String name;
    protected int hp;
    protected int maxHp;

    public Character(String name, int hp) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Ім'я персонажа не може бути порожнім.");
        }
        if (hp <= 0) {
            throw new IllegalArgumentException("HP має бути більше 0.");
        }
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
    }

    // ── Бойові методи ──────────────────────────────────────

    public void takeDamage(int damage) {
        if (damage < 0) throw new IllegalArgumentException("Damage не може бути від'ємним.");
        this.hp = Math.max(0, this.hp - damage);
    }

    public void heal(int amount) {
        if (amount < 0) throw new IllegalArgumentException("Heal не може бути від'ємним.");
        this.hp = Math.min(maxHp, this.hp + amount);
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public boolean isWeakened() {
        return this.hp < this.maxHp / 2;
    }

    // ── Абстрактні методи ──────────────────────────────────

    public abstract String getDescription();

    // ── Гетери / Сетери ────────────────────────────────────

    public String getName() { return name; }

    public int getHp() { return hp; }

    public int getMaxHp() { return maxHp; }

    public String getHpBar() {
        int filled = (int) Math.round((double) hp / maxHp * 5);
        return "●".repeat(filled) + "○".repeat(5 - filled);
    }

    // ── toString ───────────────────────────────────────────

    @Override
    public String toString() {
        return String.format("%s | HP: [%s] %d/%d", name, getHpBar(), hp, maxHp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character that = (Character) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
