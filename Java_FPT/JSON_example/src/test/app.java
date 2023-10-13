package test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class app {

	public static void main(String[] args) {

		myStudent std1 = new myStudent("Thang", 19, "FPTU");
		myStudent std2 = new myStudent("Luc", 19, "FPTU");
		myStudent std3 = new myStudent("Phuc", 18, "FPTU");
		myStudent std4 = new myStudent();

		Gson gson = new Gson();
		
		// Change object to JSON text
		String json1 = gson.toJson(std1);
		System.out.println(json1);
		
		// Change JSON text to object
		Type objType = new TypeToken<myStudent>(){}.getType();
		std4 = gson.fromJson(json1, objType);
		System.out.println(std4.toString());
		
		// Change collection to JSON text
		List<myStudent> list = new ArrayList<>();
		list.add(std1);
		list.add(std2);
		list.add(std3);
		String jsonList =  gson.toJson(list);
		System.out.println(jsonList);
		
		// Change JSON text to collection
		Type listtyType = new TypeToken<List<myStudent>>(){}.getType();
		List<myStudent> list2 = gson.fromJson(jsonList, listtyType);
		System.out.println(list2.toString());
		

	}
}
