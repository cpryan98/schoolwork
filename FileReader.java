/**
 * @Author - Colin Ryan
 * @Date - 12/6/2017
 * @Class - ITEC 324
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class FileReader
{
	public static void main(String[] args) throws IOException
	{
		System.out.printf("Please enter a file path:\n");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String name = reader.readLine();   
		String fileName = name;

		File myfile = new File(fileName);
		Path path = myfile.toPath();

		BasicFileAttributes file = Files.readAttributes(path, BasicFileAttributes.class);

		System.out.printf("File Name: %s%n", myfile.getName());
		System.out.printf("File Size: %s%n", myfile.length());
		System.out.printf("File Creation Time: %s%n", file.lastAccessTime());
	}
}
