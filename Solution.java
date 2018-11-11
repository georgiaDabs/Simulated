import java.util.ArrayList;
import java.util.Random;
public class Solution
{
    ArrayList<Integer> tour;
    private int size;
    public Solution(int size){
        this.size=size;
        tour=new ArrayList<Integer>();
        Random rand=new Random();
        while(tour.size()!=size){
            int n=rand.nextInt(size);
            if(!tour.contains(n)){
                tour.add(n);
            }
        }
    }
    public Solution(Solution s){
        //System.out.println("size passed:"+s.getSize());
        Random rand=new Random();
        int index1=rand.nextInt(s.getSize());
        int index2=index1;
        while(index2==index1){
            index2=rand.nextInt(s.getSize());
        }
        tour=new ArrayList<Integer>();
        for(int i=0;i<s.getTour().size();i++){
            if(i==index1){
                tour.add(s.getTour().get(index2));
            }else if(i==index2){
                tour.add(s.getTour().get(index1));
            }else{
                tour.add(s.getTour().get(i));
            }
        }
        this.size=s.getSize();
    }
    public int getCost(int[][] array){
        int cost=0;
        for(int i=0;i<tour.size()-1;i++){
            cost+=array[tour.get(i)][tour.get(i+1)];
        }

        cost+=array[tour.get(tour.size()-1)][tour.get(0)];
        return cost;
    }
    public int getSize(){
        return size;
    }
    public ArrayList<Integer> getTour(){
        return tour;
    }
    public void printTour(){
        System.out.println(tour);
    }
}
