import java.util.Scanner;

public class Main {
    static Scanner inputScanner = new Scanner(System.in);
    private static int count = 0;
    static String[] inputArr, prepare;

    public static void main(String[] args) {
        // ��� ���� ������ ������, ������� ����� �������� ������. (A15BA5  ->  21)
        // ����� �������� ������ �� ����������� 1000 ��������,
        // ��� ������� �������� ������ ��������� ������� ����� ���������� ��������.


        String input = inputScanner.next();
        // ������ ��������� ������� �� ���������� �����
        inputArr = input.split("\\d+");

        // ���� ���� �����
        while (!findFirstNumber(input).equals("")) {
            prepare = inputArr[0].split("");
            // �������� ��������� �����
            int firstNum = Integer.parseInt(findFirstNumber(input));
            count += prepare.length - 1; // ���������� ������� ��� ������ ����������� ������� ����� ����������
            count += firstNum;
            // ����� ������ ������������ �������
            input = input.substring(input.indexOf(findFirstNumber(input)) + findFirstNumber(input).length());
            // ������ ����� �� ���������� �����
            inputArr = input.split("\\d+");
        }
        // ���� �������� ������ ����� ��������"ABAB"
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