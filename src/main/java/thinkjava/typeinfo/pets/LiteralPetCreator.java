//: thinkjava.typeinfo/pets/LiteralPetCreator.java
// Using class literals.
package thinkjava.typeinfo.pets;
import java.util.*;

public class LiteralPetCreator extends PetCreator {
  // No try block needed.
  @SuppressWarnings("unchecked")
  public static final List<Class<? extends Pet>> allTypes =
    Collections.unmodifiableList(Arrays.asList(
      Pet.class, Dog.class, Cat.class,  Rodent.class,
      Mutt.class, Pug.class, EgyptianMau.class, Manx.class,
      Cymric.class, Rat.class, Mouse.class,Hamster.class));
  // Types for random creation:
  private static final List<Class<? extends Pet>> types =
    allTypes.subList(allTypes.indexOf(Mutt.class),
      allTypes.size());
  public List<Class<? extends Pet>> types() {
    return types;
  }	
  public static void main(String[] args) {
    System.out.println(types);
  }
} /* Output:
[class thinkjava.typeinfo.pets.Mutt, class thinkjava.typeinfo.pets.Pug, class thinkjava.typeinfo.pets.EgyptianMau, class thinkjava.typeinfo.pets.Manx, class thinkjava.typeinfo.pets.Cymric, class thinkjava.typeinfo.pets.Rat, class thinkjava.typeinfo.pets.Mouse, class thinkjava.typeinfo.pets.Hamster]
*///:~
