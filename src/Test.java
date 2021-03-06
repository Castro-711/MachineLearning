import java.io.*;
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

        stringFiles.add("WORDCOUNT ~SOURCECHARC ~SOURCE ~GOAL ~AGENT ~DATA ~METHODS ~RESULTS ~COMMENTS");

        double totalWords = 57125.0;

        for(int i = 0; i < listOfFiles.length; i++)
            if(r.getCurrentFileAsString(listOfFiles[i].getPath()).length() > 1)
            {
                String[] currentWordCount = r.getCurrentFileAsString(listOfFiles[i].getPath())
                        .split(" ");

                String[] sourceSplit = r.getCurrentFileAsString(listOfFiles[i].getPath())
                        .split("~");

                totalWords += currentWordCount.length;
                stringFiles.add(currentWordCount.length + " ~" +
                    sourceSplit[0].toCharArray().length + " ~" +
                    r.getCurrentFileAsString(listOfFiles[i].getPath()) );
            }

        for(String x : stringFiles)
            System.out.println(x);

        System.out.println(totalWords);

        File csv = createCSVFile("blurbs");

        try {
            FileWriter fw = new FileWriter(csv);
            BufferedWriter bw = new BufferedWriter(fw);

            for(int i = 0; i < stringFiles.size(); i++)
                bw.write(stringFiles.get(i) + "\n");


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    // function to create a file
    public static File createCSVFile(String name)
    {
        File file = new File(name + ".csv");
        try
        {
            boolean successfulCreation = file.createNewFile();

            if(successfulCreation)
                System.out.println("File created successfully..~");
            else
                System.out.println("Error: File not created, file with same name in this directory..~");

        }
        catch(IOException e){ System.err.println("An error occured..~"); e.printStackTrace(); }

        return file;
    }

}
