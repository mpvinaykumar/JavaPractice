package come.java7.features;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ResourceManagementBeforeJava7
{
    public static void main(String[] args)
    {
        BufferedReader br = null;
        try
        {
            String sCurrentLine;
            br = new BufferedReader(new FileReader("C:/temp/test.txt"));
            while ((sCurrentLine = br.readLine()) != null)
            {
                System.out.println(sCurrentLine);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (br != null)
                    br.close();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
