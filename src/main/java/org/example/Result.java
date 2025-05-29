package org.example;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<Integer> items = new ArrayList<>();
    private int sumWeight = 0;
    private int sumValue = 0;

    // Getters and setters
    public List<Integer> getItems() {
        return items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }

    public int getSumWeight() {
        return sumWeight;
    }

    public void setSumWeight(int sumWeight) {
        this.sumWeight = sumWeight;
    }

    public int getSumValue() {
        return sumValue;
    }

    public void setSumValue(int sumValue) {
        this.sumValue = sumValue;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Items: ");
        for (int item : items) {
            output.append(item).append(" ");
        }
        output.append("\n");
        output.append("Amount of items: ").append(items.size()).append("\n");
        output.append("Sum Weight: ").append(sumWeight).append("\n");
        output.append("Sum Value: ").append(sumValue).append("\n");
        return output.toString();
    }
}

