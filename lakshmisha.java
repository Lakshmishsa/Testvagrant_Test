//USN:- 1BI20IS049
//NAME:- LAKSHMISHA RA
//BRANCH:- ISE
//YEAR OF PASSING:- 2024
//PHONE NUMBER:- 9483562706
//EMAIL:- lakshmisha.r.a.2002@gmail.com

import java.util.*;

class Item {
    String itemName;
    double unitPrice;
    double gst;
    int quantity;

    public Item(String itemName, double unitPrice, double gst, int quantity) {
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.gst = gst;
        this.quantity = quantity;
    }

    public double calculateDiscountedPrice() {
        double discountedPrice = unitPrice * quantity;
        if (unitPrice >= 500) {
            discountedPrice *= 0.95;
        }
        return discountedPrice;
    }

    public double calculateGSTAmount() {
        return (unitPrice * gst / 100) * quantity;
    }
}

public class ShopManager {
    public static void main(String[] args) {
        List<Item> shoppingBasket = new ArrayList<>();
        shoppingBasket.add(new Item("Leather Wallet", 1100, 18, 1));
        shoppingBasket.add(new Item("Umbrella", 900, 12, 4));
        shoppingBasket.add(new Item("Cigarette", 200, 28, 3));
        shoppingBasket.add(new Item("Honey", 100, 0, 2));

        Item maxGSTItem = itemWithMaxGST(shoppingBasket);
        System.out.println("Item with maximum GST amount: " + maxGSTItem.itemName);

        double totalAmountToPay = calculateAmountToPay(shoppingBasket);
        System.out.println("Total amount to be paid to the shopkeeper: Rs" + totalAmountToPay);
    }

    private static Item itemWithMaxGST(List<Item> shoppingBasket) {
        double maxGSTAmount = 0;
        Item maxGSTItem = null;

        for (Item item : shoppingBasket) {
            double gstAmount = item.calculateGSTAmount();
            if (gstAmount > maxGSTAmount) {
                maxGSTAmount = gstAmount;
                maxGSTItem = item;
            }
        }

        return maxGSTItem;
    }

    private static double calculateAmountToPay(List<Item> shoppingBasket) {
        double totalAmount = 0;

        for (Item item : shoppingBasket) {
            totalAmount += item.calculateDiscountedPrice() + item.calculateGSTAmount();
        }

        return totalAmount;
    }
}
