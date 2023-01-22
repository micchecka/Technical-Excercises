

class Roman {

    static String[] romans1 = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    static int[] arabics = {100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] romans2 = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static boolean romanToInt(String str) {
        for (String value : romans1) {
            if (str.equals(value)) {
                return true;
            }
        }
        return false;
    }


    public static int romanToArabic(String str) {
        for (int i = 1; i <= romans1.length; i++) {
            if (str.equals(romans1[i - 1])) {
                return i;
            }
        }
        return -1;
    }


    public static String toRoman(int sum) throws Exception {

        if (sum < 0) throw new Exception("В римской системе нет отрицательных чисел");
        else {
            StringBuilder rnum = new StringBuilder();
            for (int i = 0; i < arabics.length; i++) {
                while (sum >= arabics[i]) {
                    sum -= arabics[i];
                    rnum.append(romans2[i]);
                }
            }
            return rnum.toString();
        }
    }
}