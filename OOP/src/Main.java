// Main.java
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        Team team = new Team("My Football Team");
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false); // Đảm bảo ngày tháng được phân tích chính xác
 while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Thêm cầu thủ");
            System.out.println("2. Thêm trận đấu");
            System.out.println("3. Hiển thị danh sách cầu thủ");
            System.out.println("4. Hiển thị trận đấu");
            System.out.println("5. Xem thống kê đội bóng");
            System.out.println("6. Tìm kiếm cầu thủ theo tên");
            System.out.println("7. Xóa cầu thủ");
            System.out.println("8. Cập nhật thông tin cầu thủ");
            System.out.println("9. Hiển thị danh sách cầu thủ theo vị trí chơi");
            System.out.println("10. Hiển thị thống kê tuổi đội bóng");
            System.out.println("11. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số từ 1 đến 11.");
                continue;
            }
            switch (choice) {
                case 1:
                    addPlayer(team, scanner);
                    break;
                case 2:
                    addMatch(team, scanner, dateFormat);
                    break;
                case 3:
                    team.listPlayers();
                    break;
                case 4:
                    team.listMatches();
                    break;
                case 5:
                    team.showStatistics();
                    break;
                case 6:
                    searchPlayer(team, scanner);
                    break;
                case 7:
                    removePlayer(team, scanner);
                case 8:
                    updatePlayer(team, scanner);
                    break;
                case 9:
                    listPlayersByPosition(team, scanner);
                    break;
                case 10:
                    showAgeStatistics(team);
                    break;
                case 11:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số từ 1 đến 11.");
            }
        }
    }
  // Minh: Chức năng 1 - Thêm cầu thủ
    private static void addPlayer(Team team, Scanner scanner) {
        try {
            System.out.print("Nhập tên cầu thủ: ");
            String name = scanner.nextLine();

            System.out.print("Nhập tuổi cầu thủ: ");
            int age = Integer.parseInt(scanner.nextLine());
            if (age <= 0) {
                throw new NumberFormatException("Tuổi phải là số dương.");
            }

            System.out.print("Nhập vị trí chơi: ");
            String position = scanner.nextLine();

            System.out.print("Nhập số áo: ");
            int jerseyNumber = Integer.parseInt(scanner.nextLine());

            Player player = new Player(name, age, position, jerseyNumber);
            team.addPlayer(player);
            System.out.println("Đã thêm cầu thủ thành công.");
        } catch (NumberFormatException e) {
            System.out.println("Dữ liệu nhập vào không hợp lệ: " + e.getMessage());
        }
    }
     // Tấn: Chức năng 2 - Thêm trận đấu
    private static void addMatch(Team team, Scanner scanner, SimpleDateFormat dateFormat) {
        try {
            System.out.print("Nhập ngày thi đấu (dd-MM-yyyy): ");
            String dateString = scanner.nextLine();
            Date matchDate = dateFormat.parse(dateString);

            System.out.print("Nhập tên đối thủ: ");
            String opponent = scanner.nextLine();

            System.out.print("Nhập số bàn thắng đội nhà: ");
            int ourScore = Integer.parseInt(scanner.nextLine());

            System.out.print("Nhập số bàn thắng đội khách: ");
            int opponentScore = Integer.parseInt(scanner.nextLine());

            Match match = new Match(matchDate, opponent, ourScore, opponentScore);
            team.addMatch(match);
            System.out.println("Đã thêm trận đấu thành công.");
        } catch (ParseException e) {
            System.out.println("Định dạng ngày không hợp lệ. Vui lòng nhập theo định dạng dd-MM-yyyy.");
        } catch (NumberFormatException e) {
            System.out.println("Dữ liệu số không hợp lệ: " + e.getMessage());
        }
    }
 // Vọng: Chức năng 6 - Tìm kiếm cầu thủ theo tên
    private static void searchPlayer(Team team, Scanner scanner) {
        System.out.print("Nhập tên cầu thủ cần tìm: ");
        String searchName = scanner.nextLine();
        team.searchPlayerByName(searchName);
    }

    // Vọng: Chức năng 7 - Xóa cầu thủ
    private static void removePlayer(Team team, Scanner scanner) {
        try {
            System.out.print("Nhập số áo cầu thủ cần xóa: ");
            int jerseyToDelete = Integer.parseInt(scanner.nextLine());
            team.removePlayer(jerseyToDelete);
        } catch (NumberFormatException e) {
            System.out.println("Số áo phải là một số nguyên.");
        }
    }


       // Tấn: Chức năng 8 - Cập nhật thông tin cầu thủ
    private static void updatePlayer(Team team, Scanner scanner) {
        try {
            System.out.print("Nhập số áo cầu thủ cần cập nhật: ");
            int jerseyToUpdate = Integer.parseInt(scanner.nextLine());
            team.updatePlayerInfo(jerseyToUpdate, scanner);
        } catch (NumberFormatException e) {
            System.out.println("Số áo phải là một số nguyên.");
        }
    }
    // Minh: Chức năng 9 - Hiển thị danh sách cầu thủ theo vị trí chơi
    private static void listPlayersByPosition(Team team, Scanner scanner) {
        System.out.print("Nhập vị trí chơi cần hiển thị (ví dụ: Hậu vệ, Tiền vệ, Tiền đạo): ");
        String position = scanner.nextLine();
        team.listPlayersByPosition(position);
    }

    // 10. Hiển thị thống kê tuổi đội bóng - Được thực hiện bởi tất cả mọi người
    private static void showAgeStatistics(Team team) {
        team.showAgeStatistics();
    }
}
