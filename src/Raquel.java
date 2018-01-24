import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Raquel
{
    private String [] cols;
    private ArrayList<String[]> rows;
    private int rowCount;
    private String[] strCols =
            { "SOURCE", "AGENT", "GOAL", "DATA", "METHODS", "RESULTS", "COMMENTS" };

    // read in the file
    // get it in a string
    // format string to suit csv file

    // take each line and represent it as the csv row

    // add each row


    public String getCurrentFileAsString(String path)
    {
        File inFile = new File(path);
        String stringFile = "";
        String currentLine;

        try (Scanner input = new Scanner(inFile))
        {
            while(input.hasNextLine())
            {
                currentLine = input.nextLine();

                if(currentLine.length() > 0)
                {
                    stringFile += currentLine + " ";
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return stringFile;
    }

}
