package Ex;

public class Education extends TvProgram {
    String science;
    public Education(String name, String time, String science) {
        super(name, time);
        this.science = science;
    }

    public String toString() {
        return "Наименование области науки - " + science;
    }
}