import java.io.File;
import java.util.ArrayList;

public class Test
{
    public static void main(String [] args)
    {
        Raquel r = new Raquel();

        ArrayList<String> stringFiles = new ArrayList<String>();

        File directory = new File(
                "/home/castro/college/fourth_year/sem_1/CS401/blurbs/data/" );
        File[] listOfFiles = directory.listFiles();

        for(int i = 0; i < listOfFiles.length; i++)
        {
            stringFiles.add(r.getCurrentFileAsString(listOfFiles[i].getPath()));
        }

        for(String x : stringFiles)
            System.out.println(x);

        System.out.println(stringFiles.size());

    }

}