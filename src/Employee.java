public class Employee {
    private String name;
    private String jobTitle;
    private String email;
    private String phone;
    private double salary;
    private int age;
    public Employee (String name, String jobTitle, String email, String phone, double salary, int age) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void info () {
        System.out.println("ФИО сотрудника: " + this.name + "; должность: " + this.jobTitle + "; email: " + this.email + "; телефон: " + this.phone + "; зарплата: " + this.salary + "; возраст: " + this.age);
    }

}