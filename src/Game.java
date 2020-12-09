import java.util.Scanner;

class Game {

    String[][] up = {{"W", "W", "W"}, {"W", "W", "W"}, {"W", "W", "W"}};
    String[][] left = {{"O", "O", "O"}, {"O", "O", "O"}, {"O", "O", "O"}};
    String[][] front = {{"G", "G", "G"}, {"G", "G", "G"}, {"G", "G", "G"}};
    String[][] right = {{"R", "R", "R"}, {"R", "R", "R"}, {"R", "R", "R"}};
    String[][] back = {{"B", "B", "B"}, {"B", "B", "B"}, {"B", "B", "B"}};
    String[][] down = {{"Y", "Y", "Y"}, {"Y", "Y", "Y"}, {"Y", "Y", "Y"}};

    Scanner sc = new Scanner(System.in);

    void run() {
        printAllLine();
        getFaceAndDirection();
    }

    private void getFaceAndDirection() {
        String[] str = sc.nextLine().split(" ");
    }

///////////////////////////Print all part of the cube///////////////////////////////
    private void printAllLine() {
        printUpDown(up);
        printMiddleOneLine(0);
        printMiddleOneLine(1);
        printMiddleOneLine(2);
        printUpDown(down);
    }

    private void printMiddlePartLine(int num, String[][] test) {
        for (int i = 0; i < 3; i++) {
            System.out.print(test[num][i] + " ");
        }
        System.out.print("\t\t");
    }


    private void printMiddleOneLine(int i) {
        printMiddlePartLine(i, left);
        printMiddlePartLine(i, front);
        printMiddlePartLine(i, right);
        printMiddlePartLine(i, back);
        System.out.println();
    }

    private void printUpDown(String[][] upDown) {
        System.out.println();
        for (String[] e : upDown) {
            System.out.print("\t\t\t");
            for (String ee : e) {
                System.out.print(ee + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
