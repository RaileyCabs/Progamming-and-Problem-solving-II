// Write a program and use the attached file ( babynames. txt) as input file,
    // and create two output tiles.
    // You need to create a new class file title Baby to store name, number of babies of that name, percent of baby of that name, male/female and use them as part of your code. Missing this requirement means no grade.
    // One file listing out all boys names, and the other file listing out all girls name. Need to include file not found exception handling in your code (2 points)
    // also
    // Please display on the screen the total number of
    // 1) total number of boy babies born in that year (2 points)
    // 2) total number of girl babies born in that year (2 points)
    // 3) what's the name of baby (boy or girl) that first crossed 10 Millionth babies (summing from most popular baby names, that is, from the top down.)? (2 points) 

//make sure it makes 2 files (one for total boys names, one for total girls name)
//make sure the filenotfound exception is added
//

/**
 
This Class Stores
1.name
2.number of babies of that name
3.percent of baby of that name,
4.male or female
include file not found exception handling
display:
1.total number of boy babies in that year (sum third element) (1st file)
2.total girl babies in that year (6th element) (2nd file)
3.name of baby (boy/girl) that first crossed 10 millionth babies (add both sum of babies line by line, check total and
see if it exceed 10th million, if true then return name of baby.)
(asumming from most popular baby names, that is, from the top down.)*
boy name micheal(string) , (number of babies int), (percentage 2.25 float) , girl name (string), number of girl babies int),
(percent of girls float).
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Baby {
    public static void main(String[] args) throws FileNotFoundException {
        String filename = "babynames.txt";
        try {
            processFile(filename);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e){
            System.out.println("error while writing to the output files:");
        }
    }

    public static void processFile(String fileName) throws FileNotFoundException, IOException {
        int totalBoys = 0;
        int totalGirls = 0;
        int totalBabies = 0;
        String nameTenMillion = null;
        
        PrintWriter outBoy = new PrintWriter(new FileWriter("boy_babies.txt"));
        PrintWriter outGirl = new PrintWriter(new FileWriter("girl_babies.txt"));

        Scanner scanner = new Scanner(new File(fileName));

        while (scanner.hasNext()) {
            int A = scanner.nextInt();
            String boyName = scanner.next();
            int boyBabies = scanner.nextInt();
            float boyPercentage = scanner.nextFloat();
            String girlName = scanner.next();
            int girlBabies = scanner.nextInt();
            float girlPercentage = scanner.nextFloat();

            outBoy.printf("%d %s %d %.4f\n", A, boyName, boyBabies, boyPercentage);
            totalBoys += boyBabies;
            
            outGirl.printf("%d %s %d %.4f\n", A, girlName, girlBabies, girlPercentage);
            totalGirls += girlBabies;

            totalBabies += boyBabies + girlBabies;

            if (totalBabies > 10_000_000 && nameTenMillion == null) {
                nameTenMillion = (totalBabies - girlBabies < 10_000_000) 
                    ? girlName : boyName;
            }
        }

        scanner.close();
        outBoy.close();
        outGirl.close();

        System.out.println("Total boy babies: " + totalBoys);
        System.out.println("Total girl babies: " + totalGirls);
        if (nameTenMillion != null) {
            System.out.println("The first baby to cross 10 million is: " + nameTenMillion);
        }
    }
}