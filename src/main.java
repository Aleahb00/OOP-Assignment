import java.util.Scanner;


public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Inventory userInventory = new Inventory();
    System.out.println("Welcome to your personal inventory management!");
    userInventory.createInventory();
    System.out.println("Your inventory is currently empty. Would you like to add to it? [Y/N]");
    System.out.print("> ");
    String choice = scanner.nextLine();
    if (choice.equals("Y")) {
        System.out.println("Enter the name of your product-");
        System.out.print("> ");
        String productName = scanner.nextLine();
        System.out.println("Quantity-");
        System.out.print("> ");
        String productCountstr = scanner.nextLine();
        try {
            int productCount = Integer.parseInt(productCountstr);
            userInventory.addInventory(productName, productCount);
        } catch (NumberFormatException e) {
            System.out.println("Must enter a number!");
        }
        userInventory.inventory.forEach((key, value) -> {
            System.out.println("Inventory- \n  Item: " + key + "  " + "Quantity: " + value);
        });
        while (true) {
            System.out.println("Would you like to [view], [add], [edit], or [remove] from your inventory? [q] to quit.");
            System.out.print("> ");
            String action = scanner.nextLine();
            if (action.equals("view")) {
                System.out.println("Inventory- ");
                userInventory.inventory.forEach((key, value) -> {
                    System.out.println("Item: " + key + "  " + "Quantity: " + value);
                });
            }
            else if(action.equals("add")) {
                System.out.println("Enter the name of your product-");
                System.out.print("> ");
                String newProductName = scanner.nextLine();
                System.out.println("Quantity-");
                System.out.print("> ");
                String newProductCountStr = scanner.nextLine();
                try {
                    int newProductCount = Integer.parseInt(newProductCountStr);
                    userInventory.addInventory(newProductName, newProductCount);
                } catch (NumberFormatException e) {
                    System.out.println("Must enter a number!");
                }
            }
            else if (action.equals("edit")) {
                System.out.println("What product would you like to edit?");
                System.out.print("> ");
                String updatedProduct = scanner.nextLine();
                if (userInventory.inventory.containsKey(updatedProduct)) {
                    System.out.println("Enter new product count.");
                    System.out.print("> ");
                    String updatedProductCountStr = scanner.nextLine();

                    int updatedProductCount = Integer.parseInt(updatedProductCountStr);
                    userInventory.updateInventory(updatedProduct, updatedProductCount);
                }
                else {
                    System.out.println("Product not apart of inventory!");
                }
            }
            else if (action.equals("remove")) {
                System.out.println("What product would you like to remove?");
                System.out.print("> ");
                String removedProduct = scanner.nextLine();
                if (userInventory.inventory.containsKey(removedProduct)) {
                    userInventory.removeInventory(removedProduct);
                }
                else {
                    System.out.println("Product not apart of inventory!");
                }
            }
            else if (action.equals("q")) {
                System.out.println("Exiting program...");
                break;
            }
            else {
                System.out.println("Sorry! unknown option!");
            }

        }
    }
    else if(choice.equals("N")) {
        System.out.println("Exiting program...");
    }
    else {
        System.out.println("error... closing program.");
    }

}



