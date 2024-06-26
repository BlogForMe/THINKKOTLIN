package thinkjava.JavaIo.Exercise;

import thinkjava.JavaIo.Utils.Constants;

import java.util.LinkedList;
import java.util.ListIterator;

import static thinkjava.JavaIo.Exercise.E07_FileLinkedList.readLinked;

/**
 * Created by Administrator on 2017/1/5.
 */
public class E08_argsInput {
    public static void main(String[] args) {
        //Constants.hPExercise + "E08_argsInput.java"
        if (args.length == 0){
            System.err.println("Usage: java E08_argsInput file");
            return;
        }
        LinkedList<String> lList = readLinked(Constants.hPExercise + args[0]);
        for (ListIterator<String> it = lList.listIterator(lList.size()); it.hasPrevious(); )  //逆序运算
            System.out.println(it.previous());
    }
}
