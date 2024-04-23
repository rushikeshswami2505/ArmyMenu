package IndianArmy;
import java.time.LocalDate;
import AgeCalculator.*;

public class ArmyCadidate {
    AgeController ageController = new AgeController();
    private int[] dob;
    private String name;
    private float height;
    private float weight;

    private int age;
    private String status; 

    public ArmyCadidate() {
    }

    public ArmyCadidate(int[] dob, String name, float height, float weight) {
        this.dob = dob;
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getHeight() {
        return height;
    }
    public void setHeight(float height) {
        this.height = height;
    }
    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        if(age!=0) this.age = ageController.MyAge(dob[0],dob[1],dob[2]);
    }
    public int[] getDob() {
        return dob;
    }

    public void setDob(int[] dob) {
        this.dob = dob;
        if(age!=0) this.age = ageController.MyAge(dob[0],dob[1],dob[2]);
    }
    
    @Override
    public String toString() {
        updateStatus();
        if(age!=0) this.age = ageController.MyAge(dob[0],dob[1],dob[2]);
        return "ArmyCadidate [age=" + age + ", name=" + name + ", height=" + height + ", weight=" + weight + ", status="
                + status + "]";
    }

    public String getStatus() {
        updateStatus();
        return status;
    }
    public void updateStatus(){
        if(age>18 && age<30 && height>=6 && weight>=50 && weight<=70) this.status = "Selected";
        else this.status = "Rejected";
    }
}