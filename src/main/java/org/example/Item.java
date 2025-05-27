package org.example;

public class Item {
    private int id;
    private int weight;
    private int value;
    private float sortValue;

    // Constructor
    public Item(int id, int weight, int value) {
        this.id = id;
        this.weight = weight;
        this.value = value;
        this.sortValue = value;
        this.sortValue = this.sortValue / weight;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public float getSortValue() {
        return sortValue;
    }

    public void setSortValue(float sortValue) {
        this.sortValue = sortValue;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Lp. ").append(this.id);
        output.append(" weight: ").append(this.weight);
        output.append(" value: ").append(this.value);
        output.append("\n");
        return output.toString();
    }
}
