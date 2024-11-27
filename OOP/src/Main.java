import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FootballClubManagement clubManagement = new FootballClubManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nQuản lý CLB Bóng Đá:");
            System.out.println("1. Thêm cầu thủ");
            System.out.println("2. Mua cầu thủ");
            System.out.println("3. Bán cầu thủ");
            System.out.println("4. Quản lý huấn luyện viên");
            System.out.println("5. Thêm tài chính");
            System.out.println("6. Hiển thị tài chính");
            System.out.println("7. Thêm trận đấu");
            System.out.println("8. Thêm thành tích");
            System.out.println("9. Thêm lịch sử đấu");
            System.out.println("10. Hiển thị danh sách cầu thủ");
            System.out.println("11. Hiển thị danh sách huấn luyện viên");
            System.out.println("12. Hiển thị danh sách trận đấu");
            System.out.println("13. Hiển thị danh sách thành tích");
            System.out.println("14. Hiển thị lịch sử đấu");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    clubManagement.addPlayer(scanner);
                    break;
                case 2:
                    clubManagement.buyPlayer(scanner);
                    break;
                case 3:
                    clubManagement.sellPlayer(scanner);
                    break;
                case 4:
                    clubManagement.manageCoach(scanner);
                    break;
                case 5:
                    clubManagement.addFinance(scanner);
                    break;
                case 6:
                    clubManagement.displayFinance();
                    break;
                case 7:
                    clubManagement.addMatch(scanner);
                    break;
                case 8:
                    clubManagement.addAchievement(scanner);
                    break;
                case 9:
                    clubManagement.addMatchHistory(scanner);
                    break;
                case 10:
                    clubManagement.displayPlayers();
                    break;
                case 11:
                    clubManagement.displayCoaches();
                    break;
                case 12:
                    clubManagement.displayMatches();
                    break;
                case 13:
                    clubManagement.displayAchievements();
                    break;
                case 14:
                    clubManagement.displayMatchHistories();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Chọn chức năng không hợp lệ.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}