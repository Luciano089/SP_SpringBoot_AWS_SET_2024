public class Task {
    private String description;
    private int id;

    public Task(String description, int id) {
        this.description = description;
        this.id = id;
    }
    public String getDescription() {
        return description;
    };
    public int getId() {
        return id;
    };

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
