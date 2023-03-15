package com.example.inventory_scannedbarcode;

public class Item {

    private String price;
    private String weight;
    private String barcode;
    private String timestamp;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Item(String price, String weight, String barcode, String timestamp) {
        this.price = price;
        this.weight = weight;
        this.barcode = barcode;
        this.timestamp = timestamp;
    }

    @Override
    public String toString(){
        return"Item{"+
                "price='"+price+'\''+
                ",weight='"+weight+'\''+
                ",barcode='"+barcode+'\''+
                ",timestamp='"+timestamp+'\''+
                '}';
    }
}
