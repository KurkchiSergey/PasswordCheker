import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PasswordChecker passwordChecker = new PasswordChecker();
        Scanner sc = new Scanner(System.in);
        passwordChecker.setMinLength(8);
        passwordChecker.setMaxRepeats(-1);
        while (true) {

            System.out.println("Введите пароль: ");
            String in = sc.nextLine();
            if (in.equals("end")){
                break;
            }

            System.out.println(passwordChecker.verify(in));

        }
        System.out.println("Вы завершили ввод пароля");
    }
}
