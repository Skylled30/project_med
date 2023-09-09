package Ex;

public class Show extends TvProgram {
    String treme;
    public Show(String name, String time, String treme) {
        super(name, time);
        this.treme = treme;
    }

    public String toString() {
        return "Название телепрограммы - " + name + ", начало в " + time + ", тема шоу - " + treme;
    }
}