package control;

import java.io.IOException;

import module.Login;
import view.Menu;

public class app {
	public static void main(String[] args) throws IOException {
		
		Login login= new Login();
		login.inputInfo();
		Menu menu = new Menu();
		menu.execute();
	}
}
