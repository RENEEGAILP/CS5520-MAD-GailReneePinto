package edu.neu.madcourse.numad21su_gailreneepinto;

public class CardItem {
    private final String itemName;
    private final String itemDesc;

    public CardItem(String itemName, String itemDesc) {
        this.itemName = itemName;
        this.itemDesc = itemDesc;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public String getItemName() {
        return itemName;
    }
}
