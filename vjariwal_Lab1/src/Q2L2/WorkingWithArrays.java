package Q2L2;
import java.lang.Math;
import java.util.Scanner;

public class WorkingWithArrays {
    public static void header(int labNumber) {
        System.out.printf("Lab Exercise %d-Q2", labNumber);
        System.out.printf("\nPrepared By: Vivek Jariwala");
        System.out.printf("\nStudent Number: 251213353");
        System.out.printf("\nGoal of this Exercise: Working with arrays and conditional statements!");
    }

    public static void footer(int labNumber) {
        System.out.printf("Completion of Lab Exercise %d-Q2 is successful", labNumber);
        System.out.printf("\nSigning off - Vivek");

    }

    public static double [] mma5MethodVivek(int array[]){
        double maximum = array[0];
        double minimum = array[0];
        double sum = 0;
        double counter = 0;
        double studentNumber = 251213353;
        for (int i=0; i<array.length;i++){
            double remainder1 = array[i]%5;
            if (remainder1==0){
                maximum=array[i];
                minimum=array[i];
            }
        }

        for (int j=0; j<array.length;j++){
            double remainder2 = array[j]%5;
            if (remainder2 == 0){
                sum = sum + array[j];
                counter++;
                maximum = Math.max(maximum, array[j]);
                minimum = Math.min(minimum, array[j]);

            }

        }
        double average = sum / counter;
        double noAverage = 0.00;
        int string=(int)counter;
        if (counter==0){
            double [] answers = {maximum, minimum, noAverage, studentNumber};
            System.out.println("\nVivek found " + string + " numbers that are divisible-by-5");
            return answers;
        }
        else{
            double [] answers = {maximum, minimum, average, studentNumber};
            System.out.println("\nVivek found " + string + " numbers that are divisible-by-5");
            return answers;
        }
    }

    public static void main(String[] args) {
        System.out.println("==============================================================================================================");
        header(1);
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n==============================================================================================================");
        System.out.print("Enter array size: ");
        int arraySize = scanner.nextInt();
        int[] userArray = new int[arraySize];
        for (int i=0; i<arraySize; i++){
            System.out.print("Enter value "+ (i+1) +": ");
            int value = scanner.nextInt();
            userArray[i] = value;
        }
        System.out.println("\nHere is the result......");
        double[] calculatedAnswers = new double[4];
        calculatedAnswers = mma5MethodVivek(userArray);
        int studentNumber=(int)calculatedAnswers[3];
        if (calculatedAnswers[2]!=0.0) {
            System.out.printf("\nThe max is %.2f", calculatedAnswers[0]);
            System.out.printf("\nThe min is %.2f", calculatedAnswers[1]);
            System.out.printf("\nThe average of the numbers divisible by 5 is %.2f", calculatedAnswers[2]);
            System.out.println("\nMy student number is "+studentNumber);
        }
        System.out.println("==============================================================================================================");
        footer(1);
        System.out.println("\n==============================================================================================================");
    }
}
