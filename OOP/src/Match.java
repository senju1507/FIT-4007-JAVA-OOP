public class Match {
    private String opponent;
    private String date;

    public Match(String opponent, String date) {
        this.opponent = opponent;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Trận đấu với " + opponent + " vào ngày " + date;
    }
}