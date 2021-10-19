public class Person {
    private int id;
    private String name;
    private String surname;
    private int age;

    public Person() {

    }

    public Person(int id, String name, String surname, int age) {
        this.setId(id);
        this.setName(name);
        this.setSurname(surname);
        this.setAge(age);
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void talks(){
        System.out.println(getName() + " " + getSurname() + " talks.");
    }

}
