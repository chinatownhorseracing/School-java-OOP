import java.util.List;
import java.util.Random;

public class Administrator {

    // RED
    School school;

    void run() {
        while (true) {
            simulatedDay();
        }
    }

    void run(int days) {
        for (int i = 0; i < days; i++)
        {
            simulatedDay();
        }
    }




    void simulatedDay() {
        admitStudents();
        admitInstructors();
    }

    void admitStudents() {
        Random random = new Random();
        int numberNewStudentsToAdmit = random.nextInt(3);
        List<Student> students = school.getStudents();
        for (int i = 0; i < numberNewStudentsToAdmit; i++) {
            students.add(new Student());
        }
    }

    void admitInstructors() {

    }

    void registerStudent() {

    }

    void deregisterStudent() {

    }

    void registerInstructor() {

    }

    void deregisterInstructor() {

    }
}
