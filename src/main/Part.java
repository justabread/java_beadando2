package main;

public class Part {
    private String name;
    private int price;
    private String type;
    private int stored;
    
    public Part(String name, int price, String type, int stored){       
        this.name = name;
        this.price = price;
        this.type = type;
        this.stored = stored;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStored() {
        return stored;
    }

    public void setStored(int stored) {
        this.stored = stored;
    }   
}
