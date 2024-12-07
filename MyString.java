





/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
      /*  System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        String str = randomStringOfLetters(9);
        System.out.println(str);*/
        System.out.println(spacedString(hello));
        System.out.println(spacedString(hello).length());
        System.out.println(remove("committee","meet"));
        System.out.println(insertRandomly('c',"roee"));
        //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        //// Replace the following statement with your code
        int counter = 0;
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i)==ch)
            {
                counter++;
            }
        }
        return counter;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2)
    {
         //// Replace the following statement with your code
        int counter1 =0,counter2=0;
        for( int i =0; i < str1.length(); i++ )
        {
           char c1 = str1.charAt(i);
           counter1 = countChar(str1,c1);
           for( int j =0; j<str2.length();j++)
           {
               char c2 = str2.charAt(j);
               counter2 = countChar(str2, c2);
               if(counter1>counter2)
               {
                   return false;
               }
           }
        }
       return true;

    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        //// Replace the following statement with your code
        String newString = "";
        for(int i =0; i<str.length(); i++)
        {
            newString += str.charAt(i);
            if(i<str.length()-1)
            {
                newString += " ";
            }
        }
        return newString;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n)
     {
        String str = "";
        for(int i = 0; i < n; i++)
        {
            double r = Math.random();
            int N = (int) (r*26) +97;
            str+= (char) N;
        }
        return str;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * the right example ("committee,meet") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
  public static String FillupString(String str1, String str2)
  {
    String str22 = "";
    for(int i =0; i<str1.length()-str2.length();i++)//im gonna fill all the rest of this string with 0 so i will be able to work with them more easily
    {
    str22+='o';
    }
        return str22;
  }
  public static String removeLastChar(String s) {
    return (s == null || s.length() == 0)
      ? null 
      : (s.substring(0, s.length() - 1));
}

public static String remove(String str1, String str2) {
    String result = "";

    // Create a mutable count of characters in str2
    int[] charCount = new int[256]; // Supports ASCII characters
    for (char c : str2.toCharArray()) 
    { //enhanced for loop
        charCount[c]++;
    }

    // Iterate through str1 and only keep characters not fully "used up" in str2
    for (char c : str1.toCharArray()) {
        if (charCount[c] > 0) {
            charCount[c]--; // Decrement count in str2
        } else {
            result += c; // Append to result if not in str2
        }
    }

    return result;
}






    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) 
    {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);

         return result;
    }    
}
