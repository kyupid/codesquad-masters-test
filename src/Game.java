import java.util.Scanner;

class Game {

    String[][] arr_up = {{"W", "W", "W"}, {"W", "W", "W"}, {"W", "W", "W"}};
    String[][] arr_left = {{"O", "O", "O"}, {"O", "O", "O"}, {"O", "O", "O"}};
    String[][] arr_front = {{"G", "G", "G"}, {"G", "G", "G"}, {"G", "G", "G"}};
    String[][] arr_right = {{"R", "R", "R"}, {"R", "R", "R"}, {"R", "R", "R"}};
    String[][] arr_back = {{"B", "B", "B"}, {"B", "B", "B"}, {"B", "B", "B"}};
    String[][] arr_down = {{"Y", "Y", "Y"}, {"Y", "Y", "Y"}, {"Y", "Y", "Y"}};

    String up, left, front, right, back, down;

    Scanner sc = new Scanner(System.in);

    void run() {
        printAllLine();
        turnCube();
    }

    private void turnCube() {
        String[] str = sc.nextLine().split(" ");

    }

///////////////////////////Print all part of the cube///////////////////////////////
    private void printAllLine() {
        printUpDown(arr_up);
        printMiddleOneLine(0);
        printMiddleOneLine(1);
        printMiddleOneLine(2);
        printUpDown(arr_down);
    }

    private void printMiddlePartLine(int num, String[][] test) {
        for (int i = 0; i < 3; i++) {
            System.out.print(test[num][i] + " ");
        }
        System.out.print("\t\t");
    }


    private void printMiddleOneLine(int i) {
        printMiddlePartLine(i, arr_left);
        printMiddlePartLine(i, arr_front);
        printMiddlePartLine(i, arr_right);
        printMiddlePartLine(i, arr_back);
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
