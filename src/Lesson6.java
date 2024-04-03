public class Lesson6 {
    public static void main(String[] args) {
        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("Ivanov Ivan", "Engineer",
                "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Employee("Petrov Michail", "Programmer",
                "fgfh@mailbox.com", "+78945628945", 50000, 36);
        persArray[2] = new Employee("Kirilova Marina", "CEO",
                "dfkmvj@mailbox.com", "+78945628945", 150000, 37);
        persArray[3] = new Employee("Valova Diana", "Accountant",
                "fimsw@mailbox.com", "+76745673028", 60000, 32);
        persArray[4] = new Employee("Karimov Denis", "Driver",
                "fithyrit@mailbox.com", "+76743920712", 40000, 45);
        for (int i = 0; i < persArray.length; i++) {
            persArray[i].info();
        }

        // Создаем объект внешнего класса
        Park gorky = new Park(132, 100.5, "Парк Горького");

        // Создаем объект внутреннего класса
        Park.Attraction attraction1 = gorky.new Attraction("Качели", "10.00 - 19.00", 350);
        Park.Attraction attraction2 = gorky.new Attraction("Колесо обозрения", "11.00 - 18.00", 550);
        Park.Attraction attraction3 = gorky.new Attraction("Машинки", "12.30 - 17.30", 720);
        // Вызываем методы внешнего и внутреннего классов
        System.out.println("Общие сведения о парке:");
        gorky.aboutPark();
        System.out.println("Данные об аттракционах:");
        attraction1.aboutAttraction();
        attraction2.aboutAttraction();
        attraction3.aboutAttraction();
    }
}