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
StickGameProbabilityCalculator.c
```



## 2、C++

```c++
StickGameProbabilityCalculator.cpp
```



## 3、Java

```java
StickGameProbabilityCalculator.java
```



## 4、Python

```python
StickGameProbabilityCalculator.py
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

