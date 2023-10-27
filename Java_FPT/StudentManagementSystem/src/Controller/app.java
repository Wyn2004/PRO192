package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class app {
	public static void main(String[] args) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String str = "39/2/2020";
		
		Date date = formatter.parse(str);
		System.out.println(formatter.format(date));
//		System.out.println(date.equals(LocalDate.parse(str,formatter)));
	}
}
