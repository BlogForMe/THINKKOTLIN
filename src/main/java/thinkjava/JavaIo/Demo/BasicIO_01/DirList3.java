package thinkjava.JavaIo.Demo.BasicIO_01;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by jon on 17-1-3.
 */
public class DirList3 {
    public static void main( String[] args) {
      final String[] ars = new String[]{".git"};

        File path = new File(".");
        String[] list = null;
        if (ars.length == 0)
            list = path.list();
        else
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(ars[0]);

                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list)
            System.out.println(dirItem);
    }
}
