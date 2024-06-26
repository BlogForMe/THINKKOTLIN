package thinkjava.InnerClass.demo.NestedClass;

/**
 * Created by Jon on 2016/6/12.
 * With concrete or abstract classes , inner
 * classes are the only way to produce the effect
 * of "multiple implementation inheritance."
 */
class  D{}
abstract  class  E{}
class  Z extends  D{
    E makeE(){return  new E() {};}
}
public class MultiImplementation {
    static  void takesD(D d){}
    static  void takesE(E e){}

    public static void main(String[] args) {
       Z  z  = new Z();
        takesD(z);
        takesE(z.makeE());
    }
}
