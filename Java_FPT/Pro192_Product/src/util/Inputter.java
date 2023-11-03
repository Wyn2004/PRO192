package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Inputter {

    public static Scanner sc = new Scanner(System.in);
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    //inputDouble>0
    public static double inputDouble(String name) {
        double x;
        while (true) {
            System.out.println("Enter " + name + ":");
            try {
                x = sc.nextDouble();
                if (x > 0) {
                    return x;
                } else {
                    System.err.println("Please enter the double number > 0");
                }
            } catch (InputMismatchException e) {
                System.err.println("Only enter the double number > 0");
                sc.next();
            }
        }
    }

    //inputInt>0
    public static int inputInt(String name) {
        int x;
        while (true) {
            System.out.println("Enter " + name + ":");
            try {
                x = sc.nextInt();
                if (x > 0) {
                    return x;
                } else {
                    System.err.println("Please enter the integer number > 0");
                }
            } catch (InputMismatchException e) {
                System.err.println("Only enter the integer number > 0");
                sc.next();
            }
        }
    }

    //inputNonBlankStr
    public static String inputNonBlankStr(String msg) {
        String x;
        while (true) {
            System.out.println("Enter " + msg + ":");
            x = sc.nextLine().trim();
            if (x.isEmpty() == false) {
                return x;
            } else {
                System.err.println("Please enter a non-empty string");
            }
        }
    }

    //inputDate
    public static Date inputDate(String msg) {
        String dateString;
        dateFormat.setLenient(false);//tat che do linh hoat cho viec chuyen doi ngay
        System.out.println("Enter " + msg + ":");
        while (true) {
            dateString = sc.nextLine();
            if (!dateString.isEmpty()) {
                try {
                    Date date = dateFormat.parse(dateString);
                    return date;
                } catch (ParseException e) {
                    System.err.println("Invalid date format. Please enter again (dd/mm/yyyy)");
                }
            }
        }
    }

    //inputPattern
    public static String inputPattern(String msg, String pattern) {
        String x;
        while (true) {
            System.out.println("Enter " + msg + ":");
            x = sc.nextLine().trim().toUpperCase();
            if (x.matches(pattern)) {
                return x;
            } else {
                System.err.println("Please enter a string follow pattern");
            }
        }
    }

    //inputIntHasMinMax
    public static int inputIntMinMax(String msg, int min, int max) {
        int x;
        while (true) {
            System.out.println("Enter " + msg + ":");
            try {
                x = sc.nextInt();
                if (x >= min && x <= max) {
                    return x;
                } else {
                    System.err.println("Please enter the integer number in the range");
                }
            } catch (InputMismatchException e) {
                System.err.println("Only enter the integer number in the range");
                sc.next();
            }
        }
    }

    //inputIntHasMinMax
    public static double inputDoubleMinMax(String msg, int min, int max) {
        double x;
        while (true) {
            System.out.println("Enter " + msg + ":");
            try {
                x = sc.nextDouble();
                if (x >= min && x <= max) {
                    return x;
                } else {
                    System.err.println("Please enter the double number in the range");
                }
            } catch (InputMismatchException e) {
                System.err.println("Only enter the double number in the range");
                sc.next();
            }
        }
    }

}
