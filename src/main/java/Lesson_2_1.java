public class Lesson_2_1 {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(summa());
        printNumber();
        System.out.println(numb());
        printString();
        System.out.println(leapYear(2025));
        flipArray();
        fillArray();
        multiplyIfLessThan6();
        fillDiagonal();

        int[] resultArray = createArray(5, 7); // массив из 5 элементов, все 7
        for (int i : resultArray) {
            System.out.print(i + " ");
        }
    }

    public static void printThreeWords() {
        System.out.println("1.");
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 20;
        int b = 30;
        int c = (a + b);
        System.out.println("2.");
        if (c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 78;
        System.out.println("3.");
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 4;
        int b = 3;
        System.out.println("4.");
        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
    }

    public static boolean summa() {
        System.out.println("5.");
        int a = 4;
        int b = 10;
        int c = (a + b);
        return c >= 10 && c <= 20;
    }

    public static void printNumber() {
        int a = -5;
        System.out.println("6.");
        if (a >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }

    public static boolean numb() {
        System.out.println("7.");
        int a = -5;
        return a < 0;
    }

    public static void printString() {
        System.out.println("8.");
        String str = "Hi";
        int times = 3;
        for (int i = 0; i < times; i++)
            System.out.println(str);
    }

    public static boolean leapYear(int year) {
        System.out.println("9.");
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void flipArray() {
        System.out.println("10.");
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 0 ? 1 : 0;
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void fillArray() {
        System.out.println("11.");
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void multiplyIfLessThan6() {
        System.out.println("12.");
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void fillDiagonal() {
        System.out.println("13.");
        int size = 5;
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            arr[i][i] = 1;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] createArray(int len, int initialValue) {
        System.out.println("14.");
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
}
