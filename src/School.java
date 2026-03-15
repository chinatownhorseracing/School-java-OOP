import java.util.ArrayList;
import java.util.List;

public class School {
    // RED
    private String name;

    private List<Student> students = new ArrayList<>();
    private List<Instructor> instructors = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    School(String name) {
        this.name = name;
    }

    // RED
    void add(Student student) {
        students.add(student);
    }

    // RED
    void remove(Student student) {
        students.remove(student);
    }

    // RED
    List<Student> getStudents() {
        return students;
    }

    // RED
    void add(Instructor instructor) {
        instructors.add(instructor);
    }

    // RED
    void remove(Instructor instructor) {
        instructors.remove(instructor);
    }

    // RED
    List<Instructor> getInstructors() {
        return instructors;
    }

    // RED
    void add(Subject subject) {
        subjects.add(subject);
    }

    // RED
    void remove(Subject subject) {
        subjects.remove(subject);
    }

    // RED
    List<Subject> getSubjects() {
        return subjects;
    }

    // RED
    void add(Course course) {
        courses.add(course);
    }

    // RED
    void remove(Course course) {
        courses.remove(course);
    }

    // RED
    List<Course> getCourses() {
        return courses;
    }

    // TODO
    // RED
    @Override
    public String toString() {

    }

    // RED
    void aDayAtSchool() {

        // Create new courses for subject without open courses
        List<Integer> courseSubjectIds = getCourseSubjectIds();
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
                        course.setInstructor(instructor);
                        instructor.assignCourse(course);
                        break;
                    }
                }
            }
        }

        // Assign free students to courses they can join
        List<Student> allCourseStudents = getAllCourseStudents();
        List<Student> freeStudents = new ArrayList<>();

        for (Student student : students) {
            if (!allCourseStudents.contains(student)) {
                freeStudents.add(student);
            }
        }
    }

    List<Integer> getCourseSubjectIds() {
        List<Integer> courseSubjectIds = new ArrayList<>();

        for (Course course : courses) {
            Subject subject = course.getSubject();
            int subjectId = subject.getId();
            courseSubjectIds.add(subjectId);
        }

        return courseSubjectIds;
    }

    void createNewCourseForSubject(Subject subject) {
        Course course = new Course(subject, 2);
        courses.add(course);
    }

    List<Student> getAllCourseStudents() {
        List<Student> allCourseStudents = new ArrayList<>();
        for (Course course : courses) {
            List<Student> courseStudents = course.getStudents();
            allCourseStudents.addAll(courseStudents);
        }

        return allCourseStudents;
    }

    List<Student> getFreeStudents() {

    }
}
