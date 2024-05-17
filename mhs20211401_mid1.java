import java.util.Random;
import java.util.Scanner;

public class mhs20211401_mid1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("가위, 바위, 보 중 하나를 입력하세요: ");
        String userChoice = scanner.nextLine();

        String[] choices = {"가위", "바위", "보"};
        String computerChoice = choices[random.nextInt(choices.length)];

        System.out.println("사용자: " + userChoice);
        System.out.println("컴퓨터: " + computerChoice);

        if (userChoice.equals(computerChoice)) {
            System.out.println("비겼습니다!");
        } else if (userChoice.equals("가위") && computerChoice.equals("보") ||
                   userChoice.equals("바위") && computerChoice.equals("가위") ||
                   userChoice.equals("보") && computerChoice.equals("바위")) {
            System.out.println("사용자가 이겼습니다!");
        } else {
            System.out.println("컴퓨터가 이겼습니다!");
        }

        scanner.close();
    }
}
