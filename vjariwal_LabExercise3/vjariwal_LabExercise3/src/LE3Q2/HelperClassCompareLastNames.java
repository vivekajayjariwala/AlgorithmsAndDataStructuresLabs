package LE3Q2;

import java.util.Comparator;

public class HelperClassCompareLastNames implements Comparator<Student> {
    public int compare(Student o1, Student o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
