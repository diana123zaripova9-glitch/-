import java.util.Arrays;
import java.util.Scanner;

/**
 * Практическая работа №1.
 * Все задания собраны в одном файле, без дополнительных папок.
 */
public class Main {
    public static void main(String[] args) {
        // Задание 1: массив, созданный инициализацией; сумма и среднее через for.
        int[] initialized = {4, 7, 2, 9, 3};
        int sum = 0;
        for (int value : initialized) sum += value;
        System.out.println("Задание 1");
        System.out.println("Массив: " + Arrays.toString(initialized));
        System.out.println("Сумма: " + sum);
        System.out.printf("Среднее арифметическое: %.2f%n", (double) sum / initialized.length);

        // Задание 2: ввод массива; сумма с while и do-while, минимум и максимум.
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\nЗадание 2");
            System.out.print("Введите количество элементов массива: ");
            int n = readPositiveInt(scanner);
            int[] values = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Элемент [" + i + "]: ");
                values[i] = scanner.nextInt();
            }
            int whileSum = 0, i = 0;
            int min = values[0], max = values[0];
            while (i < values.length) {
                whileSum += values[i];
                if (values[i] < min) min = values[i];
                if (values[i] > max) max = values[i];
                i++;
            }
            int doWhileSum = 0, j = 0;
            do {
                doWhileSum += values[j++];
            } while (j < values.length);
            System.out.println("Массив: " + Arrays.toString(values));
            System.out.println("Сумма (while): " + whileSum);
            System.out.println("Сумма (do-while): " + doWhileSum);
            System.out.println("Минимум: " + min);
            System.out.println("Максимум: " + max);
        }

        // Задание 3: аргументы командной строки с помощью for.
        System.out.println("\nЗадание 3 — аргументы командной строки");
        for (int k = 0; k < args.length; k++) {
            System.out.println("args[" + k + "] = " + args[k]);
        }
        if (args.length == 0) System.out.println("Аргументы не переданы.");

        // Задание 4: первые десять чисел гармонического ряда.
        System.out.println("\nЗадание 4 — гармонический ряд");
        for (int k = 1; k <= 10; k++) {
            System.out.printf("H%d = %.6f%n", k, harmonic(k));
        }

        // Задание 5: факториал, вычисляемый методом класса с циклом.
        System.out.println("\nЗадание 5 — факториал");
        for (int k = 0; k <= 10; k++) {
            System.out.println(k + "! = " + factorial(k));
        }
    }

    private static int readPositiveInt(Scanner scanner) {
        int n = scanner.nextInt();
        while (n <= 0) {
            System.out.print("Количество должно быть положительным. Повторите ввод: ");
            n = scanner.nextInt();
        }
        return n;
    }

    private static double harmonic(int n) {
        double result = 0.0;
        for (int i = 1; i <= n; i++) result += 1.0 / i;
        return result;
    }

    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Факториал определён для n >= 0");
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }
}