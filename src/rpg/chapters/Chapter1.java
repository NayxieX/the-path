package rpg.chapters;

import rpg.entities.Hero;
import rpg.entities.Enemy;
import rpg.interfaces.Chapter;
import rpg.mechanics.CombatSystem;
import rpg.util.ConsoleUI;
import java.util.Scanner;

public class Chapter1 implements Chapter {

    @Override
    public void play(Hero hero, Scanner scanner) {
        System.out.println("Темрява. Холод. Камінь під руками.");
        System.out.println("Ти прокидаєшся.");
        System.out.println("Нічого не пам'ятаєш. Навіть імені.");
        System.out.println("На стіні - напис:");
        System.out.println("\"Вона чекає тебе. Не здавайся. - М.\"");
        ConsoleUI.waitForEnter(scanner);

        System.out.println("Охоронець дивиться крізь ґрати. Питає:");
        System.out.println("Охоронець: \"Як тебе звати?\"");

        int choice = ConsoleUI.readChoice(scanner,
                "[1] \"Яка різниця як мене звати?\"\n" +
                "[2] \"Я не пам'ятаю.\"\n" +
                "[3] \"Відкрий темницю і дізнаєшся.\"\n> ", 1, 3);

        String response = switch (choice) {
            case 1 -> "Яка різниця як мене звати?";
            case 2 -> "Я не пам'ятаю.";
            default -> "Відкрий темницю і дізнаєшся.";
        };
        hero.setHeroAlias(response);

        switch (choice) {
            case 1 -> {
                System.out.println("Охоронець хмикає. \"Значить не важливо.\" Але щось в очах - цікавість.");
                System.out.println("Лишає двері незачиненими... \"випадково\".");
            }
            case 2 -> {
                System.out.println("Охоронець вагається. Щось викликає довіру.");
                System.out.println("Розповідає, що тебе привезли без свідомості.");
                System.out.println("Лишає двері незачиненими... \"випадково\".");
            }
            default -> {
                System.out.println("Охоронець йде. Повертається п'яний і злий.");
                System.out.println("Бій неминучий.");
            }
        }

        System.out.println();
        System.out.println("Ім'я - просто звук.");
        System.out.println("Не важливо яке воно.");
        System.out.println("Важливо що ти з ним зробиш.");
        ConsoleUI.waitForEnter(scanner);

        if (choice == 3) {
            Enemy guard = new Enemy("Сп'янілий охоронець"," Сп'янілого охоронця", 15);
            System.out.println(guard.getDescription());
            CombatSystem.resolveCombat(hero, guard, scanner);
        } else {
            System.out.println("Десь у глибині свідомості ти розумієш одне: цей охоронець,");
            System.out.println("пожалівши тебе, сам колись заплатить за це рішення.");
            System.out.println("Але звідки тобі це знати? Ти йдеш геть з темниці.");
        }
        ConsoleUI.waitForEnter(scanner);

        System.out.println("На виході ти проводиш рукою по холодній стіні.");
        System.out.println("На мить - тепло. Чужа долоня в твоїй. Сміх, що обривається на половині.");
        System.out.println("Ти не пам'ятаєш чийого. Але тіло пам'ятає те, чого не пам'ятає голова.");
        ConsoleUI.waitForEnter(scanner);

        System.out.println("Двері темниці лишаються позаду. Попереду - тільки дорога і ліс на горизонті.");
        ConsoleUI.waitForEnter(scanner);
    }
}
