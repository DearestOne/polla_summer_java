import java.util.Scanner;

class HumanCharacters {
    String name, age, Abilities, Personality, Background;
    boolean isdead;

    HumanCharacters(String name, String age, boolean isdead, String Abilities, String Personality, String Background) {
        this.name = name;
        this.age = age;
        this.isdead = isdead;
        this.Abilities = Abilities;
        this.Personality = Personality;
        this.Background = Background;
    }
}

class GodCharacters {
    String name, Legend, Abilities, Personality, Background;
    Scanner scan;

    GodCharacters(Scanner scan) {
        this.scan = scan;
        name = scan.next();
        Legend = scan.nextLine();
        Legend = Legend.substring(2, Legend.length()-1);
        Abilities = scan.nextLine();
        Personality = scan.nextLine();
        Background = scan.nextLine();
    }
}

public class RecordofRagnarok {
    private static void battleROR(HumanCharacters hC, GodCharacters gC, int round) {
        System.out.println("<>---------- Record of Ragnarok ----------<>");
        System.out.println("<< { --------- ROUND ( " + round + " ) --------- } >>");
        System.out.println("<<==== GOD ====>>");
        System.out.println("Name : " + gC.name);
        System.out.println("Legend : [ " + gC.Legend + " ]");
        System.out.println("- Abilities: " + gC.Abilities);
        System.out.println("- Personality: " + gC.Personality);
        System.out.println("- Background: " + gC.Background);
        System.out.println("VS");
        System.out.println("<<==== HUMAN ====>>");
        System.out.println("Name : " + hC.name);
        System.out.print("Age : " + hC.age);
        if (hC.isdead) {
            System.out.println(" at death");
        } else {
            System.out.println("");
        }
        System.out.println("- Abilities: " + hC.Abilities);
        System.out.println("- Personality: " + hC.Personality);
        System.out.println("- Background: " + hC.Background);
        System.out.println("<< { --------- ROUND ( " + round + " ) --------- } >>");
        System.out.println("<>---------- Record of Ragnarok ----------<>");
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int round = sc.nextInt();
        String t = sc.nextLine();
        HumanCharacters hC[] = new HumanCharacters[round];
        GodCharacters gC[] = new GodCharacters[round];
        for (int i = 0; i < round; i++) {
            String Age = null;
            boolean Death = false;
            String tmp1[] = sc.nextLine().split("Age: ");
            String Name = tmp1[0].substring(0, tmp1[0].length() - 2);
            if (tmp1[1].indexOf(" at death") > 0) {
                Death = true;
                Age = tmp1[1].substring(0, 2);
            } else if (tmp1[1].indexOf("Unknown") >= 0) {
                Age = "Unknown";
            } else {
                Age = tmp1[1].substring(0, 2);
            }
            String Abilities = sc.nextLine();
            String Personality = sc.nextLine();
            String Background = sc.nextLine();
            hC[i] = new HumanCharacters(Name, Age, Death, Abilities, Personality, Background);
        }
        for (int i = 0; i < round; i++) {
            gC[i] = new GodCharacters(sc);
        }
        int count = 1;
        for (;;) {
            int h = sc.nextInt();
            int g = sc.nextInt();
            boolean booH = true;
            boolean booG = true;
            if (h < 0 || h >= round) {
                booH = false;
            }
            if (g < 0 || g >= round) {
                booG = false;
            }
            if (booH == true && booG == true) {
                battleROR(hC[h], gC[g], count);
                count++;
            } else {
                break;
            }
        }
    }
}