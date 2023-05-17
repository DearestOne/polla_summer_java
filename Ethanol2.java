import java.util.Scanner;
class Ethanol{
    int[] percent,capacity,volume;
    Ethanol(int[] percent,int[] capacity,int[] volume){
        this.percent = java.util.Arrays.copyOf(percent, percent.length);
        this.capacity = java.util.Arrays.copyOf(capacity, capacity.length);
        this.volume = java.util.Arrays.copyOf(volume, volume.length);
    }
    int fill(int amount,int num){
        int want = capacity[num] - volume[num];
        if(want <= amount){
            amount -= want;
            System.out.print(want);
        }
        else{
            System.out.print(amount);
            amount = 0;
        }
        return amount;
    }
    void printInfo(int Np,int Sp){
        for(int i=0;i<percent.length;i++){
            if(percent[i] == 75){
                System.out.print((i+1) + ":");
                Sp = fill(Sp, i);
                System.out.print(" ");
            }
        }
        System.out.println();
        for(int i=0;i<percent.length;i++){
            if(percent[i] == 95){
                System.out.print((i+1) + ":");
                Np = fill(Np, i);
                System.out.print(" ");
            }
        }
    }
}
public class Ethanol2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] p = new int[n];
        int[] capacity = new int[n];
        int[] volume = new int[n];
        for(int i=0;i<n;i++){
            p[i] = scan.nextInt();
            capacity[i] = scan.nextInt();
            volume[i] = scan.nextInt();
        }
        Ethanol E = new Ethanol(p, capacity, volume);
        int Sp = scan.nextInt(); // 75%
        int Np = scan.nextInt(); // 90%
        E.printInfo(Np, Sp);
    }
}