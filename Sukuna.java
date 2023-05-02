import java.util.Scanner;
public class Sukuna {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] max_box = new int[n];
        int[] current_box = new int[n];
        for(int i=0;i<n;i++){
            max_box[i] = scan.nextInt();
        }
        int sukuna_left = 0;
        int sukuna_right = 0;
        int jubutsu = 0;
        int all_finger = 0;
        for(;;){
            int power_curse = scan.nextInt();
            if(power_curse <= 0){
                break;
            }
            int box_number = scan.nextInt();
            if(power_curse >= 100 && power_curse < 1000 && all_finger < 20){
                all_finger++;
                int current = 0;
                for(int i=0;i<3;i++){
                    current += power_curse % 10;
                    power_curse = power_curse / 10;
                }
                if(current >= 10){
                    current = (current % 10) + (current / 10);
                }
                if(box_number > 0 && box_number <= n && current_box[box_number-1] < max_box[box_number-1]){
                    if(current % 2 == 0){
                        sukuna_right++;
                    }
                    else{
                        sukuna_left++;
                    }
                    current_box[box_number-1]++;
                    System.out.println("OK !");
                }
                else{
                    System.out.println("SUKUNA !");
                }
            }
            else{
                System.out.println("JUBUTSU !");
                jubutsu++;
            }
        }
        for(int i=0;i<n;i++){
            System.out.println((i+1) + " " + current_box[i]);
        }
        System.out.println(jubutsu);
    }
}
