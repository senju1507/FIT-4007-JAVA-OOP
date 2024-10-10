// Match.java
import java.text.SimpleDateFormat;
import java.util.Date;

public class Match {
    private Date matchDate;
    private String opponent;
    private int ourScore;
    private int opponentScore;

    public Match(Date matchDate, String opponent, int ourScore, int opponentScore) {
        this.matchDate = matchDate;
        this.opponent = opponent;
        this.ourScore = ourScore;
        this.opponentScore = opponentScore;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public String getOpponent() {
        return opponent;
    }

    public int getOurScore() {
        return ourScore;
    }

    public int getOpponentScore() {
        return opponentScore;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return "Ngày: " + dateFormat.format(matchDate) + ", Đối thủ: " + opponent +
                ", Tỉ số: " + ourScore + " - " + opponentScore;
    }
}
