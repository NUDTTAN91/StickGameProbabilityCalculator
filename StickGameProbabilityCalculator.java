import java.util.HashMap;
import java.util.Map;

public class StickGameProbabilityCalculator {

    // 棍子总数和每种颜色的棍子数
    private static final int totalSticks = 27;
    private static final int sticksPerColor = 9;

    // 抽取的棍子数
    private static final int drawSticks = 9;

    public static void main(String[] args) {
        // 计算总的可能性
        long totalCombinations = comb(totalSticks, drawSticks);

        // 奖励金额对应的棍子组合
        Map<Integer, int[][]> rewards = new HashMap<>();
        rewards.put(1000, new int[][]{{9, 0, 0}, {0, 9, 0}, {0, 0, 9}});
        rewards.put(100, new int[][]{{8, 1, 0}, {8, 0, 1}, {0, 8, 1}, {0, 1, 8}, {1, 0, 8}, {1, 8, 0}});
        rewards.put(80, new int[][]{{7, 2, 0}, {7, 0, 2}, {2, 7, 0}, {2, 0, 7}, {0, 7, 2}, {0, 2, 7}});
        rewards.put(70, new int[][]{{7, 1, 1}, {1, 7, 1}, {1, 1, 7}});
        rewards.put(60, new int[][]{{6, 3, 0}, {6, 0, 3}, {3, 6, 0}, {3, 0, 6}, {0, 6, 3}, {0, 3, 6}});
        rewards.put(50, new int[][]{{6, 2, 1}, {6, 1, 2}, {2, 6, 1}, {2, 1, 6}, {1, 6, 2}, {1, 2, 6}});
        rewards.put(40, new int[][]{{5, 4, 0}, {5, 0, 4}, {4, 5, 0}, {4, 0, 5}, {0, 5, 4}, {0, 4, 5}});
        rewards.put(30, new int[][]{{5, 2, 2}, {2, 5, 2}, {2, 2, 5}});
        rewards.put(20, new int[][]{{5, 3, 1}, {5, 1, 3}, {3, 5, 1}, {3, 1, 5}, {1, 5, 3}, {1, 3, 5}});
        rewards.put(10, new int[][]{{4, 4, 1}, {4, 1, 4}, {1, 4, 4}});
        rewards.put(5, new int[][]{{3, 3, 3}});
        rewards.put(-100, new int[][]{{2, 3, 4}, {2, 4, 3}, {3, 2, 4}, {3, 4, 2}, {4, 2, 3}, {4, 3, 2}});

        // 计算每个奖励金额的概率
        Map<Integer, Double> probabilities = new HashMap<>();
        for (Map.Entry<Integer, int[][]> entry : rewards.entrySet()) {
            int reward = entry.getKey();
            int[][] combinations = entry.getValue();
            double probability = 0;
            for (int[] combination : combinations) {
                probability += calculateCombinations(combination[0], combination[1], combination[2]);
            }
            probability /= totalCombinations;
            probabilities.put(reward, probability);
        }

        // 打印结果
        probabilities.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    double probabilityData = entry.getValue() * 100;
                    System.out.printf("奖励金额 %d元 的概率是 %.8f%%%n", entry.getKey(), probabilityData);
                });
    }

    // 组合函数，用于计算不同颜色棍子的组合方式
    private static long calculateCombinations(int yellow, int blue, int red) {
        return comb(sticksPerColor, yellow) * comb(sticksPerColor, blue) * comb(sticksPerColor, red);
    }

    // 组合数计算函数
    private static long comb(int n, int k) {
        if (k > n) return 0;
        if (k > n - k) k = n - k;

        long result = 1;
        for (int i = 1; i <= k; i++) {
            result *= n - (k - i);
            result /= i;
        }
        return result;
    }
}
