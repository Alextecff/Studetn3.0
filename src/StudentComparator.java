import java.util.Comparator;

public class StudentComparator implements Comparator {
    private int i;

    public StudentComparator(int i) {
        this.i = i;
    }

    @Override
    public int compare(Object o1, Object o2) {
        Student student = (Student) o1;
        Student student2 = (Student) o2;

        if (o1 != null && o2 == null) {
            return 1;
        }
        if (o1 == null && o2 != null) {
            return -1;
        }
        if (o1 == null && o2 == null) {
            return 0;
        }

        switch (this.i){
            case 0: return student.getName().compareTo(student2.getName());
            case 1: return student.getSurname().compareTo(student2.getSurname());
            case 2: return student.getAge() - student2.getAge();
            case 3: return student.getFaculty().compareTo(student2.getFaculty());
            case 4: return student.getCourse() - student2.getCourse();
        }
        return 0;
    }
}