package rpg;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import rpg.entities.Hero;
import rpg.interfaces.Chapter;
import rpg.chapters.Chapter1;
import rpg.chapters.Chapter2;
import rpg.chapters.Chapter3;
import rpg.chapters.Chapter4;
import rpg.chapters.Chapter5;
import rpg.mechanics.ReputationSystem;
import rpg.enums.EndingType;
import rpg.util.ConsoleUI;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

         try {
        new ProcessBuilder("cmd", "/c", "chcp", "65001").inheritIO().start().waitFor();
    } catch (Exception e) {}
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        System.out.println("Ласкаво просимо до \"The Path\"!");
        
        Hero hero = new Hero("Невідомий", 100);

        List<Chapter> chapters = List.of(
                new Chapter1(),
                new Chapter2(),
                new Chapter3(),
                new Chapter4(),
                new Chapter5()
        );

        String[] titles = {
                "Розділ 1: Темниця",
                "Розділ 2: Ліс",
                "Розділ 3: Село",
                "Розділ 4: Замок",
                "Розділ 5: Фортеця"
        };

        for (int i = 0; i < chapters.size(); i++) {
            ConsoleUI.clearScreen();
            ConsoleUI.printDivider();
            System.out.println(titles[i]);
            ConsoleUI.printDivider();
            ConsoleUI.waitForEnter(scanner);

            chapters.get(i).play(hero, scanner);
        }

        EndingType ending = ReputationSystem.determineEnding(hero);
        System.out.println(ending.getEndingText());

        scanner.close();
    }
}
