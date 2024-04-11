public class Lesson8 {

    public static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    public static class MyArrayDataException extends Exception {
        public MyArrayDataException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {

        String[][] arrayRight = {
                {"323", "454", "3453", "6775"},
                {"43", "454", "65", "78"},
                {"34", "454", "4556-", "5664"},
                {"567", "34", "67", "2321"}
        };

        String[][] arrayWrong = {
                {"323", "454", "3453", "!6775"},
                {"43", "454", "65", "78"},
                {"34", "454", "4556", "5664"},
        };

        try {
            arraySize(arrayWrong);
        } catch (MyArraySizeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            arraySumm(arrayWrong);
        } catch (MyArrayDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void arraySize(String[][] array) throws MyArraySizeException {
        if ((array.length != 4) || (array[0].length != 4))  {
            throw new MyArraySizeException("Wrong array size");
        }
    }

    public static void arraySumm(String[][] array) throws MyArrayDataException {
        int[][] arrayInt = new int[array.length][array[0].length];
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    arrayInt[i][j] = Integer.parseInt(array[i][j]);
                    total += arrayInt[i][j];
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Wrong array symbol in element " + i + j);
                }

            }
        }
        System.out.println("Sum of array elements: " + total);
    }
}