package com.exercise.testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> alist = new ArrayList<>();

        alist.ensureCapacity(n);
        for (int i = 1; i <= n; i++) {
            alist.add(scanner.nextInt());
        }

        int count = 0;
        int amax = aMaxSearch(alist);
        ArrayList<Integer> list = new ArrayList<>(alist);
        Collections.sort(list);
        if (!alist.equals(list)) {
            System.out.println("-1");
        } else {
            int border = borderSearch(alist, amax);
            if ((amax - alist.get(0)) % 2 == 0) {
                while (alist.get(border) != amax) {
                    for (int i = 0; i <= border; i++) {
                        alist.set(i, alist.get(i) + (amax / 2));
                        count++;
                    }
                }
            } else {
                while (alist.get(border) != amax) {
                    for (int i = 0; i <= border; i++) {
                        alist.set(i, alist.get(i) + 1);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static int aMaxSearch(ArrayList<Integer> list) {
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
