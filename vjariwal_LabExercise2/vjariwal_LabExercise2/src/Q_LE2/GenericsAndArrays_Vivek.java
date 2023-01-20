package Q_LE2;
import java.util.*;
import java.util.InputMismatchException;

public class GenericsAndArrays_Vivek {

    //creates header, requires lab number
    public static void header(int labNumber) {
        System.out.printf("Lab Exercise %d-Q1", labNumber);
        System.out.printf("\nPrepared By: Vivek Jariwala");
        System.out.printf("\nStudent Number: 251213353");
        System.out.printf("\nGoal of this Exercise: Working with arrays and generics!");
    }

    //creates footer, requires lab number
    public static void footer(int labNumber) {
        System.out.printf("Completion of Lab Exercise %d-Q1 is successful", labNumber);
        System.out.printf("\nSigning off - Vivek");

    }

    public static class Pair<Y,N>{
        private Y key;
        private N value;

        // constructor
        public Pair (Y key, N value){
            this.key = key;
            this.value = value;
        }

        // setter methods
        public void setKey(Y key){
            this.key = key;
        }

        public void setValue(N value){
            this.value = value;
        }

        // getter methods
        public Y getKey(){
            return key;
        }

        public N getValue(){
            return value;
        }
    }

    public static void main(String[] args) {
        //prints footer and borders
        System.out.println("==============================================================================================================");
        header(2);
        System.out.println("\n==============================================================================================================");

        //creates ArrayLists and initalizes them
        ArrayList<Integer> years = new ArrayList(Arrays.asList(2, 3, 4, 3, 2, 2));
        ArrayList<String> names = new ArrayList(Arrays.asList("Harry", "Lavender", "Ron", "Hermione", "Luna", "Vincent"));

        // instantiate scanner
        Scanner keyboard = new Scanner(System.in);

        // outputs messages to user
        System.out.println("This program prints the names of the student leaders from year 2, 3 and 4.");
        System.out.println("To see the list of the students from a specific year enter an integer between 2 and 4 when\n" +
                "prompted.");


        // create boolean variable to have the program know when to stop looping when the user is done
        boolean userUsingProgram = true;

        while (userUsingProgram==true){
            // create another arraylist for the names you want to print when the user specifies year
            ArrayList<String> specificNames = new ArrayList<>();

            int range = years.size();
            Pair<Integer,String>[] pairs = new Pair[range];

            for(int i = 0; i<range;i++){
                pairs[i] = new Pair<Integer,String>(years.get(i), names.get(i));
            }
            boolean validYear=false;
            int userYear=0;
            System.out.print("\nEnter Academic Year (2, 3 or 4):");
            while(validYear==false) {
                try {
                    userYear = keyboard.nextInt();
                    if (userYear >= 2 && userYear <= 4) {
                        validYear=true;
                    }
                    else {
                        System.out.print("Invalid Input! Enter Academic Year (2, 3 or 4):");
                        userYear = keyboard.nextInt();
                    }
                } catch (InputMismatchException e) {
                    System.out.print("Invalid Input! Enter Academic Year (2, 3 or 4):");
                    keyboard.next();
                }
            }
            int counter = 0;
            for(int i=0;i<years.size();i++){
                if((int)pairs[i].getKey() == userYear){
                    specificNames.add(pairs[i].getValue().toString());
                    counter++;
                }
            }
            System.out.println("Found "+ counter +" leader(s) from year " + userYear +".");
            System.out.println("Here is the list:");
            System.out.println(specificNames);
            System.out.print("Do you wish to continue? (Press y to continue or any other key to terminate):");
            String userAnswer = keyboard.next();
            System.out.println(userAnswer);
            if(userAnswer.equals("y")){
                userUsingProgram=true;
            }
            else{
                userUsingProgram=false;
            }

        }
        System.out.println("\n==============================================================================================================");
        footer(2);
        System.out.println("\n==============================================================================================================");

    }


}
