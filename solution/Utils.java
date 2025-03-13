public class Utils {

    public static <T> void printDPArray(T[][] dp) {
        System.out.println("Vision of two-dimensional array:");
        for (T[] row : dp) {
            for (T element : row) {
                System.out.printf("%4s ", element); // 统一格式化输出
            }
            System.out.println();
        }
    }

    public static void printDPArray(int[][] dp) {
        System.out.println("Vision of two-dimensional array:");
        for (int[] row : dp) {
            for (int element : row) {
                System.out.printf("%4s ", element); // 统一格式化输出
            }
            System.out.println();
        }
    }

    public static void printDPArray(boolean[][] dp) {
        System.out.println("Vision of two-dimensional array:");
        for (boolean[] row : dp) {
            for (boolean element : row) {
                System.out.printf("%4s ", Boolean.compare(element, false)); // 统一格式化输出
            }
            System.out.println();
        }
    }
}
