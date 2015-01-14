import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PalindromeChecker extends PApplet {

public void setup()
{
  String lines[] = loadStrings("palindromes.txt");
  println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      println(lines[i] + " IS a palindrome.");
    }
    else
    {
      println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public boolean palindrome(String word)
{

  String sNew = new String();
  
  word = numLetters(word);
  int nLast = word.length()-1;
  for(int nI=nLast; nI>=0; nI--){
      sNew = sNew + word.substring(nI,nI+1); 
  }
  
  //sNew.equals(word.toLowerCase());
  
  sNew = sNew.toLowerCase();
  word = word.toLowerCase();
  System.out.println(sNew);
  System.out.println(word);
  if(sNew.equals(word)){
    return true;
  }
  return false;
}

public String noSpaces(String sWord){
  String myWord = new String();
  for( int x = 0; x < sWord.length(); x++){
    if(sWord.charAt(x) !=  ' '){
      myWord = myWord + sWord.substring(x, x+1);
     
    }
  }
  return myWord;
  
  
}

public String numLetters(String sString){
  String myString = new String();
  for(int i = 0; i < sString.length(); i++){
    if(Character.isLetter(sString.charAt(i))){
      myString = myString + sString.substring(i, i+1);
    
    }
  }
  return myString;
}



  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PalindromeChecker" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
