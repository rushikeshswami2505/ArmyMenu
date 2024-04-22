import java.util.*;

public class ArmySelection{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<ArmyCadidate> army = new ArrayList<>();
        while(true){
            System.out.println("\n1. Show all condidates\n"+
                               "2. Add candidate\n"+
                               "3. Delete candidate\n"+
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
                    showCandidates(army);
                    break;
                case 2 : 
                    ArmyCadidate newCandidate = getCadidate();
                    if(newCandidate==null) System.out.println(">>>>>>>>>>Candidate not added because of wrong input");
                    else army.add(newCandidate);
                    break;
                case 3 : break;
                case 4 : return;
            }
        }
    }

    private static void showCandidates(List<ArmyCadidate> army) {
        System.out.println("Sr. Name Age Height Weight");
        for(int i=0;i<army.size();i++){
            System.out.println((i+1)+ ". " +army.get(i).getName()+" "+army.get(i).getAge()+" "+army.get(i).height+" "+army.get(i).getWeight());
        }
    }

    private static ArmyCadidate getCadidate() {
        Scanner sc = new Scanner(System.in);
        ArmyCadidate ac = new ArmyCadidate();
        System.out.print("\nEnter date of birth(DD MM YYYY) : ");
        String dobStr[] = sc.nextLine().split(" ");
        if(dobStr.length!=3) return null;
        int[] dobInt = new int[3];
        for(int i=0;i<3;i++){
            if(!isInteger(dobStr[i])) return null;
            dobInt[i] = Integer.parseInt(dobStr[i]);
        }
        if(isValidDob(dobInt)){
            
        }
        ac.setDob(dobInt);
        System.out.print("\nEnter name : ");
        String name = sc.next();
        if(!isFloat(name) || !isInteger(name)) ac.setName(name);
        else return null;
        System.out.print("\nEnter height : ");
        String height = sc.next();
        if(isFloat(height)) ac.setHeight(Float.parseFloat(height));
        else return null;
        System.out.print("\nEnter weight : ");
        String weight = sc.next();
        if(isFloat(weight)) ac.setHeight(Float.parseFloat(weight));
        else return null;
        return ac;
    }
    private static boolean isFloat(String f){
        if(f.equals("")) return false;
        try{
            float temp = Float.parseFloat(f);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    private static boolean isInteger(String i){
        if(i.equals("")) return false;
        try{
            float temp = Integer.parseInt(i);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}