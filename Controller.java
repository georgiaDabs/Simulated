
public class Controller
{
    public Controller(String link){
        
        
        Search first=new Search(link);
        Solution bestSol=first.getBest();
        int cost=first.getBestCost();
        for(int i=0;i<1000;i++){
            Search current=new Search(link);
            if(current.getBestCost()<cost){
                bestSol=current.getBest();
                cost=current.getBestCost();
            }
        }
        System.out.println("best tour");
        bestSol.printTour();
        System.out.println("cost:"+cost);
    }
    public static void main(String[] args){
        String link="J:/SearchFiles/SearchFile535.txt";
        System.out.println(link);
        for(int i=0;i<10;i++){
            new Controller(link);
        }
    }
}
