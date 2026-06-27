package rpg.mechanics;

import rpg.enums.CombatAction;
import rpg.entities.Hero;
import rpg.entities.Enemy;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import rpg.exceptions.InvalidChoiceException;

public class CombatSystem {
    
    public static List<CombatAction> getAvailableActions(Enemy enemy) {
        return new ArrayList<>(List.of(CombatAction.values()));
    }

    public static CombatAction resolveCombat(Hero hero, Enemy enemy, Scanner scanner) {
        List<CombatAction> availableActions = getAvailableActions(enemy);
        System.out.println("Доступні дії:");
        for (CombatAction action : availableActions) {
            System.out.println(action.getDescription());
        }
        CombatAction chosenAction = null;
        while (chosenAction == null) {
            System.out.print("Виберіть дію (1-5): ");
            try {
                int input = scanner.nextInt();
                scanner.nextLine(); 
                chosenAction = CombatAction.fromInput(input);
                if (!getAvailableActions(enemy).contains(chosenAction)) {
                    System.out.println("Ця дія недоступна для цього ворога. Спробуйте ще раз.");
                    chosenAction = null;
                } else {
                    hero.addReputation(chosenAction.getRepChange());
                    System.out.println(getOutcomeText(chosenAction, enemy));
                }
            } catch (InvalidChoiceException e) {
                System.out.println(e.getMessage());
            } catch (java.util.InputMismatchException e) {
                System.out.println("Це не число. Спробуйте ще раз.");
                scanner.nextLine(); 
            }
        }
        return chosenAction;
    }

    private static String getOutcomeText(CombatAction action, Enemy enemy) {
        String who = enemy.getAccusativeName();
        return switch (action) {
            case KILL -> "Ти вбив " + who + ". Швидко і без вагань.";
            case SUBDUE -> "Ти знешкодив " + who + " і зв'язав.";
            case SCARE -> "Ти залякав " + who + " і відпустив.";
            case AMBUSH -> "Ти вдарив " + who + " ззаду без попередження.";
            case LOOT -> "Ти вбив " + who + " і обшукав тіло.";
        };
    }
}


