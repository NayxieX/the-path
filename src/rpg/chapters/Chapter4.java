package rpg.chapters;

import rpg.entities.Hero;
import rpg.interfaces.Chapter;
import rpg.util.ConsoleUI;
import java.util.Scanner;

public class Chapter4 implements Chapter {

    @Override
    public void play(Hero hero, Scanner scanner) {
        playVillageAftermath(hero);
        ConsoleUI.printDivider();
        playAbigailMarket(hero);
        ConsoleUI.printDivider();
        playClaimants(hero, scanner);
        ConsoleUI.printDivider();
        playSealSociety(scanner);
        ConsoleUI.waitForEnter(scanner);
        ConsoleUI.printDivider();
        playArchiveChoice(hero, scanner);
        ConsoleUI.waitForEnter(scanner);

        System.out.println("Архів за плечима, дорога попереду веде до останньої брами.");
        System.out.println("Туди де чекає Морлок. Туди де чекає відповідь.");
        ConsoleUI.waitForEnter(scanner);
    }

    private void playVillageAftermath(Hero hero) {
        switch (hero.getChapter3Choice()) {
            case 1 -> {
                System.out.println("\"Культ викритий. Жителі одужують.\"");
                System.out.println("Дрібна замітка: \"Невідомий чужинець допоміг.\"");
            }
            case 2 -> {
                System.out.println("\"Культ все ще там. Старосту знайшли за селом наступного ранку.\"");
            }
            default -> {
                System.out.println("На ринку замку продають рабів. Ти впізнаєш обличчя - жителі села.");
                System.out.println("Культист киває з подякою.");
            }
        }
    }

    private void playAbigailMarket(Hero hero) {
        System.out.println("Вона і мати - тут. Їхні очі зустрічаються з твоїми.");
        switch (hero.getChapter2Choice()) {
            case 1 -> System.out.println("Мати ледь киває тобі - з обережною вдячністю. Абігейл усміхається.");
            case 2 -> System.out.println("Вони дивляться на тебе байдуже, як на чужинця, якого ледь пам'ятають.");
            default -> System.out.println("Абігейл відразу хапає матір за руку і відводить погляд. Вона досі тебе боїться.");
        }
    }

    // Чисто сторітелінговий момент - вибір нічого не дає і не забирає з репутації,
    // лише трохи розкриває світ через те, кого гравець підтримає і чому.
    // Інформація про претендентів подається не від них самих напряму, а через
    // підслухані/випитані чужі слова - спершу слугу, потім капітана гарнізону.
    private void playClaimants(Hero hero, Scanner scanner) {
        System.out.println("Зала прийомів ще порожня. Слуга поспішає кудись із тацею - ти зупиняєш його коротким питанням.");
        System.out.println("\"Перепрошую. Хто такий Лорд Кейн?\"");
        System.out.println("Слуга озирається, наче боїться що почують. \"Військовий. Каже - спалити архів, бо минуле слабить людей.");
        System.out.println("Він втратив під ним половину гарнізону. Для нього це не політика - особисте.\"");

        int choice = ConsoleUI.readChoice(scanner,
                "[1] \"А що з приводу Леді Сорін?\"\n" +
                "[2] Цього досить, дякую\n> ", 1, 2);

        if (choice == 1) {
            System.out.println("Слуга стишує голос ще більше. \"Торговка. Хоче продати архів тому, хто заплатить більше.");
            System.out.println("Каже, що не питає, навіщо комусь правда - просто називає ціну.\"");
        } else {
            System.out.println("\"Зрозуміло, дякую,\" - кажеш ти. Слуга киває і поспішає далі своєю дорогою.");
        }

        System.out.println();
        System.out.println("Між тобою і дверима зали раптом стає жінка в обладунку, що йшла швидше, ніж здавалося.");
        System.out.println("\"Перепрошую, що втручаюсь,\" - каже вона, хоч у голосі не чути особливого жалю. \"Капітан Рейна, одна з командирів гарнізону.\"");
        System.out.println("\"Якщо вже розпитуєш про претендентів - запитай і про Брата Алана. Інші про нього мовчать, з різних причин.\"");
        System.out.println("\"Жрець. Хоче знищити архів - 'єресь, записана чорнилом, лишається єрессю', як він каже.\"");
        System.out.println("\"Та щоразу, коли він це каже, в голосі чути не переконаність, а страх. Ніби там написано і про нього самого.\"");
        System.out.println("Капітан киває тобі і прямує до зали, не чекаючи подяки.");
        ConsoleUI.waitForEnter(scanner);
        ConsoleUI.printDivider();

        System.out.println("Троє претендентів на трон чекають у залі прийомів.");
        System.out.println("Кожен по-своєму дивиться на тебе - як на загрозу, інструмент або цікавість.");
        System.out.println("Жоден з них не питає хто такий насправді Морлок. Їх цікавить лише трон, який він залишить порожнім.");
        System.out.println();
        System.out.println("Кого з трьох ти підтримаєш?");
        int support = ConsoleUI.readChoice(scanner,
                "[1] Лорд Кейн\n" +
                "[2] Леді Сорін\n" +
                "[3] Брат Алан\n> ", 1, 3);

        hero.setClaimantSupported(support);

        ConsoleUI.printDivider();
        playClaimantCutscene(support, scanner);
    }

    private void playClaimantCutscene(int claimant, Scanner scanner) {
        switch (claimant) {
            case 1 -> playKaneCutscene(scanner);
            case 2 -> playSorinCutscene(scanner);
            default -> playAlanCutscene(scanner);
        }
    }

    private void playKaneCutscene(Scanner scanner) {
        System.out.println("Ти лишаєшся з Кейном після того, як інші виходять із зали.");
        System.out.println("\"Чому трон?\" - питаєш ти прямо.");
        System.out.println("Він довго дивиться на меч на стіні, перш ніж відповісти.");
        System.out.println("\"Я тримав цей гарнізон двадцять років. Бачив, як старий король втрачав контроль рік за роком.\"");
        System.out.println("\"Якщо я не сяду на той трон - сяде хтось гірший. Я принаймні знаю ціну хаосу.\"");

        int choice = ConsoleUI.readChoice(scanner,
                "[1] \"Ціну для кого - для тебе чи для людей?\"\n" +
                "[2] \"А якщо ти сам станеш тим хаосом?\"\n> ", 1, 2);

        if (choice == 1) {
            System.out.println("Він мовчить довше ніж очікувано. \"Я давно перестав розрізняти ці двоє.\"");
            System.out.println("\"Можливо, це і є проблема. Але принаймні я чесний щодо неї.\"");
        } else {
            System.out.println("Щось ламається в його погляді - на мить. \"Тоді сподіваюсь, хтось такий як ти зупинить мене.\"");
            System.out.println("\"Як зараз зупиняєш Морлока.\"");
        }

        System.out.println();
        System.out.println("Він киває тобі - вперше як рівному, а не як знаряддю.");
        System.out.println("\"Іди. Закінчи те, що почав. Трон підождe.\"");
        ConsoleUI.waitForEnter(scanner);
    }

    private void playSorinCutscene(Scanner scanner) {
        System.out.println("Сорін лишається сама з тобою, нарешті відклавши монету.");
        System.out.println("\"Чому трон?\" - питаєш ти.");
        System.out.println("\"Бо я пам'ятаю голод,\" - відповідає вона без звичної посмішки. \"Справжній. Той, що забирає молодших першими.\"");
        System.out.println("\"Гроші - це просто спосіб ніколи більше не бути тією дитиною. Трон - це останній спосіб, який мені залишився.\"");

        int choice = ConsoleUI.readChoice(scanner,
                "[1] \"А люди в цьому королівстві - вони для тебе теж товар?\"\n" +
                "[2] \"Влада нагодує тебе більше, ніж золото вже наситило?\"\n> ", 1, 2);

        if (choice == 1) {
            System.out.println("\"Товар, який я не дам нікому спалити чи продати дешевше, ніж він вартий,\" - відрізає вона.");
            System.out.println("\"Можеш не вірити мені на слово. Просто дивись, що я робитиму.\"");
        } else {
            System.out.println("Вона сміється, але сміх якийсь надламаний. \"Ні. Але голод не питає логіки.\"");
            System.out.println("\"Він просто завжди шепоче, що наступного разу буде достатньо.\"");
        }

        System.out.println();
        System.out.println("Вона ховає монету у кишеню - вперше за весь час без розрахунку в очах.");
        System.out.println("\"Йди. Я триматиму це місце для того, хто повернеться його заслужити.\"");
        ConsoleUI.waitForEnter(scanner);
    }

    private void playAlanCutscene(Scanner scanner) {
        System.out.println("Алан просить тебе лишитися, поки інші йдуть. Амулет досі в його пальцях.");
        System.out.println("\"Чому трон?\" - питаєш ти.");
        System.out.println("\"Бо двадцять років тому я носив інший символ,\" - каже він тихо. \"Той самий, що на стінах темниці.\"");
        System.out.println("\"Я вийшов з культу живим. Майже ніхто інший не вийшов.\"");

        int choice = ConsoleUI.readChoice(scanner,
                "[1] \"Чому ти пішов?\"\n" +
                "[2] \"Трон - це покута чи нова форма того ж культу?\"\n> ", 1, 2);

        if (choice == 1) {
            System.out.println("\"Побачив, кого вони називали наступною жертвою,\" - відповідає він. \"Дитину. Я не зміг.\"");
            System.out.println("\"З того дня я ношу два тягарі - вину тих, кого не врятував, і страх перед тим, ким міг стати.\"");
        } else {
            System.out.println("Він не ображається на питання - лише сумно киває. \"Чесно? Я не завжди знаю різницю.\"");
            System.out.println("\"Тому мені потрібен хтось ззовні, хто скаже, коли я переступлю межу. Можливо, ти.\"");
        }

        System.out.println();
        System.out.println("\"Йди до нього,\" - каже Алан нарешті. \"Морлок носив той самий символ. Можливо, тільки ти зрозумієш чому.\"");
        ConsoleUI.waitForEnter(scanner);
    }

    // Голос у підвалі виявляється тим самим дідом з таверни в Розділі 3 -
    // явний зв'язок двох "двісті років" замість випадкового збігу чисел.
    private void playSealSociety(Scanner scanner) {
        System.out.println("Слова претендента ще довго не дають заснути. Ти бродиш порожніми коридорами замку, не знаючи, куди йдеш і навіщо.");
        System.out.println("У тіні під старими сходами, де давно не міняли смолоскип, помічаєш видряпаний на каменю знак.");
        System.out.println("Символ - той самий, що біля напису Морлока у в'язниці.");
        System.out.println("Під ним - записка, яку хтось підсунув щойно, поки ти не дивився: \"Підвал. Північ. Один.\"");
        System.out.println();
        System.out.println("\"Ми чекали тебе двісті років.\"");
        System.out.println("Голос виходить із тіні разом зі своїм власником - і це не дивно. Тільки знайомо.");
        System.out.println("Той самий дід з таверни в селі. Той самий хрипкий голос, що казав тобі правду про чуму.");
        System.out.println("\"Не дивуйся,\" - каже він, перш ніж ти встигаєш спитати. \"Двісті років - довгий час, та не для всіх. Я казав правду тоді. Кажу і зараз.\"");

        int choice = ConsoleUI.readChoice(scanner,
                "[1] \"Чому ти не сказав прямо ще в селі?\"\n" +
                "[2] \"Хто ще з вас живий стільки ж?\"\n> ", 1, 2);

        if (choice == 1) {
            System.out.println("\"Бо правду треба заслужити почути. Ти заслужив - тим, що дійшов аж сюди.\"");
        } else {
            System.out.println("\"Менше, ніж хотілося б. Цикл забирає не лише тих, хто намагається його розірвати.\"");
        }

        System.out.println();
        System.out.println("\"Не тебе особисто ми чекали. Когось хто пройде той самий шлях.\"");
        System.out.println("\"Ти спав там де спав Морлок.\"");
        System.out.println("\"Прокинувся без пам'яті як він.\"");
        System.out.println("\"Чому саме я?\" - питаєш ти. Старий відповідає не зразу:");
        System.out.println("\"Тому що цикл шукає не сильних. Він шукає тих, хто зможе його розірвати.\"");
        System.out.println("\"Ти єдиний претендент якого ми бачили за двісті років.\"");
    }

    private void playArchiveChoice(Hero hero, Scanner scanner) {
        System.out.println("\"Цикл шукає того, хто зможе його розірвати,\" - сказав старий. Слова, з якими важко просто піти спати.");
        System.out.println("Якщо двісті років хтось приховує правду про Морлока, відповідь має лежати десь у документах замку - в архіві, під замком і вартою.");
        System.out.println("Тієї ж ночі, поки коридори ще порожні, ти прямуєш туди сам.");
        ConsoleUI.printDivider();

        playArchiveHeistEncounter(hero, scanner);
        ConsoleUI.printDivider();

        int choice = ConsoleUI.readChoice(scanner,
                "[1] Вкрасти архів для \"Печатки\"\n" +
                "[2] Продати інформацію претенденту\n" +
                "[3] Знищити архів самому\n> ", 1, 3);

        hero.setChapter4Choice(choice);

        switch (choice) {
            case 1 -> {
                System.out.println("Небезпечно, але правда збережеться.");
                hero.addReputation(15);
            }
            case 2 -> {
                switch (hero.getClaimantSupported()) {
                    case 1 -> {
                        System.out.println("Ти знаходиш Кейна і кладеш перед ним те, що бачив в архіві. \"Хочу дещо натомість - шлях до Морлока.\"");
                        System.out.println("Він киває коротко, по-військовому, навіть не питаючи деталей. \"Матимеш карту і двох людей. Далі - сам.\"");
                    }
                    case 2 -> {
                        System.out.println("Ти пропонуєш Сорін угоду - архів в обмін на дорогу до Морлока.");
                        System.out.println("Вона зважує інформацію, як завжди зважує монету. \"Чесна ціна за чесний товар,\" - і кличе писаря готувати карту.");
                    }
                    default -> {
                        System.out.println("Ти приходиш до Алана з тим, що знайшов в архіві, і просиш натомість шлях до фортеці.");
                        System.out.println("Він довго мовчить, стискаючи амулет. \"Якщо це допоможе тобі дістатись раніше, ніж дістанеться цикл - бери.\"");
                    }
                }
                hero.addReputation(0);
            }
            default -> {
                System.out.println("Ти тримаєш архів. Сотні сторінок. Правда про Морлока.");
                System.out.println("Кидаєш в багаття.");
                System.out.println("На останній сторінці - малюнок чорнилом.");
                System.out.println("Двоє людей і маленька фігурка між ними.");
                System.out.println("Точно такий самий, як у щоденнику, який ти ще не читав.");
                System.out.println("Вогонь поглинає його раніше, ніж ти встигаєш зрозуміти.");
                hero.addReputation(-15);
            }
        }
    }

    // Сторітелінговий епізод перед самим вибором долі архіву - зустріч з вартовим
    // в коридорі, що проходить по-різному залежно від репутації героя.
    private void playArchiveHeistEncounter(Hero hero, Scanner scanner) {
        System.out.println("Коридор до архіву порожній, лише один вартовий ходить між полицями зі свічкою.");

        switch (hero.getReputationReaction()) {
            case HERO -> {
                System.out.println("Він помічає тебе і хапається за меч. \"Стій! Сюди заборонено!\"");
                System.out.println("Клинки схрещуються лише раз, перш ніж між вами стає лицар у білому плащі.");
                System.out.println("\"Йди,\" - каже лицар, не дивлячись на тебе, тримаючи вартового на відстані. \"Я його затримаю. Іди!\"");
                System.out.println("Ти не встигаєш навіть подякувати - двері архіву вже зачиняються за тобою.");
            }
            case NEUTRAL -> {
                System.out.println("Вартовий дивиться на тебе, потім - повз тебе, ніби тебе тут немає.");
                System.out.println("\"Не бачив. Не питай чому,\" - бурмотить він і йде в інший бік коридору.");
            }
            default -> {
                System.out.println("Вартовий впізнає тебе - чутки про темницю і ліс дійшли навіть сюди.");
                System.out.println("Свічка тремтить у його руці. \"Т-ти... залишайся там!\" - кричить він, відступаючи.");

                int choice = ConsoleUI.readChoice(scanner,
                        "[1] Вбити його поки кричить\n" +
                        "[2] Пробігти повз і не озиратись\n> ", 1, 2);

                if (choice == 1) {
                    System.out.println("Крик обривається швидше, ніж встигає привернути увагу.");
                    System.out.println("Ти переступаєш через тіло. Архів попереду, тихий і байдужий.");
                } else {
                    System.out.println("Ти проштовхуєшся повз нього і біжиш коридором, поки крик ще лунає за спиною.");
                    System.out.println("Можливо, хтось почув. Можливо, ні. Дізнаєшся пізніше.");
                }
            }
        }
        ConsoleUI.waitForEnter(scanner);
    }
}
