package class_3;

public class Student{
    int rollno;
    String name;
    String city;

    public Student(int rollno, String name, String city){
        this.rollno=rollno;
        this.name=name;
        this.city=city;
    }

    @Override
    public String toString() {
        return rollno+" "+name+" "+city;
    }
}