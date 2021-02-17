public class PureRandomGeneration {
    public static void main(String[] args) {
        int seed = 12;
        //可供参考的一些数值：
        //a = 2^31-1 =int.MaxValue
        //m = 7^5 = 16807
        //c = 0
        final int a = 255, c = 369, m = 16807; // 这里的m（module）选择很重要，不然的话容易生成周期随机数
        int[] value = new int[1000];
        for(int i = 0; i < 1000; i++) {
            if(i == 0) {
                value[0] = Generate(seed, a, c, m);
                System.out.println("value[0]: " + value[0]);
            }
            else {
                value[i] = Generate(value[i - 1], a, c, m);
                System.out.println("value[" + i + "]: " + value[i]);
            }
        }

    }

    public static int Generate(int x, int a, int c, int m) {
        int result;
        // 计算公式： x(n + 1) = (a * x(n) + c) mod m
        result = (a * x + c) % m;
        return result;
    }
}
