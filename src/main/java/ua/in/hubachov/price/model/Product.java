package ua.in.hubachov.price.model;

/**
 * Created by Sashko on 4/7/17.
 */
public class Product {

    private String name;
    private double price;
    private boolean available;

    public Product() {

    }

    private Product(final String name, final double price, final boolean available) {
        this.name = name;
        this.price = price;
        this.available = available;
    }

    public static Product create(final String name, final double price, final boolean available) {
        return new Product(name, price, available);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(final boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
    }

}
