import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private List<Integer> certificates = new ArrayList<>();

    Student(String name, char gender, int age) {
        super(name, gender, age);
    }

    void graduate(Subject subject) {
        int subjectId = subject.getId();
        certificates.add(subjectId);
    }

    public List<Integer> getCertificates() {
        return certificates;
    }

    boolean hasCertificate(Subject subject) {
        int subjectId = subject.getId();
        boolean hasCertificate = certificates.contains(subjectId);
        return hasCertificate;
    }
}
