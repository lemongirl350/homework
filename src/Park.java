public class Park {
    private int amountOfWorkers;
    private double area;
    private String nameOfPark;
    public Park (int amountOfWorkers, double area, String nameOfPark) {
        this.amountOfWorkers = amountOfWorkers;
        this.area = area;
        this.nameOfPark = nameOfPark;
    }
    public void aboutPark () {
        System.out.println("название: " + nameOfPark + "; площадь: " + area + "; количество сотрудников: " + amountOfWorkers);
    }
    public class Attraction {
        private String nameOfAttraction;
        private String schedule;
        private double cost;
        public Attraction (String nameOfAttraction, String schedule, double cost) {
            this.nameOfAttraction = nameOfAttraction;
            this.schedule = schedule;
            this.cost = cost;
        }
        public void aboutAttraction () {
            System.out.println("Название: " + nameOfAttraction + "; график работы: " + schedule + "; стоимость: " + cost);
        }
    }
}
