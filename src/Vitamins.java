public class Vitamins extends Pharmacy{
    String mainElement;


    public Vitamins(String name, String company, double price, String date_, String mainElement) {
        super(name, company, price, date_);
        this.mainElement = mainElement;
    }

    @Override
    public String toString() {
        return "Vitamins{" +
                "mainElement='" + mainElement + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                ", dataOfManufacture='" + dataOfManufacture + '\'' +
                '}';
    }

    public String getMainElement() {
        return mainElement;
    }
}