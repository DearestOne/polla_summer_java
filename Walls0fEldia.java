import java.util.Scanner;
public class Walls0fEldia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int capital = scan.nextInt();
        int[][] space = new int[capital+6][capital+6];
        for(;;){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int type = scan.nextInt();
            if(x < 0 || x > capital+5 || y < 0 || y > capital+5 || type < 0 || type > 9){
                break;
            }
            space[x][y] = type;
        }

        int Colossus = 0; //9
        int Armored = 0; //8
        int War_Hammer = 0; //6
        int Attack = 0; //4
        int Deviant = 0; //1
        int Survey = 0;

        System.out.println("WALL MAP ["+ ((capital+6)*(capital+6))+"]");
        for(int i=0;i<capital+6;i++){
            for(int j=0;j<capital+6;j++){
                System.out.print(space[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("WALL MAP ["+ ((capital+6)*(capital+6))+"]");

        for(int i=0;i<capital+6;i++){
            for(int j=0;j<capital+6;j++){
                int xy = space[i][j];
                boolean isMaria = i == 0 || j == 0 || i == capital+5 || j == capital+5;
                boolean isRose = i == 1 || j == 1 || i == capital+4 || j == capital+4;
                boolean isSina = i == 2 || j == 2 || i == capital+3 || j == capital+3;
                boolean isWall = isMaria || isRose || isSina;
                boolean isfoundTITAN = xy == 9 || xy == 8 || xy == 6 || xy == 4 || xy == 1;
                if(isfoundTITAN){
                    if(isMaria){
                        System.out.print("Wall Maria " + i + " " + j + " ");
                    }
                    else if(isRose){
                        System.out.print("Wall Rose " + i + " " + j + " ");
                    }
                    else if(isSina){
                        System.out.print("Wall Sina " + i + " " + j + " ");
                    }
                }
                if(isWall && xy == 9){
                    System.out.println("Colossus Titan");
                    Colossus++;
                }
                else if(isWall && xy == 8){
                    System.out.println("Armored Titan");
                    Armored++;
                }
                else if(isWall && xy == 6){
                    System.out.println("War Hammer Titan");
                    War_Hammer++;
                }
                else if(isWall && xy == 4){
                    System.out.println("Attack Titan");
                    Attack++;
                }
                else if(isWall && xy == 1){
                    System.out.println("Deviant");
                    Deviant++;
                }
                else if(isWall && !isfoundTITAN && xy != 0){
                    Survey++;
                }
            }
        }
        System.out.println("Survey Corps " + Survey);
        System.out.println("Deviant " + Deviant);
        System.out.println("Attack Titan " + Attack);
        System.out.println("War Hammer Titan " + War_Hammer);
        System.out.println("Armored Titan " + Armored);
        System.out.println("Colossus Titan " + Colossus);
    }
}
