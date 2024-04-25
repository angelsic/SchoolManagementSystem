package main.v1.repository.entity;

public class Course {
    private int id;
    private String name;
    private String description;
    private int creditnumber;
    private String version;

    public Course(int id, String name, String description, int creditnumber, String version) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creditnumber = creditnumber;
        this.version = version;
    }

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreditnumber() {
        return creditnumber;
    }

    public void setCreditnumber(int creditnumber) {
        this.creditnumber = creditnumber;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
