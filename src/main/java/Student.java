import java.util.Objects;

public class Student {

    private final String name;
    private final int group;
    private int course;
    private double mark;

    public Student(String name, int group, int course, double mark) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public int getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public double getMark() {
        return mark;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return group == student.group && course == student.course && Double.compare(mark, student.mark) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group, course, mark);
    }
}