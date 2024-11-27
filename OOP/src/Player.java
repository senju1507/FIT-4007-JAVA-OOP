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

    public String getName() {
        return name;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    @Override
    public String toString() {
        return "Cầu thủ: " + name + ", Tuổi: " + age + ", Vị trí: " + position + ", Số áo: " + jerseyNumber;
    }
}