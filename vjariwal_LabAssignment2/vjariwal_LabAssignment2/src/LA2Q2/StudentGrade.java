package LA2Q2;

public class StudentGrade implements Comparable<StudentGrade> {
    private String firstName; // variable for the first name
    private String lastName; // variable for the last name
    private Integer grade; // variable for the grade

    // constructor for student grade

    public StudentGrade(){

    }

    // getter method for the first name
    public String getFirstName() {
        return firstName;
    }

    // setter method for the first name

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // getter method for the last name
    public String getLastName() {
        return lastName;
    }

    // setter method for the last name

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // getter method for the grade
    public Integer getGrade() {
        return grade;
    }

    // setter method for the grade

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    // constructor for Student Grade that sets the first name, last name, and grade values
    public StudentGrade(String f, String l, Integer g){
        this.firstName=f;
        this.lastName = l;
        this.grade = g;
    }

    // compare to method that compares the grades of two StudentGrade objects and sorts in descending order
    @Override
    public int compareTo(StudentGrade s2) {
        /* the object that called this method has a grade larger than the second object it is being compared to,
        return 1
        */
        if (this.grade > s2.grade){
            return 1;
        }
        /* the object that called this method has a grade equal to the second object it is being compared to,
        return 0
        */
        else if (this.grade == s2.grade){
            return 0;
        }
        /* the object that called this method has a grade smaller than the second object it is being compared to,
        return -1
        */
        else{
            return -1;
        }
    }

    // to String method that formats the student grade objects contents
    public String toString(){
        // formats the String output of the Student Grade object by separating names with a semicolon
        String output = String.format("%12s %-2s \t:%4d ",getFirstName(), getLastName(),getGrade());
        return output; // returns output variable
    }


}
