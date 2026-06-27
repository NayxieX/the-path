package rpg.chapters;

import rpg.entities.Hero;
import rpg.entities.NPC;
import rpg.interfaces.Chapter;
import rpg.util.ConsoleUI;
import java.util.Scanner;

public class Chapter3 implements Chapter {

    @Override
    public void play(Hero hero, Scanner scanner) {
        playArrival(hero);
        ConsoleUI.waitForEnter(scanner);
        ConsoleUI.printDivider();
        playCultPriest(hero, scanner);
        ConsoleUI.printDivider();
        playPostCultChoice(hero, scanner);
        ConsoleUI.printDivider();
        playTavernWhispers(scanner);
        ConsoleUI.printDivider();
        playTavernElder();
        ConsoleUI.waitForEnter(scanner);
        ConsoleUI.printDivider();
        playSickChoice(hero, scanner);
        ConsoleUI.printDivider();
        playAbigailFence(hero, scanner);
        ConsoleUI.waitForEnter(scanner);
        ConsoleUI.printDivider();
        playVillageFarewell(hero, scanner);

        System.out.println("Дорога з села веде вгору, до кам'яних стін замку, що чекає на горизонті.");
        ConsoleUI.waitForEnter(scanner);
    }

    private void playArrival(Hero hero) {
        System.out.println("Перші дахи з'являються між деревами. Дим, голоси, запах хліба і гнилі одночасно.");
        switch (hero.getReputationReaction()) {
            case HERO -> {
                System.out.println("Люди на вулиці поступаються дорогою, дехто киває з повагою, що тебе самого бентежить.");
                System.out.println("Собака, що мала би гавкати на чужинця, лише підходить і треться об ногу.");
                System.out.println("Хтось із дверей шепоче дитині: \"Дивись - той, що допомагав у лісі.\"");
            }
            case NEUTRAL -> {
                System.out.println("На тебе дивляться так само, як на будь-якого чужинця - з обережною байдужістю.");
                System.out.println("Ніхто не вітає, ніхто не тікає. Просто ще один подорожній.");
            }
            case ANTAGONIST -> {
                System.out.println("Вулиця помітно пустіє, як тільки тебе бачать. Двері зачиняються одні за одними.");
                System.out.println("Жінка хапає дитину за руку і переходить на інший бік дороги, не дивлячись у твій бік.");
                System.out.println("Хтось встигає прошепотіти: \"Це він. З лісу.\"");
            }
        }
    }

    private void playPostCultChoice(Hero hero, Scanner scanner) {
        int choice = ConsoleUI.readChoice(scanner,
                "Куди підеш далі?\n" +
                "[1] Прямо до таверни\n" +
                "[2] Прогулятися вулицею\n> ", 1, 2);

        if (choice == 2) {
            playStreetStories(hero, scanner);
        } else {
            System.out.println("Ти йдеш прямо до таверни, не звертаючи уваги на гомін вулиці.");
            ConsoleUI.waitForEnter(scanner);
        }
    }

    private void playStreetStories(Hero hero, Scanner scanner) {
        System.out.println("Дорогою вуха самі чіпляються за шматки чужих розмов.");
        System.out.println();
        System.out.println("\"...кажуть, чума прийшла бо хтось розкопав стару могилу за пагорбом...\"");
        System.out.println("\"...моя бабця бачила Морлока живим. Каже, очі як у звичайної людини. Це найгірше...\"");
        System.out.println("\"...староста знову зустрічався з тим у каптурі. Втретє цього тижня...\"");
        System.out.println("\"...якщо культ каже мовчати - мовчи. Дядько Гаврило не мовчав...\"");
        System.out.println();

        switch (hero.getReputationReaction()) {
            case HERO -> {
                System.out.println("\"...чули про того чужинця? На площі не схилив голови перед жерцем...\"");
                System.out.println("\"...якби таких більше було - може, і не боялися б так усі...\"");
            }
            case NEUTRAL -> {
                System.out.println("\"...хтось новий у селі. Тихий. Навіть не зрозуміло, що про нього думати...\"");
            }
            case ANTAGONIST -> {
                System.out.println("\"...бачила того, що з лісу прийшов? Кажуть, з культом по-доброму розмовляв...\"");
                System.out.println("\"Тихіше,\" - перебиває хтось інший. \"Раптом почує.\"");
            }
        }

        System.out.println();
        System.out.println("\"...а підеш до таверни - запитай старого в кутку. Він про все знає, навіть про те, чого краще не знати...\"");
        System.out.println("Що ж - саме туди ти і прямував.");
        ConsoleUI.waitForEnter(scanner);
    }

    private void playTavernWhispers(Scanner scanner) {
        System.out.println("Перш ніж дід у кутку встигає тебе покликати, встигаєш почути ще кілька фраз з шинку:");
        System.out.println("\"...кажуть, у замку вже б'ються за трон, поки старий ще й не вмер до кінця...\"");
        System.out.println("\"...якщо хтось і вийде з останньої брами живим, то вже не людиною...\"");
        System.out.println("\"Тихіше,\" - хтось засичав, помітивши, що ти слухаєш.");
        ConsoleUI.waitForEnter(scanner);
    }

    private void playCultPriest(Hero hero, Scanner scanner) {
        NPC priest = new NPC("Жрець культу");

        switch (hero.getReputationReaction()) {
            case HERO -> {
                System.out.println("На площі " + priest.getName() + " наказним тоном змушує людей зносити майно до возів культу.");
                System.out.println("Натовп мовчки підкоряється, дивлячись у землю - ніхто не наважується відмовити.");
                System.out.println("Ти не можеш пройти мимо. Підходиш сам.");
            }
            case NEUTRAL -> {
                System.out.println(priest.getName() + " помічає тебе серед натовпу і сам перепиняє дорогу.");
                System.out.println("\"Нове обличчя,\" - каже він, оцінюючи тебе зором. \"Зупинись на хвилину.\"");
            }
            case ANTAGONIST -> {
                System.out.println(priest.getName() + " впізнає тебе ще здалеку і йде назустріч, майже з усмішкою.");
                System.out.println("\"Чутки про тебе дійшли і сюди. Може, нам є про що поговорити.\"");
            }
        }

        System.out.println(priest.getName() + ": \"Морлок карає невірних. Але ті хто схиляє голову - живуть.\"");
        System.out.println(priest.getName() + ": \"Ти схилиш голову?\"");

        int choice = ConsoleUI.readChoice(scanner,
                "[1] \"Я не схиляюсь ні перед ким.\"\n" +
                "[2] Мовчиш і проходиш мимо.\n" +
                "[3] \"Де тут можна заробити?\"\n> ", 1, 3);

        switch (choice) {
            case 1 -> {
                System.out.println("\"Давно не бачив таких очей.\"");
                hero.addReputation(15);
            }
            case 2 -> {
                System.out.println("\"Він теж мовчав спочатку.\"");
                hero.addReputation(0);
            }
            default -> {
                System.out.println("\"О. Ти саме той кого ми шукали.\"");
                hero.addReputation(-15);
            }
        }
    }

    private void playTavernElder() {
        System.out.println("Дід у таверні нахиляється ближче, говорить тихо:");
        System.out.println("\"Морлок не посилав чуму.");
        System.out.println(" Він сам втратив все через хворобу.");
        System.out.println(" Через людську хворобу - заздрість і страх.\"");
        System.out.println();
        System.out.println("\"Звідки ви знаєте?\" - питаєш ти.");
        System.out.println("Дід мовчить довше, ніж потрібно для відповіді.");
        System.out.println("\"Бо я був там. Двісті років - довгий час, та не для всіх.\"");
        System.out.println("\"Культ бреше. Але правда вже нікому не потрібна.\"");
        System.out.println();
        System.out.println("Дід відхиляється назад у тінь, ніби розмова забрала останні сили на сьогодні.");
        System.out.println("Ти лишаєш кілька монет на столі і виходиш з таверни на вечірню вулицю - слова про двісті років ще крутяться в голові.");
    }

    private void playSickChoice(Hero hero, Scanner scanner) {
        System.out.println("Далі вулицею - старий хлів, тепер з важким замком на дверях і двома культистами при вході.");
        System.out.println("Зсередини чути кашель. Багато кашлю.");
        System.out.println();
        System.out.println("Жінка стоїть біля дверей, тримаючись за замок, наче це може щось змінити.");
        System.out.println("\"Мій чоловік там. Кажуть - карантин. Кажуть, це заради нас усіх.\"");
        System.out.println("Один з культистів повертається на твій погляд. \"Тримай дистанцію, чужинче. Заради власного здоров'я.\"");
        System.out.println();
        System.out.println("Жінка нахиляється ближче, доки культист не дивиться. \"Заходять туди здорові. Виходять не всі. Чому?\"");
        System.out.println("Ти розумієш - карантин тут лише слово. Підвал - це фільтр. Перевірка, хто вартий \"одужання\".");

        int choice = ConsoleUI.readChoice(scanner,
                "[1] Звільнити хворих\n" +
                "[2] Донести старості\n" +
                "[3] Допомогти культу\n> ", 1, 3);

        hero.setChapter3Choice(choice);

        switch (choice) {
            case 1 -> {
                System.out.println("Ти чекаєш, доки культисти відвернуться, і зриваєш замок одним різким рухом.");
                System.out.println("Двері відчиняються в темряву і сморід хвороби. Десятки очей дивляться на світло.");
                System.out.println("Хтось плаче. Хтось пробує встати і не може. Жінка кидається повз тебе всередину, кричучи ім'я чоловіка.");
                System.out.println("Один з культистів хапається за зброю - та натовп хворих, що виходить назовні, занадто великий, щоб його зупинити.");
                System.out.println("Ризик, що хвороба справді пошириться, лишається. Але тепер це принаймні їхній власний вибір.");
                hero.addReputation(15);
            }
            case 2 -> {
                System.out.println("Ти знаходиш старосту і розповідаєш усе, що бачив і чув.");
                System.out.println("Він слухає, не дивлячись на тебе, потираючи скроні. \"Я знаю,\" - каже він нарешті, тихо. \"Знаю давно.\"");
                System.out.println("\"А що ти сам можеш зробити - проти них?\" - питає він у відповідь, і це звучить не як риторичне питання.");
                System.out.println("Він обіцяє \"щось придумати\". Ти йдеш, не знаючи - чи це означає допомогу, чи просто слова, аби ти пішов.");
                hero.addReputation(0);
            }
            default -> {
                System.out.println("Ти підходиш до культистів і тихо вказуєш, де по селу ховається решта незгодних.");
                System.out.println("Один з них киває, щось занотовує. \"Корисно. Морлок це не забуде.\"");
                System.out.println("Жінка біля дверей дивиться на тебе так, ніби щойно зрозуміла, ким ти є насправді.");
                hero.addReputation(-15);
            }
        }
    }

    private void playAbigailFence(Hero hero, Scanner scanner) {
        System.out.println("Дитина малює вугіллям на паркані. Двоє людей і маленька фігурка між ними.");

        if (hero.getChapter2Choice() == 2) {
            // У лісі (вибір 2 - "Домовитись") ім'я ще не було назване.
            System.out.println("\"Як тебе звати?\" - питаєш ти.");
            System.out.println("\"Абігейл,\" - відповідає вона, не відриваючись від малюнка.");
            System.out.println("Ти завмираєш, хоч сам не розумієш чому.");
        } else {
            // Якщо вже знаєш ім'я з Глави 2 (захист або темний варіант).
            System.out.println("Абігейл піднімає очі і впізнає тебе. Не лякається - просто дивиться, оцінюючи.");
        }

        System.out.println("\"Це моя улюблена казка. Про героя який забув себе.\"");
        System.out.println("\"Ти теж забув?\"");

        int choice = ConsoleUI.readChoice(scanner,
                "[1] \"Забув. Але, може, це не найголовніше.\"\n" +
                "[2] Промовчати і просто кивнути\n> ", 1, 2);

        if (choice == 1) {
            System.out.println("Вона дивиться на тебе уважно, як дорослий дивиться на дорослого.");
            System.out.println("\"Тоді намалюй собі нове ім'я,\" - каже вона і простягає шматок вугілля.");
        } else {
            System.out.println("Вона приймає мовчання як відповідь. Дописує щось крихітне в кутку малюнка - літеру, яку ти не встигаєш розгледіти.");
        }
        System.out.println("Десь за плотом мати кличе її додому. Абігейл встає, лишаючи малюнок на паркані - для тебе, чи для когось іншого.");
    }

    private void playVillageFarewell(Hero hero, Scanner scanner) {
        switch (hero.getReputationReaction()) {
            case HERO -> {
                System.out.println("На виході з села тебе наздоганяє кілька людей.");
                System.out.println("\"Дякуємо,\" - каже один, простягаючи в дорогу хліб і трохи сиру.");
                System.out.println("\"Повертайся, якщо зможеш,\" - додає інший. \"Тут завжди знайдеться місце за столом.\"");
            }
            case NEUTRAL -> {
                System.out.println("Ти виходиш з села тим самим шляхом, яким зайшов.");
                System.out.println("Ніхто не виходить попрощатись. Ніхто навіть не помічає, що ти йдеш.");
            }
            case ANTAGONIST -> {
                System.out.println("На виході тебе вже чекають - не з хлібом, а з вилами і палицями.");
                System.out.println("\"Йди і не повертайся,\" - кричить хтось здалеку, ховаючись за спинами інших.");
                System.out.println("Ти йдеш не озираючись. За спиною - тиша, гірша за крик.");
            }
        }
        ConsoleUI.waitForEnter(scanner);
    }
}
