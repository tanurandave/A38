public class LowercaseFirstCharacter {
    public static void main(String[] args) {
        String text = "Hello World Welcome To Java";
        System.out.println(convert(text));
    }

    public static String convert(String text) {
        char[] ch = text.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (i == 0 && ch[i] != ' ') {
                ch[i] = Character.toLowerCase(ch[i]);
            } else if (i > 0 && ch[i] != ' ' && ch[i - 1] == ' ') {
                ch[i] = Character.toLowerCase(ch[i]);
            }
        }

        return new String(ch);
    }
}
