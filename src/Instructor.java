public abstract class Instructor extends Person {
    private Course assignedCourse;

    Instructor(String name, char gender, int age) {
        super(name, gender, age);
    }

    void assignCourse(Course course) {
        assignedCourse = course;
    }

    void unassignCourse() {
        assignedCourse = null;
    }

    public Course getAssignedCourse() {
        return assignedCourse;
    }

    abstract boolean canTeach(Subject subject);
}
