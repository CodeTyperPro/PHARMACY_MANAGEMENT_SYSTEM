package model;

public class Medicine {
    private String name;
    private String supplier;
    private Double price;
    private Integer quantity;

    public Medicine() {
        this.name = "default";
        this.supplier = "default";
        this.price = 0.0;
        this.quantity = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Medicine(String name, String supplier, Double price, Integer quantity) {
        this.name = name;
        this.supplier = supplier;
        this.price = price;
        this.quantity = quantity;
    }
}
