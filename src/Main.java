public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(checkSumInRange(1, 5));
        checkSign(100);
        System.out.println(checkSignReverse(-10));
        printStringNTimes("Котик", 10);
        System.out.println();
        System.out.println(checkIsLeapYear(1900));
        arrayReverse();
        fillArray();
        calculateArray();
        fillTwoDimensionalArray();
        fillArrayByArgs(10,100);
    }


    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 10;
        int b = -20;
        int summ = a + b;

        if (summ >= 0) {
            System.out.println("Сумма положительная");
        } else  System.out.println("Сумма отрицательная");

    }

    public static void printColor() {
        int value = 101;

        if (value <= 0) System.out.println("Красный");
        else if (0 < value && value <= 100) System.out.println("Желтый");
        else System.out.println("Зеленый");
    }

    public static void compareNumbers() {
        int a = 10;
        int b = 100;

        if(a >= b) System.out.println("a >= b");
        else System.out.println("a < b");
    }

    public static boolean checkSumInRange(int a, int b) {
        int summ = a + b;
        if (10 <= summ && summ <=20) return true;
        else return false;
    }

    public static void checkSign(int a) {
        if (a >= 0) System.out.print("Положительное");
        else System.out.println("Отрицательное");
    }

    public static boolean checkSignReverse(int a) {
        return a < 0;
    }

    public static void printStringNTimes(String str, int time) {
        for (int i = 0; i < time; i++) {
            System.out.print(str);
        }
    }

    //Считаем от AD
    public static boolean checkIsLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

    public static void arrayReverse() {
        int[] arr = {1,0,1,0,0,0,1,1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) arr[i] = 0;
            else arr[i] = 1;
        }

        /*for (int j : arr) {
            System.out.print(j + ";");
        }*/
    }

    public static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        /*for (int j : arr) {
            System.out.print(j + ";");
        }*/
    }

    public static void calculateArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] = arr[i] * 2;
        }

        /*for (int j : arr) {
            System.out.print(j + ";");
        }*/
    }

    public static void fillTwoDimensionalArray() {
        int size = 100;
        int[][] arr = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j< size; j++) {
                if(i == j) arr[i][j] = 1;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j< size; j++) {
                if(i + j == size - 1) arr[i][j] = 1;
            }
        }

        /*for (int i = 0; i < size; i++) {
            for (int j = 0; j< size; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }*/
    }

    public static void fillArrayByArgs(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }

        /*for (int j : arr) {
            System.out.print(j + ";");
        }*/
    }
}