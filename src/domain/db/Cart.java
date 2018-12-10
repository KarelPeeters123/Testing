package domain.db;

import domain.model.Product;
import domain.model.ShopService;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Integer, Integer> products;
    private ShopService service;

    public Cart(ShopService service) {
        products = new HashMap<>();
        this.service = service;
    }

    public void add(int productId, int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("quantity can't be negative");
        products.put(productId, getAmount(productId) + quantity);
    }

    private int getAmount(int id) {
        if (products.get(id) == null) {
            return 0;
        } else {
            return products.get(id);
        }
    }

    public Map<Product, Integer> getProducts() {
        HashMap<Product, Integer> out = new HashMap<>();
        for (int id : products.keySet()) {
            out.put(service.getProduct(id), products.get(id));
        }
        return out;
    }

    public int totalAmountOfProducts() {
        int total = 0;
        for (int value : products.values()) {
            total += value;
        }
        return total;
    }

    public double totalPrice() {
        double total = 0;
        for (Product p : getProducts().keySet()) {
            double subPrice = p.getPrice() * products.get(p.getProductId());
            total += subPrice;
        }
        return (double) Math.round(total * 100) / 100;
    }

}
