import java.util.Scanner;
import java.util.HashMap;


public class Inventory {
    HashMap<String, Integer> inventory;

    public void createInventory() {
        this.inventory = new HashMap<>();
    }

    public void addInventory(String name, int count) {
        inventory.put(name, count);
    }

    public void removeInventory(String name) {
        inventory.remove(name);
    }

    public void updateInventory(String name, int count) {
        if (inventory.containsKey(name)) {
            inventory.put(name, count);
        }
    }}


