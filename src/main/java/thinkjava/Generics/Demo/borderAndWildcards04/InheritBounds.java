package thinkjava.Generics.Demo.borderAndWildcards04;

/**
 * Created by Jon on 2016/6/5.
 * 15.9边界
 */

class HoldItem<T> {
    T item;

    public HoldItem(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }
}

class Colored2<T extends HasColor> extends HoldItem<T> {

    public Colored2(T item) {
        super(item);
    }

    java.awt.Color color() {
        return item.getColor();
    }
}

class ColoredDimension2<T extends Dimension & HasColor> extends Colored2<T> {

    public ColoredDimension2(T item) {
        super(item);
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }
}

class Solid2<T extends Dimension & HasColor & Weight> extends ColoredDimension2<T> {

    public Solid2(T item) {
        super(item);
    }

    int weight() {
        return item.weight();
    }
}

public class InheritBounds {
    public static void main(String[] args) {
        Solid2<Bounded> solid2 = new Solid2<>(new Bounded());
        solid2.color();
        solid2.getY();
        solid2.weight();
    }
}