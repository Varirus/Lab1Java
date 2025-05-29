package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Problem {
    public List<Item> items = new ArrayList<>();

    public Problem(int n, int seed) {
        Random random = new Random(seed);
        for (int i = 0; i < n; i++) {
            items.add(new Item(i, random.nextInt(1,11), random.nextInt(1,11)));
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Item item : items) {
            output.append("No. ").append(item.getId())
                    .append(" weight: ").append(item.getWeight())
                    .append(" value: ").append(item.getValue())
                    .append("\n");
        }
        return output.toString();
    }

    public Result solve(int capacity) {
        List<Item> sortedItems = new ArrayList<>(items);

        // Sort by sortValue descending
        sortedItems.sort(new Comparator<Item>() {
            @Override
            public int compare(Item i1, Item i2) {
                return Float.compare(i2.getSortValue(), i1.getSortValue());
            }
        });

        Result result = new Result();
        boolean isFilled = false;

        while (!isFilled) {
            if (sortedItems.isEmpty() || capacity <= 0) {
                isFilled = true;
            } else if (sortedItems.getFirst().getWeight() > capacity) {
                sortedItems.removeFirst();
            } else {
                Item selected = sortedItems.removeFirst();
                result.getItems().add(selected.getId());
                result.setSumWeight(result.getSumWeight() + selected.getWeight());
                result.setSumValue(result.getSumValue() + selected.getValue());
                capacity -= selected.getWeight();
            }
        }

        return result;
    }
    public Result solveDantzig(int capacity) {
        List<Item> sortedItems = new ArrayList<>(items);

        // Sort by sortValue descending
        sortedItems.sort(new Comparator<Item>() {
            @Override
            public int compare(Item i1, Item i2) {
                return Float.compare(i2.getSortValue(), i1.getSortValue());
            }
        });

        Result result = new Result();
        boolean isFilled = false;

        while (!isFilled) {
            if (sortedItems.isEmpty() || capacity <= 0) {
                isFilled = true;
            } else if (sortedItems.getFirst().getWeight() > capacity) {
                sortedItems.removeFirst();
            } else {
                Item selected = sortedItems.getFirst();
                result.getItems().add(selected.getId());
                result.setSumWeight(result.getSumWeight() + selected.getWeight());
                result.setSumValue(result.getSumValue() + selected.getValue());
                capacity -= selected.getWeight();
            }
        }

        return result;
    }
}

