public class AntiTrauma extends Pharmacy {
    String task;

    public AntiTrauma(String name, String company, double price, String date_, String task) {
        super(name, company, price, date_);
        this.task = task;
    }


    @Override
    public String toString() {
        return "AntiTrauma{" +
                "task='" + task + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                ", dataOfManufacture='" + dataOfManufacture + '\'' +
                '}';
    }
}
