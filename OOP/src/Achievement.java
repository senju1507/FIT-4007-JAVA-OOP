public class Achievement {
    private String title;
    private int year;

    public Achievement(String title, int year) {
        this.title = title;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Thành tích: " + title + " - Năm: " + year;
    }
}