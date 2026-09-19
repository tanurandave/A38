public class ReplaceDigit {

    public static void main(String[] args) {

        String[] words = {
            "a1c1e1",
            "a1b2c3",
            "x2y3z4"
        };

        for (int i = 0; i < words.length; i++) {

            System.out.println(
                words[i] + " -> " + replaceDigits(words[i])
            );
        }
    }

    public static String replaceDigits(String s) {

        char[] data = s.toCharArray();

        for (int i = 1; i < data.length; i += 2) {

            int num = data[i] - 48;

            data[i] = (char)(data[i - 1] + num);
        }

        return new String(data);
    }
}