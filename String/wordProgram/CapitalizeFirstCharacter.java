public class CapitalizeFirstCharacter {
    public static void main(String[] args) {
        String text = "hello world welcome to java";
        System.out.println(capitalize(text));
    }

    public static String capitalize(String text) {
        char[] ch = text.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (i == 0 && ch[i] != ' ') {
                ch[i] = Character.toUpperCase(ch[i]);
            } else if (i > 0 && ch[i] != ' ' && ch[i - 1] == ' ') {
                ch[i] = Character.toUpperCase(ch[i]);
            }
        }

        return new String(ch);
    }
}
