package rpg.interfaces;

import rpg.enums.ReputationLevel;

/**
 * Контракт для персонажів, що по-різному реагують (репліками, поведінкою)
 * залежно від поточної репутації героя. Реалізують NPC та Enemy —
 * у самого Hero своєї "реакції" немає, бо репутація належить йому самому.
 */
public interface ReputationReactive {

    String getReaction(ReputationLevel heroLevel);
}
