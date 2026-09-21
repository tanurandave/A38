
public class CustomString {

    private char[] data;

    // ================= CONSTRUCTORS =================

    // 1. Default constructor
    public CustomString() {
        data = new char[0];
    }

    // 2. Constructor using java String
    public CustomString(java.lang.String str) {
        data = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            data[i] = str.charAt(i);
        }
    }

    // 3. Constructor using char array
    public CustomString(char[] chars) {
        data = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            data[i] = chars[i];
        }
    }

    // 4. Constructor using char array with offset and count
    public CustomString(char[] chars, int offset, int count) {
        if (offset < 0 || count < 0 || offset + count > chars.length) {
            throw new IndexOutOfBoundsException();
        }

        data = new char[count];

        for (int i = 0; i < count; i++) {
            data[i] = chars[offset + i];
        }
    }

    // ================= BASIC METHODS =================

    // 5. length()
    public int length() {
        return data.length;
    }

    // 6. charAt()
    public char charAt(int index) {
        if (index < 0 || index >= data.length) {
            throw new StringIndexOutOfBoundsException(index);
        }

        return data[index];
    }

    // 7. isEmpty()
    public boolean isEmpty() {
        return data.length == 0;
    }

    // 8. toString()
    @Override
    public java.lang.String toString() {
        return new java.lang.String(data);
    }

    // 9. equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CustomString)) {
            return false;
        }

        CustomString other = (CustomString) obj;

        if (data.length != other.data.length) {
            return false;
        }

        for (int i = 0; i < data.length; i++) {
            if (data[i] != other.data[i]) {
                return false;
            }
        }

        return true;
    }

    // 10. hashCode()
    @Override
    public int hashCode() {
        int hash = 0;

        for (int i = 0; i < data.length; i++) {
            hash = 31 * hash + data[i];
        }

        return hash;
    }

    // ================= SEARCH METHODS =================

    // 11. indexOf(char)
    public int indexOf(char ch) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == ch) {
                return i;
            }
        }

        return -1;
    }

    // 12. lastIndexOf(char)
    public int lastIndexOf(char ch) {
        for (int i = data.length - 1; i >= 0; i--) {
            if (data[i] == ch) {
                return i;
            }
        }

        return -1;
    }

    // 13. contains(char)
    public boolean contains(char ch) {
        return indexOf(ch) != -1;
    }

    // ================= COMPARISON =================

    // 14. equalsIgnoreCase()
    public boolean equalsIgnoreCase(CustomString other) {
        if (other == null || data.length != other.data.length) {
            return false;
        }

        for (int i = 0; i < data.length; i++) {
            char first = toLower(data[i]);
            char second = toLower(other.data[i]);

            if (first != second) {
                return false;
            }
        }

        return true;
    }

    private char toLower(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char) (ch + 32);
        }

        return ch;
    }

    // 15. compareTo()
    public int compareTo(CustomString other) {
        int minLength = Math.min(data.length, other.data.length);

        for (int i = 0; i < minLength; i++) {
            if (data[i] != other.data[i]) {
                return data[i] - other.data[i];
            }
        }

        return data.length - other.data.length;
    }

    // ================= SUBSTRING METHODS =================

    // 16. substring(beginIndex)
    public CustomString substring(int beginIndex) {
        return substring(beginIndex, data.length);
    }

    // 17. substring(beginIndex, endIndex)
    public CustomString substring(int beginIndex, int endIndex) {
        if (beginIndex < 0 || endIndex > data.length ||
                beginIndex > endIndex) {
            throw new IndexOutOfBoundsException();
        }

        char[] result = new char[endIndex - beginIndex];

        for (int i = beginIndex; i < endIndex; i++) {
            result[i - beginIndex] = data[i];
        }

        return new CustomString(result);
    }

    // ================= CASE CONVERSION =================

    // 18. toUpperCase()
    public CustomString toUpperCase() {
        char[] result = new char[data.length];

        for (int i = 0; i < data.length; i++) {
            char ch = data[i];

            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }

            result[i] = ch;
        }

        return new CustomString(result);
    }

    // 19. toLowerCase()
    public CustomString toLowerCase() {
        char[] result = new char[data.length];

        for (int i = 0; i < data.length; i++) {
            char ch = data[i];

            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }

            result[i] = ch;
        }

        return new CustomString(result);
    }

    // ================= MAIN METHOD =================

    public static void main(String[] args) {
        CustomString str = new CustomString("Hello Java");

        System.out.println("String: " + str);
        System.out.println("Length: " + str.length());
        System.out.println("Character at index 1: " + str.charAt(1));
        System.out.println("Is empty: " + str.isEmpty());
        System.out.println("Index of 'J': " + str.indexOf('J'));
        System.out.println("Last index of 'a': " + str.lastIndexOf('a'));
        System.out.println("Contains 'H': " + str.contains('H'));
        System.out.println("Substring: " + str.substring(6));
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase());
    }
}