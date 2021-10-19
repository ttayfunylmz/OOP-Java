public class Student {

    private int studentId;
    private String studentName;
    private String studentSurname;
    private int studentNumber;

    public Student() {

    }

    public Student(int studentId, String studentName, String studentSurname, int studentNumber) {
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.studentNumber = studentNumber;
        this.studentId = studentId;
    }


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }


    public void learn(){
        System.out.println("The lesson has been learned from a student.");
    }

    public void giveBreak(){
        System.out.println("A student took a short break.");
    }
}
