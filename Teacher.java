public class Teacher {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private String subject;
    private String address; // Adding address as a member variable

    // Constructor
    public Teacher(String name, int age, String subject, String address) {
        this.name = name;
        this.age = age;
        this.subject = subject;
        this.address = address; // Assigning address parameter to the member variable
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // toString method
    @Override
    public String toString() {
        return "Teacher{" + "name='" + name + '\'' + ", age=" + age + ", subject='" + subject + '\'' + ", address='" + address + '\'' + '}';
    }
}
