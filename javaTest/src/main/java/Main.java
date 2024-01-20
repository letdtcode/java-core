public class Main {

    public static void main(String[] args) {
        Student[] students = new Student[2017];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student("Student" + i);
        }

        int index = 0;
        while (true) {
            index = (int) (Math.random() * 2016);
            students[index].signIn();
        }
    }
}
