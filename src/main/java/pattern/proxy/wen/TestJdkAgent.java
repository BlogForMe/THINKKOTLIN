package pattern.proxy.wen;




public class TestJdkAgent {
    public static void main(String[] args) {
        new ProxyDog(new InvocationHandler() {
            @Override
            public void invoke() {
                //enhancement feature
                System.out.println("before");
                new TargetDog().eat();
            }
        });


    }

}

interface Target{
    void eat();
}


class TargetDog implements Target{

    @Override
    public void eat() {
        System.out.println("够吃 shit");
    }
}


interface InvocationHandler{
    void invoke();
}





