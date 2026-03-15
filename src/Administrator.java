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
        kickGraduateStudents();
        kickFreeStudents();
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

    void kickGraduateStudents() {
        List<Student> graduateStudents = school.getGraduateStudents();
        for (Student graduateStudent : graduateStudents) {
            school.remove(graduateStudent);
        }
    }

    void kickFreeStudents() {
        List<Student> allCourseStudents = school.getAllCourseStudents();
        List<Student> freeStudents = school.getFreeStudents(allCourseStudents);
        for (Student freeStudent : freeStudents) {
            Random random = new Random();
            int chanceThreshold = random.nextInt(100) + 1;
            if (chanceThreshold <= 5) {
                school.remove(freeStudent);
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
