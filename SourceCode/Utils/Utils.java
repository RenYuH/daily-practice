package Utils;

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
}
