package com.exercise.testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.ensureCapacity(n);
        for (int i = 1; i <= n; i++) {
            numbers.add(scanner.nextInt());
        }

        int count = 0;
        int maxNumber = maxNumberSearch(numbers);
        ArrayList<Integer> list = new ArrayList<>(numbers);
        Collections.sort(list);
        if (!numbers.equals(list)) {
            System.out.println("-1");
        } else {
            int border = borderSearch(numbers, maxNumber);
            if ((maxNumber - numbers.get(0)) % 2 == 0) {
                while (numbers.get(border) != maxNumber) {
                    for (int i = 0; i <= border; i++) {
                        numbers.set(i, numbers.get(i) + (maxNumber / 2));
                        count++;
                    }
                }
            } else {
                while (numbers.get(border) != maxNumber) {
                    for (int i = 0; i <= border; i++) {
                        numbers.set(i, numbers.get(i) + 1);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static int maxNumberSearch(ArrayList<Integer> list) {
        int max = list.get(0);
        for (Integer integer : list) {
            if (integer > max) {
                max = integer;
            }
        }
        return max;
    }

    public static int borderSearch(ArrayList<Integer> list, int max) {
        int border = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == max) {
                border = i - 1;
                break;
            }
        }
        return border;
    }

}
