import java.util.Scanner;

public class Cubic {
    private String[][] cube = {{"R", "R", "W"},
            {"G", "C", "W"},
            {"G", "B", "B"}};

    Cubic() {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");

        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("U")) {
                String up = cube[0][0] + cube[0][1] + cube[0][2];
                up = up.substring(1) + up.substring(0, 1);
                cube[0][0] = up.substring(0, 1);
                cube[0][1] = up.substring(1, 2);
                cube[0][2] = up.substring(2, 3);
            }
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
    }

    public static void main(String[] args) {
        new Cubic();
    }
}

