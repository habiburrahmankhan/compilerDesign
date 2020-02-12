import java.util.*;
import java.io.* ;
public class file_02 
{
public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       //System.out.println("ENTER THE EXPRESSION ");
       //String expr ="(00)*1+2*" ;
       while(true)
       {
       System.out.println("Enter the String -1 to exit  ");
       
       String str = s.next();
       if (str.equals("-1")) {
       	     break ; 
       }
       System.out.println("THIS STRING IS " + checkString(  str ));
   }
}

public static boolean checkString(String str)
{
    boolean check = true ;
     if (str.length() < 3 || str.length() > 16) {
     	check = false ; 
     	return check ;
     }
     int i = 0  ;
     while(i < str.length())
     {
     	char ch  =str.charAt(i) ;
          if ( (ch>='a' && ch<='z' ) || ( ch>='0' && ch<='9') || (ch=='*') || (ch=='-') ) {
          	 i++;
          }
          else
          {
          	check = false ;
          	break ;
          }
     }
  



    return check ;
}
}