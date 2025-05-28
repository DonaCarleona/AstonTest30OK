public class MathLibrary {

    public static int getFactorial(int a) {
        int res = 1;
        if (a > 0 && a < 12) {
            while (a > 0) {
                res = res * a;
                a = a - 1;
            }
        } else throw new RuntimeException("Значение больше 12 и меньше 1 выхрдят за диапазон допустимых значений");
        return res;
    }

    public static double getTriangle(int a, int b, int c) {
        if ((a + b > c) && (a + c > b) && (b + c > a)) {
            double p = (double) (a + b + c) / 2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        } else throw new RuntimeException("Не треугольник");

    }

    public static int addition(int a, int b) {
        return a + b;
    }

    public static int subtraction(int a, int b) {
        return a - b;
    }

    public static int multiplication(int a, int b) {
        return a * b;
    }

    public static double delete(int a, int b) {
        if (b==0) throw new RuntimeException("На ноль делить нельзя");
        return (double) a / b;
    }

    public static String comparison(int a, int b) {
        if(a > b) return "a больше b";
        if(b > a) return "b больше a";
        return "числа равны";
    }
}