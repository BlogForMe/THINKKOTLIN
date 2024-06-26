package thinkjava.JavaIo.Exercise;


import thinkjava.net.mindview.util.Print;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by jon on 17-1-4.
 */
public class Exercise_02 {
    public static void main(String[] args) {
        //Default constructor  == current directory
        SortedDirList dir = new SortedDirList();
        Print.print(Arrays.asList(dir.list("E0[12]_.*\\.java")));
    }
}

class SortedDirList {
    private File path;

    public SortedDirList() {
        path = new File(".");
    }

    public SortedDirList(File path) {
        this.path = path;
    }

    public String[] list() {
        String[] list = path.list();
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        return list;
    }

    public String[] list(final String fn_regex) {
        String[] list = path.list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(fn_regex);

            @Override
            public boolean accept(File dir, String name) {

                return pattern.matcher(name).matches();
            }
        });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        return list;
    }

}

