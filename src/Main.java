import Ex.TvProgram;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void showInfo(ArrayList<Pharmacy> medicines){
        for (int i = 0; i < medicines.size(); i++) {
            System.out.println(medicines.get(i));
        }
    }

    public static void showMenu() {
        System.out.println("\n");
        System.out.println("1 - Show collection");
        System.out.println("2 - Add new EarThroatNoseMed");
        System.out.println("3 - Add new AntiTrauma");
        System.out.println("4 - Add new Antibiotics");
        System.out.println("5 - Add new Vitamin");
        System.out.println("6 - Sorting");
        System.out.println("7 - Add collection into file");
        System.out.println("8 - Get collection from file");
        System.out.println("9 - Exit");
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);

        EarThroatNose earThroatNose1 = new EarThroatNose("Аквалор форте", "Нижфарм АО", 429, "10.01.2022", Subcategories.runnyNose);
        AntiTrauma antiTrauma1 = new AntiTrauma("Пластырь", "ВЕРОФАРМ", 52, "11.01.2022", "Фиксация");
        Antibiotics antibiotics = new Antibiotics("Монурал", "Замбон", 589, "07.11.2022", "Фосфомицин");
        Vitamins vitamins = new Vitamins("Формула антистресс", "West Coast Laboratories, Inc.", 772, "10.10.2021", "Ca");

        ArrayList<Pharmacy> medicines = new ArrayList<>();
        ArrayList<Pharmacy> medicinesDatabase = new ArrayList<>();
        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.getDbConnection();

        medicines.add(earThroatNose1);
        medicines.add(antiTrauma1);
        medicines.add(antibiotics);
        medicines.add(vitamins);

        while (true) {
            showMenu();
            System.out.print("Type item: ");
            int menuItem = in.nextInt();
            System.out.println();
            switch (menuItem) {
                case 1: {
                    showInfo(medicines);
                }
                case 9:
                    dbHandler.getData(medicinesDatabase);
                    showInfo(medicinesDatabase);
                    break;
                case 10: {
                    System.out.println("Good bye!");
                    break;
                }
                case 2: case 3: case 4: case 5: {
                    System.out.print("Введите название препарата: ");
                    String name = in.next();
                    System.out.print("Введите название компании: ");
                    String company = in.next();
                    System.out.print("Введите цену: ");
                    double price = in.nextDouble();
                    System.out.print("Введите дату изготовления: ");
                    String dataOfManufacture = in.next();

//                    System.out.println(name + " " + company + " " + price + " " + dataOfManufacture);
                    switch (menuItem) {
                        case 2: {
                            System.out.println("Выберите подкатегорию\n" +
                                    "насморк - 1\n" +
                                    "головная боль - 2\n" +
                                    "аллергия - 3");
                            int numberItem = in.nextInt() - 1;
                            EarThroatNose earThroatNose = new EarThroatNose(name, company, price, dataOfManufacture, Subcategories.values()[numberItem]);
                            medicines.add(earThroatNose);
                            break;
                        }
                        case 3: {
                            System.out.println("Введите травму: ");
                            String task = in.next();
                            AntiTrauma antiTrauma = new AntiTrauma(name, company, price, dataOfManufacture, task);
                            medicines.add(antiTrauma);
                            break;
                        }
                        case 4: {
                            System.out.println("Введите активный элемент: ");
                            String actingPart = in.next();
                            Antibiotics antibiotics1 = new Antibiotics(name, company, price, dataOfManufacture, actingPart);
                            medicines.add(antibiotics1);
                            break;
                        }
                        case 5: {
                            System.out.println("Введите главный элемент: ");
                            String mainElement = in.next();
                            Vitamins vitamins1 = new Vitamins(name, company, price, dataOfManufacture, mainElement);
                            medicines.add(vitamins1);
                            dbHandler.addVitamin(vitamins1);
                            break;
                        }

                    }
                    break;
                }
                case 6: {
                    for (int i = 0; i < medicines.size(); i++) {
                        for (int j = 0; j < medicines.size(); j++) {
                            if (medicines.get(i).name.charAt(0) > medicines.get(j).name.charAt(0)){
                                Pharmacy pharmacy = medicines.get(i);
                                medicines.set(i, medicines.get(j));
                                medicines.set(j, pharmacy);
                            }
                        }
                    }
                }

                case 7: {
                    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pharmacy.dat")))
                    {
                        oos.writeObject(medicines);
                        System.out.println("File has been written");
                    }
                    catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case 8: {
                    try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pharmacy.dat")))
                    {
                        ArrayList<Pharmacy> data = (ArrayList<Pharmacy>) ois.readObject();
                        showInfo(data);
                    }
                    catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                }


            }
        }

    }
}