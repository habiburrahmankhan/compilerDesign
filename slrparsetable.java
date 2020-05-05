import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class slrparsetable {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("slr") ;
        hrkhan();
        Scanner s = new Scanner(file);
        HashMap<String , String[]> map = new HashMap<>();
        HashMap<String , HashMap<String , String[]>> collectall = new HashMap<>();
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
        String[] ss = new String[1];
        ss[0] = non_terminal[0];
        map.put((char)'Z' +"",ss );
        diagram(map , non_terminal , collectall);
    }

    private static void diagram(HashMap<String, String[]> map, String[] non_terminal, HashMap<String, HashMap<String, String[]>> collectall) {
        String str = map.get("Z")[0];
        Queue<String> que = new LinkedList<>();
            HashMap<String , String[]> I = new HashMap<>();

            que.add(str);
            I.put(str , map.get(str));
            while (que.isEmpty())
            {
                str = que.remove();
                I.put(str , map.get(str));
                for (String st : map.get(str))
                {
                    for (int i = 0; i < st.length(); i++) {
                        que.add(st.charAt(i)+"");
                    }
                }
            }
    }

    private static void hrkhan() {
        System.out.println("\nName :- Habiburrahman \nRollno 17BCS071 \nB-Tech Computer Engineering \n");
    }
}
