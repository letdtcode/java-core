import java.time.LocalDate;

public class Student {
    private String MSSV;
    private String fullName;
    private LocalDate dateOfBirth;
    private String address;
    private float mathScore;
    private float itScore;
    private float englishScore;
    private float GPA;

    public Student(String MSSV, String fullName, LocalDate dateOfBirth, String address, float mathScore, float itScore, float englishScore, float GPA) {
        this.MSSV = MSSV;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.mathScore = mathScore;
        this.itScore = itScore;
        this.englishScore = englishScore;
        this.GPA = GPA;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getMathScore() {
        return mathScore;
    }

    public void setMathScore(float mathScore) {
        this.mathScore = mathScore;
    }

    public float getItScore() {
        return itScore;
    }

    public void setItScore(float itScore) {
        this.itScore = itScore;
    }

    public float getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(float englishScore) {
        this.englishScore = englishScore;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }
}
