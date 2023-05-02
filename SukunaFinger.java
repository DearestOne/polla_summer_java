import java.util.Scanner;
public class SukunaFinger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sukuna_left = 0;
        int sukuna_right = 0;
        int jubutsu = 0;
        for(;;){
            int power_curse = scan.nextInt();
            if(power_curse <= 0){
                break;
            }
            else if(power_curse >= 100 && power_curse < 1000 && sukuna_left + sukuna_right < 20){
                int current = 0;
                for(int i=0;i<3;i++){
                    current += power_curse % 10;
                    power_curse = power_curse / 10;
                }
                if(current >= 10){
                    current = (current % 10) + (current / 10);
                }

                if(current % 2 == 0){
                    sukuna_right++;
                }
                else{
                    sukuna_left++;
                }
            }
            else{
                System.out.println("JUBUTSU !");
                jubutsu++;
            }
        }
        // print
        System.out.println("Sukuna's right finger " + sukuna_right);
        System.out.println("Sukuna's left finger " + sukuna_left);
        System.out.println("Sukuna's finger " + (sukuna_left+sukuna_right));
        System.out.println("jubutsu " + jubutsu);
    }
}