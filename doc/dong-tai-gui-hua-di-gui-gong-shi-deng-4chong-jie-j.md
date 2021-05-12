
### 1，动态规划解决
注意这里机器人只能向下和向右移动，不能往其他方向移动，我们用dp[i][j]表示到坐标(i，j)这个格内有多少条不同的路径，所以最终的答案就是求dp[m-1][n-1]。



因为只能从上面或左边走过来，所以递推公式是

**dp[i][j]=dp[i-1][j]+dp[i][j-1]。**
**dp[i-1][j]** 表示的是从上面走过来的路径条数。
**dp[i][j-1]** 表示的是从左边走过来的路径条数。
![image.png](https://pic.leetcode-cn.com/1602162769-bhepEu-image.png)
那么边界条件是什么呢，如果Finish在第一行的任何位置都只有一条路径，同理Finish在第一列的任何位置也都只有一条路径，所以边界条件是**第一行和第一列都是1**。我们已经找到了递推公式，又找到了边界条件，所以动态规划代码很容易写出来，我们来看下

```
public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    //第一列都是1
    for (int i = 0; i < m; i++) {
        dp[i][0] = 1;
    }
    //第一行都是1
    for (int i = 0; i < n; i++) {
        dp[0][i] = 1;
    }

    //这里是递推公式
    for (int i = 1; i < m; i++)
        for (int j = 1; j < n; j++)
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    return dp[m - 1][n - 1];
}
```
看下运行结果
![image.png](https://pic.leetcode-cn.com/1602162837-SttjDy-image.png)

<br>

### 2，动态规划优化
我们看上面二维数组的递推公式，当前坐标的值只和左边与上面的值有关，和其他的无关，这样二维数组造成大量的空间浪费，所以我们可以把它改为一维数组。
```
public int uniquePaths(int m, int n) {
    int[] dp = new int[m];
    Arrays.fill(dp, 1);
    for (int j = 1; j < n; j++)
        for (int i = 1; i < m; i++)
            dp[i] += dp[i - 1];
    return dp[m - 1];
}
```
看下运行结果
![image.png](https://pic.leetcode-cn.com/1602162894-ChnOJM-image.png)

<br>

### 3，递归方式
这题除了动态规划以外，还可以把上面的动态规划改为递归的方式（注意下面解法会超时）
```
public int uniquePaths(int m, int n) {
    return uniquePathsHelper(1, 1, m, n);
}

//第i行第j列到第m行第n列共有多少种路径
public int uniquePathsHelper(int i, int j, int m, int n) {
    //边界条件的判断
    if (i > m || j > n)
        return 0;
    if ((i == m && j == n))
        return 1;
    //从右边走有多少条路径
    int right = uniquePathsHelper(i + 1, j, m, n);
    //从下边走有多少条路径
    int down = uniquePathsHelper(i, j + 1, m, n);
    //返回总的路径
    return right + down;
}
```
代码中有注释，很容易理解，但其实这种效率很差，因为他包含了大量的重复计算，我们画个图来看一下。

![image.png](https://pic.leetcode-cn.com/1602162990-nxISgC-image.png)

我们看到上面图中红色，黑色，还有那种什么颜色的都表示重复的计算，所以有一种方式就是把计算过的值使用一个map存储起来，用的时候先查看是否计算过，如果计算过就直接拿来用，看下代码
```
public int uniquePaths(int m, int n) {
    return uniquePathsHelper(1, 1, m, n, new HashMap<>());
}

public int uniquePathsHelper(int i, int j, int m, int n, Map<String, Integer> map) {
    if (i > m || j > n)
        return 0;
    if ((i == m && j == n))
        return 1;
    String key = i + "*" + j;
    if (map.containsKey(key))
        return map.get(key);
    int right = uniquePathsHelper(i + 1, j, m, n, map);
    int down = uniquePathsHelper(i, j + 1, m, n, map);
    int totla = right + down;
    map.put(key, totla);
    return totla;
}
```

<br>

### 4，使用公式计算
我们要想到达终点，需要往下走n-1步，往右走m-1步，总共需要走n+m-2步。他无论往右走还是往下走他的总的步数是不会变的。也就相当于总共要走n+m-2步，往右走m-1步总共有多少种走法，很明显这就是一个排列组合问题，公式如下
![image.png](https://pic.leetcode-cn.com/1602163053-AVHzhL-image.png)

排列组合的计算公式如下
![image.png](https://pic.leetcode-cn.com/1602163061-mbkULy-image.png)

公式为(m+n-2)! / [(m-1)! * (n-1)!]

代码如下
```
public int uniquePaths(int m, int n) {
    int N = n + m - 2;
    double res = 1;
    for (int i = 1; i < m; i++)
        res = res * (N - (m - 1) + i) / i;
    return (int) res;
}
```
看下运行结果
![image.png](https://pic.leetcode-cn.com/1602163108-gyPSKa-image.png)




<br>

**如果觉得有用就给个赞吧，你的赞是给我最大的鼓励，也是我写作的最大动力**

![image.png](https://pic.leetcode-cn.com/d56a80459005b444404d2ad6fbaabdabecd2b9ed3cb2cf432e570c315ae2fcf7-image.png)
##### 查看更多答案，可扫码关注我微信公众号“**[数据结构和算法](https://img-blog.csdnimg.cn/20200807155236311.png)**”