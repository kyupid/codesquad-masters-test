import java.util.Scanner;

public class Cubic {
    public static void main(String[] args) {
        String word;
        int push;
        char direction;

        Scanner sc = new Scanner(System.in);
        System.out.println("단어?");
        System.out.print(">>");
        word = sc.nextLine();
        System.out.println("정수?");
        System.out.print(">>");
        push = sc.nextInt();
        while (push < -100 || push >= 100) {
                push = sc.nextInt();
            }
        System.out.println("L or R?");
        direction = sc.next().charAt(0);


        }
    }

