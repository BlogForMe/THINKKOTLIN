package thinkjava.Generics.Exercise;


import thinkjava.Generics.Demo.InterfaceAndMethod_02.Generators;
import thinkjava.net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jon on 17-1-14.
 */
public class E19_CargoShip {
    public static void main(String[] args) {
        System.out.println(new CargoShip(14, 5, 10));
    }
}

class Container extends ArrayList<Product> {
    public Container(int nProducts) {
        Generators.fill(this, Product.generator, nProducts);
    }
}

class CargoHold extends ArrayList<Container> {
    public CargoHold(int nContainers, int nProducts) {
        for (int i = 0; i < nContainers; i++)
            add(new Container(nProducts));
    }
}

class Crane {
}

class CommandSection {
}

class CargoShip extends ArrayList<CargoHold> {
    private ArrayList<Crane> cranes = new ArrayList<>();
    private CommandSection cmdSection = new CommandSection();

    public CargoShip(int nCargoHolds, int nContainers, int nProducts) {
        for (int i = 0; i < nCargoHolds; i++)
            add(new CargoHold(nContainers, nProducts));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (CargoHold ch : this)
            for (Container c : ch)
                for (Product p : c) {
                    result.append(p);
                    result.append("\n");
                }

        return result.toString();
    }
}


class Product {
    private final int id;
    private String description;
    private double price;

    public Product(int id) {
        this.id = id;
    }

    public Product(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return id + ": " + description + " , price : &" + price;
    }

    public void priceChage(double change) {
        price += change;
    }

    public static Generator<Product> generator = new Generator<Product>() {
        private Random rand = new Random(47);

        @Override
        public Product next() {
            return new Product(rand.nextInt(1000), "Test", Math.round(rand.nextDouble() * 1000.0) + 0.99);
        }
    };
}