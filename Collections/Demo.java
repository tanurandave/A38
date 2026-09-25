import java.util.*;

class Demo {

    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression, 0).set;
        return new ArrayList<>(result);
    }

    private Result parse(String s, int index) {
        Set<String> result = new TreeSet<>();
        Set<String> current = new TreeSet<>();
        current.add("");

        while (index < s.length() && s.charAt(index) != '}') {

            if (s.charAt(index) == '{') {
                Result inner = parse(s, index + 1);

                current = multiply(current, inner.set);
                index = inner.index + 1;

            } else if (s.charAt(index) == ',') {
                result.addAll(current);
                current = new TreeSet<>();
                current.add("");
                index++;

            } else {
                Set<String> word = new TreeSet<>();
                word.add(String.valueOf(s.charAt(index)));

                current = multiply(current, word);
                index++;
            }
        }

        result.addAll(current);

        return new Result(result, index);
    }

    private Set<String> multiply(Set<String> first, Set<String> second) {
        Set<String> result = new TreeSet<>();

        for (String a : first) {
            for (String b : second) {
                result.add(a + b);
            }
        }

        return result;
    }

    private static class Result {
        Set<String> set;
        int index;

        Result(Set<String> set, int index) {
            this.set = set;
            this.index = index;
        }
    }
}