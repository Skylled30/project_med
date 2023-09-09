package Ex;

public class Movie extends TvProgram {
    String directBox;
    int year;
    public Movie(String name, String time, String directBox, int year) {
        super(name, time);
        this.directBox = directBox;
        this.year = year;
    }
    public String toString() {
        return "Название телепрограммы - " + name + ", начало в " + time + ", доп. информация - " + directBox + ", " + year;
    }
}