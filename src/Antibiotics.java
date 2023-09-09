public class Antibiotics extends Pharmacy{

    String actingPart;

    public Antibiotics(String name, String company, double price, String date_, String actingPart) {
        super(name, company, price, date_);
        this.actingPart = actingPart;
    }

    @Override
    public String toString() {
        return "Antibiotics{" +
                "actingPart='" + actingPart + '\'' +
                "} " + super.toString();
    }
}