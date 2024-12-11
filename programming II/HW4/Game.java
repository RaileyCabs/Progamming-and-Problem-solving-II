import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;

        System.out.println("Math Quest: The Adventure of Numbers!");

        
        LevelOne levelOne = new LevelOne();
        totalScore += levelOne.startLevel(scanner);

        
        if (totalScore >= 5) {
            LevelTwo levelTwo = new LevelTwo();
            totalScore += levelTwo.startLevel(scanner);
        } else {
            System.out.println("Score too low, Try again!");
        }

        
        if (totalScore >= 10) {
            LevelThree levelThree = new LevelThree();
            totalScore += levelThree.startLevel(scanner);
        } else {
            System.out.println("Score too low, Try again!");
        }

        
        System.out.println("Game over! Your final score is: " + totalScore);
        scanner.close();
    }
}
