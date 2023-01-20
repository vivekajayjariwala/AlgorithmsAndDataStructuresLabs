package LE3Q1;

public class MyStudent {
    private String firstName;
    private Double score;

    public MyStudent(){
        firstName = "Vivek";
        score = 10.03;

    }

    public MyStudent(String firstName, Double score){
        this.firstName = firstName;
        this.score = score;

    }

    public String toString(){
        String output = String.format(firstName + ": %.2f", score);
        return output;
    }

}
