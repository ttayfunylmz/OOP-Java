public class Student extends Person implements Sportmen{

    private String studentNumber;
    private Laptop laptop;

    public Student() {

    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop() {
        this.laptop = new Laptop();
    }

    @Override
    public void drinkingShakes() {
        System.out.println(getFirstName() + " " + getLastName() + " drinks shakes.");
    }

    @Override
    public void diet() {
        System.out.println(getFirstName() + " " + getLastName() + " diets.");
    }

    @Override
    public void workingOut() {
        System.out.println(getFirstName() + " " + getLastName() + " works out.");
    }

}
