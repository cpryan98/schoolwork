/***********************
 *
 *   LicensePlate
 *
 *   Author:   Colin Ryan
 *   Date:     2016-10-30
 *
 *   A LicensePlate has two pieces of instance data:
 *      plateNumber - array of 8 char
 *      price - int, cost of plate in whole dollars
 *
 ***********************/ 

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

 public class LicensePlate
 {
    private static final String PLATE_FILE = "existingplates.txt";
    private final int BASE_PRICE = 50;
    private char[] plateNumber;
    private int price;

    // constructor generates a valid plate number and sets the price to the base price
    public LicensePlate()
    {
        plateNumber = new char[8];
        this.genRandomPlate();

        this.price = BASE_PRICE;
    }

    private void genRandomPlate()
    {
        for (int i=0; i<3; i++)
        {
            this.plateNumber[i] = randomLetter();
        }
        this.plateNumber[3] = '-';
        for (int i=4; i<8; i++)
        {
            this.plateNumber[i] = randomDigit();
        }
    }

    private char randomLetter()
    {
        Random gen = new Random();
        int range = 'Z'-'A'+1;
        return (char) (gen.nextInt(range) + 'A');
    }

    private char randomDigit()
    {
        Random gen = new Random();
        return (char) ('0' + gen.nextInt(10));
    }

    public int getPrice()
    {
        return price;
    }

    public char[] getPlateNumber()
    {
        return plateNumber;
    }

    // personalize takes a String and validates it
    // if it is a valid plate, it changes the plateNumber to 
    // the new plateNumber and calculates the cost of the plate.
    // the method returns true if the new plateNumber is valid and the plate was changed,
    // and false if the new plateNumber was invalid and no changes were made.
    //
    // A personalized plate may be 3 up to 7 chars and 1 space or dash
    // Use letters, numbers, dashes, and spaces ONLY
    // A personalized plate costs $10 extra plus $5 per letter (not including dashes or spaces)
    public boolean personalize(String vanity) throws IOException
    {
        vanity = vanity.trim().toUpperCase();

        boolean valid = isValidPlate(vanity);
        boolean notTaken = isPlateTaken(vanity);
        if (valid && notTaken)
        {
            updatePlateNumber(vanity);
            updatePriceForPersonalized(vanity);
        } 
        return (valid && !notTaken);
    }

    private void updatePlateNumber(String vanity)
    {
        for(int i=0; i<this.plateNumber.length; i++)
        {
            if (i < vanity.length())
                this.plateNumber[i] = vanity.charAt(i);
            else
                this.plateNumber[i] = ' ';
        }
    }

    private void updatePriceForPersonalized(String vanity)
    {
        this.price = BASE_PRICE;
        this.price += 10;
        this.price += 5*countChars(vanity);
    }

    public boolean isPlateTaken(String vanity) throws IOException
    {
        Scanner plateScanner;
        FileReader readMe = new FileReader("existingplates.txt");
        
        boolean plateIsTaken = false;
        try {
        	while(readMe.hasNext())
        	{
        		String stringLine = readMe.nextLine();
        		if(vanity.equals(stringLine))
        			plateIsTaken = true;
        	}

        } catch (Exception exc) {
            System.err.println("Unable to read file <" + PLATE_FILE + ">.\n" + exc.getStackTrace());
        }
        return plateIsTaken;
    }

    private boolean isValidPlate(String vanity)
    {
        boolean valid = true;

        if (vanity.length() < 3 || vanity.length() > 8)
            valid = false;
        else 
        {
            int charCount = countChars(vanity);

            if (charCount < 3 || charCount > 7)
                valid = false;
            if (hasInvalidChar(vanity))
                valid = false;
            if (hasMoreThanOne(vanity,'-'))
                valid = false;
            if (hasMoreThanOne(vanity,' '))
                valid = false;
        }
        return valid;
    }

    private boolean hasMoreThanOne(String s, char ch)
    {
        int charCnt=0;

        int pos=0;
        while(charCnt<2 && pos<s.length())
        {
            if (s.charAt(pos) == ch)
                charCnt++;
            pos++;
        }
        return (charCnt >= 2);
    }

    private boolean hasInvalidChar(String vanity)
    {
         boolean illegalChar = false;
         for (int i=0; i<vanity.length(); i++)
         {
            char ch = vanity.charAt(i);
            if (!isLetter(ch) && !isDigit(ch) && !isSpace(ch) && !isDash(ch))
                illegalChar = true;
         }
         return illegalChar;
    }

    private boolean isDash(char ch)
    {
        return (ch == '-');
    }

    private boolean isSpace(char ch)
    {
        return (ch == ' ');
    }

    private boolean isDigit(char ch)
    {
        return (ch >= '0' && ch <= '9');
    }

    private boolean isLetter(char ch)
    {
        return (ch >= 'A' && ch <= 'Z');
    }

    private int countChars(String vanity)
    {
        int chCnt = 0;
        for(int i=0; i<vanity.length(); i++)
        {
            char ch = vanity.charAt(i);
            if (isDigit(ch) || isLetter(ch))
                chCnt++;
        }
        return chCnt;
    }
    public boolean equals(String vanity)
    {
    	boolean bool = false;
    	String s = getPlateNumber().toString();
    	if(s == vanity)
    		bool = true;
    	return bool;
    }
    public int compareTo(LicensePlate anotherLP)
    {
    	String s = getPlateNumber().toString();
    	String a = anotherLP.toString();
    	int x = a.compareTo(s);
    	return x;
    }

    public String toString()
    {
        String plate = "";
        for(char c:this.plateNumber)
            plate += c;
        return plate + "\t$" + price;
    }


 }