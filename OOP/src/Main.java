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
            System.out.println("5. Xem thống kê đội bóng");
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
                case 5:
                    team.showStatistics();
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
