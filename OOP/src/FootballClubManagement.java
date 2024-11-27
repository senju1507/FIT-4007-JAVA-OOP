import java.util.ArrayList;
import java.util.Scanner;

public class FootballClubManagement {
    private ArrayList<Player> players;
    private ArrayList<Coach> coaches;
    private ArrayList<Match> matches;
    private ArrayList<Achievement> achievements;
    private ArrayList<MatchHistory> matchHistories;
    private Finance finance;

    public FootballClubManagement() {
        players = new ArrayList<>();
        coaches = new ArrayList<>();
        matches = new ArrayList<>();
        achievements = new ArrayList<>();
        matchHistories = new ArrayList<>();
        finance = new Finance();
    }

    public void addPlayer(Scanner scanner) {
        System.out.print("Nhập tên cầu thủ: ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi cầu thủ: ");
        int age = scanner.nextInt();
        System.out.print("Nhập vị trí cầu thủ: ");
        scanner.nextLine(); // Clear buffer
        String position = scanner.nextLine();
        System.out.print("Nhập số áo cầu thủ: ");
        int jerseyNumber = scanner.nextInt();
        players.add(new Player(name, age, position, jerseyNumber));
        System.out.println("Cầu thủ đã được thêm.");
    }

    public void buyPlayer(Scanner scanner) {
        System.out.print("Nhập tên cầu thủ cần mua: ");
        String name = scanner.nextLine();
        System.out.print("Nhập số áo cầu thủ: ");
        int jerseyNumber = scanner.nextInt();
        System.out.print("Nhập giá cầu thủ: ");
        double price = scanner.nextDouble();

        finance.deductFinance(price, "Mua cầu thủ: " + name);
        players.add(new Player(name, 25, "Vị trí", jerseyNumber)); // Giả sử cầu thủ mới 25 tuổi và vị trí "Vị trí"
        System.out.println("Đã mua cầu thủ: " + name);
    }

    public void sellPlayer(Scanner scanner) {
        System.out.print("Nhập số áo cầu thủ cần bán: ");
        int jerseyNumber = scanner.nextInt();
        Player playerToRemove = null;

        for (Player player : players) {
            if (player.getJerseyNumber() == jerseyNumber) {
                playerToRemove = player;
                break;
            }
        }

        if (playerToRemove != null) {
            players.remove(playerToRemove);
            System.out.print("Nhập giá bán cầu thủ: ");
            double sellPrice = scanner.nextDouble();
            finance.addFinance(sellPrice, "Bán cầu thủ: " + playerToRemove.getName());
            System.out.println("Đã bán cầu thủ: " + playerToRemove.getName());
        } else {
            System.out.println("Cầu thủ không tồn tại.");
        }
    }

    public void manageCoach(Scanner scanner) {
        System.out.print("Nhập tên huấn luyện viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập kinh nghiệm huấn luyện viên: ");
        int experience = scanner.nextInt();
        coaches.add(new Coach(name, experience));
        System.out.println("Huấn luyện viên đã được thêm.");
    }

    public void addFinance(Scanner scanner) {
        System.out.print("Nhập số tiền thêm vào ngân sách: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer
        System.out.print("Nhập mô tả: ");
        String description = scanner.nextLine();
        finance.addFinance(amount, description);
        System.out.println("Tài chính đã được thêm.");
    }

    public void displayFinance() {
        System.out.println("Ngân sách hiện tại: " + finance.getBudget());
        finance.displayTransactions();
    }

    public void addMatch(Scanner scanner) {
        System.out.print("Nhập đối thủ: ");
        String opponent = scanner.nextLine();
        System.out.print("Nhập ngày: ");
        String date = scanner.nextLine();
        matches.add(new Match(opponent, date));
        System.out.println("Lịch đấu đã được thêm.");
    }

    public void addAchievement(Scanner scanner) {
        System.out.print("Nhập thành tích: ");
        String title = scanner.nextLine();
        System.out.print("Nhập năm: ");
        int year = scanner.nextInt();
        achievements.add(new Achievement(title, year));
        System.out.println("Thành tích đã được thêm.");
    }
    public void addMatchHistory(Scanner scanner) {
        System.out.print("Nhập chi tiết lịch sử đấu: ");
        String matchDetails = scanner.nextLine();
        matchHistories.add(new MatchHistory(matchDetails));
        System.out.println("Lịch sử đấu đã được thêm.");
    }

    public void displayPlayers() {
        System.out.println("Danh sách cầu thủ:");
        for (Player player : players) {
            System.out.println(player);
        }
    }

    public void displayCoaches() {
        System.out.println("Danh sách huấn luyện viên:");
        for (Coach coach : coaches) {
            System.out.println(coach);
        }
    }

    public void displayMatches() {
        System.out.println("Danh sách trận đấu:");
        for (Match match : matches) {
            System.out.println(match);
        }
    }

    public void displayAchievements() {
        System.out.println("Danh sách thành tích:");
        for (Achievement achievement : achievements) {
            System.out.println(achievement);
        }
    }

    public void displayMatchHistories() {
        System.out.println("Lịch sử đấu:");
        for (MatchHistory matchHistory : matchHistories) {
            System.out.println(matchHistory);
        }
    }
}
