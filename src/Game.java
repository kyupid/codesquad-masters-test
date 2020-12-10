import java.util.Scanner;

class Game {

    String[][] arr_up = {{"W", "W", "W"}, {"W", "W", "W"}, {"W", "W", "W"}};
    String[][] arr_left = {{"O", "O", "O"}, {"O", "O", "O"}, {"O", "O", "O"}};
    String[][] arr_front = {{"G", "G", "G"}, {"G", "G", "G"}, {"G", "G", "G"}};
    String[][] arr_right = {{"R", "R", "R"}, {"R", "R", "R"}, {"R", "R", "R"}};
    String[][] arr_back = {{"B", "B", "B"}, {"B", "B", "B"}, {"B", "B", "B"}};
    String[][] arr_down = {{"Y", "Y", "Y"}, {"Y", "Y", "Y"}, {"Y", "Y", "Y"}};

    String[] array = new String[12];

    Scanner sc = new Scanner(System.in);

    void run() {
        printAllLine();
        while(true) {
            turnCube();
        }
    }

    private void turnCube() {
        System.out.print("CUBE >> ");
        String[] str = sc.nextLine().split(" ");
        for (String e : str) {
            if (e.equals("F")) {

                array[0] = arr_up[2][0];
                array[1] = arr_up[2][1];
                array[2] = arr_up[2][2];
                array[3] = arr_left[0][2];
                array[4] = arr_left[1][2];
                array[5] = arr_left[2][2];
                array[6] = arr_right[0][0];
                array[7] = arr_right[1][0];
                array[8] = arr_right[2][0];
                array[9] = arr_down[0][0];
                array[10] = arr_down[0][1];
                array[11] = arr_down[0][2];

                arr_right[0][0] = array[0];
                arr_right[1][0] = array[1];
                arr_right[2][0] = array[2];
                arr_up[2][2] = array[3];
                arr_up[2][1] = array[4];
                arr_up[2][0] = array[5];
                arr_down[0][2] = array[6];
                arr_down[0][1] = array[7];
                arr_down[0][0] = array[8];
                arr_left[0][2] = array[9];
                arr_left[1][2] = array[10];
                arr_left[2][2] = array[11];
            }
        }
        printAllLine();
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
