public class Professor {
    private String professorName;
    private String professorSurname;
    private int professorId;

    public Professor(){

    }

    public Professor(String professorName, String professorSurname, int professorId) {
        this.professorName = professorName;
        this.professorSurname = professorSurname;
        this.professorId = professorId;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public String getProfessorSurname() {
        return professorSurname;
    }

    public void setProfessorSurname(String professorSurname) {
        this.professorSurname = professorSurname;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }


    public void teach(){
        System.out.println("The lesson has been teached by the professor.");
    }

    public void answer(){
        System.out.println("Professor has answered the questions.");
    }
}
