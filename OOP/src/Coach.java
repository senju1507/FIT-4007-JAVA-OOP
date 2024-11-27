public class Coach {
    private String name;
    private int experience;

    // Constructor: Dùng để khởi tạo đối tượng Coach
    public Coach(String name, int experience) {
        setName(name); // Sử dụng setter để kiểm tra dữ liệu
        setExperience(experience);
    }

    // Getter: Lấy tên huấn luyện viên
    public String getName() {
        return name;
    }

    // Setter: Đặt tên huấn luyện viên (có kiểm tra hợp lệ)
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên không được để trống.");
        }
        this.name = name.trim();
    }

    // Getter: Lấy số năm kinh nghiệm
    public int getExperience() {
        return experience;
    }

    // Setter: Đặt số năm kinh nghiệm (có kiểm tra hợp lệ)
    public void setExperience(int experience) {
        if (experience < 0) {
            throw new IllegalArgumentException("Kinh nghiệm phải là số không âm.");
        }
        this.experience = experience;
    }

    // Override toString: Hiển thị thông tin huấn luyện viên
    @Override
    public String toString() {
        return "Huấn luyện viên: " + name + ", Kinh nghiệm: " + experience + " năm";
    }

    // Phương thức so sánh kinh nghiệm với một huấn luyện viên khác
    public boolean hasMoreExperienceThan(Coach other) {
        return this.experience > other.experience;
    }
}
