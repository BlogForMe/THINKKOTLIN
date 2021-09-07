package senior;

import com.sun.istack.internal.Nullable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import main.java.senior.HeroKt;
import main.java.senior.SpellBook;

import java.io.IOException;
import java.util.List;

public class Jhava {
    private int hitPoints = 3232320;

    public int getHitPoints() {
        System.out.println("----hitPoints-----");
        return hitPoints;
    }

    public String utterGreeting() {
        return "HELLO";
    }


    public static void main(String[] args) {
//        System.out.println(HeroKt.makeProclamation());
//        System.out.println(Hero);

        SpellBook spellBook = new SpellBook();

        List<String> spells = spellBook.getSpells();
        List<String> spells1 = spellBook.spells1;

        //伴生对象
        SpellBook.Companion.getSpellbookGreeting();

        //添加@JvmField  支持静态调用
        int maxSpellCount = SpellBook.MAX_SPELL_COUNT;

        try {
            //在java里面强制 在编译器处理的异常
            new Jhava().extendHandInFriendship();
        } catch (IOException e) {
            e.printStackTrace();
        }


//        try {
//            HeroKt.acceptApology();
//        } catch (IOException e) {   //报错 Exception 'java.io.IOException' is never thrown in the corresponding try block
//            e.printStackTrace();
//        }

        try {
            HeroKt.acceptApology();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        try {
            HeroKt.acceptApology1();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Function1<String, Unit> translator = HeroKt.getTranslator();
        translator.invoke("TRUECE");

    }

    @Nullable
    public String determineFriends() {
        return null;
    }

    public void extendHandInFriendship() throws IOException {
        throw new IOException();
    }
}
