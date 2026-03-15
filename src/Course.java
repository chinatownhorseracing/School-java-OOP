import java.util.ArrayList;
import java.util.List;

public class Course {
    private Subject subject;
    private int daysUntilStarts;
    private int daysToRun;

    Course(Subject subject, int daysUntilStarts) {
        this.subject = subject;
        this.daysUntilStarts = daysUntilStarts;
        daysToRun = subject.getDuration();
    }

    public Subject getSubject() {
        return subject;
    }

    int getStatus() {

        if (daysUntilStarts > 0) {
            int negativeDaysUntilStarts = -daysUntilStarts;
            return negativeDaysUntilStarts;
        }
        else if (daysToRun > 0) {
            return daysToRun;
        }
        return 0;
    }

    void aDayPasses() {
        if (daysUntilStarts > 0) {
            daysUntilStarts--;
        }
        else {
            daysToRun--;
        }
    }
}
