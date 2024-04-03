import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Задача 1:");
        printThreeWords();
        System.out.println("Задача 2:");
        checkSumSign();
        System.out.println("Задача 3:");
        printColor();
        System.out.println("Задача 4:");
        compareNumbers();
        System.out.println("Задача 5:");
        System.out.println(taskFive(1, 5));
        System.out.println("Задача 6:");
        taskSix(-1);
        System.out.println("Задача 7:");
        System.out.println(taskSeven(-17));
        System.out.println("Задача 8:");
        taskEight("The text for testing", 2);
        System.out.println("Задача 9:");
        System.out.println(taskNine(1200));
        System.out.println("Задача 10:");
        taskTen();
        System.out.println("Задача 11:");
        taskEleven();
        System.out.println("Задача 12:");
        taskTwelve();
        System.out.println("Задача 13:");
        taskThirteen();
        System.out.println("Задача 14:");
        taskFourteen(6, -52);
    }
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    public static void checkSumSign() {
        int a = 0, b = -10;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
    public static void printColor() {
        int value = -140;
        if (value <= 0) {
            System.out.println("Красный");
        } else if ((value > 0) && (value <= 100)) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }
    public static void compareNumbers() {
        int a = -17, b = -10;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
    public static boolean taskFive(int a, int b) {
        return  ((a + b >= 10) && (a + b <= 20));
    }
    public static void taskSix(int a) {
        if (a >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }
    public static boolean taskSeven(int a) {
        return  (a < 0);
    }
    public static void taskEight(String txt, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(txt);
        }
    }
    public static boolean taskNine(int year) {
        return  ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
    }
    public static void taskTen() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
            }
        System.out.println(Arrays.toString(arr));
        }
    public static void taskEleven() {
        int[] arr = new int[100];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void taskTwelve() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void taskThirteen() {
        int[][] table = new int[5][5];
        int counter = 4;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j) {
                    table[i][j] = 1;
                } else if (i + j == 4) {
                    table[i][j] = 1;
                } else {
                    table[i][j] = counter;
                }
                System.out.print(table[i][j] + " ");
                counter++;
            }
            System.out.println();
        }
    }
    public static void taskFourteen(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr));
    }
}
