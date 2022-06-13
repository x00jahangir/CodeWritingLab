import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String[] str = {"abc", "def", "ghi", "jkl"};
//        String found = Arrays.stream(str).filter(e -> e.equals("ghii")).findFirst().orElse(null);

        boolean found = Arrays.asList(str).contains("dsef");
        if (found == true) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }
    }
}
