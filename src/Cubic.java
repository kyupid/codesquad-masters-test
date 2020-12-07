import java.util.Scanner;

public class Cubic {
    private String word;
    private String[] array_word;

    private int num;
    private char direction;

    Cubic() {
        Scanner sc = new Scanner(System.in);

        System.out.println("단어?");
        System.out.print(">>");
        word = sc.nextLine();
        array_word = word.split("");

        System.out.println("정수?");
        System.out.print(">>");
        num = sc.nextInt();
        while (num < -100 || num >= 100) { // 주어진 요구사항에 맞춰서 정수범위 정하기
            System.out.println("정수의 범위는 -100 초과 100 이하 입니다");
            System.out.print(">>");
            num = sc.nextInt();
        }

        System.out.println("L or R?");
        direction = sc.next().charAt(0);

        checkDirection();

        System.out.println("\n결과: " + word);
        // num 이 0일 때는 아무것도 변하지 않았으므로 원래 word 가 나옴
    }

    private void left() {
        inspectNum();

        if (num > 0) { // num 이 양수일때
            word = word.substring(num) + word.substring(0, num); // 결과물

        } else if (num < 0) { // num 이 음수일때
            num = -num;
            right();
        }
    }

    private void right() {
        inspectNum();

        if (num > 0) {
            word = word.substring(array_word.length - num) + word.substring(0, array_word.length - num); // 결과물
        } else if (num < 0) {
            num = -num;
            left();
        }
    }

    private void inspectNum() {
        if (num > array_word.length) { // 반복적인 결과물을 하나로 통일하려고
            num = num % array_word.length;
        }
    }

    private void checkDirection() {
        if (direction == 'l' || direction == 'L') {
            left();
        }

        if (direction == 'r' || direction == 'R') {
            right();
        }
    }

    public static void main(String[] args) {
        new Cubic();
    }
}

