import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Administrator {

    // RED
    School school;
    Administrator(School school) {
        this.school = school;
    }

    void run() {
        while (true) {
            simulateDay();
        }
    }

    void run(int days) {
        for (int i = 0; i < days; i++)
        {
            simulateDay();
            reportDay();
        }
    }

    void simulateDay() {
        admitNewStudents();
        admitNewInstructors();
        school.aDayAtSchool();
        kickFreeInstructors();
        kickGraduateStudents();
        kickFreeStudents();
    }

    void admitNewStudents() {
        Random random = new Random();
        int numberNewStudentsToAdmit = random.nextInt(3);
        List<Student> students = school.getStudents();
        for (int i = 0; i < numberNewStudentsToAdmit; i++) {
            String randomName = "Student " + random.nextInt(1000);
            char randomGender = getRandomGender();
            int randomAge = random.nextInt(40) + 40;
            school.add(new Student(randomName, randomGender, randomAge));
        }
    }

    void admitNewInstructors() {
        Random random = new Random();

        // See if we get teacher
        int chanceBoundary = random.nextInt(100) + 1;
        if (chanceBoundary <= 20) {
            String randomName = "Teacher " + random.nextInt(1000);
            char randomGender = getRandomGender();
            int randomAge = random.nextInt(40) + 40;
            school.add(new Teacher(randomName, randomGender, randomAge));
        }

        // See if we get demonstrator
        chanceBoundary = random.nextInt(100) + 1;
        if (chanceBoundary <= 10) {
            String randomName = "Demonstrator " + random.nextInt(1000);
            char randomGender = getRandomGender();
            int randomAge = random.nextInt(40) + 40;
            school.add(new Demonstrator(randomName, randomGender, randomAge));
        }

        // See if we get OOTrainer
        chanceBoundary = random.nextInt(100) + 1;
        if (chanceBoundary <= 5) {
            String randomName = "OOTrainer " + random.nextInt(1000);
            char randomGender = getRandomGender();
            int randomAge = random.nextInt(40) + 40;
            school.add(new OOTrainer(randomName, randomGender, randomAge));
        }

        // See if we get GUITrainer
        chanceBoundary = random.nextInt(100) + 1;
        if (chanceBoundary <= 5) {
            String randomName = "GUITrainer " + random.nextInt(1000);
            char randomGender = getRandomGender();
            int randomAge = random.nextInt(40) + 40;
            school.add(new GUITrainer(randomName, randomGender, randomAge));
        }
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

    char getRandomGender() {
        Random random = new Random();
        boolean genderBool = random.nextBoolean();
        char gender;
        if (genderBool) {
            gender = 'M';
        }
        else {
            gender = 'F';
        }
        return gender;
    }

    public static void main(String[] args) throws FileNotFoundException {
        School newSchool =  new School("Temp");
        Administrator administrator = new Administrator(newSchool);
        administrator.loadFromFile(args[0]);
        int durationSimulation = Integer.parseInt(args[1]);
        administrator.run(durationSimulation);
    }

    void loadFromFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String[] lineParts = line.split(":");

            String object = lineParts[0];

            String objectAttributes = lineParts[1];
            String[] objectAttributesParts = objectAttributes.split(",");

            if (object.equals("school")) {
                String attribute1 = objectAttributesParts[0];
                String schoolName = attribute1;
                this.school.setName(schoolName);
            }
            else if (object.equals("subject")) {
                String attribute1 = objectAttributesParts[0];
                String attribute2 = objectAttributesParts[1];
                String attribute3 = objectAttributesParts[2];
                String attribute4 = objectAttributesParts[3];
                int subjectId = Integer.parseInt(attribute2);
                int specialism = Integer.parseInt(attribute3);
                int duration = Integer.parseInt(attribute4);
                String description = attribute1;
                Subject newSubject = new Subject(subjectId, specialism, duration, description);
                school.add(newSubject);
            }
            else if (object.equals("student")) {
                String attribute1 = objectAttributesParts[0];
                String attribute2 = objectAttributesParts[1];
                String attribute3 = objectAttributesParts[2];
                String name = attribute1;
                char gender = attribute2.charAt(0);
                int age = Integer.parseInt(attribute3);
                Student newStudent = new Student(name, gender, age);
                school.add(newStudent);
            }
            else if (object.equals("Teacher")) {
                String attribute1 = objectAttributesParts[0];
                String attribute2 = objectAttributesParts[1];
                String attribute3 = objectAttributesParts[2];
                String name = attribute1;
                char gender = attribute2.charAt(0);
                int age = Integer.parseInt(attribute3);
                Teacher newTeacher = new Teacher(name, gender, age);
                school.add(newTeacher);
            }
            else if (object.equals("Demonstrator")) {
                String attribute1 = objectAttributesParts[0];
                String attribute2 = objectAttributesParts[1];
                String attribute3 = objectAttributesParts[2];
                String name = attribute1;
                char gender = attribute2.charAt(0);
                int age = Integer.parseInt(attribute3);
                Demonstrator newDemonstrator = new Demonstrator(name, gender, age);
                school.add(newDemonstrator);
            }
            else if (object.equals("OOTrainer")) {
                String attribute1 = objectAttributesParts[0];
                String attribute2 = objectAttributesParts[1];
                String attribute3 = objectAttributesParts[2];
                String name = attribute1;
                char gender = attribute2.charAt(0);
                int age = Integer.parseInt(attribute3);
                OOTrainer newOOTrainer = new OOTrainer(name, gender, age);
                school.add(newOOTrainer);
            }
            else if (object.equals("GUITrainer")) {
                String attribute1 = objectAttributesParts[0];
                String attribute2 = objectAttributesParts[1];
                String attribute3 = objectAttributesParts[2];
                String name = attribute1;
                char gender = attribute2.charAt(0);
                int age = Integer.parseInt(attribute3);
                GUITrainer newGUITrainer = new GUITrainer(name, gender, age);
                school.add(newGUITrainer);
            }
        }
    }
}
