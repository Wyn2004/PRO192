package util;

import java.util.Comparator;

public class MyArrays {

    //
    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    //gia lap kieu int, cac kieu byte, short, long, double, float lam tuong tu (method overloading)
    public static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                }
            }
        }
    }
    
    //gia lap kieu double
    private static void swap(double[] a, int i, int j) {
        double tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void sort(double[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                }
            }
        }
    }

    //toString
    public static String toString(int[] a) {
        String s = "";
        for (int i = 0; i < a.length; i++) {
            s += a[i] + " ";
        }
        return s;
    }

    public static String toString(double[] a) {
        String s = "";
        for (int i = 0; i < a.length; i++) {
            s += a[i] + " ";
        }
        return s;
    }

    public static <T> String toString(T[] a) {
        String s = "";
        for (int i = 0; i < a.length; i++) {
            s += a[i].toString() + " ";
        }
        return s;
    }

    //
    public static <T> void swap(T[] a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    //gia lap kieu T - Comparable
    public static <T> void sort(T[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (((Comparable) a[i]).compareTo(a[j]) > 0) {
                    swap(a, i, j);
                }
            }
        }
    }

    //gia lap kieu T - Comparator
    public static <T> void sort(T[] a, Comparator<T> c) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (c.compare(a[i], a[j]) > 0) {
                    swap(a, i, j);
                }
            }
        }
    }
    
    
}
