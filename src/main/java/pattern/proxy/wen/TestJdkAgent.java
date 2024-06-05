package pattern.proxy.wen;




public class TestJdkAgent {
    public static void main(String[] args) {


        ProxyDog proxyDog = new ProxyDog(new InvocationHandler() {
            @Override
            public void invoke() {
                //enhancement feature
                System.out.println("before");
                new TargetDog().eat();
            }
        });
        proxyDog.eat();
        proxyDog.drink();

    }

}

interface Target{
    void eat();
    void drink();
}


class TargetDog implements Target{

    @Override
    public void eat() {
        System.out.println("eat shit");
    }

    @Override
    public void drink() {
        System.out.println("drink");
    }
}


interface InvocationHandler{
    void invoke();
}





