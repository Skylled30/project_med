package Ex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Main {
    public static void show(ArrayList<TvProgram> list) {
        if (list.size() == 0) {
            System.out.println("Массив пуст");
        }
        for (TvProgram element : list) {
            System.out.println(element.toString());
        }
    }
    public static void showMenu() {
        System.out.println("\n");
        System.out.println("1 - Ex.Show collection");
        System.out.println("2 - Add new Ex.TvProgram");
        System.out.println("3 - Add new Ex.Show");
        System.out.println("4 - Add new Ex.Movie");
        System.out.println("5 - Add new Ex.Children program");
        System.out.println("6 - Add new Ex.Education program");
        System.out.println("7 - Sorting");
        System.out.println("8 - Add collection into file");
        System.out.println("9 - Get collection from file");
        System.out.println("10 - Exit");
    }
    public static void main(String[] args) {
        Children tv1 = new Children("Gym", "8:00", 3, 6);
        Movie tv2 = new Movie("Beautiful breakfast", "20:00", "some breakfast recipes", 2022);
        Show tv3 = new Show("Java", "18:00", "some update in java");
        ArrayList<TvProgram> teleprograms = new ArrayList<>(Arrays.asList(tv1, tv2, tv3));
        Scanner in = new Scanner(System.in);
        showMenu();
        while(true) {
            int menuItem = in.nextInt();
            switch(menuItem) {
                case 1: {
                    show(teleprograms);
                    break;
                }
                case 10: {
                    System.out.println("Bye");
                    System.exit(0);
                    break;
                }
                case 2: case 3: case 4: case 5: case 6: {
                    System.out.println("Введите название телепрограммы ....");
                    in.nextLine();
                    String newnaime = in.nextLine();
                    System.out.println("Введите начало телепрограммы ....");
                    String newtime = in.nextLine();
                    switch(menuItem) {
                        case 2: {
                            TvProgram new_tp = new TvProgram(newnaime, newtime);
                            teleprograms.add(new_tp);
                            break;
                        }
                        case 3: {
                            System.out.println("Введите тему шоу ....");
                            String newtheme = in.nextLine();
                            Show new_tp = new Show(newnaime, newtime, newtheme);
                            teleprograms.add(new_tp);
                            break;
                        }
                        case 4: {
                            System.out.println("Введите дополнительную информацию о фильме ....");
                            String newinfo = in.nextLine();
                            System.out.println("Введите год фильма ....");
                            int newyear = in.nextInt();
                            Movie new_tp = new Movie(newnaime, newtime, newinfo, newyear);
                            teleprograms.add(new_tp);
                            break;
                        }
                        case 5: {
                            System.out.println("Введите минимальный возраст ребенка ....");
                            int newmin = in.nextInt();
                            System.out.println("Введите максимальный возраст ребенка ....");
                            int newmax = in.nextInt();
                            Children new_tp = new Children(newnaime, newtime, newmin, newmax);
                            teleprograms.add(new_tp);
                            break;
                        }
                        case 6: {
                            System.out.println("Введите наименование области науки ....");
                            String newscience = in.nextLine();
                            Education new_tp = new Education(newnaime, newtime, newscience);
                            teleprograms.add(new_tp);
                            break;
                        }
                    }
                    break;
                }
                case 7: {
                    for (int i=0; i < teleprograms.size(); i++) {
                        for (int j=i+1; j < teleprograms.size(); j++) {
                            if (teleprograms.get(i).name.charAt(0) > teleprograms.get(j).name.charAt(0)) {
                                TvProgram extra = teleprograms.get(j);
                                teleprograms.set(j, teleprograms.get(i));
                                teleprograms.set(i, extra);
                            }
                        }
                    }
                    show(teleprograms);
                }
                case 8: {
                    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teleprograms.dat")))
                    {
                        oos.writeObject(teleprograms);
                        System.out.println("File has been written");
                    }
                    catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case 9: {
                    try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teleprograms.dat")))
                    {
                        ArrayList<TvProgram> col=(ArrayList<TvProgram>)ois.readObject();
                        show(col);
                    }
                    catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
            }
        showMenu();
    }
    }
}
