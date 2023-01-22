import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение:");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(calc(line));
    }

    public static String calc(String input) throws Exception {
        int a1;
        int b1;
        String[] actions = {"+", "-", "*", "/"};
        String sign = null;
        boolean arabic;
        for (String action : actions) {
            if (input.contains(action)) {
                sign = action;
                break;
            }
        }
        if (sign == null) throw new Exception("Неверный знак");

        String[] str = input.split("[\\+\\-*/]");
        if (str.length!=2) throw new Exception("Формат математической операции не удовлетворяет заданию " +
                "- два операнда и один оператор (+, -, /, *)");
        if (Roman.romanToInt(str[0]) & Roman.romanToInt(str[1])) {
            a1 = Roman.romanToArabic(str[0]);
            b1 = Roman.romanToArabic(str[1]);
            arabic = false;
        } else if (!Roman.romanToInt(str[0]) & !Roman.romanToInt(str[1])) {
            a1 = Integer.parseInt(str[0]);
            b1 = Integer.parseInt(str[1]);
            arabic = true;
        } else {
            throw new Exception("Используются одновременно разные системы счисления, либо введеное число больше допустимого");
        }

        int a = getIntNum(a1);
        int b = getIntNum(b1);

        String romanres;
        String result = null;
        int res = (getRes(a, b, sign));
        if (arabic) {
            result = Integer.toString(res);
        } else if (!arabic) {
            romanres = Roman.toRoman(res);
            result = romanres;
        }

        return result;

    }


    public static int getIntNum(int x) throws Exception {
        int num = 0;
        if (x < 11 & x > 0) {
            num = x;
        } else if (x > 11 | x < 0) throw new Exception("Неверное число");
        return num;
    }

    public static int getRes(int a, int b, String sign) {
        return switch (sign) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> getRes(a, b, sign);
        };
    }
}








