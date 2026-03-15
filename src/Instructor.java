public abstract class Instructor extends Person {

    // RED
    private Course assignedCourse;

    Instructor(String name, char gender, int age) {
        super(name, gender, age);
    }

    // RED
    void assignCourse(Course course) {
        assignedCourse = course;
    }

    // RED
    void unassignCourse() {
        assignedCourse = null;
    }

    // RED
    public Course getAssignedCourse() {
        return assignedCourse;
    }

    // RED
    abstract boolean canTeach(Subject subject);
}
