package rpg.exceptions;

public class InvalidChoiceException extends RuntimeException {
    private final int invalidInput;
    public InvalidChoiceException(String message) {
        super(message);
        this.invalidInput = -1;
        ;
    }
    public InvalidChoiceException(int invalidInput) {
        super("Невірний вибір: " + invalidInput + ". Введи число зі списку.");
        this.invalidInput = invalidInput;
    }

    public InvalidChoiceException(int invalidInput, int min, int max) {
        super("Невірний вибір: " + invalidInput + ". Очікується від " + min + " до " + max + ".");
        this.invalidInput = invalidInput;
    }

    public int getInvalidInput() {
        return invalidInput;
    }
}
