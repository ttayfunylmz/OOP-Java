public class Professor extends Person{
    private int professorNumber;

    public Professor(){

    }

    public Professor(int professorNumber) {
        this.setProfessorNumber(professorNumber);
    }


    public int getProfessorNumber() {
        return professorNumber;
    }

    public void setProfessorNumber(int professorNumber) {
        this.professorNumber = professorNumber;
    }

    public void teach(){
        System.out.println(getName() + " " + getSurname() + " has teached the lesson.");
    }

}
