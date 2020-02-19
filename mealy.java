import java.io.* ;
import java.util.Scanner;

public class mealy {
    public static void main(String[] args) throws Exception{
        File input_program_mealy = new File("/Users/habiburrahmankhan/Desktop/hrkhan/sem6/compilerDesign/input_mealy");
        Scanner s = new Scanner(input_program_mealy);
        String table[][] = new String[4][5];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j <table[i].length ; j++) {
                table[i][j] = s.next();
            }
        }
        table_print(table);
        String str = s.next() ;
        for (int i = 0; i <str.length() ; i++) {
            if (!(str.charAt(i)=='1' || str.charAt(i)=='0'))
            {
                System.out.println("the String is Wrong ");
                return;
            }
        }
        int k = 0 , m = 0 , n = 0 ;
        String finalAnswer = "" , initial_str = "q1" , state = "q1 ---" ;

        while(k < str.length())
        {
            for (int i = 0; i <table.length ; i++) {
                if (initial_str.equals(table[i][0]))
                {
                    m = i ;
                    break;
                }
            }
            if (str.charAt(k)=='0')
            {
               finalAnswer +=table[m][2] ;
               initial_str = table[m][1] ;
               state+="0---> " + initial_str + " ( "+table[m][2]  + " ) -----" ;
            }
            else
            {
                initial_str = table[m][3] ;
                finalAnswer +=table[m][4] ;
                state+="1---> " + initial_str + " ( "+table[m][4] + " )  ---- " ;
            }
            k++ ;
        }
        if (!(initial_str.equals("q3") || initial_str.equals("q4")) )
        {
            System.out.println("final State does Not Match");
            return ;
        }
        System.out.println("the final state is : - " +initial_str);
        System.out.println("the final outPut of string  is : - " + finalAnswer);
        System.out.println("State :-    " + state);

    }

    private static void table_print(String[][] table) {
System.out.println("CS     d(q ,0)      lamda(q,0)       d(q ,1)       lamda(q,1)");
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j <table[i].length ; j++) {
                System.out.print(table[i][j] +  "            ");
            }
            System.out.println();
        }
    }
}
