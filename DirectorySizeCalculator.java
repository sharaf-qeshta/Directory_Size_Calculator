import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;


public class DirectorySizeCalculator
{
    public static void main(String[] args)
    {
        System.out.println(getSize(new File("DirectoryPath")));
    }

    public static long getSize(File directory)
    {
        long size = 0;
        Queue<File> files = new LinkedList<>();
        files.add(directory);
        while (files.size() > 0)
        {
            File t = files.remove();
            if (t.isFile())
                size += t.length();
            else
                files.addAll(Arrays.asList(Objects.requireNonNull(t.listFiles())));
        }
        return size;
    }
}
