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

    // add numbers for each row and headings in the first row

    // now I have to add each string to a file


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
                    stringFile += currentLine + " ";
            }

            input.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return removeHeadings(stringFile);
    }

    public String removeHeadings(String original)
    {
        String updated = removeSource(original);
        updated = removeGoal(updated);
        updated = removeAgent(updated);
        updated = removeData(updated);
        updated = removeMethods(updated);
        updated = removeResults(updated);
        updated = removeComments(updated);

        return updated;
    }

    public String removeSource(String line)
    {
        String test = line.replaceAll("SOURCE(:)? ", "");

        return test;
    }

    public String removeGoal(String line)
    {
        String test = line.replaceAll("GOAL(:)? ", "~");

        return test;
    }

    public String removeAgent(String line)
    {
        String test = line.replaceAll("AGENT(:)? ", "~");

        return test;
    }

    public String removeData(String line)
    {
        String test = line.replaceAll("DATA(:)? ", "~");

        return test;
    }

    public String removeMethods(String line)
    {
        String test = line.replaceAll("METHODS(:)? ", "~");

        return test;
    }

    public String removeResults(String line)
    {
        String test = line.replaceAll("RESULTS(:)? ", "~");

        return test;
    }

    public String removeComments(String line)
    {
        String test = line.replaceAll("COMMENTS(:)? ", "~");

        return test;
    }

}
