package Ex;

public class Children extends TvProgram {
    int minAge;
    int maxAge;
    public Children(String name, String time, int minAge, int maxAge) {
        super(name, time);
        this.minAge = minAge;
        this.maxAge = maxAge;
    }
    public String toString() {
        return "Телепрограмма "+ name+" начитается в "+time+", ограничение по возрасту: "+"минимальный детский возраст - " + minAge + ", максимальный детский возраст - " + maxAge;
    }
}