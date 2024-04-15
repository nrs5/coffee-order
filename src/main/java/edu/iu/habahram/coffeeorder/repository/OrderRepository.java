package edu.iu.habahram.coffeeorder.repository;

import edu.iu.habahram.coffeeorder.model.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Repository
@Component
public class OrderRepository {
    private static final String DB_FILE_PATH = "db.txt";
    private int lastUsedId = 0; // Initialize the last used ID to 0

    public Receipt add(OrderData order) throws Exception {
        Beverage beverage = null;
        switch (order.beverage().toLowerCase()) {
            case "dark roast":
                beverage = new DarkRoast();
                break;
            // Add more cases for other types of beverages if needed
            case "decaf":
                beverage = new Decaf();
                break;
            case "espresso":
                beverage = new Espresso();
                break;
            case "house blend":
                beverage = new HouseBlend();
        }
        if (beverage == null) {
            throw new Exception("Beverage type '%s' is not valid!".formatted(order.beverage()));
        }
        for (String condiment : order.condiments()) {
            if(condiment != null) {
                switch (condiment.toLowerCase()) {
                    case "milk":
                        beverage = new Milk(beverage);
                        break;
                    case "mocha":
                        beverage = new Mocha(beverage);
                        break;
                    // Add more cases for other types of condiments if needed
                    case "whip":
                        beverage = new Whip(beverage);
                        break;
                    case "soy":
                        beverage = new Soy(beverage);
                    default:
                        throw new Exception("Condiment type '%s' is not valid".formatted(condiment));
                }
            }
        }

        // Increment the last used ID and use it for the new order
        int orderId = ++lastUsedId;

        // Create receipt
        Receipt receipt = new Receipt(beverage.getDescription(), beverage.cost(), orderId);

        // Write order details to db.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DB_FILE_PATH, true))) {
            writer.write(String.format("%d, %.2f, %s\n", receipt.id(), receipt.cost(), receipt.description()));
            System.out.println("Beverage added to system");
        } catch (IOException e) {
            // Handle IO exception
            throw new Exception("Error occurred while saving order to database.");
        }

        return receipt;
    }
}