/**
 * FileReader -- reads records (rows) from a file. 
 *
 * @author  Jeff Pittges
 * @version 01-Jan-2015
 */
import java.io.*; 
import java.util.Scanner;

public class FileReader  
{
    private int lineCount;		// number of lines processed thus far 
    private Scanner fileScan;		// scans the given file 

    public FileReader(String filename) throws IOException 
    {
		this.lineCount = 0;
		this.fileScan = new Scanner(new File(filename));
    }

	public boolean hasNext()
	{
		return fileScan.hasNext();
	}

    public String nextLine() throws IOException
    {
		String line = ""; 

		if (fileScan.hasNext())
		{
		   line = fileScan.nextLine();
	   	   ++lineCount;
		}

		return line; 
    }
}
