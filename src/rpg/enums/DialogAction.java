// FOR THE FUTURE: This enum is no longer used in the game, but it may be useful for future development. It is kept here for reference and potential future use.


// package rpg.enums;
// import rpg.exceptions.InvalidChoiceException;
// public enum DialogAction {
//     CONFRONT_TRUTH(15, "Розкрити правду в очі"),
//     THREATEN(10, "Погрожувати"),
//     APPEAL(5, "Благати про милосердя"),
//     SILENCE(0, "Промовчати");

//     private final int hpChange;
//     private final String description;
    
//     DialogAction(int hpChange, String description) {
//         this.hpChange = hpChange;
//         this.description = description;
//     }

//     public int getHpChange() {
//         return hpChange;
//     }

//     public String getDescription() {
//         return description;
//     }

//     public static DialogAction fromInput(int input) {
//         return switch (input) {
//             case 1 -> CONFRONT_TRUTH;
//             case 2 -> THREATEN;
//             case 3 -> APPEAL;
//             case 4 -> SILENCE;
//             default -> throw new InvalidChoiceException(input);
//         };
//     }

//     @Override
//     public String toString() {
//         return description;
//     }
// }
