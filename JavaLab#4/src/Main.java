public class Main {

    public static void main(String[] args) {

        Wireless wireless=new Wireless();

        Student student1 = new Student();
        student1.setId(1);
        student1.setFirstName("Tayfun");
        student1.setLastName("Yılmaz");
        student1.setStudentNumber("190706010");
        student1.setLaptop();
        student1.getLaptop().setLaptopModel("Monster Tulpar v19.2");
        student1.getLaptop().setRamCapacity("16 GB");

        Student student2 = new Student();
        student2.setId(2);
        student2.setFirstName("Edvin");
        student2.setLastName("Davulcu");
        student2.setStudentNumber("190706019");
        student2.setLaptop();
        student2.getLaptop().setLaptopModel("Monster Abra v5.2");
        student2.getLaptop().setRamCapacity("8 GB");
        student2.getLaptop().setWireless(wireless);

        Student student3 = new Student();
        student3.setId(3);
        student3.setFirstName("Melih");
        student3.setLastName("Sahtiyan");
        student3.setStudentNumber("190706023");
        student3.setLaptop();
        Laptop laptop3= student3.getLaptop();
        laptop3.setLaptopModel("Monster Abra v5");
        student3.getLaptop().setRamCapacity("32 GB");

        Professor professor = new Professor();
        professor.setId(2);
        professor.setFirstName("Ensar");
        professor.setLastName("Gül");
        professor.setProfessorNumber("123546");
        professor.setLaptop();
        professor.getLaptop().setLaptopModel("Casper Nirvana S500");
        professor.getLaptop().setRamCapacity("16 GB");
        professor.getLaptop().setWireless(wireless);

        System.out.println("-------------------- \uD83D\uDE42 -----------------------");
        professor.getLaptop().connect();
        System.out.println("-------------------- \uD83D\uDE42 -----------------------");
        System.out.println("Student 1 : " + student1.getFirstName() + " " + student1.getLastName() );
        System.out.println("Student 2 : " + student2.getFirstName() + " " + student2.getLastName() );
        System.out.println("Student 3 : " + student3.getFirstName() + " " + student3.getLastName() );
        System.out.println("Professor : " + professor.getFirstName() + " " + professor.getLastName() );
        System.out.println("-------------------- \uD83D\uDE42 -----------------------");
        student1.talks();
        System.out.println("-------------------- \uD83D\uDE42 -----------------------");
        student2.getLaptop().connect();
        System.out.println("-------------------- \uD83D\uDE42 -----------------------");
        student3.diet();
        student3.workingOut();
        student3.drinkingShakes();
        System.out.println("-------------------- \uD83D\uDE42 -----------------------");
        professor.teach();




    }
}
