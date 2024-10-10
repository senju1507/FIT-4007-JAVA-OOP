// Player.java
public class Player {
    private String name;
    private int age;
    private String position;
    private int jerseyNumber;

    public Player(String name, int age, String position, int jerseyNumber) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
    }

    // Getters và Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    @Override
    public String toString() {
        return "Cầu thủ: " + name + ", Tuổi: " + age + ", Vị trí: " + position + ", Số áo: " + jerseyNumber;
    }
}
