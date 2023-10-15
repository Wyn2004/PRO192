package view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import module.ClassRoom;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class app {

	public static void main(String[] args) {
		FileReader reader = null;
		ClassRoom classssRoom = new ClassRoom();


		try {
			// gson java example => vi du trong tung truong hop 1
			reader = new FileReader("student.txt");

			Type classOfT = new TypeToken<ArrayList<ClassRoom>>() {
			}.getType();

//			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
			Gson gson = new Gson();
			ArrayList<ClassRoom> list = gson.fromJson(reader, classOfT);

			for (ClassRoom classRoom : list) {
				classRoom.display();
				classssRoom = classRoom;
			}
			String data = gson.toJson(classssRoom.getStudentList());
			System.out.println(data);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(app.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ex) {
					Logger.getLogger(app.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}
}
