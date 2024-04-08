public class Animal {
    protected String name;
    protected int limitRun;
    protected int limitSwim;
    private static int count;

    public Animal(String name, int limitRun, int limitSwim) {
        this.name = name;
        this.limitRun = limitRun;
        this.limitSwim = limitSwim;
        count++;
    }

    public void run(int distRun) {
        if ((distRun <= limitRun) && (distRun > 0)) {
            System.out.println(name + " пробежал " + distRun + " м");
        } else {
            System.out.println("Неправильно указана дистанция");
        }
    }

    public void swim(int distSwim) {
        if ((distSwim <= limitSwim) && (distSwim > 0)) {
            System.out.println(name + " проплыл " + distSwim + " м");
        } else {
            System.out.println("Неправильно указана дистанция");
        }
    }

    public static int getCount() {
        return count;
    }
}

class Cat extends Animal {
    private static int count;
    public boolean satiety;
    public int howMuchEat; //сколько ест кот

    public Cat(String name, int howMuchEat) {
        super(name, 200, 0);
        this.howMuchEat = howMuchEat;
        satiety = false;
        count++;
    }

    public void eat() {
        satiety = true;
        System.out.println(name + " сытый");
    }

    public static int getCount() {
        return count;
    }
}

class Dog extends Animal {
    private static int count;

    public Dog(String name) {
        super(name, 500, 10);
        count++;
    }

    public static int getCount() {
        return count;
    }
}

