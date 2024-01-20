import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Management {
    public static void addStudent(ArrayList<Student> listStudent) {
        String MSSV = getLine("Enter Student MSSV: ");
        String fullName = getLine("Enter full name: ");
        LocalDate dateOfBirth = getDate("Enter date of birth: ");
        String address = getLine("Enter address: ");
        float mathScore = getFloat("Enter math socre: ");
        float itScore = getFloat("Enter IT score: ");
        float englishScore = getFloat("Enter english score: ");
        float GPA = calculateGPA(mathScore, itScore, englishScore);
        listStudent.add(new Student(MSSV, fullName, dateOfBirth, address, mathScore, itScore, englishScore, GPA));
    }

    public Student findStudent(String MSSV, ArrayList<Student> listStudent) {
        Iterator<Student> iStudentList = listStudent.iterator();
        while (iStudentList.hasNext()) {
            Student objectStudent = iStudentList.next();
            if (objectStudent.getMSSV().equals(MSSV)) {
                return objectStudent;
            }
        }
        return null;
    }

    public void editStudent(String MSSV, ArrayList<Student> listStudent) {
        Student student = findStudent(MSSV, listStudent);
        if (student != null) {
            String fullName = getLine("Enter full name: ");
            LocalDate dateOfBirth = getDate("Enter date of birth: ");
            String address = getLine("Enter address: ");
            float mathScore = getFloat("Enter math socre: ");
            float itScore = getFloat("Enter IT score: ");
            float englishScore = getFloat("Enter english score: ");
            float GPA = calculateGPA(mathScore, itScore, englishScore);

            student.setFullName(fullName);
            student.setDateOfBirth(dateOfBirth);
            student.setAddress(address);
            student.setMathScore(mathScore);
            student.setItScore(itScore);
            student.setEnglishScore(englishScore);
            student.setGPA(GPA);
        }
    }

    public static void displayStudent(ArrayList<Student> listStudent) {
        for (Student s : listStudent) {
            System.out.println("MSSV: " + s.getMSSV() + " - Full Name: "
                    + s.getFullName() + " - Date Of Birth: " + s.getDateOfBirth() + " - Address: "
                    + s.getAddress() + " - Math Score: " + s.getMathScore() + " - IT Score: "
                    + s.getItScore() + "English Score: " + s.getEnglishScore() + " - GPA: " + s.getGPA());
        }
    }

    public static String getLine(String mess) {
        System.out.println(mess);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().trim();
    }

    public static float getFloat(String mess) {
        System.out.println(mess);
        Scanner sc = new Scanner(System.in);
        return sc.nextFloat();
    }

    public static LocalDate getDate(String mess) {
        System.out.println(mess);
        Scanner sc = new Scanner(System.in);
        String dateOfBirth = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birth = LocalDate.parse(dateOfBirth, formatter);
        return birth;
    }

    public static float calculateGPA(float math, float it, float english) {
        float GPA = 0;
        GPA = (math + it + english * 2) / 4;
        return GPA;
    }
}
