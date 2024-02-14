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
