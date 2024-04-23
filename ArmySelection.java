package IndianArmy;
import java.util.*;

public class ArmySelection{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArmyController army = new ArmyController(new ArrayList<ArmyCadidate>());
        System.out.println("###############################################################################");
        System.out.println("########################### Army Selection process ############################");
        System.out.println("###############################################################################");
        while(true){
            System.out.println("\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.println("\n1. Show all condidates\n"+
                               "2. Add candidate\n"+
                               "3. Remove candidate\n"+
                               "4. Close");
            System.out.print("Please select any option from the below : ");
            String choiceStr = sc.next();
            if(choiceStr.length()!=1 || choiceStr.charAt(0)-'0'<=0 || choiceStr.charAt(0)-'0'>4){
                System.err.println(">>>>>>>>>>Please enter valid input");
                continue;
            }
            int choice = choiceStr.charAt(0)-'0'; 
            switch(choice){
                case 1 : 
                    army.showCandidates();
                    break;
                case 2 : 
                    army.getCadidate();
                    break;
                case 3 : 
                    army.removeCandidate();
                    break;
                case 4 :    
                    sc.close();
                    return;
            }
        }
    }
}