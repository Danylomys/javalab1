import java.util.Scanner;

public class CharCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть рядок: ");
        String input = scanner.nextLine();
        
        CharCountPair[] pairs = new CharCountPair[input.length()];
        int pairCount = 0;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            boolean found = false;
            for (int j = 0; j < pairCount; j++) {
                if (pairs[j].getCharacter() == currentChar) {
                    pairs[j].incrementCount();
                    found = true;
                    break;
                }
            }

            if (!found) {
                pairs[pairCount] = new CharCountPair(currentChar, 1);
                pairCount++;
            }
        }

        System.out.println("Кількість кожного символу:");
        for (int i = 0; i < pairCount; i++) {
            System.out.println(pairs[i]);
        }
    }
}
