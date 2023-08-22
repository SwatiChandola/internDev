import java.util.*;
class Student {
    String name;
    List<Double> scores;
    Student(String name) {
        this.name = name;
        scores = new ArrayList<>();
    }
    void addScore(double score) {
        scores.add(score);
    }
    double calculateAverage() {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        return sum / scores.size();
    }
}
public class gradebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        while (true) {
            System.out.print("Enter student name (or 'exit' to quit): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            Student student = new Student(input);
            for (int i = 1; i <= 5; i++) {
                System.out.print("Enter score for assignment " + i + ": ");
                double score = scanner.nextDouble();
                student.addScore(score);
            }
            scanner.nextLine();
            students.add(student);
        }
        System.out.println("\nSummary:");
        for (Student student : students) {
            double average = student.calculateAverage();
            System.out.println("Student: " + student.name);
            System.out.println("Scores: " + student.scores);
            System.out.println("Average: " + average);
            System.out.println();
        }
    }
}
