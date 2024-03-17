import java.util.Random;

class Word {
    static String[] words = {
            "tablespoon",
            "monitor",
            "refrigerator",
            "microwave",
            "carpet",
            "kitchen",
            "computer",
            "lightning",
            "cocoa",
            "timber",
            "thunder",
            "keyboard",
            "pointer",
            "expression",
            "waterfall",
            "application",
            "science"
    };
    static String chooseWord() {
        return words[new Random().nextInt(words.length)];
    };
}
