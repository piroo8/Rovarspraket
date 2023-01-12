import javax.swing.*; 
import java.util.ArrayList;
/**
 * Rovarspraket
 *
 * Program will take any input from the user and translate it into Rovarspraket.
 * 
 * @author Pierre Ishak
 * 
 * @version Dec 3, 2020
 * 
 */
public class RovarspraketIshP 
{  
  public static boolean isCancelPressed = false; // class variable to keep track of cancel button press, assume not pressed
  
  public static void main(String[] args)  
  {
    String input;
    ArrayList<String> phrase = new ArrayList<String>();
    
    printProgramDescription();
    input = getUserInput();
    translateInput(phrase,input);
    printTranslatedInput(phrase,input); // Rovarspraket
  }
  /**
   * Prints out program description to the user
   */
  public static void printProgramDescription()
  {
    //Prints Program Description
    JOptionPane.showMessageDialog(null,"Hello!\nThis program will use \"Rovarspraket algorthim\" to translate the user's input. Rovarspraket means \"Robber's Language\" in Swedish. \nTo convert an English word into Rovarspraket you leave all vowels intact while replacing all the consonants with that consonant \ndoubled but with an \"o\" between them. ","Rovarspraket Translator",JOptionPane.INFORMATION_MESSAGE);
  }
  /**
   * Gets user input that isn't empty
   * 
   * @return The user's input (in an ordinary String)
   */
  public static String getUserInput()
  {
    String input = "",errMsg;
    boolean isNotValidCode = true;
    
    if (isCancelPressed==false) //if cancel button not pressed
    {
      do
      {      
        input = JOptionPane.showInputDialog(null,"Enter the phrase or word you want to translate into Rovarspraket:","Rovarspraket Translator",JOptionPane.QUESTION_MESSAGE);
        
        errMsg = "Sorry, \" " + input + " \" is empty";
        
        if (input == null)
        {
          isCancelPressed = true;  //set sentinel to indicate cancel button was pressed
          break;
        }
        
        try
        {   
          if(input.trim().replaceAll(" ","").isEmpty())
          {
            Integer.parseInt("a");
          }
          
          isNotValidCode = false;  
        }
        catch (NumberFormatException error)
        {
          JOptionPane.showMessageDialog(null,errMsg,"Rovarspraket Translator",JOptionPane.ERROR_MESSAGE);
        }
        
      }while(isNotValidCode);
    }
    
    return input;
  }
  /**
   * Manipulates the user's input to translate into Rovarsparket
   * 
   * @param phrase User's input before manipulation in array list
   * @param input User's Orginal text
   */
  public static void translateInput(ArrayList<String> phrase,String input)
  {
    if (isCancelPressed==false) //if cancel button not pressed
    {
      for(int i = 0; i < input.length(); i++)
      {
        phrase.add(Character.toString(input.charAt(i)));
      }
      
      for(int i = 0; i < phrase.size(); i++) 
      { 
        String letter = phrase.get(i);
        
        if ((letter.charAt(0) >= 65 && letter.charAt(0) <= 90)||(letter.charAt(0) >= 97 && letter.charAt(0) <= 122))
        {
          if (letter.equalsIgnoreCase("a") || letter.equalsIgnoreCase("e") || letter.equalsIgnoreCase("i") || letter.equalsIgnoreCase("o") ||  letter.equalsIgnoreCase("u") ||  letter.equalsIgnoreCase("y")) 
          { 
            phrase.set(i,letter);
          } 
          else
          { 
            phrase.set(i,letter + "o" + letter);
          } 
        }
      }
    }
  }
  /**
   * Prints out the input and its Rovarsparket translation
   * 
   * @param phrase User's input after manipulation in array list
   * @param input User's Orginal text
   */
  public static void printTranslatedInput(ArrayList<String> phrase,String input)
  {
    String outputcheck = "";
    
    if (isCancelPressed==false) //if cancel button not pressed
    {
      for (int i = 0; i < phrase.size(); i++)
      { 
        outputcheck += phrase.get(i);
      }
      
      JOptionPane.showMessageDialog(null,"Your Orginal Test: " + input + "\nThe Rovarsparket Transaltion: " + outputcheck,"Rovarspraket Translator",JOptionPane.INFORMATION_MESSAGE);
    }
  }
}
