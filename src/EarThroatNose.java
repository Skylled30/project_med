public class EarThroatNose extends Pharmacy {

    Subcategories subcategory;

    public EarThroatNose(String name, String company, double price, String dataOfManufacture, Subcategories subcategory) {
        super(name, company, price, dataOfManufacture);
        this.subcategory = subcategory;
    }

    @Override
    public String toString() {
        return "EarThroatNose{" +
                "subcategory=" + subcategory +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                ", dataOfManufacture='" + dataOfManufacture + '\'' +
                '}';
    }
}

enum Subcategories {
    runnyNose,
    headache,
    allergy
}
