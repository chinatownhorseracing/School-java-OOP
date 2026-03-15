import java.util.ArrayList;
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
        school.aDayAtSchool();
        kickFreeInstructors();
    }

    void admitStudents() {
        Random random = new Random();
        int numberNewStudentsToAdmit = random.nextInt(3);
        List<Student> students = school.getStudents();
        for (int i = 0; i < numberNewStudentsToAdmit; i++) {
            school.add(new Student());
        }
    }

    void admitInstructors() {

    }

    void kickFreeInstructors() {
        List<Instructor> freeInstructors = school.getFreeInstructors();
        for (Instructor freeInstructor : freeInstructors) {
            Random random = new Random();
            int chanceBoundary = random.nextInt(100) + 1;
            if (chanceBoundary <= 20) {
                school.remove(freeInstructor);
            }
        }
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
