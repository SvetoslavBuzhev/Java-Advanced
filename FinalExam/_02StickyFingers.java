import java.util.Scanner;

public class _02StickyFingers {
    public static int positionR = -1;
    public static int positionC = -1;
    public static int pocketMoney = 0;
    public static boolean isCaught = false;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        String[][] plain = new String[size][size];

        String[] commands = scan.nextLine().split(",");

        initialize(plain, scan);
        getCoordinates(plain);
        /*
        ⦁	+ - regular position on the field.
        ⦁	$ - house
        ⦁	D - Dillinger position
        ⦁	P – police */


        for (String command : commands) {
            if (isCaught) {
                break;
            }
            switch (command) {
                case "left":
                    move(plain, 0, -1);
                    break;
                case "right":
                    move(plain,0,1);
                    break;
                case "up":
                    move(plain,-1,0);
                    break;
                case "down":
                    move(plain,1,0);
            }
        }
        if (!isCaught){
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.\n",pocketMoney);
        }
        printMatrix(plain);
    }

    public static void move(String[][] plain, int mutatorR, int mutatorC) {
        if (positionC + mutatorC >= 0&&positionR+mutatorR>=0&&
                positionC+mutatorC<plain[positionR].length&&positionR+mutatorR< plain.length) {
            int lastR = positionR;
            int lastC = positionC;
            positionC+=mutatorC;
            positionR+=mutatorR;
            if (plain[positionR][positionC].equals("$")) {
                int currentMoney = positionR * positionC;
                pocketMoney += currentMoney;
                plain[lastR][lastC] = "+";
                plain[positionR][positionC] = "D";
                System.out.printf("You successfully stole %d$.\n", currentMoney);
            } else if (plain[positionR][positionC].equals("P")) {
                System.out.printf("You got caught with %d$, and you are going to jail.\n", pocketMoney);
                plain[lastR][lastC] = "+";
                plain[positionR][positionC] = "#";
                isCaught = true;
            }else {
                plain[lastR][lastC] = "+";
                plain[positionR][positionC] = "D";
            }
        }else {
            System.out.print("You cannot leave the town, there is police outside!\n");
        }
    }

    private static void printMatrix(String[][] plain) {
        for (String[] line : plain) {
            for (String element : line) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static void getCoordinates(String[][] plain) {
        for (int i = 0; i < plain.length; i++) {
            for (int j = 0; j < plain[i].length; j++) {
                if (plain[i][j].equals("D")) {
                    positionR = i;
                    positionC = j;
                }
            }
        }
    }

    private static void initialize(String[][] plain, Scanner scan) {
        for (int i = 0; i < plain.length; i++) {
            String[] input = scan.nextLine().split("\\s+");
            for (int j = 0; j < plain[i].length; j++) {
                plain[i][j] = input[j];
            }
        }
    }

}
