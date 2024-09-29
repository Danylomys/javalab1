public class SubstringInMatrix {
    public static void main(String[] args) {

        String[][] matrix = {
                {"hello", "world", "java"},
                {"string", "hello", "substring"},
                {"matrix", "search", "helloworld"}
        };

        String substring = "hello";

        int count = findSubstringOccurrences(matrix, substring);

        System.out.println("Кількість входжень підрядка '" + substring + "': " + count);
    }

    public static int findSubstringOccurrences(String[][] matrix, String substring) {
        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // Якщо поточний елемент містить підрядок, збільшуємо лічильник
                if (matrix[i][j].contains(substring)) {
                    count++;
                }
            }
        }

        return count;
    }
}
