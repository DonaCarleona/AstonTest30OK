import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static HashSet<Student> students;
    public static ArrayList<PhoneDictionary> dictionaries;

    public static void main(String[] args) {
        iniStudents();
        printStudent(students, 2);
        initDictionary();
        get("Иванов");
    }

    public static void iniStudents() {
        students = new HashSet<>();
        students.add(new Student("Иванов", 2, 1, 3.4));
        students.add(new Student("Владимиров", 1, 2, 2.4));
        students.add(new Student("Костина", 3, 3, 4.4));
        students.add(new Student("Кравченко", 2, 1, 3.4));
        students.add(new Student("Наквакина", 1, 2, 1.4));
        students.add(new Student("Сидоров", 3, 3, 2.4));
        students.add(new Student("Петров", 1, 1, 4.4));
        students.add(new Student("Камынин", 2, 2, 0.4));
        students.add(new Student("Снежкин", 3, 3, 4.4));
        students.add(new Student("Маслова", 2, 1, 2.4));
        students.add(new Student("Петрик", 1, 1, 4.4));
    }

    public static void updateStudents() {
        for(Student student: students) {
            if(student.getMark() >= 3.0) student.setCourse(student.getCourse() + 1);
        }
    }

    public static void deleteStudents() {
        students.removeIf(student -> student.getMark() < 3.0);
    }

    public static void printStudent(HashSet<Student> students, int course) {
        for(Student student: students) {
            if(student.getCourse() == course) System.out.println(student.getName());
        }
    }

    public static void initDictionary() {
        dictionaries = new ArrayList<>();
        dictionaries.add(new PhoneDictionary("Иванов", "+79089999999"));
        dictionaries.add(new PhoneDictionary("Петров", "+79089999900"));
        dictionaries.add(new PhoneDictionary("Сидоров", "+79080009999"));
        dictionaries.add(new PhoneDictionary("Кравченко", "+79089999999"));
        dictionaries.add(new PhoneDictionary("Крайненко", "+79089911119"));
        dictionaries.add(new PhoneDictionary("Юдин", "+79089559999"));
        dictionaries.add(new PhoneDictionary("Иванов", "+79088889999"));
        dictionaries.add(new PhoneDictionary("Иванов", "+79089994399"));
        dictionaries.add(new PhoneDictionary("Иванов", "+79085799999"));
    }

    public static void add(String name, String phone) {
        dictionaries.add(new PhoneDictionary(name, phone));
    }

    public static void get(String name) {
        for(PhoneDictionary phoneDictionary: dictionaries) {
            if(phoneDictionary.getName().equals(name)) System.out.println(phoneDictionary.getPhone());
        }
    }
}