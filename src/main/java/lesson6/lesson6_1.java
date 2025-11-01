import java.util.*;

class Student {
    private String name;
    private String group;
    private int course;
    private Map<String, Integer> grades;

    public Student(String name, String group, int course, Map<String, Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) return 0.0;
        int sum = 0;
        for (int grade : grades.values()) {
            sum += grade;
        }
        return sum * 1.0 / grades.size();
    }

    public void promoteIfEligible() {
        if (getAverageGrade() >= 3.0) {
            course++;
        }
    }

    @Override
    public String toString() {
        return name + " (Курс " + course + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group, course);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student other = (Student) obj;
        return Objects.equals(name, other.name) &&
                Objects.equals(group, other.group) &&
                course == other.course;
    }
}

class StudentManager {

    private Set<Student> students;

    public StudentManager() {
        students = new HashSet<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeLowPerformers() {
        students.removeIf(s -> s.getAverageGrade() < 3.0);
    }

    public void promoteEligibleStudents() {
        for (Student s : students) {
            s.promoteIfEligible();
        }
    }

    public void printStudents(int course) {
        System.out.println("Студенты на курсе #" + course + ":");
        for (Student s : students) {
            if (s.getCourse() == course) {
                System.out.println(s.getName());
            }
        }
    }
}

public class lesson6_1 {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        Map<String, Integer> grades1 = Map.of("Математика", 4, "Экономика", 5, "Информатика", 3, "Физкультура", 4);
        Map<String, Integer> grades2 = Map.of("Математика", 5, "Экономика", 4, "Информатика", 5, "Физкультура", 4);
        Map<String, Integer> grades3 = Map.of("Математика", 3, "Экономика", 2, "Информатика", 2, "Физкультура", 4);
        Map<String, Integer> grades4 = Map.of("Математика", 4, "Экономика", 5, "Информатика", 5, "Физкультура", 4);
        Map<String, Integer> grades5 = Map.of("Математика", 5, "Экономика", 3, "Информатика", 2, "Физкультура", 4);
        Map<String, Integer> grades6 = Map.of("Математика", 3, "Экономика", 5, "Информатика", 3, "Физкультура", 4);
        Map<String, Integer> grades7 = Map.of("Математика", 5, "Экономика", 4, "Информатика", 5, "Физкультура", 4);
        Map<String, Integer> grades8 = Map.of("Математика", 2, "Экономика", 3, "Информатика", 2, "Физкультура", 4);
        Map<String, Integer> grades9 = Map.of("Математика", 4, "Экономика", 5, "Информатика", 2, "Физкультура", 4);
        Map<String, Integer> grades10 = Map.of("Математика", 5, "Экономика", 4, "Информатика", 5, "Физкультура", 4);

        manager.addStudent(new Student("Дарья", "A1", 1, grades1));
        manager.addStudent(new Student("Мария", "A1", 1, grades2));
        manager.addStudent(new Student("Александр", "А1", 1, grades3));
        manager.addStudent(new Student("Алексей", "А1", 1, grades4));
        manager.addStudent(new Student("Михаил", "А1", 1, grades5));
        manager.addStudent(new Student("Серегй", "А1", 1, grades6));
        manager.addStudent(new Student("Анна", "А1", 1, grades7));
        manager.addStudent(new Student("Виктор", "А1", 1, grades8));
        manager.addStudent(new Student("Анастасия", "А1", 1, grades9));
        manager.addStudent(new Student("Лев", "А1", 1, grades10));

        manager.removeLowPerformers();

        manager.promoteEligibleStudents();

        manager.printStudents(2);
    }
}
