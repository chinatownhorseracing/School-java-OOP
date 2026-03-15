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
            reportDay();
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

    void reportDay() {
        reportCourses();
        reportStudents();
        reportInstructors();
    }

    void reportCourses() {
        List<Course> courses = school.getCourses();
        for (Course course : courses) {
            int status = course.getStatus();
            List<Student> enrolledStudents = course.getStudents();
            System.out.println(status);
            System.out.println(enrolledStudents);
        }
    }

    void reportStudents() {
        List<Student> students = school.getStudents();
        List<Course> courses = school.getCourses();

        for (Student student : students) {

            List<Integer> studentCertificates = student.getCertificates();
            System.out.println(studentCertificates);

            for (Course course : courses) {
                List<Student> enrolledStudents = course.getStudents();
                if (enrolledStudents.contains(student)) {
                    System.out.println(course);
                }
            }

        }


    }

    void reportInstructors() {
        List<Instructor> instructors = school.getInstructors();
        for (Instructor instructor : instructors) {
            Course instructorAssignedCourse = instructor.getAssignedCourse();
            System.out.println(instructorAssignedCourse);
        }
    }
}
