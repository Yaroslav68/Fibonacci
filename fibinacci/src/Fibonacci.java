import java.math.BigInteger;
import java.util.Scanner;
public class Fibonacci {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Введите число Фибоначчи: ");
        int number = scanner.nextInt();
        if (number < 0) {
            System.out.println("Факториал должен быть положительным числом");
            return;
        }
        System.out.println("Число Фибоначчи, найдено итеративным способом: " + iterative(number));
        System.out.println("Число Фибоначчи, найдено рекурсивным способом: " + recursive(number));
        time();
        System.out.println("Максимальное число по порядковому номеру типа long " + iterativeLong(number));
        System.out.println("Максимальное число по порядковому номеру типа BigInteger " + iterativeBigInteger(number));
    }

    private static int iterative(int number) {
        int F1 = 1;
        int F2 = 1;
        for (int i = 3; i <= number; ++i) {
            int a = F1 + F2;
            F1 = F2;
            F2 = a;
        }
        return F2;
    }

    private static int recursive(int number) {
        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else {
            return recursive(number - 1) + recursive(number - 2);
        }
    }

    private static long iterativeLong(int number) {
        long[] term = new long[number];
        term[0] = 1;
        term[1] = 1;

        for (int i = 2; i < number; i++) {
            term[i] = term[i - 1] + term[i - 2];

        }

        return term[number - 1];
    }

    private static BigInteger iterativeBigInteger(int number) {
        int[] term = new int[number];
        term[0] = 1;
        term[1] = 1;
        for (int i = 2; i < number; i++) {
            term[i] = term[i - 1] + term[i - 2];
        }
        return BigInteger.valueOf(term[number - 1]);
    }

    private static void time() {
        long before = System.currentTimeMillis();
        System.out.println(before + " миллисекунд, требуется итернативному способу");
        long after = System.currentTimeMillis();
        System.out.println(after + " миллисекунд, требуется рекурсивному способу");
        System.out.println(after - before + " миллисекунд (сравнение)");
    }
}