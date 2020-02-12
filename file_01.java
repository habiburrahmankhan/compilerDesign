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
       System.out.println(" IS STRING ACCEPTED :-  " + checkString( expr ,  str ));
   }
}

public static  boolean   checkString(String expr , String str)
{
	boolean  check = true ;
    int i = 0 , str1 = 0 ;
    while(i< str.length())
    {
    	if ( (i +1  < str.length() ) && (str.charAt(i+0)=='0') && (str.charAt(i+1)=='0') ) {

    				i+=2 ;
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
    if (str.charAt(0)=='1')
    {
        str1 =1 ;
    }
    while(i < str.length() && ( str.charAt(i)=='1' ) && str1 ==1)
    {
    	i++ ;
    }
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

	return check && str1==1 ;
}
}