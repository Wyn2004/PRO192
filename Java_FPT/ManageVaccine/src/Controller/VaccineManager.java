package Controller;

import java.io.IOException;

import Module.IFileInfo;
import Module.Vaccine;
import Util.Inputter;
import View.Menu;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VaccineManager implements IFileInfo {

    private List<Vaccine> vaccines = new ArrayList<>();

    public VaccineManager() {
        try {
            readFile();
        } catch (IOException ex) {
            Logger.getLogger(VaccineManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void add() {

        String mess = "Enter code vaccine: ";
        String code;
        while (true) {
            code = Inputter.inputString(mess).toUpperCase();
            if (!searchVaccine(code)) {
                break;
            } else {
                mess = "This code is exist, please enter code again: ";
            }
        }
        String name = Inputter.inputString("Enter name vaccine: ").toUpperCase();
        int quantity = Inputter.inputInt("Enter quantity vaccine: ", 1, Integer.MAX_VALUE);
        Date expirationDate = Inputter.inputDate("Enter expiration date: ");
        double price = Inputter.inputDouble("Enter price vaccine: ", 0, Double.MAX_VALUE);
        Date lastinjectedDate = Inputter.inputDate("Enter last injected date: ");

        Vaccine newVacine = new Vaccine(name, code, quantity, expirationDate, price, lastinjectedDate);
        this.vaccines.add(newVacine);
        System.out.println("Add done!!!");
    }

    public boolean searchVaccine(String ortherCode) {
        if (!vaccines.isEmpty()) {
            for (Vaccine vaccine : vaccines) {
                if (vaccine.getCode().equalsIgnoreCase(ortherCode)) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public void deleteVacine(Predicate<Vaccine> p) {
        if (!vaccines.isEmpty()) {
            int sizeCurrent = vaccines.size();
            for (Vaccine vaccine : vaccines) {
                if (p.test(vaccine)) {
                    vaccines.remove(vaccine);
                }
            }
            if (sizeCurrent == vaccines.size()) {
                System.err.println("Vaccine with code is not exist!!!");
            } else {
                System.out.println("Remove done!!!");
            }
        } else {
            System.err.println("List vaccine is empty!!!");
        }
    }

    public void displayVaccines() {
        if (!vaccines.isEmpty()) {
            System.out.println("List vaccines:");
            System.out.println("---------------------------------------------------------------------------------------");
            for (Vaccine vaccine : vaccines) {
                System.out.println(vaccine.toString());
            }
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("Total " + vaccines.size() + " vaccines");
        } else {
            System.err.println("List vaccine is empty!!!");
        }
    }

    public void sortVaccineByName(Comparator<Vaccine> c) {
        int n = vaccines.size();
        System.out.println("List vaccines was sort by name:");

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (c.compare(vaccines.get(j), vaccines.get(j + 1)) > 0) {
                    Vaccine temp = vaccines.get(j);
                    vaccines.set(j, vaccines.get(j + 1));
                    vaccines.set(j + 1, temp);
                }
            }
        }
        displayVaccines();
    }

    @Override
    public void writeFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("vaccines_output.txt");
        for (Vaccine vaccine : vaccines) {
            fos.write((vaccine.toString() + "\n").getBytes());
        }
        System.out.println("Export data vaccines done!!!");
        fos.close();
    }

    @Override
    public void readFile() throws IOException {
        FileReader fr = new FileReader("vaccines_input.txt");
        try ( BufferedReader reader = new BufferedReader(fr)) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] tokens = line.split("[,=]");
                String code = tokens[1].trim();
                String name = tokens[3].trim();
                int quantity = Integer.parseInt(tokens[5].trim());
                Date expirationDAte = Inputter.parseDate(tokens[7].trim());
                double price = Double.parseDouble(tokens[9].trim());
                Date lastInjectedDate = Inputter.parseDate(tokens[11].trim());

                Vaccine vaccine = new Vaccine(name, code, quantity, expirationDAte, price, lastInjectedDate);
                this.vaccines.add(vaccine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String[] options = {"Display all VAccines From File", "Add a Vaccine", "Delete a Vaccine by code", "Sort Vaccines by Name", "Save to File", "Exit"};
        Menu mainMenu = new Menu("Vaccin Managerment", options) {
            @Override
            public void execute() {
                int choice;
                VaccineManager vaccineManager = new VaccineManager();
                do {
                    choice = displayMenu();
                    System.out.println();
                    switch (choice) {
                        case 1: {
                            vaccineManager.displayVaccines();
                            System.out.println();
                            break;
                        }
                        case 2: {
                            vaccineManager.add();
                            System.out.println();
                            break;

                        }
                        case 3: {
                            String code = Inputter.inputString("Enter code vaccine want delete: ").toUpperCase();
                            vaccineManager.deleteVacine(p -> p.getCode().equalsIgnoreCase(code));
                            System.out.println();
                            break;
                        }
                        case 4: {
                            vaccineManager.sortVaccineByName(((o1, o2) -> o1.getName().compareTo(o2.getName())));
                            System.out.println();
                            break;

                        }
                        case 5: {
                            try {
                                vaccineManager.writeFile();
                            } catch (IOException ex) {
                                Logger.getLogger(VaccineManager.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            System.out.println();
                            break;
                        }
                        case 6: {
                            System.out.println("Bye!!!");
                            System.out.println();
                        }
                    }
                } while (choice != 6);
            }
        };
        mainMenu.execute();
    }
}
