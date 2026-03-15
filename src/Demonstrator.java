public class Demonstrator extends Instructor {
    Demonstrator(String name, char gender, int age) {
        super(name, gender, age);
    }

    @Override
    boolean canTeach(Subject subject) {
        int subjectId = subject.getId();
        if (subjectId == 2) {
            return true;
        }
        return false;
    }


}
