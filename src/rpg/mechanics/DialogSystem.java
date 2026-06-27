package rpg.mechanics;

import rpg.entities.Hero;
import rpg.entities.Morlock;
import rpg.enums.ReputationLevel;
import rpg.util.ConsoleUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DialogSystem {

    public static void resolveMorlockFight(Hero hero, Morlock morlock, Scanner scanner) {
        System.out.println(morlock.getReaction(hero.getReputationReaction()));
        ConsoleUI.waitForEnter(scanner);

        List<MorlockQuestion> remaining = new ArrayList<>(getQuestionsForLevel(hero.getReputationReaction()));

        while (morlock.isAlive() && !remaining.isEmpty()) {
            System.out.println(morlock.getHpBar());
            System.out.println("Що питаєш?");
            for (int i = 0; i < remaining.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + remaining.get(i).text());
            }

            int input = ConsoleUI.readChoice(scanner, "> ", 1, remaining.size());
            MorlockQuestion chosen = remaining.remove(input - 1);

            morlock.takeDamage(chosen.damage());

            if (!morlock.isAlive()) {
                System.out.println("Останнє слово влучає глибше за будь-який клинок. Морлок падає на коліна,");
                System.out.println("і звук цього падіння глухо тоне у порожній залі - наче фортеця сама затримала дихання.");
                break;
            }

            System.out.println(chosen.reaction());
        }
    }

    private static List<MorlockQuestion> getQuestionsForLevel(ReputationLevel level) {
        return switch (level) {
            case HERO -> List.of(
                    new MorlockQuestion("\"Хто така Ліра?\"", 20,
                            "\"Не твоя справа,\" - голос тремтить. \"Не смій вимовляти це ім'я.\""),
                    new MorlockQuestion("\"Чому ти не зупинився?\"", 25,
                            "\"Я зупинявся! Сотні разів. А потім вони забирали ще щось.\""),
                    new MorlockQuestion("\"Чи був хтось хто міг тебе врятувати?\"", 30,
                            "Він мовчить довго. \"Був. Я сам відштовхнув його руку.\""),
                    new MorlockQuestion("\"Ти шкодуєш?\"", 50,
                            "\"Кожного дня. Кожної ночі. Це і є покарання, яке я обрав собі сам.\"")
            );
            case NEUTRAL -> List.of(
                    new MorlockQuestion("\"Чого ти насправді хотів?\"", 20,
                            "\"Хотів щоб вони перестали брехати. Замість цього навчився брехати краще за них.\""),
                    new MorlockQuestion("\"Якби міг повернутись - змінив би щось?\"", 25,
                            "\"Все. Нічого. Залежить від дня.\""),
                    new MorlockQuestion("\"Ти знав що так скінчиться?\"", 30,
                            "\"Ніхто не знає як скінчиться. Просто йде, поки щось не зупинить.\""),
                    new MorlockQuestion("\"Хто винен більше - ти чи король?\"", 50,
                            "Він сміється гірко. \"Яка різниця? Ми обидва тут.\"")
            );
            case ANTAGONIST -> List.of(
                    new MorlockQuestion("\"Ти слабкий бо дозволив їм зламати себе.\"", 20,
                            "\"Слабкий?\" - він раптом дуже спокійний. \"Подивись на трон, що йдеш забирати, і скажи це ще раз.\""),
                    new MorlockQuestion("\"Влада варта була цього чи ні?\"", 25,
                            "\"Запитай мене, коли сядеш на той трон сам.\""),
                    new MorlockQuestion("\"Якби міг - вбив би короля раніше?\"", 30,
                            "\"Щодня. І щодня щось зупиняло. Можливо, те саме, що зараз зупиняє тебе.\""),
                    new MorlockQuestion("\"Ти отримав що хотів врешті решт?\"", 50,
                            "Довга мовчанка. \"Я отримав трон і порожню кімнату. Спитай мене ще раз через двісті років.\"")
            );
        };
    }
}
