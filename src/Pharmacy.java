public class Pharmacy {

    String name;
    String company;
    double price;
    String dataOfManufacture;

    public Pharmacy(String name, String company, double price, String dataOfManufacture) {
        this.name = name;
        this.company = company;
        this.price = price;
        this.dataOfManufacture = dataOfManufacture;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                ", dataOfManufacture='" + dataOfManufacture + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public double getPrice() {
        return price;
    }

    public String getDataOfManufacture() {
        return dataOfManufacture;
    }
}
