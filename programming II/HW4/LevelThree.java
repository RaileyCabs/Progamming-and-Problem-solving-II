import java.util.Random;
import java.util.Scanner;

public class LevelThree {
    public int startLevel(Scanner scanner) {
        System.out.println("Welcome to Level 3: The Subtraction Showdown!");

        int score = 0;
        Random random = new Random();
        
        while (score < 5) {
            int num1 = random.nextInt(9) + 1; 
            int num2 = random.nextInt(9) + 1; 
            int answer = num1 - num2;
            if (answer >= 0) {
                int attempts = 0;
                boolean correctAnswer = false;
                while (attempts < 2 && !correctAnswer) {
                    System.out.println("What is " + num1 + " - " + num2 + "?");
                    int response = scanner.nextInt();

                    if (response == answer) {
                        System.out.println("Correct! You are conquering the Subtraction Showdown!");
                        score++;
                        correctAnswer = true;
                    } else {
                        System.out.println("Wrong answer! Try again.");
                        attempts++;
                    }
                }                
                if (!correctAnswer) {
                    System.out.println("Game over! You have been defeated.");
                    return score;
                }
            } else {
                continue;
            }
        }
        System.out.println("Congratulations! You have conquered the Subtraction Showdown and completed Level 3!");
        return score;
    }
}
