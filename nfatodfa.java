import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class nfatodfa {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("nfatodfa_input") ;
        Scanner s = new Scanner(file) ;
        int noofstate = s.nextInt() ;
        int noofvariable = s.nextInt() ;
        String[][]   nfatable = new String[noofstate][noofvariable + 1] ;
        for (int i = 0; i < noofstate ; i++) {
            for (int j = 0; j < noofvariable + 1; j++) {
                nfatable[i][j] =  s.next() ;
            }
        }
        int nooffinalstate = s.nextInt() ;
        ArrayList<String> finalState = new ArrayList<>() ;
        for (int i = 0; i <nooffinalstate ; i++) {
            finalState.add(s.next()) ;
        }
        for (int i = 0; i < noofstate ; i++) {
            for (int j = 0; j < noofvariable + 1; j++) {
                System.out.print(nfatable[i][j] + "   ") ;
            }
            System.out.println();
        }
        nfatodta_convert(nfatable , noofstate , noofvariable , finalState);
    }

    private static void nfatodta_convert(String[][] nfatable ,int noofstate , int noofvariable ,ArrayList<String> finalState) {
        String[][]  dfatable =new  String[(int)Math.pow(2 ,noofstate)][noofvariable + 1] ;
        HashMap<String , Integer> map = new HashMap<>();
        for (int i = 0; i <noofvariable + 1 ; i++) {
            if(!nfatable[0][i].equals("-")) {
                dfatable[0][i] = nfatable[0][i];
            }
            else
            {
                dfatable[0][i] = "X" ;
            }
        }
        map.put(dfatable[0][0] , 1) ;
        int m = 1 , i = 0  ,  j = 1  ;
        while(m!=(int)Math.pow(2 ,noofstate))
        {
            String str = dfatable[i][j];
            if(str==null)
            {
                break;
            }
            if (!map.containsKey(str))
            {
                dfatable[m][0] = str ;
                String strcpy = str ;
                map.put(str  ,1);
                for (int k = 1 ; k < noofvariable + 1 ; k++)
                {
                    String newstate = ""  ;
                    if(str.equals("X"))
                    {
                        newstate = "X" ;
                        str = "" ;
                    }
                    while (str.length()!=0) {
                        String ch = str.charAt(0) + "" ;
                        str =  str.substring(1);
                        for (int l = 0; l < noofstate; l++) {

                              if (nfatable[l][0].equals(ch))
                              {
                                  if (!nfatable[l][k].equals("-")) {
                                      newstate += nfatable[l][k];
                                  }
                                  else
                                  {
                                      newstate +="" ;
                                  }
                              }
                        }
                    }

                    dfatable[m][k] = newstate ;
                    str = strcpy ;
                }
                str = dfatable[m][0] ;
            }
            else
            {
                j++;
                if((j==noofvariable+1))
                {
                    j = 1 ;
                    i++ ;
                }

                continue;
            }
            j++ ;
            if((j==noofvariable+1))
            {
                j = 1 ;
                i++ ;
            }

            m++ ;
        }


        for (int k = 0; k < dfatable.length ; k++) {
            for (int l = 0; l < dfatable[k].length; l++) {
                if (dfatable[k][l]==null)
                {
                    break;
                }
                System.out.print(dfatable[k][l] + "               ") ;
            }
            System.out.println();
        }
        String finalstate = "" ;
        for (int k = 0; k <dfatable.length ; k++) {
            if (dfatable[k][0]==null)
            {
                break;
            }
                for (int l = 0; l <finalState.size() ; l++) {
                if (dfatable[k][0].indexOf(finalState.get(l) , 0)!=-1)
                {
                    finalstate +=dfatable[k][0] + "      " ;
                }
            }
        }
        System.out.println( "final State of dfa     "+ finalstate );

    }
}
