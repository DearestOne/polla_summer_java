import java.util.Scanner;
public class GetoSuguru {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] current_box = new int[n];
        int[] box_power = new int[n];
        int geto_max_power = scan.nextInt();
        int geto_current_power = 0;
        for(;;){
            int power = scan.nextInt();
            if(power % 7 == 0 || power % 11 == 0){
                break;
            }
            int box_number = scan.nextInt();
            if(box_number > 0 && box_number <= n && power + geto_current_power <= geto_max_power){
                System.out.println("EAT IT");
                current_box[box_number-1]++;
                box_power[box_number-1] += power;
                geto_current_power += power;
            }
            else{
                System.out.println("VOMIT");
            }
        }
        System.out.println(geto_current_power);
        for(int i=0;i<n;i++){
            System.out.println((i+1) + " " + current_box[i] + " " +  box_power[i]);
        }
    }
}
