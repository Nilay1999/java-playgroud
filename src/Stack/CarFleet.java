package Stack;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {

    public class Time {
        int position;
        int speed;

        Time(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Time[] time = new Time[n];
        for (int i = 0; i < time.length; i++) {
            time[i] = new Time(position[i], speed[i]);
        }
        Arrays.sort(time, (a, b) -> (a.position - b.position));
        Stack<Double> stack = new Stack<>();
        for (int i = time.length - 1; i >= 0; i--) {
            int posi = time[i].position;
            int sp = time[i].speed;

            stack.add((double) (target - posi) / sp);
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }

        return stack.size();
    }

    public int bruteForce(int target, int[] position, int[] speed) {
        int fleet = 0;

        for (int i = 0; i < position.length; i++) {
            double ti = (double) (target - position[i]) / speed[i];
            boolean blocked = false;
            for (int j = 0; j < position.length; j++) {
                if (position[j] <= position[i])
                    continue;
                double tj = (double) (target - position[j]) / position[j];
                if (tj >= ti) {
                    blocked = true;
                    break;
                }
            }
            if (!blocked)
                fleet++;
        }

        return fleet;
    }

    public static void main(String[] args) {
        int target = 12;
        int[] position = { 10, 8, 0, 5, 3 }, speed = { 2, 4, 1, 1, 3 };

        System.out.println(new CarFleet().carFleet(target, position, speed));
    }
}
