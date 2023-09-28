package view;

import module.ListStudent;


public abstract class Menu {
	
	private String menuName;
	private String[] options;
	private ListStudent students;
	
	public Menu() {
		super();
	}

	public Menu(String menuName, String[] options, ListStudent students) {
		this.menuName = menuName;
		this.options = options;
		this.students = new ListStudent();
//		this.students menuName= students;
	}
	
	public int displayMenu() {
		
		System.out.println(menuName);
		System.out.println("-------------------------");
		for(int i = 0; i<options.length; i++) 
			System.out.println((i+1)+"."+options[i]);
		System.out.println("-------------------------");
		 
	}
	
	
	
}
