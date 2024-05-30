package generics.extendsuper;

public class UpBorder1 {
    public static void main(String[] args) {
//        Plate<Fruit> p = new Plate<Apple>(new Apple());
//        Plate<? extends  Fruit> p = new Plate<Apple>(new Apple());
        Plate1<? extends Fruit1> p = new Plate1<>();
//        p.set(new Fruit());
//        p.set(new Apple());
//        System.out.println(p.get());
//        p.set(new GreenApple());
    }
}


class Plate1<T> {
    public Plate1() {
    }

    T item;

    public Plate1(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }

    public void set(T item) {
        this.item = item;
    }
}


