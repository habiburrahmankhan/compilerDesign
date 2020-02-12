import java.util.*;
import java.io.* ;
public class file_01 
{
public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       //System.out.println("ENTER THE EXPRESSION ");
       while(true)
       {
       String expr ="(00)*1+2*" ;
       System.out.println("Enter the String ");
       String str = s.next();
       if (str.equals("-1")) {
       	break ; 
       }
       System.out.println("THIS STRING IS " + checkString( expr ,  str ));
   }
}

public static  boolean   checkString(String expr , String str)
{
	//  System.out.println("Enter the String ");
	boolean  check = true ;
    int i = 0 , str1 = 0 ;
    while(i< str.length())
    {
    	if (str.charAt(i+0)=='0') {
    		if ( (i +1  < str.length() ) )  {
    			if ( str.charAt(i+1)=='0') {
    				i+=2 ;
    			}
    			else
    		     {
    			     check = false ;
    			     break ;
    		     }
    		}
    		else
    		{
    			check = false ;
    			break ;
    		}
    	}
    	else if(str.charAt(i+0)=='1')
    	{
    		str1 = 1 ;
    		break ;
    	}
    	else
    	{
    		check = false ;
    		break ;
    	}
    }
    while(i < str.length() && ( str.charAt(i)=='1' ))
    {
    	i++ ;
    }
    //System.out.println("Enter the Stringg " + i);
    while(i< str.length())
    {
      if (str.charAt(i)=='2') {
      	i++ ;
      }
      else
      {
      	check = false ;
      	break ;
      }
    }
    //  System.out.println("Enter the Stringg   " + check);

	return check ;
}
}