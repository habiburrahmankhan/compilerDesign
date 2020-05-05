import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class firstFollow {
    public static void main(String[] args) throws FileNotFoundException {
        hrkhan();
        File file = new File("first.txt");
        Scanner s = new Scanner(file) ;
        int non_terminal = Integer.parseInt(s.nextLine());

        HashMap<String , String[]> map = new HashMap<>();
        String[] terminal = new String[non_terminal];
        for (int i = 0; i <non_terminal ; i++) {
             String str = s.nextLine();
             String[] str_split = str.split("-->" );
             String[] terminal_str = str_split[1].split("/");
            //System.out.println(Arrays.toString(terminal_str));
            map.put(str_split[0] , terminal_str) ;
            terminal[i] = str_split[0];
        }
        HashMap<String , ArrayList<String> >  first = new HashMap<>();
        HashMap<String , ArrayList<String> >  follow = new HashMap<>();
        System.out.println("First of All non-Terminal  ");
        first_func(map , first,terminal);
        System.out.println("Follow of all non-Terminal ");
        follow_func(map ,first ,terminal , follow);
    }

    public static void follow_func(HashMap<String, String[]> map, HashMap<String, ArrayList<String>> first, String[] terminal, HashMap<String, ArrayList<String>> follow) {
        for (int i = 0; i <terminal.length ; i++) {
            String str = terminal[i] ;
            int j = 0 ;

            ArrayList<String> follow_str = new ArrayList<>();
            if(i==0)
            {
                follow_str.add("$") ;
            }
            for (int k = 0; k <map.size(); k++) {
                String st[]  = map.get(terminal[k]);
                for (int l = 0; l <st.length ; l++) {
                    if(st[l].contains(terminal[i]))
                    {
                        int m = st[l].indexOf(terminal[i] , 0 );
                        if(m + 1< st[l].length())
                        {
                            if (map.containsKey(st[l].charAt(m+1) + ""))
                            {
                                if(!map.get(terminal[k]).equals(st[l].charAt(m+1) + ""))
                                {
                                    ArrayList<String>  ft = first.get(st[l].charAt(m+1) + "") ;
                                    for (String sttt:ft) {
                                        if (!follow_str.contains(sttt)) {
                                            if (sttt.equals("#"))
                                            {
                                                ArrayList<String>  ff = follow.get(terminal[k]);
                                                for (String epl:ff) {
                                                    if (!follow_str.contains(epl)) {
                                                        follow_str.add(epl);
                                                    }
                                                }
                                            }
                                            else
                                            {
                                                follow_str.add(sttt);
                                            }

                                        }
                                    }
                                }
                            }
                            else
                            {
                                follow_str.add(st[l].charAt(m+1) + "") ;
                            }
                        }
                        else
                        {
                            if (map.containsKey(st[l].charAt(m) + ""))
                            {
                                if(!terminal[k].equals(st[l].charAt(m) + ""))
                                {
                                    ArrayList<String>  ft = follow.get(terminal[k]);
                                    for (String sttt:ft) {
                                        if (!follow_str.contains(sttt)) {
                                            follow_str.add(sttt);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }

            follow.put(terminal[i] , follow_str) ;
            System.out.println("follow ( " + terminal[i] + " )    =     " + follow_str);
        }

    }


    private static void hrkhan() {
        System.out.println("\nName :- Habiburrahman \nRollno 17BCS071 \nB-Tech Computer Engineering \n");
    }

    public static void first_func(HashMap<String, String[]> map, HashMap<String, ArrayList<String>> first, String[] terminal){
        for (int i = 0; i <terminal.length ; i++) {
            String str = terminal[i];
            ArrayList<String> first_str = new ArrayList<>();
            String[] st = map.get(str);
            int j = 0 ;
            while(j < st.length)
            {
                if(map.containsKey(st[j].charAt(0) + ""))
                {
                    st = map.get(st[j].charAt(0) + "") ;
                }
                else
                {
                    first_str.add(st[j].charAt(0) + "");
                    j++ ;
                }
            }
            st = map.get(str);
            first.put(terminal[i] , first_str) ;
        }

        for (int i = 0; i <first.size() ; i++) {
            System.out.println("first( " +terminal[i] + " )   =       "  + first.get(terminal[i]));
        }
    }
}
//E-->TR
//        R-->+TR/#
//        T-->FY
//        Y-->*FY/#
//        F-->(E)/i