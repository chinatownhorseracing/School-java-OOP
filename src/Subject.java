public class Subject {
    private int id;
    private int specialism;
    private int duration;
    private String description;

    Subject(int id, int specialism, int duration, String description) {
        this.id = id;
        this.specialism = specialism;
        this.duration = duration;
        this.description = description;
    }

    int getId() {
        return id;
    }

    int getSpecialism() {
        return specialism;
    }

    int getDuration() {
        return duration;
    }

    String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
