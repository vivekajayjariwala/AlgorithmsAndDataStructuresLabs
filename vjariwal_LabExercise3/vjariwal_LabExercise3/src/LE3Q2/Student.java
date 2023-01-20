package LE3Q2;

public class Student implements Comparable<Student>{

    private String firstName;
    private String lastName;

    private Double score;

    public Student(){
        firstName = "Vivek";
        lastName = "Jariwala";
        score = 100.00;

    }

    public Student(String firstName, String lastName, Double score){
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;

    }

    public String toString(){
        String output = String.format(firstName + " " + lastName + ": %.2f", score);
        return output;
    }

    public int compareTo(Student sm) {
        int rv = 0;
        if(this.score>sm.score)
            rv = -1;
        else if(this.score<sm.score)
            rv = 1;
        else
            rv = 0;
        return rv;
    }

    public Double getScore(){
        return score;
    }

    public void setScore(Double d){
        score = d;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String s){
        firstName = s;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String s){
        lastName = s;
    }

}
