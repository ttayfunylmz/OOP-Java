public class Student extends Person{
    private int studentNumber;

    public Student(){

    }
    public Student(int studentNumber) {
        this.setStudentNumber(studentNumber);
    }


    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void learn(){
        System.out.println(getName() + " " + getSurname() + " has learned the lesson");
    }

}
