package Stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.add(i);
        }

        return answer;
    }

    public int[] bruteForce(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = { 73, 74, 75, 71, 69, 72, 76, 73 };
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(arr)));
        System.out.println(Arrays.toString(new DailyTemperatures().bruteForce(arr)));
    }
}
