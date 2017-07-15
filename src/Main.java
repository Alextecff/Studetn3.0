import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Group group = new Group();
        Scanner scanner = new Scanner(System.in);

// interactive array
        /*while (Group.getIndex() < Group.getCountStudent()){
            System.out.println("Введите имя фамилию возраст факультет и курс студента:");
            String string = scanner.nextLine();
            String[] splitString = string.split(" ");
            String name = splitString[0];
            String surname = splitString[1];
            int age = Integer.parseInt(splitString[2]);
            String faculty = splitString[3];
            int course = Integer.parseInt(splitString[4]);
            try {
                group.addStudent(new Student(name, surname, age, faculty, course));
            } catch (countStudentException e) {
                System.out.println(e.getMessage());
            }
        }*/

//fillArratyStudenst
        /*try {
            group.addStudent(new Student("Alex0", "Platon", 15, "IT", 4));
            group.addStudent(new Student("Alex1", "Platon1", 24, "IT", 3));
            group.addStudent(new Student("Alex9", "Platon9", 30, "Engineer", 2));
            group.addStudent(new Student("Alex2", "Platon2", 32, "IT", 2));
            group.addStudent(new Student("Alex4", "Platon4", 18, "Maneger", 2));
            group.addStudent(new Student("Alex8", "Platon8", 17, "Engineer", 4));
            group.addStudent(new Student("Alex5", "Platon5", 15, "Maneger", 2));
            group.addStudent(new Student("Alex6", "Platon6", 12, "IT", 1));
            group.addStudent(new Student("Alex7", "Platon7", 28, "IT", 2));
            group.addStudent(new Student("Alex3", "Platon3", 43, "Maneger", 3));
            group.addStudent(new Student("Alex3", "Platon3", 43, "Maneger", 3));
        } catch (CountStudentException e) {
            System.out.println(e.getMessage());
        }*/

//loadFromFile
        group.loadFromFile();

//delete student by index
        group.delStudent(2);

//sort by parameter
        System.out.println("По какому параметру сортировать?");
        System.out.println("0 - Имя\n1 - Фамилия\n2 - возраст\n3 - факультет\n4 - курс");
        int parametr = scanner.nextInt();
        group.sortByParametr(parametr);
        System.out.println("------------SortByParameter-------------");
        System.out.println(group);

//interface voenkom
        Student[] soldiers = group.getSoldier();
        System.out.println("------------Voenkom-------------");
        for (Student sl : soldiers){
            System.out.println(sl);
        }

//saveToFile
        group.saveToFile();
    }
}