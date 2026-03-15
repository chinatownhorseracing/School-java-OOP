public class Subject {

    // RED
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


    // RED
    int getId() {
        return id;
    }

    // RED
    int getSpecialism() {
        return specialism;
    }

    // RED
    int getDuration() {
        return duration;
    }

    // RED
    String getDescription() {
        return description;
    }

    // RED
    public void setDescription(String description) {
        this.description = description;
    }
}
