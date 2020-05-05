import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class leaderBasicBlocks {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("leaderbasicblockinput") ;
        hrkhan();
        Scanner s = new Scanner(file);
        HashMap<Integer , String>  input = new HashMap<>();
        HashMap<Integer , String>  leader = new HashMap<>();
        HashMap<Integer , ArrayList<String>>  basic = new HashMap<>();
        int i  =1 ;
        while (s.hasNextLine())
        {
            String str = s.nextLine() ;
            input.put(i++ , str);
        }
        leader_func(input, leader);
        basicblocksfunc(input , leader , basic);
    }

    private static void basicblocksfunc(HashMap<Integer, String> input, HashMap<Integer, String> leader, HashMap<Integer, ArrayList<String>> basic) {
                  Set<Integer> linenos = leader.keySet() ;
                  int[]   lineno = new int[linenos.size()];
                  int j = 0 ;
        for (int i : linenos) {
            lineno[j] = i ;
            j++;
        }
        Arrays.sort(lineno);
        j = 1;
        for (int i = 0; i <lineno.length-1; i++) {
            ArrayList<String>  basicstr = new ArrayList<>();
            for (int k = lineno[i]; k <lineno[i+1]; k++) {
                  basicstr.add(input.get(k));
            }
            basic.put(j++ , basicstr);
        }
        ArrayList<String>  basicstr = new ArrayList<>();
        for (int k = lineno[lineno.length -1 ]; k < input.size()+1; k++) {
            basicstr.add(input.get(k));
        }
        basic.put(j++ , basicstr);
        for (int i : basic.keySet()) {
            ArrayList<String>  showoutput =  basic.get(i) ;
            System.out.println("Basic blocks  no " + i + "    ");
            for (String st:
                 showoutput) {
                System.out.println(st);
            }
        }
    }


    private static void leader_func(HashMap<Integer, String> input, HashMap<Integer, String> leader) {
        leader.put(1 , input.get(1)) ;
        for (int i = 1; i <=input.size(); i++) {
            if (input.get(i).contains("goto"))
            {
                int m  = input.get(i).indexOf("(");
                int n   = input.get(i).indexOf(")");
                int line_no = Integer.parseInt(input.get(i).substring(m+1 , n));
                leader.put(line_no , input.get(line_no));
                if (input.containsKey(i+1) )
                {
                    leader.put(i+1, input.get(i+1));
                }
            }
        }
        for (int i : leader.keySet()) {
            System.out.println("leaders line no " + i + "    " + leader.get(i));
        }
    }
    private static void hrkhan() {
        System.out.println("\nName :- Habiburrahman \nRollno 17BCS071 \nB-Tech Computer Engineering \n");
    }
}
