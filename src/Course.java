import java.util.ArrayList;
import java.util.List;

public class Course {

    // RED
    private Subject subject;
    private int daysUntilStarts;
    private int daysToRun;

    private List<Student> enrolledStudents = new ArrayList<>(3);
    private Instructor instructor;
    private boolean isCancelled = false;

    Course(Subject subject, int daysUntilStarts) {
        this.subject = subject;
        this.daysUntilStarts = daysUntilStarts;
        daysToRun = subject.getDuration();
    }

    // RED
    public Subject getSubject() {
        return subject;
    }

    // RED
    int getStatus() {

        // Course didn't start
        if (daysUntilStarts > 0) {
            int negativeDaysUntilStarts = -daysUntilStarts;
            return negativeDaysUntilStarts;
        }
        // Course started
        else if (daysToRun > 0) {
            return daysToRun;
        }
        // Course finished
        return 0;
    }

    // RED
    void aDayPasses() {
        // if course not started
        if (daysUntilStarts > 0) {
            daysUntilStarts--;
        }

        // if course finished
        else if (daysToRun == 0) {
            for (Student student : enrolledStudents) {
                student.graduate(subject);
            }
            instructor.unassignCourse();
        }

        // if course started
        else {
            if (instructor == null || enrolledStudents.size() == 0) {
                isCancelled = true;
            }
            daysToRun--;
        }
    }

    // RED
    boolean enrolStudent(Student student) {
        int courseStatus = getStatus();
        boolean courseStarted = false;
        if (courseStatus > 0) {
            courseStarted = true;
        }
        if (enrolledStudents.size() < 3 && !courseStarted) {
            enrolledStudents.add(student);
            return true;
        }
        return false;
    }

    // RED
    int getSize() {
        int numberEnrolledStudents = enrolledStudents.size();
        return numberEnrolledStudents;
    }

    // RED
//    Student[] getStudents() {
//        Student[] studentsArray = enrolledStudents.toArray(new Student[0]);
//        return studentsArray;
//    }
    List<Student> getStudents() {
        return enrolledStudents;
    }

    // RED
    boolean setInstructor(Instructor instructor) {
        if (instructor.canTeach(subject)) {
            this.instructor = instructor;
            return true;
        }
        return false;
    }

    // RED
    boolean hasInstructor() {
        boolean hasInstructor = false;
        if (instructor != null) {
            hasInstructor = true;
        }
        return hasInstructor;
    }

    // RED
    boolean isCancelled() {
        return isCancelled;
    }
}
