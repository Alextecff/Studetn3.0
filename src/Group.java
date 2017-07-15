import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Group implements Voenkom{
    private static final int COUNT_STUDENT = 10;
    private Student[] students = new Student[COUNT_STUDENT];
    private static int index;

    public static int getCountStudent() {
        return COUNT_STUDENT;
    }

    public static int getIndex() {
        return index;
    }

    public void addStudent(Student student) throws CountStudentException{
        if(index >= COUNT_STUDENT){
            throw new CountStudentException();
        }
        if(student != null){
            students[index++] = student;
        }
    }

    public void delStudent(int index){
        if(index >= 0 && index < COUNT_STUDENT){
            students[index] = null;
        }
    }

    public void sortByParametr(int i){
        Arrays.sort(students, new StudentComparator(i));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            if (student != null) {
                sb.append(student);
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    @Override
    public Student[] getSoldier() {
        int count = 0;
        for(Student st : students){
            if(st != null && st.getAge() >= 18){
                count++;
            }
        }

        Student[] soldiers = new Student[count];
        int i = 0;
        for(Student st : students){
            if(st != null && st.getAge() >= 18){
                soldiers[i++] = st;
            }
        }
        return soldiers;
    }

    public void saveToFile(){
        File file = new File("D:\\Java\\SaveToFile.txt");
        file.delete();
        for(Student student: students){
            if(student != null){
                try(FileWriter fw = new FileWriter(file, true)) {
                    fw.write(student.toString()+"\r\n");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void loadFromFile(){
        System.out.println("------------------LoadFromFile------------------");
        File file = new File("D:\\Java\\LoadFromFile.txt");

        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                String str = scanner.nextLine();
                String[] lines = str.split(",");

                String name = lines[0];
                String surname = lines[1];
                int age = Integer.parseInt(lines[2]);
                String faculty = lines[3];
                int course = Integer.parseInt(lines[4]);
                try {
                    addStudent(new Student(name, surname, age, faculty, course));
                } catch (CountStudentException e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}