import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static String[] options = {"1- Thêm sinh viên ",
            "2- Chỉnh sửa sinh viên",
            "3- Xóa sinh viên",
            "4- Sắp xếp sinh viên theo GPA từ cao đến thấp",
            "5- Sắp xếp sinh viên theo họ tên",
            "6- Tìm kiếm sinh viên",
            "7- Xuất danh sách sinh viên",
            "8- Làm rỗng danh sách sinh viên",
            "9- Kiểm tra danh sách sinh viên",
            "10- Exit",
    };

    public static int Menu(String[] options) {
        Scanner scanner = new Scanner(System.in);
        int optionChoose = 1;
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
        optionChoose = scanner.nextInt();
        return optionChoose;
    }

    public static void main(String[] args) {
        ArrayList<Student> listStudent = new ArrayList<>();
        while (true) {
            int choice = Menu(options);
            try {
                switch (choice) {
                    case 1:
                        Management.addStudent(listStudent);
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        Management.displayStudent(listStudent);
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Please enter an integer value between 1 and " + options.length);
            }
        }
    }
}
