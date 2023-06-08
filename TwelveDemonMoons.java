import java.util.Scanner;
import java.util.ArrayList;
class Demons {
    private String name;
    private int Hp;
    private String Background;
    public Demons(String name, int Hp, String Background) {
        this.name = name;
        this.Hp = Hp;
        this.Background = Background;
    }
    public String getName() {
        return name;
    }
    public int getHp() {
        return Hp;
    }
    public String getBackground() {
        return Background;
    }
    public void setHp(int Hp) {
        this.Hp = Hp;
    }
}
class Muzan extends Demons{
    private String Alias,Gender;
    private int MBlood;
    public int power;
    Muzan(String name, int Hp[], String Background,int type){
        super(name,Hp[type]/2,Background);
        MBlood = getHp();
        power = (getHp() + MBlood) * 50;
        if(type == 0){
            Alias = "Child";
            Gender = "Male";
        }
        else if(type == 1){
            Alias = "Geisha";
            Gender = "Female";
        }
        else{
            Alias = "The King of Demons";
            Gender = "Male";
        }
    }
    Muzan(String name){
        super(name, 0, "Unknown");
    }
    int Blood(){
        int result = MBlood / 10;
        MBlood -= result;
        power = (getHp() + MBlood) * 50;
        return result;
    }
    void printInfo(){
        System.out.println(getName() + " ( " + Alias + " )");
        System.out.println("Gender : " + Gender);
        System.out.println("HP : " + getHp());
        System.out.println("Blood : " + MBlood);
        System.out.println("Power : " + power);
        System.out.println("Background : " + getBackground());
    }
}
class DemonMoons_UpperRanks extends Muzan{
    public int rank;
    DemonMoons_UpperRanks(String name,int rank,int RBlood){
        super(name);
        this.rank = rank;
        power = rank * RBlood * 50;
        setHp(rank * RBlood * 75);
    }
    void Blood(int B){
        power += B * 50;
        setHp(getHp() + (B * 75));
    }
    void printInfo(){
        System.out.println("Name : " + getName());
        System.out.println("Upper Rank : " + rank);
        System.out.println("Power : " + power);
        System.out.println("HP : " + getHp());
        System.out.println("Background : " + getBackground());
    }
}
class DemonMoons_LowerRanks extends Muzan{
    public int rank;
    DemonMoons_LowerRanks(String name,int rank,int RBlood){
        super(name);
        this.rank = rank;
        power = rank * RBlood * 25;
        setHp(rank * RBlood * 50);
    }
    void Blood(int B){
        power += B * 25;
        setHp(getHp() + (B * 50));
    }
    void printInfo(){
        System.out.println("Name : " + getName());
        System.out.println("Lower Ranks : " + rank);
        System.out.println("Power : " + power);
        System.out.println("HP : " + getHp());
        System.out.println("Background : " + getBackground());
    }
}
public class TwelveDemonMoons {
    private static ArrayList<Muzan> DemonMoons = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int hp[] = new int[3];
        for(int i=0;i<3;i++){
            hp[i] = sc.nextInt();
        }
        String t = sc.nextLine();
        String bg = sc.nextLine();
        int type = sc.nextInt();
        Muzan muzun = new Muzan(name, hp, bg, type);
        for (;;) {
            int type_demon = sc.nextInt();
            if (type_demon == 0) {
                break;
            } else if (type_demon > 0) {
                String n = sc.next();
                int rank = sc.nextInt();
                int blood = muzun.Blood();
                Muzan upper = new DemonMoons_UpperRanks(n, rank, blood);
                DemonMoons.add(upper);
            } else {
                String n = sc.next();
                int rank = sc.nextInt();
                int blood = muzun.Blood();
                Muzan lower = new DemonMoons_LowerRanks(n, rank, blood);
                DemonMoons.add(lower);
            }
        }
        int com = sc.nextInt();
        for (int i = 0; i < com; i++) {
            int id = sc.nextInt() - 1;
            int blood = muzun.Blood();
            if (DemonMoons.get(id) instanceof DemonMoons_UpperRanks) {
                DemonMoons_UpperRanks up = (DemonMoons_UpperRanks) DemonMoons.get(id);
                up.Blood(blood);
                DemonMoons.set(id, up);
            } else if (DemonMoons.get(id) instanceof DemonMoons_LowerRanks) {
                DemonMoons_LowerRanks low = (DemonMoons_LowerRanks) DemonMoons.get(id);
                low.Blood(blood);
                DemonMoons.set(id, low);
            }
        }
        muzun.printInfo();
        for (Muzan x : DemonMoons) {
            if (x instanceof DemonMoons_UpperRanks) {
                DemonMoons_UpperRanks up = (DemonMoons_UpperRanks) x;
                up.printInfo();
            } else if (x instanceof DemonMoons_LowerRanks) {
                DemonMoons_LowerRanks low = (DemonMoons_LowerRanks) x;
                low.printInfo();
            }
        }
    }
}