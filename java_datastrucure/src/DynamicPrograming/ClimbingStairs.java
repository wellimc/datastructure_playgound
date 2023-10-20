package DynamicPrograming;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs stairs = new ClimbingStairs();
        System.out.println(stairs.climbStairs(10));

        System.out.println(stairs.climbStairsRec(10));
    }

    public  int climbStairs(int n){
        int one=1,two = 1;

        for (int i=0; i<n-1;i++){
            int temp = one;
            one = one + two;
            two = temp;
        }
        return  one;
    }

    public  int climbStairsRec(int n){
        if ( n <= 2){
            return 1;
        }
        return  climbStairs(n-1) + climbStairs(n-2);
    }
}
