import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class mhs20211401_mid2 {

    enum RPS {
        가위, 바위, 보
    }

    public static RPS getRPSChoice(String input) {
        switch (input.toLowerCase()) {
            case "바위":
            case "r":
                return RPS.바위;
            case "보":
            case "p":
                return RPS.보;
            case "가위":
            case "s":
                return RPS.가위;
            default:
                return null;
        }
    }

    public static String determineWinner(RPS user, RPS computer) {
        if (user == computer) {
            return "비김";
        }
        switch (user) {
            case 바위:
                return (computer == RPS.가위) ? "user" : "computer";
            case 보:
                return (computer == RPS.바위) ? "user" : "computer";
            case 가위:
                return (computer == RPS.보) ? "user" : "computer";
            default:
                return "error";
        }
    }

    public static RPS getRandomRPS() {
        Random random = new Random();
        int choice = random.nextInt(3);
        switch (choice) {
            case 0:
                return RPS.바위;
            case 1:
                return RPS.보;
            case 2:
                return RPS.가위;
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("가위바위보 스택 게임을 시작합니다!");

        List<RPS> userChoices = new ArrayList<>();
        List<RPS> computerChoices = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.print("가위, 바위, 보 중 하나를 입력하세요 (종료하려면 'exit' 입력): ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("게임을 종료합니다.");
                return;
            }

            RPS userChoice = getRPSChoice(userInput);
            if (userChoice == null) {
                System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                i--;
                continue;
            }

            RPS computerChoice = getRandomRPS();
            userChoices.add(userChoice);
            computerChoices.add(computerChoice);

            System.out.println("라운드 " + (i + 1) + " 결과:");
            System.out.println("사용자 선택: " + userChoice);
            System.out.println("컴퓨터 선택: " + computerChoice);
        }

        int userScore = 0;
        int computerScore = 0;

        for (int i = 0; i < 3; i++) {
            String result = determineWinner(userChoices.get(i), computerChoices.get(i));
            if (result.equals("user")) {
                userScore++;
            } else if (result.equals("computer")) {
                computerScore++;
            }
        }

        System.out.println("최종 결과:");
        System.out.println("사용자 점수: " + userScore);
        System.out.println("컴퓨터 점수: " + computerScore);

        if (userScore > computerScore) {
            System.out.println("사용자가 최종 승리했습니다!");
        } else if (userScore < computerScore) {
            System.out.println("컴퓨터가 최종 승리했습니다!");
        } else {
            System.out.println("최종 결과는 무승부입니다!");
        }
    }
}
