package rpg.util;

import java.util.InputMismatchException;
import java.util.Scanner;
import rpg.exceptions.InvalidChoiceException;

public class ConsoleUI {

    // Читає ціле число від користувача в діапазоні [min, max].
    public static int readChoice(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int input = scanner.nextInt();
                if (input < min || input > max) {
                    throw new InvalidChoiceException(input, min, max);
                }
                scanner.nextLine(); // з'їдаємо залишок рядка (символ \n після числа),
                                     // інакше наступний waitForEnter() пропускає сам себе
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Це не число. Спробуй ще раз.");
                scanner.nextLine(); // очищаємо буфер від некоректного вводу
            } catch (InvalidChoiceException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Просить натиснути Enter, щоб продовжити (пауза між сценами/главами).
    // Після натискання очищає екран, щоб попередній текст не накопичувався
    // і гравець бачив тільки поточну сцену.
    public static void waitForEnter(Scanner scanner) {
        System.out.println("Натисніть Enter, щоб продовжити...");
        scanner.nextLine();
        clearScreen();
    }

    // Очищення консолі. Працює і в Windows-терміналі (cls), і в Unix-подібних (clear).
    // Якщо з якоїсь причини не вдалося - просто ігнорується, гра продовжує без очищення.
    public static void clearScreen() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // не критично - просто текст не очиститься цього разу
        }
    }

    // Розділювач між сценами
    public static void printDivider() {
        System.out.println("------------------------------");
    }
}
