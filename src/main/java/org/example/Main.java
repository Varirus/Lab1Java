package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seed = 0;
        int n = 0;
        int capacity = 0;

        try {
            System.out.println("Enter seed:");
            String line = scanner.nextLine();
            seed = Integer.parseInt(line);

            System.out.println("Enter number of items:");
            line = scanner.nextLine();
            n = Integer.parseInt(line);
            if (n < 0) {
                System.out.println("Invalid number of items");
                return;
            }

            System.out.println("Enter capacity:");
            line = scanner.nextLine();
            capacity = Integer.parseInt(line);
            if (capacity < 0) {
                System.out.println("Invalid capacity");
                return;
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
            return;
        }

        Problem problem = new Problem(n, seed);

        System.out.println("Our items and their parameters: ");
        System.out.println(problem);

        System.out.println("Solution for capacity " + capacity);
        System.out.println(problem.solve(capacity));
    }
}
