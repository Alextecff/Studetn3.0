import java.util.Comparator;

public class Student extends Human {

    private String faculty;
    private int course;


    public Student(String name, String surname, int age, String faculty, int course) {
        super(name, surname, age);
        this.faculty = faculty;
        this.course = course;
    }

    public Student(){

    }

    public String getFaculty() {
        return faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return super.toString() + "," + faculty + "," + course;
    }
}