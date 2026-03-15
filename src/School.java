import java.util.ArrayList;
import java.util.List;

public class School {
    private String name;
    private List<Student> students = new ArrayList<>();
    private List<Instructor> instructors = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    School(String name) {
        this.name = name;
    }

    void add(Student student) {
        students.add(student);
    }

    void remove(Student student) {
        students.remove(student);
    }

    List<Student> getStudents() {
        return students;
    }

    void add(Instructor instructor) {
        instructors.add(instructor);
    }

    void remove(Instructor instructor) {
        instructors.remove(instructor);
    }

    List<Instructor> getInstructors() {
        return instructors;
    }

    void add(Subject subject) {
        subjects.add(subject);
    }

    void remove(Subject subject) {
        subjects.remove(subject);
    }

    List<Subject> getSubjects() {
        return subjects;
    }

    void add(Course course) {
        courses.add(course);
    }

    void remove(Course course) {
        courses.remove(course);
    }

    List<Course> getCourses() {
        return courses;
    }

    // TODO
    @Override
    public String toString() {

    }

    void aDayAtSchool() {

        // Create new courses for subject without open courses
        List<Integer> courseSubjectIds = new ArrayList<>();
        for (Course course : courses) {
            Subject subject = course.getSubject();
            int subjectId = subject.getId();
            courseSubjectIds.add(subjectId);
        }

        for (Subject subject : subjects) {
            int subjectId = subject.getId();
            if (!courseSubjectIds.contains(subjectId)) {
                createNewCourseForSubject(subject);
            }
        }


        // Assign instructors to courses that need one
        for (Course course : courses) {
            Subject courseSubject = course.getSubject();

            if (!course.hasInstructor()) {
                for (Instructor instructor : instructors) {
                    Course instructorAssignedCourse = instructor.getAssignedCourse();
                    if (instructorAssignedCourse == null && instructor.canTeach(courseSubject)) {
                        boolean assigned = course.setInstructor(instructor);
                    }
                }
            }
        }
    }

    void createNewCourseForSubject(Subject subject) {
        Course course = new Course(subject, 2);
        courses.add(course);
    }
}
