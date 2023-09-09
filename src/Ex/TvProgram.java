package Ex;

import java.io.Serializable;

public class TvProgram  implements Serializable {
    String name;
    String time;
    public TvProgram() {}

    public TvProgram(String name, String time) {
        this.name = name;
        this.time = time;
    }
    @Override
    public String toString() {
        return "Название телепрограммы - " + name + ", начало в " + time;
    }
}
