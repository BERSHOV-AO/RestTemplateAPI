public class User {
    private Long id;
    private String name;
    private String lasName;
    private Byte age;

    public User() {
    }

    public User(Long id, String name, String lasName, Byte age) {
        this.id = id;
        this.name = name;
        this.lasName = lasName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLasName() {
        return lasName;
    }

    public void setLasName(String lasName) {
        this.lasName = lasName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }
}
