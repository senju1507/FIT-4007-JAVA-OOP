// Team.java
import java.util.ArrayList;
import java.util.Scanner;

public class Team {
    private String name;
    private ArrayList<Player> players;
    private ArrayList<Match> matches;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        this.matches = new ArrayList<>();
    }

    // Minh: Chức năng 1 - Thêm cầu thủ
    public void addPlayer(Player player) {
        // Kiểm tra số áo đã tồn tại
        for (Player p : players) {
            if (p.getJerseyNumber() == player.getJerseyNumber()) {
                System.out.println("Số áo " + player.getJerseyNumber() + " đã tồn tại. Không thể thêm cầu thủ.");
                return;
            }
        }
        players.add(player);
    }
       // Tấn: Chức năng 2 - Thêm trận đấu
    public void addMatch(Match match) {
        matches.add(match);
    }
       // Tấn: Chức năng 4 - Hiển thị trận đấu
    public void listMatches() {
        if (matches.isEmpty()) {
            System.out.println("Danh sách trận đấu trống.");
            return;
        }
        System.out.println("\n--- Danh Sách Trận Đấu ---");
        for (Match match : matches) {
            System.out.println(match);
        }
    }


// Minh: Chức năng 5 - Xem thống kê đội bóng
    public void showStatistics() {
        System.out.println("\n--- Thống Kê Đội Bóng ---");
        System.out.println("Tên đội: " + name);
        System.out.println("Số cầu thủ: " + players.size());
        System.out.println("Số trận đấu: " + matches.size());

    }


       // Tấn: Chức năng 8 - Cập nhật thông tin cầu thủ
    public void updatePlayerInfo(int jerseyNumber, Scanner scanner) {
        for (Player player : players) {
            if (player.getJerseyNumber() == jerseyNumber) {
                try {
                    System.out.print("Nhập tên mới (hiện tại: " + player.getName() + "): ");
                    String newName = scanner.nextLine();
                    if (!newName.trim().isEmpty()) {
                        player.setName(newName);
                    }

                    System.out.print("Nhập tuổi mới (hiện tại: " + player.getAge() + "): ");
                    String ageInput = scanner.nextLine();
                    if (!ageInput.trim().isEmpty()) {
                        int newAge = Integer.parseInt(ageInput);
                        if (newAge > 0) {
                            player.setAge(newAge);
                        } else {
                            System.out.println("Tuổi phải là số dương. Không cập nhật tuổi.");
                        }
                    }

    // Minh: Chức năng 9 - Hiển thị danh sách cầu thủ theo vị trí chơi
    public void listPlayersByPosition(String position) {
        boolean found = false;
        System.out.println("\n--- Danh Sách Cầu Thủ Vị Trí: " + position + " ---");
        for (Player player : players) {
            if (player.getPosition().equalsIgnoreCase(position)) {
                System.out.println(player);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy cầu thủ ở vị trí \"" + position + "\".");
        }
    }

    // 10. Hiển thị thống kê tuổi đội bóng - Được thực hiện bởi tất cả mọi người (Minh, Tấn, Vọng)
    public void showAgeStatistics() {
        if (players.isEmpty()) {
            System.out.println("Không có cầu thủ nào trong đội để tính toán thống kê tuổi.");
            return;
        }

        int totalAge = 0;
        int maxAge = players.get(0).getAge();
        int minAge = players.get(0).getAge();
        Player oldestPlayer = players.get(0);
        Player youngestPlayer = players.get(0);

        for (Player player : players) {
            int age = player.getAge();
            totalAge += age;

            if (age > maxAge) {
                maxAge = age;
                oldestPlayer = player;
            }

            if (age < minAge) {
                minAge = age;
                youngestPlayer = player;
            }
        }

        double averageAge = (double) totalAge / players.size();

        System.out.println("\n--- Thống Kê Tuổi Đội Bóng ---");
        System.out.printf("Tuổi trung bình: %.2f%n", averageAge);
        System.out.println("Cầu thủ cao tuổi nhất: " + oldestPlayer);
        System.out.println("Cầu thủ trẻ tuổi nhất: " + youngestPlayer);
    }
}
