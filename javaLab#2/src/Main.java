public class Main {

    public static void main(String[] args) {
        Professor professor = new Professor();
        professor.setProfessorId(1);
        professor.setProfessorName("Ensar");
        professor.setProfessorSurname("Gül");

        Student student1 = new Student();
        student1.setStudentId(1);
        student1.setStudentName("Tayfun");
        student1.setStudentSurname("Yılmaz");
        student1.setStudentNumber(190706010);

        Student student2 = new Student();
        student2.setStudentId(2);
        student2.setStudentName("Edvin");
        student2.setStudentSurname("Davulcu");
        student2.setStudentNumber(190706017);

        Student student3 = new Student();
        student3.setStudentId(3);
        student3.setStudentName("Melih");
        student3.setStudentSurname("Sahtiyan");
        student3.setStudentNumber(190706023);

        Student student4 = new Student();
        student4.setStudentId(4);
        student4.setStudentName("İrem");
        student4.setStudentSurname("Batak");
        student4.setStudentNumber(190706009);

        Student student5 = new Student();
        student5.setStudentId(5);
        student5.setStudentName("Ebru");
        student5.setStudentSurname("Sayil");
        student5.setStudentNumber(190706033);

        System.out.println("Professor : " + professor.getProfessorName() + " " + professor.getProfessorSurname());
        System.out.println("-------------------- \uD83D\uDE42 -----------------------");
        System.out.println("Student1 : " + student1.getStudentName() + " " + student1.getStudentSurname());
        System.out.println("Student2 : " + student2.getStudentName() + " " + student2.getStudentSurname());
        System.out.println("Student3 : " + student3.getStudentName() + " " + student3.getStudentSurname());
        System.out.println("Student4 : " + student4.getStudentName() + " " + student4.getStudentSurname());
        System.out.println("Student5 : " + student5.getStudentName() + " " + student5.getStudentSurname());
        System.out.println("-------------------- \uD83D\uDE42 -----------------------");
        
        student1.learn();
        professor.answer();
        student2.giveBreak();
        professor.teach();
    }
}
