import java.util.* ;
import java.io.* ;

public class mooretomealy
{
	public static void main(String[] args) throws Exception {
		
        File file = new File("moore_to_mealy.txt");
		Scanner s = new Scanner(file) ;
		String no_of_State = s.next() ; 
		int m = Integer.parseInt(no_of_State) ; 
		String table[][] = new String[m][4];
		for (int i = 0;i< table.length ; i++) {
			for (int j = 0 ;j<table[i].length ;j++ ) {
				  table[i][j]  = s.next() ;
			}
		}
    
        System.out.println("Moore Table "); 
        System.out.println("Present State     a =   0	     a =   1       output  ");
		for (int i = 0;i< table.length ; i++) {
			for (int j = 0 ;j<table[i].length ;j++ ) {
				 System.out.print(table[i][j] +  "		") ;
			}
			System.out.println();
		}


		moore_to_mealy_convert(table) ; 
	}
   public static void moore_to_mealy_convert(String table[][])
   {
   	  String mealyTable[][] = new String[table.length][5]; 
      HashMap<String , String > map = new HashMap<>() ; 
      for (int i =0 ;i < table.length ; i++) {
      	  map.put(table[i][0] , table[i][3]) ; 
      }

   	  for(int i =0 ; i < mealyTable.length ; i++)
   	  {
   	  	  mealyTable[i][0]  = table[i][0] ; 
   	  	  mealyTable[i][1] = table[i][1] ; 
   	  	  mealyTable[i][3]  = table[i][2] ; 
   	  	  String str = table[i][1] ; 
   	  	  if(map.get(str).equals("0"))
   	  	  {
   	  	  	mealyTable[i][2] = "0" ;
   	  	  }

   	  	  if(map.get(str).equals("1"))
   	  	  {
   	  	  	mealyTable[i][2] = "1" ;
   	  	  }
           
           str = table[i][2] ;
          if(map.get(str).equals("0"))
   	  	  {
   	  	  	mealyTable[i][4] = "0" ;
   	  	  }

   	  	  if(map.get(str).equals("1"))
   	  	  {
   	  	  	mealyTable[i][4] = "1" ;
   	  	  }


   	  }

       System.out.println("Mealy Table "); 
        System.out.println("Present State     a =   0	 output       a =   1       output  ");
		for (int i = 0;i< mealyTable.length ; i++) {
			for (int j = 0 ;j<mealyTable[i].length ;j++ ) {
				 System.out.print(mealyTable[i][j] +  "		") ;
			}
			System.out.println();
		}
     






   }
}