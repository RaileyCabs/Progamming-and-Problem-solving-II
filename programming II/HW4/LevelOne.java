import java.util.Random;
import java.util.Scanner;

public class LevelOne {
    public int startLevel(Scanner scanner) {
        System.out.println("Let the Math Adventure Begin!");
        System.out.println("Lair of Addition: Level 1");
        
        int score = 0;
        Random random = new Random();
        
        while (score < 5) {
            int num1 = random.nextInt(9) + 1;
            int num2 = random.nextInt(9) + 1;
            int answer = num1 + num2;
            
            if (answer < 10) {
                int attempts = 0;
                boolean correctAnswer = false;
                
                while (attempts < 2 && !correctAnswer) {
                    System.out.println("What is " + num1 + " + " + num2 + "?");
                    int response = scanner.nextInt();
                    
                    if (response == answer) {
                        System.out.println("Correct! Onward, brave mathematician!");
                        score++;
                        correctAnswer = true;
                    } else {
                        System.out.println("Wrong answer! Try again.");
                        attempts++;
                    }
                }
                if (!correctAnswer) {
                    System.out.println("Game over! You DIED.");
                    return score; 
                }
            } else {
                continue; 
            }
        }
        System.out.println("You defeated the Addition God! You may continue.");
        return score;
    }
}
