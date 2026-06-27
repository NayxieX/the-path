package rpg.mechanics;

// Один варіант репліки у фінальному діалоговому бою з Морлоком.
// damage - скільки ХП знімає ця реплика, reaction - власна відповідь Морлока
// саме на це питання (а не загальна фраза для всіх питань підряд).
public record MorlockQuestion(String text, int damage, String reaction) {
}
