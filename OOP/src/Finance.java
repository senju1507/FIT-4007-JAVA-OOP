import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Finance {
    private double budget; // Số dư ngân sách
    private final List<String> transactions; // Lịch sử giao dịch (final để không thể thay đổi tham chiếu)

    // Constructor: Khởi tạo ngân sách và danh sách giao dịch
    public Finance(double initialBudget) {
        if (initialBudget < 0) {
            throw new IllegalArgumentException("Ngân sách ban đầu không được âm.");
        }
        this.budget = initialBudget;
        this.transactions = new ArrayList<>();
        logTransaction("Khởi tạo ngân sách: " + formatAmount(initialBudget));
    }

    // Thêm tiền vào ngân sách
    public void addFinance(double amount, String description) {
        validateAmount(amount, "Số tiền thêm");
        budget += amount;
        logTransaction("Thêm: " + formatAmount(amount) + " - " + description);
    }

    // Trừ tiền từ ngân sách
    public void deductFinance(double amount, String description) {
        validateAmount(amount, "Số tiền giảm");
        if (amount > budget) {
            logTransaction("Thất bại: Giảm: " + formatAmount(amount) + " - " + description
                    + " (Ngân sách không đủ)");
            throw new IllegalStateException("Ngân sách không đủ để thực hiện giao dịch này.");
        }
        budget -= amount;
        logTransaction("Giảm: " + formatAmount(amount) + " - " + description);
    }

    // Lấy số dư ngân sách hiện tại
    public double getBudget() {
        return budget;
    }

    // Hiển thị tất cả giao dịch
    public void displayTransactions() {
        System.out.println("=== Lịch sử giao dịch tài chính ===");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
        System.out.println("=== Số dư ngân sách hiện tại: " + formatAmount(budget) + " ===");
    }

    // Lấy lịch sử giao dịch (danh sách không thể thay đổi từ bên ngoài)
    public List<String> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    // Định dạng số tiền (ví dụ: 1,000.00)
    private String formatAmount(double amount) {
        return String.format("%,.2f", amount);
    }

    // Kiểm tra số tiền hợp lệ
    private void validateAmount(double amount, String fieldName) {
        if (amount <= 0) {
            throw new IllegalArgumentException(fieldName + " phải lớn hơn 0.");
        }
    }

    // Ghi lại giao dịch
    private void logTransaction(String message) {
        transactions.add(message);
    }
}
