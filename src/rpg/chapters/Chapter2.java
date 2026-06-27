package rpg.chapters;

import rpg.entities.Hero;
import rpg.entities.NPC;
import rpg.entities.Enemy;
import rpg.enums.CombatAction;
import rpg.enums.ReputationLevel;
import rpg.interfaces.Chapter;
import rpg.mechanics.CombatSystem;
import rpg.util.ConsoleUI;
import java.util.Scanner;

public class Chapter2 implements Chapter {

    @Override
    public void play(Hero hero, Scanner scanner) {
        playWoundedTraveler(hero, scanner);
        ConsoleUI.printDivider();
        playMemoryFragment(scanner);
        ConsoleUI.printDivider();
        playWitch(hero, scanner);
        ConsoleUI.printDivider();
        playBandits(hero, scanner);
        ConsoleUI.waitForEnter(scanner);

        System.out.println("Ліс рідіє. Дим над дахами на горизонті - попереду село.");
        ConsoleUI.waitForEnter(scanner);
    }

    private void playMemoryFragment(Scanner scanner) {
        System.out.println("Щось змушує тебе зупинитися біля старого колодязя на краю просіки.");
        System.out.println("Ти підходиш ближче, сам не розуміючи навіщо, і нахиляєшся, кладучи долоню на край каменю.");
        System.out.println("Камінь холодний і вологий під пальцями - і чомусь знайомий, хоч ти тут точно вперше.");
        System.out.println("Заглядаєш у темряву всередині. Власне відображення тремтить десь на дні, серед чорної води.");
        System.out.println("І на мить - голос. Свій власний, але молодший:");
        System.out.println("\"...тримайся за мене, добре? Я не відпущу.\"");
        System.out.println("Кому ти це казав? Ти різко відсмикуєш руку від каменю, наче обпікся. Голос зникає швидше, ніж встигаєш зрозуміти.");
        ConsoleUI.waitForEnter(scanner);
    }

    private void playWoundedTraveler(Hero hero, Scanner scanner) {
        System.out.println("Ліс змикається над головою, тиша така густа, що чути власні кроки по хвої.");
        System.out.println("Десь збоку - тихий хрип. Не звіриний. Людський.");
        System.out.println("Можна було б пройти мимо і не зважати. Та цікавість, як завжди, перемагає - не страх, просто бажання знати, що там.");
        System.out.println("Ти звертаєш з дороги і йдеш на звук.");
        System.out.println();

        NPC traveler = new NPC("Поранений мандрівник");
        System.out.println("Чоловік під деревом. Стріла в плечі. Біля нього - сумка з золотом.");
        System.out.println(traveler.getName() + ": \"Допоможи... будь ласка...\"");

        int choice = ConsoleUI.readChoice(scanner,
                "[1] Допомогти, залишити золото\n" +
                "[2] Взяти трохи золота і допомогти\n" +
                "[3] Забрати все золото і піти\n> ", 1, 3);

        switch (choice) {
            case 1 -> {
                System.out.println("Ти витягуєш стрілу, перев'язуєш рану. Золото лишається на місці.");
                hero.addReputation(15);
            }
            case 2 -> {
                System.out.println("Ти береш трохи монет і все ж перев'язуєш рану. Він мовчки киває.");
                hero.addReputation(0);
            }
            default -> {
                System.out.println("Ти забираєш всю сумку і йдеш геть.");
                System.out.println("Через хвилину стогін зупиняється. Тиша. Ти розумієш сам.");
                hero.addReputation(-15);
            }
        }
    }

    private void playWitch(Hero hero, Scanner scanner) {
        System.out.println("Голос від колодязя ще не йде з голови. Ти блукаєш між деревами, сам не знаючи, що шукаєш,");
        System.out.println("аж доки не виходиш просто на вогнище, що тліє між корінням старого дуба.");

        NPC witch = new NPC("Стара відьма");
        System.out.println(witch.getName() + " співає колискову спиною до тебе.");
        System.out.println("Обертається. Довго мовчить.");

        switch (hero.getReputationReaction()) {
            case HERO -> {
                System.out.println("\"Ті самі очі... але тепліші.\"");
                System.out.println("Дає їжу. Показує рукою кудись між дерев. \"Туди. І не звертай, що б ти там не почув.\"");
            }
            case NEUTRAL -> {
                System.out.println("\"Ті самі очі...\"");
                System.out.println("Мовчить ще мить, потім коротко вказує напрямок між деревами і йде в темряву, не сказавши більше нічого.");
            }
            case ANTAGONIST -> {
                System.out.println("\"Ті самі очі... але темніші.\"");
                System.out.println("Кидає їжу тобі під ноги і тікає - та перш ніж зникнути, тремтячою рукою тицяє кудись між дерев, аби ти швидше пішов звідси.");
            }
        }
        ConsoleUI.waitForEnter(scanner);
    }

    private void playBandits(Hero hero, Scanner scanner) {
        System.out.println("Ти йдеш у вказаному напрямку - спершу стежкою, потім просто проштовхуючись через гущавину, що чіпляється за одяг.");
        System.out.println("За годину ходьби ти чуєш крик. Жіночий - чи то благає, чи то просить. І чоловічі голоси, не один - спершу здається, що їх п'ять, може й більше.");
        System.out.println("Ти насторожуєшся і повільно, тихо підходиш ближче, ховаючись у кущах.");
        System.out.println("Голосів, коли роздивляєшся крізь гілки, виявляється менше, ніж здавалося в гущавині - лише троє, та й ті при возі.");
        System.out.println("Троє бандитів. Клітка на возі. Всередині - жінка і маленька дівчинка, з якими поводяться як з рабами, а не з людьми.");
        System.out.println("Роздумувати довго нема коли. Ти виходиш з кущів.");
        System.out.println();

        switch (hero.getReputationReaction()) {
            case HERO -> System.out.println("Бандит: \"Іди своєю дорогою, друже.\" - він нервує.");
            case NEUTRAL -> System.out.println("Бандит: \"Хочеш приєднатись? Ділимось чесно.\"");
            case ANTAGONIST -> System.out.println("Бандит: \"Брате. Є робота якщо цікавить.\" - одразу вважає своїм.");
        }

        int choice = ConsoleUI.readChoice(scanner,
                "[1] Захистити\n" +
                "[2] Домовитись\n" +
                "[3] Темний варіант\n> ", 1, 3);

        hero.setChapter2Choice(choice);

        switch (choice) {
            case 1 -> {
                Enemy bandits = new Enemy("Бандити", "бандитів", 25);
                System.out.println(bandits.getDescription());
                CombatAction action = CombatSystem.resolveCombat(hero, bandits, scanner);
                hero.addReputation(15);
                ConsoleUI.waitForEnter(scanner);

                playRescuedMotherDialogue(scanner);

                if ((action == CombatAction.SUBDUE || action == CombatAction.SCARE)
                        && hero.getReputationReaction() == ReputationLevel.HERO) {
                    ConsoleUI.printDivider();
                    System.out.println("Сільвія перехоплює твій погляд, що зупинився на зв'язаному бандиті біля воза.");
                    System.out.println("\"Він тобі вже нічого не зробить,\" - каже вона тихо. \"Можеш спитати, якщо хочеш знати. Я почекаю.\"");
                    playBanditBackstory(scanner);
                }
            }
            case 2 -> {
                System.out.println("Ти підходиш відкрито, тримаючи руки на видноті. \"Є пропозиція. Вигідніша за бійку.\"");
                System.out.println("Бандити перезираються - такого вони не чекали. Поки ти говориш про ціну і ризики, не блефуючи й не поспішаючи,");
                System.out.println("жінка непомітно тягне дівчинку до щілини між возами. Ти бачиш це краєм ока і говориш голосніше, перекриваючи шум.");
                System.out.println("\"...тому простіше відпустити, ніж тягнути зайвий вантаж,\" - закінчуєш ти, коли клітка вже порожня.");
                System.out.println("Один з бандитів помічає це за мить пізніше і лається - та гнатися вже немає сенсу, слід стерся між деревами.");
                System.out.println("Ти йдеш у протилежний бік, навіть не встигнувши спитати, як їх звати.");
                hero.addReputation(0);
            }
            default -> {
                System.out.println("Бандити мертві. Ти витираєш зброю. Повільно. Акуратно.");
                System.out.println("Підходиш до клітки. Присідаєш на рівні очей з дівчинкою.");
                System.out.println("Мовчиш довго. Потім до матері - спокійно, майже лагідно:");
                System.out.println("\"Як її звати?\"");
                System.out.println("\"...Абігейл.\"");
                System.out.println("\"Абігейл.\"");
                System.out.println("Ти повторюєш ім'я ніби пробуєш на смак. Встаєш.");
                System.out.println("\"Проведеш мене до міста.\"");
                System.out.println("\"А потім?\"");
                System.out.println("Довга пауза. \"Побачимо.\"");
                System.out.println("Вона йде бо невідомість страшніша ніж будь-яка погроза.");
                System.out.println("Донька не плаче. Тримає матір за руку.");
                System.out.println("І більше не заплющує очі - бо тепер боїться що поки очі закриті ти можеш зникнути. Або не зникнути.");
                hero.addReputation(-15);
            }
        }
    }

    // Завжди відбувається після врятування жінки з дочкою (вибір "Захистити") -
    // знайомство, історія їхньої втечі та перша згадка про культ, що керує селом.
    private void playRescuedMotherDialogue(Scanner scanner) {
        System.out.println("Жінка кидається до клітки і обіймає дочку. Дівчинка визирає з-за неї, не зводячи з тебе очей.");
        System.out.println("\"Дякую,\" - видихає жінка, відсапуючись. \"Мене звати Сільвія. А це - Абігейл.\"");
        System.out.println();
        System.out.println("\"Як ви опинились у бандитів?\" - питаєш ти.");
        System.out.println("\"Йшли через ліс - надія дістатись до родичів за горами. Вистежили нас за день.\"");
        System.out.println("Вона замовкає, наче вирішуючи, чи варто казати далі. Потім тихо додає:");
        System.out.println("\"Ми тікали не від голоду. Від культу.\"");
        System.out.println("\"Культу?\" - перепитуєш ти.");
        System.out.println("\"Морлока. Кажуть, що служать пам'яті старости, а насправді давно керують усім самі.\"");
        System.out.println("\"Староста лише підписує те, що вони пишуть. Хто йде проти - зникає.\"");
        System.out.println();
        System.out.println("\"Я знаю дорогу через ліс,\" - каже вона нарешті. \"Можу провести тебе до села, якщо підеш туди.\"");
        ConsoleUI.waitForEnter(scanner);
    }

    // Лише для HERO, і тільки якщо бандит лишився живий (SUBDUE/SCARE) -
    // чисто сторітелінговий бонус без впливу на репутацію.
    private void playBanditBackstory(Scanner scanner) {
        System.out.println("Один з бандитів, зв'язаний, дивиться на тебе знизу вгору.");
        System.out.println("\"Чого тобі ще треба?\" - бурмотить він, та в очах радше страх, ніж злість.");

        int choice = ConsoleUI.readChoice(scanner,
                "[1] \"Як тебе звати? Як ти тут опинився?\"\n" +
                "[2] Залишити його і йти далі\n> ", 1, 2);

        if (choice == 1) {
            System.out.println("\"Дарен,\" - відповідає він не зразу. \"Був кравцем. Поки культ не спалив нашу майстерню.\"");
            System.out.println("\"Сказали - 'неправильні' символи на тканинах. Брехня. Просто хтось хотів наше місце на ринку.\"");
            System.out.println("\"Після цього що залишається? Або вмерти з голоду, або грабувати дорогу.\"");
            System.out.println("Він кивком показує на інших. \"Вони з того ж села. Усі не від хорошого життя.\"");
            System.out.println("Ти розв'язуєш йому руки. Він не вірить власному щастю ще кілька секунд.");
        } else {
            System.out.println("Ти лишаєш його зв'язаним і йдеш далі. Деякі питання краще не ставити.");
        }
        ConsoleUI.waitForEnter(scanner);
    }
}
