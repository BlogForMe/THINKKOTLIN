package pattern.proxy.xiangxue;


import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DynamicProxyTest {
    public static void main(String[] args) {

        ZhangYuXin zyxHello = new ZhangYuXin();
//        ZhangYuXinProxy zhangYuXin = new ZhangYuXinProxy(zyxHello);
//        zhangYuXin.sayHello("hello");


        System.out.println("--------------------\n");

        DoSomeThingDynamic say1 = new DoSomeThingDynamic(zyxHello);
        ZyxInterface zyxProxy = say1.create(ZyxInterface.class);
        zyxProxy.sayHello("John");

        System.out.println("---------------------\n");

        BinBin binBye = new BinBin();
        DoSomeThingDynamic say2 = new DoSomeThingDynamic(binBye);
        BinInterface bbProxy = say2.create(BinInterface.class);
        bbProxy.sayBye();


        /**
         * 生成代理类的，并且输出字节码
         */
        byte[] classFile = ProxyGenerator.generateProxyClass("BinInterface$0", new Class[]{ZyxInterface.class});
        try {
            FileOutputStream out = new FileOutputStream( "BinInterface$0.class");
            out.write(classFile);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
