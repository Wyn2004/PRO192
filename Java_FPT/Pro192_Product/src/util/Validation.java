package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validation {

    //kt chuoi ki tu co phai chuoi so thuc ko
    public static boolean isNumericDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //kt chuoi ki tu co phai chuoi so nguyen ko
    public static boolean isNumericInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //kt chuoi ki tu co phai chuoi date theo dinh dang ko
    public static boolean isValidDate(String dateString, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false); //tat che do linh hoat cho viec chuyen doi ngay
        try {
            sdf.parse(dateString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    //chuyen date kieu string thanh date kieu Date
    public static Date parseDate(String dateString, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }
}
