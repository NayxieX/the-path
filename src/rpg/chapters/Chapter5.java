package rpg.chapters;

import rpg.entities.Hero;
import rpg.entities.Morlock;
import rpg.enums.ReputationLevel;
import rpg.interfaces.Chapter;
import rpg.mechanics.DialogSystem;
import rpg.util.ConsoleUI;
import java.util.Scanner;

public class Chapter5 implements Chapter {

    @Override
    public void play(Hero hero, Scanner scanner) {
        playRoadToFortress(hero);
        ConsoleUI.printDivider();
        playFortressEntrance(scanner);
        ConsoleUI.printDivider();
        playFirstMeeting(scanner);
        ConsoleUI.printDivider();

        Morlock morlock = new Morlock();
        DialogSystem.resolveMorlockFight(hero, morlock, scanner);

        ConsoleUI.printDivider();
        playFinalBlow(hero, scanner);
        ConsoleUI.printDivider();
        playDiary(scanner);
        ConsoleUI.printDivider();
        playFinalChoice(hero, scanner);
    }

    private void playRoadToFortress(Hero hero) {
        switch (hero.getChapter4Choice()) {
            case 1 -> {
                System.out.println("\"Печатка\" дає провідника.");
                System.out.println("Старий тисне руку: \"Ти вже зробив більше ніж ми сміли сподіватись.\"");
            }
            case 2 -> {
                System.out.println("Претендент дає карту і двох солдатів.");
                System.out.println("На підході: \"Ми не підемо далі.\"");
            }
            default -> {
                System.out.println("Армія чекає за пагорбом. \"Ти підеш першим.\"");
                System.out.println("Армія яка чекає твоєї смерті як сигналу.");
            }
        }
    }

    private void playFortressEntrance(Scanner scanner) {
        System.out.println("Фортеця не темна і не страшна. Просто стара. Втомлена.");
        System.out.println("Коридори порожні. Смолоскипи горять, але нікого немає.");
        System.out.println("Тільки один звук - десь далеко вгорі хтось грає на лютні.");
        System.out.println("Музика зупиняється, коли ти входиш у зал.");
        ConsoleUI.waitForEnter(scanner);
    }

    private void playFirstMeeting(Scanner scanner) {
        System.out.println("Він сидить спиною. Не на троні - на підлозі біля вікна. Лютня лежить поруч.");
        System.out.println("\"Я чув що ти йдеш. Сів і чекав.\"");
        System.out.println("\"Як там люди? Все ще бояться мого імені?\"");

        int choice = ConsoleUI.readChoice(scanner,
                "[1] \"Вони страждають через тебе.\"\n" +
                "[2] \"Вони не пам'ятають хто ти насправді.\"\n" +
                "[3] \"Мені байдуже що з ними.\"\n> ", 1, 3);

        switch (choice) {
            case 1 -> System.out.println("\"Знаю.\"");
            case 2 -> System.out.println("Гірко сміється. \"Це навіть гірше.\"");
            default -> System.out.println("Вперше обертається. \"Ось це цікаво.\"");
        }
        ConsoleUI.waitForEnter(scanner);
    }

    private void playFinalBlow(Hero hero, Scanner scanner) {
        System.out.println("Десь над залою рветься забута струна - та сама лютня, що замовкла, коли ти увійшов, віддає останній звук і тихне назавжди.");
        System.out.println("Морлок на підлозі. Не намагається встати. Просто дивиться на клинок у твоїй руці - чи на руку, що його тримає.");

        int choice = ConsoleUI.readChoice(scanner,
                "[1] Піднести клинок до горла - закінчити негайно\n" +
                "[2] Опустити зброю і дати йому сказати останнє\n" +
                "[3] Опуститись на коліна поруч з ним, на одному рівні\n> ", 1, 3);

        switch (choice) {
            case 1 -> System.out.println("Клинок зупиняється на волосину від шкіри. \"Ще не зараз,\" - кажеш ти собі, а не йому.");
            case 2 -> System.out.println("Ти опускаєш зброю. Метал глухо дзвенить по каменю - єдиний звук у залі, що завмерла разом з лютнею.");
            default -> System.out.println("Ти опускаєшся поруч - вперше за всю цю дорогу дивишся на нього не зверху вниз, а як рівний на рівного.");
        }

        System.out.println();
        System.out.println("\"Ти... говорив з нею?\"");
        System.out.println("\"З Лірою. У снах. Вона казала що хтось прийде.\"");
        System.out.println("\"Хтось схожий на мене але не зламаний.\"");
        System.out.println("\"Це ти?\"");
        ConsoleUI.waitForEnter(scanner);
    }

    private void playDiary(Scanner scanner) {
        System.out.println("Минуло три дні. Порожня дорога. Вітер. Тиша. Попіл.");
        System.out.println("На роздоріжжі стоїть старий. Просто чекає.");
        System.out.println("\"Ти той хто зупинив його?\"");
        System.out.println("Дістає книгу. Понівечена - чорне, буре, темно-червоне.");
        System.out.println("\"Він просив передати. Сказав - той хто переможе зрозуміє.\"");
        System.out.println("Старий іде не озираючись.");
        ConsoleUI.waitForEnter(scanner);

        System.out.println("Перша сторінка - малюнок чорнилом.");
        System.out.println("Двоє людей і маленька фігурка між ними.");
        System.out.println("Точно такий самий, як малювала Абігейл на паркані.");
        System.out.println("\"Сьогодні вона сказала що буде дівчинка. Хотіла назвати її Ліра.\"");
        System.out.println("Ти згадуєш напис. \"Вона чекає тебе. Не здавайся. - М.\"");
        System.out.println("М. Морлок. Це була його камера.");
        System.out.println("\"Сьогодні привели нового в'язня. Молодий. Схожий на когось.");
        System.out.println(" Я написав йому на стіні.");
        System.out.println(" Може зробить краще ніж я.\"");
        System.out.println("Остання сторінка. Один рядок чистим почерком:");
        System.out.println("\"Я не був лиходієм. Я просто дуже любив.\"");
        ConsoleUI.waitForEnter(scanner);
    }

    private void playFinalChoice(Hero hero, Scanner scanner) {
        ReputationLevel level = hero.getReputationReaction();

        System.out.println("Ти закриваєш книгу.");
        System.out.println("Стоїш на роздоріжжі. Вітер. Попіл. Тиша.");
        System.out.println("Що ти відчуваєш?");

        int choice = ConsoleUI.readChoice(scanner,
                "[1] \"Я зробив те що мав зробити. Світ став кращим. Це головне.\"\n" +
                "[2] \"Я не знаю що правда а що брехня. Але я зробив вибір і живу з ним.\"\n" +
                "[3] \"Вони всі брехали. Все життя. Більше ніхто не буде вирішувати за мене що правильно.\"\n> ",
                1, 3);

        switch (choice) {
            case 1 -> hero.addReputation(20);
            case 2 -> hero.addReputation(0);
            default -> hero.addReputation(-20);
        }

        printFinalPhrase(level, choice);
    }

    private void printFinalPhrase(ReputationLevel level, int choice) {
        switch (level) {
            case HERO -> {
                switch (choice) {
                    case 1 -> System.out.println("\"Може він і не був монстром.\n" +
                            " Але світ без темряви - це те заради чого варто жити.\"");
                    case 2 -> System.out.println("\"Я не знаю чи був він правий.\n" +
                            " Але я знаю що намагався робити краще ніж він.\"");
                    default -> System.out.println("\"Вони брехали йому. Брехали мені.\n" +
                            " Але я не стану тим ким став він.\"");
                }
                System.out.println("Ти кладеш книгу на землю. Обережно. Як щось святе.");
            }
            case NEUTRAL -> {
                switch (choice) {
                    case 1 -> System.out.println("\"Може так. Може ні.\n" +
                            " Але хтось мав це зробити. Цього разу це був я.\"");
                    case 2 -> {
                        System.out.println("\"Ні герой. Ні лиходій.\n" +
                                " Просто людина яка стояла на потрібному місці.\"");
                        System.out.println("Або ні. Вже не важливо.");
                    }
                    default -> {
                        System.out.println("\"Вони завжди брешуть. Переможцям. Переможеним. Всім.\"");
                        System.out.println("\"Принаймні тепер я знаю правила гри.\"");
                    }
                }
            }
            case ANTAGONIST -> {
                switch (choice) {
                    case 1 -> {
                        System.out.println("\"Так. Став кращим. Для мене.\"");
                        System.out.println("Ти кидаєш книгу в багаття. Дивишся як горить.");
                    }
                    case 2 -> {
                        System.out.println("\"Він зламався бо любив.\n" +
                                " Я не зроблю тієї ж помилки.\"");
                        System.out.println("Ти кладеш книгу в сумку. Як нагадування.");
                    }
                    default -> {
                        System.out.println("\"Він був правий у всьому.\n" +
                                " Помилився лише в одному - зупинився.\"");
                        System.out.println("Ти йдеш у бік замку. Трон все ще порожній.");
                    }
                }
            }
        }
    }
}
