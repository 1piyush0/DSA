import java.util.*;

public class LongestStreak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] tiles = new int[n];
        for (int i = 0; i < n; i++) {
            tiles[i] = sc.nextInt();
        }

        Map<Integer, Integer> freqTiles = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            freqTiles.put(tiles[i], freqTiles.getOrDefault(tiles[i], 0) + 1);
        }

        int flg = 0;
        int previous = 0;
        int cur = 0;
        int longestStreak = 0;

        for (Map.Entry<Integer, Integer> entry : freqTiles.entrySet()) {
            int tile = entry.getKey();
            if (flg == 0) {
                flg = 1;
                cur = 1;
            } else {
                if (previous == tile - 1) {
                    cur += 1;
                } else {
                    cur = 1;
                }
            }
            previous = tile;
            longestStreak = Math.max(longestStreak, cur);
        }

        System.out.println(longestStreak);
        sc.close();
    }
}
