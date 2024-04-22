public class ArmyCadidate {

    int age;
    int[] dob;
    String name;
    float height;
    float weight;

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
    }
    public int[] getDob() {
        return dob;
    }

    public void setDob(int[] dob) {
        this.dob = dob;
    }
}
