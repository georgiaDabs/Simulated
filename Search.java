import java.io.*;
import java.util.*;
public class Search
{
    private int[][]array;
    private int cost;
    private Solution best;
   public Search(String link){
    int size=0;
      try{
        File file=new File(link);
        Scanner sc=new Scanner(file);
        sc.nextLine();
        sc.next();
        sc.next();
        String s=sc.next();
        s=s.replaceAll(",$","");
        
         size=Integer.parseInt(s);
        array=new int[size][size];
        boolean running =true;
        List<Integer> numbers=new ArrayList<Integer>();
        while(running){
            if(sc.hasNext()){
                String next=sc.next();
                String[] values=next.split(",");
                for(String str: values){
                    //System.out.println(str);
                    str=str.replaceAll("[^0-9]","");
                    numbers.add(Integer.parseInt(str));
                }
            }else{running=false;}
        }
      //  System.out.println(numbers);
        //System.out.println("size:"+size);
        for (int i=0;i<size;i++){
            for(int j=i;j<size;j++){
                if(i!=j){
                    array[i][j]=numbers.get(0);
                    array[j][i]=array[i][j];
                    numbers.remove(0);
                }
            }
        }
     /*   for(int[] row:array){
            for(int i: row){
                System.out.print(","+i);
            }
            System.out.println(" ");
        }*/
    }catch(IOException e){
        System.out.println("file not found");
    }
    Anneal a=new Anneal(array,1.0,0.00001,0.9);
    best=a.getBest();
    //best.printTour();
    cost=best.getCost(array);
   // System.out.println("cost:"+cost);
    }
    public Solution getBest(){
        return best;
    }
    public int getBestCost(){
        return cost;
    }
}
