import java.util.Scanner;

public class Main {
    static Scanner inputScanner = new Scanner(System.in);
    private static int count = 0;
    static String[] inputArr, prepare;

    public static void main(String[] args) {
        // Вам дана сжатая строка, найдите длину исходной строки. (A15BA5  ->  21)
        // Длина исходной строки не превосходит 1000 символов,
        // все символы исходной строки заглавные большие буквы латинского алфавита.


        String input = inputScanner.next();
        // найдем строковые символы до следующего числа
        inputArr = input.split("\\d+");

        // если есть число
        while (!findFirstNumber(input).equals("")) {
            prepare = inputArr[0].split("");
            // запросим следующее число
            int firstNum = Integer.parseInt(findFirstNumber(input));
            count += prepare.length - 1; // прибавляем единицу для каждой предыдущего символа кроме последнего
            count += firstNum;
            // нужно убрать обработанные символы
            input = input.substring(input.indexOf(findFirstNumber(input)) + findFirstNumber(input).length());
            // найдем буквы до следующего числа
            inputArr = input.split("\\d+");
        }
        // если остались только буквы например"ABAB"
        if ((!input.equals("")) && (findFirstNumber(input).equals(""))) {
            prepare = inputArr[0].split("");
            count += prepare.length;
        }
        System.out.println(count);
    }

    public static String findFirstNumber(final String str) {
        if (str == null || str.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
                found = true;
            } else if (found) {
                break;
            }
        }
        return sb.toString();
    }
}