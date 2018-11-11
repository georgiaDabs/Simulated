import java.util.Random;
public class Anneal
{
    private double temp;
    private Solution best;
    private int cost;
    public Anneal(int[][] array,double temp,double minTemp,double alpha){
        this.temp=temp;
         Solution solution=new Solution(array);
         
         best=solution;
         cost=solution.getCost(array);
         //System.out.println("---------------Solution1------------------");
         //solution.printTour();
         Random rand=new Random();
         while(temp>minTemp){
            Solution newSolution=new Solution(solution);
            //System.out.println("-------------NEW SOLUTION-----------------");
            if(newSolution.getCost(array)<solution.getCost(array)){
                if(newSolution.getCost(array)<cost){
                    best=newSolution;
                    cost=newSolution.getCost(array);
                }
                solution=newSolution;
                
            }else{
                double a=Math.exp(((double)solution.getCost(array)-(double)newSolution.getCost(array))/(double)temp);
                double r=rand.nextDouble();
                if(a>r){
                    solution=newSolution;
                }
            
            }
            temp=temp*alpha;
            }
    }
    public Solution getBest(){
        return best;
    }
}
