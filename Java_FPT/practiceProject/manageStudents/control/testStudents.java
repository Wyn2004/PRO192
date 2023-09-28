package control;

import java.util.Scanner;

import module.Person;
import module.Student;

public class testStudents {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Person p = new Person();
		Student s = new Student();
//		p.inputInfo();
//		p.showInfo();
		s.inputInfo();
		s.showInfo();
//		int a, b, c;
//		System.out.print("Enter:");
//		a = scanner.nextInt();
//		b = scanner.nextInt();
//		c = scanner.nextInt();
//		System.out.println(a + "/" + b + "/" + c);
	}
}
