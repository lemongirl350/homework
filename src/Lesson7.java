public class Lesson7 {
    public static void main(String[] args) {
        Cat catLion = new Cat("Lion", 5);
        Dog dogWolf = new Dog("Wolf");
        Dog dogFriend = new Dog("Friend");
        Bowl bowl = new Bowl(30);

        Cat[] catArray = new Cat[5];
        catArray[0] = new Cat ("Bowie", 2);
        catArray[1] = new Cat ("Dio", 17);
        catArray[2] = new Cat ("Tyler", 14);
        catArray[3] = new Cat ("Bonjovi", 5);
        catArray[4] = new Cat ("Halford", 11);

        dogWolf.run(300);
        dogWolf.swim(5);

        dogFriend.run(500);
        dogFriend.swim(15);

        catLion.run(150);
        catLion.swim(10);

        System.out.println("Создано собак: " + Dog.getCount());
        System.out.println("Создано котов: " + Cat.getCount());
        System.out.println("Создано животных: " + Animal.getCount());

        for (int i = 0; i < catArray.length; i++) {
            if (catArray[i].howMuchEat <= bowl.foodAmount) {
                catArray[i].eat();
                bowl.foodAmount -= catArray[i].howMuchEat;
            } else {
                System.out.println(catArray[i].name + " голодный");
            }
        }
        bowl.addFood(15);
        System.out.println();

        Circle circle = new Circle(5, "Red", "Black");
        Rectangle rectangle = new Rectangle(4, 6, "Green", "Blue");
        Triangle triangle = new Triangle(3, 4, 5, "Yellow", "Purple");

        printShapeInfo(circle);
        printShapeInfo(rectangle);
        printShapeInfo(triangle);
    }

    private static void printShapeInfo(Shape shape) {
        System.out.println("Shape: " + shape.getClass().getSimpleName());
        System.out.println("Perimeter: " + shape.calculatePerimeter());
        System.out.println("Area: " + shape.calculateArea());
        System.out.println("Fill Color: " + shape.getFillColor());
        System.out.println("Border Color: " + shape.getBorderColor());
        System.out.println();
    }
}
