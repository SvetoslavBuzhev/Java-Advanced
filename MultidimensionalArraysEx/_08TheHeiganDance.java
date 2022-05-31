package MultidimensionalArraysEx;

import java.util.*;

public class _08TheHeiganDance {
    static int[] startingPoint = {7, 7}; //започваме винаги от средата
    static int[][] chambers = new int[15][15]; //Playground полето винаги е [15][15]
    static double HeiganHp = 3000000; //живота е 3мил.
    static int characterHp = 18500; // живота на charactera
    static int[] Player = startingPoint; //позицията, която ще променям
    static ArrayDeque<String> castedSpells=new ArrayDeque<>(); //спелове,които ще запазвам


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String killingSpell="";
        double dmgPerRound = Double.parseDouble(scan.nextLine()); // четем dmg за всеки рунд
        fillMatrixWith1(); //пълним матрицата с 1 само
        while (characterHp>0&&HeiganHp>0) {
            HeiganHp-=dmgPerRound; //всеки рунд в началото му вземаме от живота
            if (castedSpells.contains("Plague Cloud")) { //ако предния рунд е имало spell "Plague Cloud"
                characterHp -= 3500;                    //вадим веднъж от живота на Player и трием spell от stack
                killingSpell = castedSpells.pop();
            }else if (!castedSpells.isEmpty()){         //за да не се натрупват много спелове, всеки път,когато
                castedSpells.pop();                     //stack не е празен pop() последния елемент
            }
            if (characterHp<=0||HeiganHp<=0){
                castedSpells.add(killingSpell);         //връщаме спела, за да може да го отпечатаме после
                break;
            }
            String[] split = scan.nextLine().split(" ");
            String spell = split[0];
            int rowOfSpell = Integer.parseInt(split[1]);
            int colOfSpell = Integer.parseInt(split[2]);

            fillSpellCells(rowOfSpell, colOfSpell);     //да запълним ударените клетки
            if (( Player[0] >= Math.max(0, rowOfSpell - 1) &&  Player[0] <= Math.min(14, rowOfSpell + 1))
                    && (Player[1] >= Math.max(0, colOfSpell - 1) && Player[1] <= Math.min(14, colOfSpell + 1))) {
              moveOrHit(spell);                         //движим се в посока нагоре,надясно,надолу,наляво
            }
            fillMatrixWith1();                          //ресетваме матрицата
        }
        if (HeiganHp<=0&&characterHp<=0){
            System.out.println("Heigan: Defeated!");
            System.out.println("Player: Killed by Plague Cloud");
        }else if (HeiganHp<=0){
            System.out.println("Heigan: Defeated!");
            System.out.printf("Player: %d%n",characterHp);
        }else if(characterHp<=0){
            System.out.printf("Heigan: %.2f%n",HeiganHp);
            System.out.println("Player: Killed by "+castedSpells.peek());
        }
        System.out.println("Final position: "+Player[0]+", "+Player[1] );
    }

    private static void moveOrHit(String spell) {
        if (Player[0] - 1 >= 0 && (chambers[Player[0] - 1][Player[1]] == 1)) {
            Player[0] = Player[0] - 1;
        } else if (Player[1] + 1 < 15 && (chambers[Player[0]][Player[1] + 1] == 1)) {
            Player[1] = Player[1] + 1;
        } else if (Player[0] + 1 < 15 && (chambers[Player[0] + 1][Player[1]] == 1)) {
            Player[0] = Player[0] + 1;
        } else if (Player[1] - 1 >= 0 && (chambers[Player[0]][Player[1] - 1] == 1)) {
            Player[1] = Player[1] - 1;
        }else {
            switch (spell){
                case "Cloud":
                    characterHp-=3500;
                    castedSpells.add("Plague Cloud");
                    break;
                case "Eruption":
                    characterHp-=6000;
                    castedSpells.add(spell);
                    break;
            }

        }
    }


    private static void fillSpellCells(int rowOfSpell, int colOfSpell) {
        chambers[rowOfSpell][colOfSpell] = -1;
        if (rowOfSpell-1>=0&&colOfSpell-1>=0) {
            chambers[rowOfSpell - 1][colOfSpell - 1] = -1;
        }
        if (rowOfSpell-1>=0){
            chambers[rowOfSpell - 1][colOfSpell] = -1;
        }
        if (rowOfSpell-1>=0&&colOfSpell+1<15) {
            chambers[rowOfSpell - 1][colOfSpell + 1] = -1;
        }
        if (colOfSpell-1>=0) {
            chambers[rowOfSpell][colOfSpell - 1] = -1;
        }
        if (colOfSpell+1<15) {
            chambers[rowOfSpell][colOfSpell + 1] = -1;
        }
        if (rowOfSpell+1<15&&colOfSpell-1>=0) {
            chambers[rowOfSpell + 1][colOfSpell - 1] = -1;
        }
        if (rowOfSpell+1<15) {
            chambers[rowOfSpell + 1][colOfSpell] = -1;
        }
        if (rowOfSpell+1<15&&colOfSpell+1<15) {
            chambers[rowOfSpell + 1][colOfSpell + 1] = -1;
        }

    }

    private static void fillMatrixWith1() {
        for (int[] chamber : chambers) {
            Arrays.fill(chamber, 1);
        }
    }
}
