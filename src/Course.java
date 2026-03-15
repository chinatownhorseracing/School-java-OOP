import java.util.ArrayList;
import java.util.List;

public class Course {
    private Subject subject;
    private int daysUntilStarts;
    private int daysToRun;
    List<Student> enrolledStudents = new ArrayList<>(3);

    Course(Subject subject, int daysUntilStarts) {
        this.subject = subject;
        this.daysUntilStarts = daysUntilStarts;
        daysToRun = subject.getDuration();
    }

    public Subject getSubject() {
        return subject;
    }

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

    void aDayPasses() {
        if (daysUntilStarts > 0) {
            daysUntilStarts--;
        }
        else if (daysToRun == 0) {
            for (Student student : enrolledStudents) {
                student.graduate(subject);
            }
        }
        else {
            daysToRun--;
        }
    }

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

    int getSize() {
        int numberEnrolledStudents = enrolledStudents.size();
        return numberEnrolledStudents;
    }

    Student[] getStudents() {
        Student[] studentsArray = enrolledStudents.toArray(new Student[0]);
        return studentsArray;
    }
}
