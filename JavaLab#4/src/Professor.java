public class Professor extends Person {

    private String professorNumber;
    private Laptop laptop;

    public Professor() {

    }

    public String getProfessorNumber() {
        return professorNumber;
    }

    public void setProfessorNumber(String professorNumber) {
        this.laptop = new Laptop();
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop() {
        this.laptop = new Laptop();
    }

    public void teach() {
        if(laptop != null)
            System.out.println("Class will be on.");
        else
            System.out.println("Teacher forgot to bring his laptop. Class is dismissed.");

    }
}
