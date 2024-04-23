package IndianArmy;
import AgeCalculator.*;
import java.util.*;
import java.time.LocalDate;


public class ArmyController {
    List<ArmyCadidate> army;

    public ArmyController(List<ArmyCadidate> army) {
        this.army = army;
    }

    public void showCandidates() {
        System.out.println("______________________________________________________________________");
        System.out.println("| Sr.  |       Name       |  Age  |  Height  |  Weight  |  Status     ");
        for(int i=0;i<army.size();i++){
            String name = army.get(i).getName();
            for(int j=name.length();j<20;j+=2) name = " "+name+" ";
            System.out.println("| "+(i+1)+
            "    " +name+
            "  "+army.get(i).getAge()+
            "      "+army.get(i).getHeight()+
            "        "+army.get(i).getWeight()+
            "      "+army.get(i).getStatus()+"    ");
        }
        System.out.println("______________________________________________________________________");
    }

    public void getCadidate() {
        ArmyCadidate am =  addCandidate();
        if(am==null) System.out.println(">>>>>>>>>>Candidate not added because of wrong input");
        else{    
            System.out.println(am.toString());
            System.out.println(">>>>>>>>>>New candidate added");
        }
    }
    

    private ArmyCadidate addCandidate() {
        Scanner sc = new Scanner(System.in);
        ArmyCadidate ac = new ArmyCadidate();
        AgeController ageController = new AgeController();

        System.out.print("Enter date of birth(DD MM YYYY) : ");
        String dobStr[] = sc.nextLine().split(" ");
        if(dobStr.length!=3) return null;
        int[] dobInt = new int[3];
        for(int i=0;i<3;i++){
            if(!isInteger(dobStr[i])) return null;
            dobInt[i] = Integer.parseInt(dobStr[i]);
        }
        if(!ageController.validDate(dobInt[0],dobInt[1],dobInt[2])) return null;
        ac.setDob(dobInt);
        System.out.print("Enter name : ");
        String name = sc.next();
        if(!isFloat(name) || !isInteger(name)) ac.setName(name);
        else return null;
        System.out.print("Enter height : ");
        String height = sc.next();
        if(isFloat(height)) ac.setHeight(Float.parseFloat(height));
        else return null;
        System.out.print("Enter weight : ");
        String weight = sc.next();
        if(isFloat(weight)) ac.setWeight(Float.parseFloat(weight));
        else return null;
        army.add(ac);
        return ac;
    }

    public static boolean isFloat(String f){
        if(f.equals("")) return false;
        try{
            float temp = Float.parseFloat(f);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public static boolean isInteger(String i){
        if(i.equals("")) return false;
        try{
            float temp = Integer.parseInt(i);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public void removeCandidate() {
        showCandidates();
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter sr number of the candidate : ");
        int sr = sc.nextInt();
        System.out.println("Candidate removed: "+army.get(sr-1).toString());
        army.remove(sr-1);
        // sc.close();
    }
}
