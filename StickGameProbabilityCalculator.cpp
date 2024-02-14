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
