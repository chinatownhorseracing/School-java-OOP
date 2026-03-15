public class OOTrainer extends Instructor {
    OOTrainer(String name, char gender, int age) {
        super(name, gender, age);
    }

    @Override
    boolean canTeach(Subject subject) {
        int subjectId = subject.getId();
        if (subjectId == 1 || subjectId == 2 || subjectId == 3) {
            return true;
        }
        return false;
    }


}
