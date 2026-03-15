import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    // RED
    private List<Integer> certificates = new ArrayList<>();

    Student(String name, char gender, int age) {
        super(name, gender, age);
    }

    // RED
    void graduate(Subject subject) {
        int subjectId = subject.getId();
        certificates.add(subjectId);
    }

    // RED
    public List<Integer> getCertificates() {
        return certificates;
    }

    // RED
    boolean hasCertificate(Subject subject) {
        int subjectId = subject.getId();
        boolean hasCertificate = certificates.contains(subjectId);
        return hasCertificate;
    }
}
