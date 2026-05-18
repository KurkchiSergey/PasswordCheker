import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PasswordChecker checker = new PasswordChecker();
        Scanner scanner = new Scanner(System.in);

       try {
           System.out.print("Введите минимальную длинну пароля: ");
           int minLength = Integer.parseInt(scanner.nextLine());
           checker.setMinLength(minLength);
           System.out.print("Введите макс. допустимое количество повторений символа подряд: ");
           int maxRepeats = Integer.parseInt(scanner.nextLine());
           checker.setMaxRepeats(maxRepeats);
       } catch (IllegalArgumentException e) {
           System.out.println(e.getMessage());
       }

       try {
           while (true) {
               System.out.print("Введите пароль или end: ");
               String pasInput = scanner.nextLine();
               if ("end".equals(pasInput)) {
                   break;
               }
               System.out.println(checker.verify(pasInput) ? "Подходит!" : "Не подходит!");
           }
       } catch (IllegalStateException e) {
           System.out.println(e.getMessage());
       }
        System.out.print("Программа завершена");
    }
}