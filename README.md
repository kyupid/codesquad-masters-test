# 루빅스 큐빅 구현

## 1단계: 단어밀어내기 구현
1. 입력: 사용자로부터 단어 하나, 정수 숫자 하나( -100 <= N < 100) , L 또는 R을 입력받는다. L 또는 R은 대소문자 모두 입력 가능하다.
2. 주어진 단어를 L이면 주어진 숫자 갯수만큼 왼쪽으로, R이면 오른쪽으로 밀어낸다.
3. 밀려나간 단어는 반대쪽으로 채워진다.

---

## 커밋 망함
커밋하면서 생각이 끊기는거 같아서 Diff를 이용해서 작업 단위로 커밋을 한꺼번에 하려고 했습니다. 근데 마지막에 그렇게 하려고 보니 Diff가 완전히 바뀌어서 작업 단위가 코드 통째로 1개이더군요. 그래서 코드에 대한 커밋 기록이 2개 밖에 없습니다. 😢

다음부터는 생각이 끊기지 않을 정도의 작업 단위까지 완성하고 바로 커밋하는 습관을 들여야겠습니다.

---

## 코드

### 구조
1. 메인 클래스에서 `Cubic` 클래스를 생성하면 생성자를 통해서 단어, 정수 그리고 left or right 를 받습니다.
2. `checkDirection()` 메소드를 통해서 left 인지 right 인지 체크해서 해당되는 `left()` 메소드나 `right()` 메소드를 호출합니다
3. 호출이 되면 `inspectNum()` 메소드를 통해서 문자열 `word`과 `num`의 관계에 의하여 `num`의 정수를 변경합니다.
4. 그러면  `left()` 메소드와 `right()` 메소드에서 로직에 의하여 요구되는 문자열로 바뀝니다.
5. `num`이 음수일 경우에는 단지 반대방향을 가리키기 때문에 반대방향의 메소드를 호출해줍니다.
6. 결과물을 출력하고 메인클래스가 종료됩니다.

### 코드 설명
먼저 `word`의 배열인 `array_word`를  선언해줍니다. `word`를 `split()`으로 한 문자 단위로 모두 따로 배열에 담아야합니다. 여기서 substring이 주요 로직이기 때문입니다.

```java
// 코드 1

private void inspectNum() {
        if (num > array_word.length) { // 반복적인 결과물을 하나로 통일하려고
            num = num % array_word.length;
        }
    }
```
`코드 1`에서 `num`을 변경해주는 작업을 하는 것은 문제의 요구사항에 따르면 `array_word`의 길이를 넘으면  반복되는 작업이기 때문입니다. 예를 들어서, apple 이라는 문자열이 있을때 계속 문자를 밀으면 결국에는 어느 순간 원래 문자열로 돌아옵니다. 다른 문자열들도 마찬가지이고요. 그래서 원래 문자열로 돌아오기까지 몇번인지 살펴보면, 배열의 길이와 같다는 걸 알수있습니다. 그 이후는 반복작업이니 `%` 연산자를 사용하면 됩니다.

```java
// 코드 2

private void left() {
     inspectNum();

     if (num > 0) { // num 이 양수일때
         word = word.substring(num) + word.substring(0, num); // 결과물
         
     } else if (num < 0) { // num 이 음수일때
         num = -num;
         right();
     }
}
```
아까 `코드 1`에서 `num`이 배열의 길이를 넘으면 `num`을 바꾸는 작업을 했습니다. 근데 `num`이 음수일 경우에는 작동하지 않습니다. `코드 2`에서는  먼저 양수일 경우에 `substring()`을 이용해서 문제에서 요구되는 `word`로 변경하고, 음수일 경우에는 반대 방향과 결과가 같기 때문에 반대 방향의 메소드를 출력합니다.

```java
// 코드 3
private void left() {
	if (num > 0) {
		word = word.substring(num) + word.substring(0, num); // 결과물
 	}
 }

// 코드 4
private void right() {
	if (num > 0) {
		word = word.substring(array_word.length - num) + word.substring(0, array_word.length - num); // 결과물
 }
}
```
`코드 3`과 `코드 4`의 로직은 단순히 직접 단어마다 입출력해보면 연속성을 찾을 수 있습니다. 예를 들어서,  apple 을 left 로 한번 해보겠습니다.

1. pplea ->`word.subString(1) + array_word[0];`
2. pleap ->`word.subString(2) + array_word[0] + array_word[1];`
3. leapp ->`word.subString(3) + array_word[0] + array_word[1] + array_word[2];`
4. eappl -> `word.subString(4) + array_word[0] + array_word[1] + array_word[2] + array_word[3];`
5. apple -> `apple`
6. 반복

`array_word`를 `substring()`으로 바꾸면 자연스럽게 로직이 만들어지고 반대방향도 이와같이 하면 그에 따른 연속성을 찾을 수 있습니다.
