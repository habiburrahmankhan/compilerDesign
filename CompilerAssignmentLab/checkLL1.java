import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class checkLL1 {
    public static void main(String[] args) throws FileNotFoundException {
        hrkhan();
        File file = new File("cfg");
        Scanner s = new Scanner(file) ;
        HashMap<String , String[]> map = new HashMap<>();
        HashMap<String , String[]> leftRecursion = new HashMap<>();
        HashMap<String , String[]> leftFactoring = new HashMap<>();

        int i =0  ;
        while (s.hasNextLine())
        {
            String str = s.nextLine() ;
            String[] str_split = str.split("-->" );
            String[] terminal_str = str_split[1].split("/");
            //System.out.println(Arrays.toString(terminal_str));
            map.put(str_split[0] , terminal_str) ;
        }
        String[] non_terminal = new String[map.size()];
        for (String str: map.keySet()
             ) {
            non_terminal[i++] = str ;
        }

        boolean lr = checkLeftRecursion(map , non_terminal , leftRecursion);
        boolean lf = checkLeftfactoring(map , non_terminal , leftFactoring);
        if (lr && lf)
        {
            System.out.println("CFG is valid for LL1");
        }
        else
        {
            System.out.println("CFG is Not  valid for LL1");
            System.out.println("the CFG suitable for LL parsing ");
        }
        for (String st : map.keySet()) {
            System.out.print(st + " --> ");
            for (String ss : map.get(st)) {
                System.out.print(ss + " / ");
            }
            System.out.println();
        }
    }

    private static boolean checkLeftfactoring(HashMap<String, String[]> map, String[] non_terminal, HashMap<String, String[]> leftFactoring) {
       int w = (int) 'W';

        HashMap<String , Boolean> del = new HashMap<>();
        for (String str: map.keySet()) {
            String stt = map.get(str)[0];
                for (int i = 1; i < map.get(str).length; i++) {
                       stt =  commonPrefix(stt , map.get(str)[i]);
                }
                String alpha = stt.length()!=map.get(str)[0].length() ? stt:"";
                if (alpha.length()!=0)
                {
                    del.put(str , true);
                    ArrayList<String> beeta = new ArrayList<>();
                    ArrayList<String> gamma = new ArrayList<>();
                    for (int i = 0; i <map.get(str).length ; i++) {
                        if (map.get(str)[i].contains(alpha))
                        {
                            int m = map.get(str)[i].indexOf(alpha , 0);
                            beeta.add(map.get(str)[i].substring(m+1));
                        }
                        else
                        {
                            gamma.add(map.get(str)[i]);
                        }
                    }
                    String[] beeta_ = new String[beeta.size()];
                    String[] gamma_ = new String[gamma.size() + 1 ];
                    gamma_[0] = alpha + (char)w ;
                    for (int j = 1; j < gamma_.length; j++) {
                        gamma_[j] = gamma.get(j-1);
                    }

                    for (int j = 0; j <beeta.size() ; j++) {
                        beeta_[j] = beeta.get(j);
                    }
                    leftFactoring.put(str , gamma_ );
                    leftFactoring.put((char)w+""  , beeta_);

                    w++;
                }
        }

        for (String de:del.keySet()) {
            if (map.containsKey(de))
            {
                map.remove(de);
            }
        }
        for (String sr : leftFactoring.keySet()) {
            map.put(sr , leftFactoring.get(sr));
        }
            if (del.size()==0)
            {
                System.out.println("No Factoring (Non - Deterministic Grammar) in the production After Left Recursion removing  ");
                return true;
            }
            else
            {
                return false ;
            }
    }
    static String commonPrefix(String str1, String str2) {
        String result = "";
        int n1 = str1.length(), n2 = str2.length();
        if (str1.charAt(0)!=str2.charAt(0))
            return str1 ;
        // Compare str1 and str2
        for (int i = 0, j = 0; i <= n1 - 1 && j <= n2 - 1; i++, j++) {
            if (str1.charAt(i) != str2.charAt(j)) {
                break;
            }
            result += str1.charAt(i);
        }

        return (result);
    }

    private static boolean checkLeftRecursion(HashMap<String, String[]> map, String[] non_terminal , HashMap<String , String[]> leftRe) {
        int p = 80 ;
        HashMap<String , Boolean> del = new HashMap<>();
        for (String str: map.keySet()) {
            for (int i = 0; i < map.get(str).length ; i++) {
                if(map.get(str)[i].charAt(0) == str.charAt(0))
                {
                    System.out.println(" Left Recursion found in the production " +str +"-->"  + Arrays.toString(map.get(str)));
                    del.put(str , true);
                    ArrayList<String> alpha = new ArrayList<>();
                    ArrayList<String> beeta = new ArrayList<>();
                    for (String ab:map.get(str)) {
                        if (ab.charAt(0) == str.charAt(0))
                        {
                            alpha.add(ab.substring(1));
                        }
                        else
                        {
                            beeta.add(ab);
                        }
                    }
                    String[] beeta_ = new String[beeta.size()];
                    String[] alpha_ = new String[alpha.size() + 1];
                    for (int j = 0; j <beeta.size() ; j++) {
                        beeta_[j] = beeta.get(j)+(char)p;
                    }

                    for (int j = 0; j <alpha.size() ; j++) {
                        alpha_[j] = alpha.get(j)+(char)p;
                    }
                    alpha_[alpha.size()] = "#" ;
                    leftRe.put(str,beeta_);
                    leftRe.put((char)p + "" ,alpha_ ) ;
                    p++;
                }
                break;
            }

        }
        for (String de:del.keySet()) {
            if (map.containsKey(de))
            {
                map.remove(de);
            }
        }
        for (String sr : leftRe.keySet()) {
            map.put(sr , leftRe.get(sr));
        }
        if (del.size()==0)
        {
            System.out.println("No Left Recursion in the production ");
            return true;
        }
        else
        {
            return false ;
        }

    }


    private static void hrkhan() {
        System.out.println("\nName :- Habiburrahman \nRollno 17BCS071 \nB-Tech Computer Engineering \n");
    }

}
