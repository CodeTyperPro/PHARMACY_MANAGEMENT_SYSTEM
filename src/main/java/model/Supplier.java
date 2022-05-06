package model;

public class Supplier {
    private String name;

    public Supplier(String name) {
        this.name = name;
    }

    public Supplier() {
        this.name = "Default";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "name='" + name + '\'' +
                '}';
    }
}
