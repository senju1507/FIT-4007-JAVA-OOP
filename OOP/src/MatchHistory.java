public class MatchHistory {
    private String matchDetails;

    public MatchHistory(String matchDetails) {
        this.matchDetails = matchDetails;
    }

    @Override
    public String toString() {
        return "Lịch sử đấu: " + matchDetails;
    }
}
