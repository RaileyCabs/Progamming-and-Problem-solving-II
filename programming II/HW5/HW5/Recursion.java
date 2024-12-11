import java.util.Scanner;
import java.util.Random;

public class Recursion {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("How big would you like your array to be: ");
        int size = scanner.nextInt();
        
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++){
            array[i] = random.nextInt(100) + 1;
        }
        System.out.print("Your array: ");
        for (int num : array){
            System.out.print(num + " ");
        }
        System.out.println();
        
        int sum = arraySum(array, size - 1);
        System.out.println("The sum of all values in your array:" + sum);
        
        scanner.close();
    }
    public static int arraySum (int[] array, int index)
    {
        if (index < 0){
            return 0;
        }
        return array[index] + arraySum (array, index - 1);
    }
}