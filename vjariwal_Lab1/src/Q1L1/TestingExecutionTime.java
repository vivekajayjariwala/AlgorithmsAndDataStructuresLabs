package Q1L1;
import java.util.Scanner;

public class TestingExecutionTime {
    public static void header(int labNumber) {
        System.out.printf("Lab Exercise %d-Q1", labNumber);
        System.out.printf("\nPrepared By: Vivek Jariwala");
        System.out.printf("\nStudent Number: 251213353");
        System.out.printf("\nGoal of this Exercise: Checking the code-execution time!");
    }

    public static void footer(int labNumber) {
        System.out.printf("Completion of Lab Exercise %d-Q1 is successful", labNumber);
        System.out.printf("\nSigning off - Vivek");

    }

    public static long nanoTime(){
        return System.nanoTime();
    }

    public static double factorialIterative (int number) {
        double result = 1;
        int i = 1;
        while(i<=number){
            result=result*i;
            i++;
        }
        return result;
    }

    public static double factorialRecursive(int number){
        if (number==0) {
            return 1;
        }
        else {
            return number*factorialRecursive(number-1);
        }
    }

    public static void main(String[] args) {
        System.out.println("==============================================================================================================");
        header(1);
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n==============================================================================================================");
        int numberForFactorial;
        do {
            System.out.print("Enter an integer number: ");
            numberForFactorial = scanner.nextInt();
        }
        while ((numberForFactorial<0) && (numberForFactorial!=0));

        double mainIterativeStartTime=nanoTime();
        double result = 1;
        int i = 1;
        while(i<=numberForFactorial){
            result=result*i;
            i++;
        }
        double mainIterativeEndTime=nanoTime();
        System.out.printf("Factorial (%d) is %.1g", numberForFactorial, result);
        System.out.printf("\nTime taken by iterative solution inside main: %.2e sec", ((mainIterativeEndTime-mainIterativeStartTime)/1000000000));

        double iterativeStartTime=nanoTime();
        System.out.printf("\nFactorial (%d) with iterative method is %.1g", numberForFactorial, factorialIterative(numberForFactorial));
        double iterativeEndTime = nanoTime();
        System.out.printf("\nTime taken by iterative method call: %.2e sec", ((iterativeEndTime-iterativeStartTime)/1000000000));

        double recursiveStartTime=nanoTime();
        System.out.printf("\nFactorial (%d) with recursive call is %.1g", numberForFactorial, factorialRecursive(numberForFactorial));
        double recursiveEndTime = nanoTime();
        System.out.printf("\nTime taken by recursive method call: %.2e sec", ((recursiveEndTime-recursiveStartTime)/1000000000));

        System.out.println("\n==============================================================================================================");
        footer(1);
        System.out.println("\n==============================================================================================================");
    }

}
