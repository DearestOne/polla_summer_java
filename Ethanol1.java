// import java.util.Scanner;
// class Ethanol{
//     int percent,capacity,volume;
//     Ethanol(int percent,int capacity){
//         this.percent = percent;
//         this.capacity = capacity;
//         this.volume = capacity;
//     }
//     void used(int want){
//         if(volume < want){
//             volume = 0;
//         }
//         else{
//             volume -= want;
//         }
//     }
//     void printInfo(){
//         System.out.println("Ethanol " + percent + "% (" + volume + "ml./" + capacity + "ml.)");
//     }
// }
// public class Ethanol1 {
//     public static void main(String[] args) {
//         Scanner scan = new Scanner(System.in);
//         int percent = scan.nextInt();
//         int capacity = scan.nextInt();
//         Ethanol E = new Ethanol(percent, capacity);
//         int want = scan.nextInt();
//         E.used(want);
//         E.printInfo();
//     }
// }
