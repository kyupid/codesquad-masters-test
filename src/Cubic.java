import java.util.Scanner;

public class Cubic {
    private String[][] cube = {{"R", "R", "W"},
            {"G", "C", "W"},
            {"G", "B", "B"}};

    private Scanner sc = new Scanner(System.in);
    private String[] str;

    private String s;


    Cubic() {
        while (true) {
            System.out.print("CUBE >> ");
            str = sc.nextLine().split(" ");
            mix();
        }
    }

    private void mix() {
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("U")) {
                s = cube[0][0] + cube[0][1] + cube[0][2];
                s = s.substring(1) + s.substring(0, 1);
                cube[0][0] = s.substring(0, 1);
                cube[0][1] = s.substring(1, 2);
                cube[0][2] = s.substring(2, 3);
            }

            if (str[i].equals("U'")) {
                s = cube[0][0] + cube[0][1] + cube[0][2];
                s = s.substring(2) + s.substring(0, 2);
                cube[0][0] = s.substring(0, 1);
                cube[0][1] = s.substring(1, 2);
                cube[0][2] = s.substring(2, 3);
            }


            if (str[i].equals("R")) {
                s = cube[0][2] + cube[1][2] + cube[2][2];
                s = s.substring(1) + s.substring(0, 1);
                cube[0][2] = s.substring(0, 1);
                cube[1][2] = s.substring(1, 2);
                cube[2][2] = s.substring(2, 3);
            }

            if (str[i].equals("R'")) {
                s = cube[0][2] + cube[1][2] + cube[2][2];
                s = s.substring(2) + s.substring(0, 2);
                cube[0][2] = s.substring(0, 1);
                cube[1][2] = s.substring(1, 2);
                cube[2][2] = s.substring(2, 3);
            }

            if (str[i].equals("L")) {
                s = cube[0][0] + cube[1][0] + cube[2][0];
                s = s.substring(2) + s.substring(0, 2);
                cube[0][0] = s.substring(0, 1);
                cube[1][0] = s.substring(1, 2);
                cube[2][0] = s.substring(2, 3);
            }

            if (str[i].equals("L'")) {
                s = cube[0][0] + cube[1][0] + cube[2][0];
                s = s.substring(1) + s.substring(0, 1);
                cube[0][0] = s.substring(0, 1);
                cube[1][0] = s.substring(1, 2);
                cube[2][0] = s.substring(2, 3);
            }

            if (str[i].equals("B")) {
                s = cube[2][0] + cube[2][1] + cube[2][2];
                s = s.substring(2) + s.substring(0, 2);
                cube[2][0] = s.substring(0, 1);
                cube[2][1] = s.substring(1, 2);
                cube[2][2] = s.substring(2, 3);
            }

            if (str[i].equals("B'")) {
                s = cube[2][0] + cube[2][1] + cube[2][2];
                s = s.substring(1) + s.substring(0, 1);
                cube[2][0] = s.substring(0, 1);
                cube[2][1] = s.substring(1, 2);
                cube[2][2] = s.substring(2, 3);
            }

            if (str[i].equals("Q")) {
                System.exit(0);
            }
            System.out.println(str[i]);
            printArray();
        }
    }


    private void printArray() {
        for (int i = 0; i < cube.length; i++) {
            for (int j = 0; j < cube.length; j++) {
                System.out.print(cube[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new Cubic();
    }
}

