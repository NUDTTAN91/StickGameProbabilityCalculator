<center>
    <font size=7><b>彩棒抽奖游戏</b></font>
</center>




---



# 一、游戏规则

​		现有<font size=5 color='yellow'><b>黄</b></font>、<font size=5 color='blue'><b>蓝</b></font>、<font size=5 color='red'><b>红</b></font>的棍子各`9`根，混合之后放入袋子里，每次从这`27`根棍子抽`9`根棍子，各个颜色的金额对应如下表：

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>奖励金额表格</title>
<style>
    table {
        width: 100%;
        border-collapse: collapse;
    }
    table, th, td {
        border: 1px solid black;
    }
    th, td {
        padding: 10px;
        text-align: center;
    }
    th {
        background-color: #f2f2f2;
    }
    .yellow-cell {
        background-color: rgb(128, 128, 128);
        font-weight: bold;
        color: yellow;
    }
    .blue-cell {
        background-color: rgb(128, 128, 128);
        font-weight: bold;
        color: blue;
    }
    .red-cell {
        background-color: rgb(128, 128, 128);
        font-weight: bold;
        color: red;
    }
</style>
</head>
<body>
<table>
    <tr>
        <th class="yellow-cell">黄</th>
        <th class="blue-cell">蓝</th>
        <th class="red-cell">红</th>
        <th>奖励金额（￥）</th>
    </tr>
    <tr>
        <td class="yellow-cell">9</td>
        <td class="blue-cell">0</td>
        <td class="red-cell">0</td>
        <td>1000元</td>
    </tr>
    <tr>
        <td class="yellow-cell">8</td>
        <td class="blue-cell">1</td>
        <td class="red-cell">0</td>
        <td>100元</td>
    </tr>
    <tr>
        <td class="yellow-cell">7</td>
        <td class="blue-cell">2</td>
        <td class="red-cell">0</td>
        <td>80元</td>
    </tr>
    <tr>
        <td class="yellow-cell">7</td>
        <td class="blue-cell">1</td>
        <td class="red-cell">1</td>
        <td>70元</td>
    </tr>
    <tr>
        <td class="yellow-cell">6</td>
        <td class="blue-cell">3</td>
        <td class="red-cell">0</td>
        <td>60元</td>
    </tr>
    <tr>
        <td class="yellow-cell">6</td>
        <td class="blue-cell">2</td>
        <td class="red-cell">1</td>
        <td>50元</td>
    </tr>
    <tr>
        <td class="yellow-cell">5</td>
        <td class="blue-cell">4</td>
        <td class="red-cell">0</td>
        <td>40元</td>
    </tr>
    <tr>
        <td class="yellow-cell">5</td>
        <td class="blue-cell">2</td>
        <td class="red-cell">2</td>
        <td>30元</td>
    </tr>
    <tr>
        <td class="yellow-cell">5</td>
        <td class="blue-cell">3</td>
        <td class="red-cell">1</td>
        <td>20元</td>
    </tr>
    <tr>
        <td class="yellow-cell">4</td>
        <td class="blue-cell">4</td>
        <td class="red-cell">1</td>
        <td>10元</td>
    </tr>
    <tr>
        <td class="yellow-cell">3</td>
        <td class="blue-cell">3</td>
        <td class="red-cell">3</td>
        <td>5元</td>
    </tr>
    <tr>
        <td class="yellow-cell">2</td>
        <td class="blue-cell">3</td>
        <td class="red-cell">4</td>
        <td>-100元</td>
    </tr>
</table>
</body>
</html>



> [!IMPORTANT]
>
> 棍子的顺序并不重要



# 二、计算各个奖励金额的数学原理

​		在这个问题中，我们要计算的是从27根棍子中抽取9根，其中每种颜色（黄、蓝、红）各9根，得到不同颜色组合的概率。这是一个典型的组合问题，可以使用组合数学中的多项式分布来解决。

## 组合数 (Combinations)

​		组合数表示的是在没有考虑顺序的情况下，从n个不同元素中取出k个元素的不同组合方式的数量。组合数的计算公式为：

$$
C(n, k) = \frac{n!}{k!(n - k)!}
$$
​		其中 `n!` 表示n的阶乘，即 `n * (n-1) * (n-2) * ... * 1`。

## 多项式分布 (Multinomial Distribution)

​		多项式分布是二项分布的推广，适用于每次试验有多于两个可能结果的情况。在这个问题中，每次抽取棍子可以得到三种颜色中的一种，因此是一个多项式分布的问题。

​		多项式分布的概率质量函数（PMF）为：

$$
P(X_1 = x_1, X_2 = x_2, \ldots, X_k = x_k) = \frac{n!}{x_1! \times x_2! \times \ldots \times x_k!} \times p_1^{x_1} \times p_2^{x_2} \times \ldots \times p_k^{x_k}
$$
​		其中，`X1, X2, ..., Xk` 是每种结果发生的次数，`p1, p2, ..., pk` 是每种结果的概率，且 `x1 + x2 + ... + xk = n`。

​		在我们的问题中，由于每种颜色的棍子数量相同，因此每种颜色被抽到的概率是相等的，即 `p1 = p2 = p3 = 1/3`。但是，由于我们只关心颜色的组合，而不关心顺序，所以我们可以忽略概率的乘积部分，只计算组合数。

## 计算步骤

1、计算总的可能性，即从27根棍子中抽取9根的组合数：
$$
{total_combinations} = C(27, 9)
$$
2、对于每个奖励金额，计算对应的颜色组合的组合数。例如，对于1000元奖励，需要抽出9根黄色棍子，组合数为：

$$
{combinations}_{1000} = C(9, 9) \times C(9, 0) \times C(9, 0)
$$
3、计算每个奖励金额的概率，即对应颜色组合的组合数除以总的可能性：
$$
{probability}_{1000} = \frac{{combinations}_{1000}}{{total_combinations}}
$$
4、重复步骤2和3，计算每个奖励金额的概率。

5、输出每个奖励金额的概率。

​		通过以上步骤，我们可以得到每个奖励金额的概率。这个计算假设每次抽取都是独立的，且每根棍子被抽到的概率是相等的。



# 三、计算概率

## 1、C

```c
#include <stdio.h>

// 函数声明
unsigned long long comb(int n, int k);
double calculate_combinations(int yellow, int blue, int red, int sticks_per_color);
void print_probabilities(double total_combinations, double probabilities[], int rewards[], int size);

int main() {
    int total_sticks = 27;
    int sticks_per_color = 9;
    int draw_sticks = 9;
    int rewards[] = {1000, 100, 80, 70, 60, 50, 40, 30, 20, 10, 5, -100};
    int combinations[12][6][3] = {
        {{9, 0, 0}, {0, 9, 0}, {0, 0, 9}},
        {{8, 1, 0}, {8, 0, 1}, {0, 8, 1}, {0, 1, 8}, {1, 0, 8}, {1, 8, 0}},
        {{7, 2, 0}, {7, 0, 2}, {2, 7, 0}, {2, 0, 7}, {0, 7, 2}, {0, 2, 7}},
        {{7, 1, 1}, {1, 7, 1}, {1, 1, 7}},
        {{6, 3, 0}, {6, 0, 3}, {3, 6, 0}, {3, 0, 6}, {0, 6, 3}, {0, 3, 6}},
        {{6, 2, 1}, {6, 1, 2}, {2, 6, 1}, {2, 1, 6}, {1, 6, 2}, {1, 2, 6}},
        {{5, 4, 0}, {5, 0, 4}, {4, 5, 0}, {4, 0, 5}, {0, 5, 4}, {0, 4, 5}},
        {{5, 2, 2}, {2, 5, 2}, {2, 2, 5}},
        {{5, 3, 1}, {5, 1, 3}, {1, 5, 3}, {1, 3, 5}, {3, 5, 1}, {3, 1, 5}},
        {{4, 4, 1}, {4, 1, 4}, {1, 4, 4}},
        {{3, 3, 3}},
        {{2, 3, 4}, {2, 4, 3}, {3, 2, 4}, {3, 4, 2}, {4, 2, 3}, {4, 3, 2}}
    };
    int combination_counts[] = {3, 6, 6, 3, 6, 6, 6, 3, 6, 3, 1, 6};
    double total_combinations = comb(total_sticks, draw_sticks);
    double probabilities[12] = {0};

    // 计算每个奖励金额的概率
    for (int i = 0; i < 12; i++) {
        for (int j = 0; j < combination_counts[i]; j++) {
            probabilities[i] += calculate_combinations(combinations[i][j][0], combinations[i][j][1], combinations[i][j][2], sticks_per_color);
        }
        probabilities[i] /= total_combinations;
    }

    // 打印结果
    print_probabilities(total_combinations, probabilities, rewards, 12);

    return 0;
}

// 函数定义：计算组合数
unsigned long long comb(int n, int k) {
    if (k > n) return 0;
    if (k > n - k) k = n - k;

    unsigned long long result = 1;
    for (int i = 1; i <= k; i++) {
        result *= n - (k - i);
        result /= i;
    }
    return result;
}

// 函数定义：计算特定组合的概率
double calculate_combinations(int yellow, int blue, int red, int sticks_per_color) {
    return comb(sticks_per_color, yellow) * comb(sticks_per_color, blue) * comb(sticks_per_color, red);
}

// 函数定义：打印概率结果
void print_probabilities(double total_combinations, double probabilities[], int rewards[], int size) {
    for (int i = 0; i < size; i++) {
        printf("奖励金额 %d元 的概率是 %.8f%%\n", rewards[i], probabilities[i] * 100);
    }
}
```



## 2、C++

```c++
#include <iostream>
#include <vector>
#include <cmath>

// 函数声明
unsigned long long comb(int n, int k);
double calculate_combinations(int yellow, int blue, int red, int sticks_per_color);
void print_probabilities(double total_combinations, const std::vector<double>& probabilities, const std::vector<int>& rewards);

int main() {
    int total_sticks = 27;
    int sticks_per_color = 9;
    int draw_sticks = 9;
    std::vector<int> rewards = {1000, 100, 80, 70, 60, 50, 40, 30, 20, 10, 5, -100};
    std::vector<std::vector<std::vector<int>>> combinations = {
        {{9, 0, 0}, {0, 9, 0}, {0, 0, 9}},
        {{8, 1, 0}, {8, 0, 1}, {0, 8, 1}, {0, 1, 8}, {1, 0, 8}, {1, 8, 0}},
        {{7, 2, 0}, {7, 0, 2}, {2, 7, 0}, {2, 0, 7}, {0, 7, 2}, {0, 2, 7}},
        {{7, 1, 1}, {1, 7, 1}, {1, 1, 7}},
        {{6, 3, 0}, {6, 0, 3}, {3, 6, 0}, {3, 0, 6}, {0, 6, 3}, {0, 3, 6}},
        {{6, 2, 1}, {6, 1, 2}, {2, 6, 1}, {2, 1, 6}, {1, 6, 2}, {1, 2, 6}},
        {{5, 4, 0}, {5, 0, 4}, {4, 5, 0}, {4, 0, 5}, {0, 5, 4}, {0, 4, 5}},
        {{5, 2, 2}, {2, 5, 2}, {2, 2, 5}},
        {{5, 3, 1}, {5, 1, 3}, {1, 5, 3}, {1, 3, 5}, {3, 5, 1}, {3, 1, 5}},
        {{4, 4, 1}, {4, 1, 4}, {1, 4, 4}},
        {{3, 3, 3}},
        {{2, 3, 4}, {2, 4, 3}, {3, 2, 4}, {3, 4, 2}, {4, 2, 3}, {4, 3, 2}}
    };
    std::vector<int> combination_counts = {3, 6, 6, 3, 6, 6, 6, 3, 6, 3, 1, 6};
    std::vector<double> probabilities(12, 0.0);
    double total_combinations = comb(total_sticks, draw_sticks);

    // 计算每个奖励金额的概率
    for (size_t i = 0; i < combinations.size(); i++) {
        for (int j = 0; j < combination_counts[i]; j++) {
            probabilities[i] += calculate_combinations(combinations[i][j][0], combinations[i][j][1], combinations[i][j][2], sticks_per_color);
        }
        probabilities[i] /= total_combinations;
    }

    // 打印结果
    print_probabilities(total_combinations, probabilities, rewards);

    return 0;
}

// 函数定义：计算组合数
unsigned long long comb(int n, int k) {
    if (k > n) return 0;
    if (k > n - k) k = n - k;

    unsigned long long result = 1;
    for (int i = 1; i <= k; i++) {
        result *= n - (k - i);
        result /= i;
    }
    return result;
}

// 函数定义：计算特定组合的概率
double calculate_combinations(int yellow, int blue, int red, int sticks_per_color) {
    return comb(sticks_per_color, yellow) * comb(sticks_per_color, blue) * comb(sticks_per_color, red);
}

// 函数定义：打印概率结果
void print_probabilities(double total_combinations, const std::vector<double>& probabilities, const std::vector<int>& rewards) {
    for (size_t i = 0; i < probabilities.size(); i++) {
        std::cout << "奖励金额 " << rewards[i] << "元 的概率是 " << probabilities[i] * 100 << "%" << std::endl;
    }
}
```



## 3、Java

```java
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
```



## 4、Python

```python
from math import comb

# 棍子总数和每种颜色的棍子数
total_sticks = 27
sticks_per_color = 9

# 抽取的棍子数
draw_sticks = 9

# 组合函数，用于计算不同颜色棍子的组合方式
def calculate_combinations(yellow, blue, red):
    return comb(sticks_per_color, yellow) * comb(sticks_per_color, blue) * comb(sticks_per_color, red)

# 计算总的可能性
total_combinations = comb(total_sticks, draw_sticks)

# 奖励金额对应的棍子组合
rewards = {
    1000: [(9,0,0), (0,9,0), (0,0,9)],
    100: [(8,1,0), (8,0,1), (0,8,1), (0,1,8), (1,0,8), (1,8,0)],
    80: [(7,2,0), (7,0,2), (2,7,0), (2,0,7), (0,7,2), (0,2,7)],
    70: [(7,1,1), (1,1,7), (1,7,1)],
    60: [(6,3,0), (6,0,3), (3,6,0), (3,0,6), (0,6,3), (0,3,6)],
    50: [(6,2,1), (6,1,2), (2,1,6), (2,6,1), (1,2,6), (1,6,2)],
    40: [(5,4,0), (5,0,4), (4,5,0), (4,0,5), (0,5,4), (0,4,5)],
    30: [(5,2,2), (2,5,2), (2,2,5)],
    20: [(5,3,1), (5,1,3), (1,3,5), (1,5,3), (3,5,1), (3,1,5)],
    10: [(4,4,1), (1,4,4), (4,1,4)],
    5: [(3,3,3)],
    -100: [(2,3,4), (2,4,3), (3,2,4), (3,4,2), (4,2,3), (4,3,2)]
}

# 计算每个奖励金额的概率
probabilities = {}
for reward, combinations in rewards.items():
    probability = sum(calculate_combinations(*combination) for combination in combinations) / total_combinations
    probabilities[reward] = probability

# 打印结果
for reward, probability in sorted(probabilities.items()):
    probability_data=probability*100
    print(f"奖励金额 {reward}元 的概率是 {probability_data:.8f}%")
```



# 四、计算结果

```bash
奖励金额 -100元 的概率是 48.77809605%
奖励金额 5元 的概率是 12.64617305%  
奖励金额 10元 的概率是 9.14589301%  
奖励金额 20元 的概率是 12.19452401% 
奖励金额 30元 的概率是 10.45244915% 
奖励金额 40元 的概率是 2.03242067%  
奖励金额 50元 的概率是 3.48414972%  
奖励金额 60元 的概率是 0.90329807%  
奖励金额 70元 的概率是 0.18665088%  
奖励金额 80元 的概率是 0.16591189%  
奖励金额 100元 的概率是 0.01036949% 
奖励金额 1000元 的概率是 0.00006401%
```

