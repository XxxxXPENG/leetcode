package tanxin;

import java.util.PriorityQueue;

public class PredictPartyVictory {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        PriorityQueue<Integer> radiant = new PriorityQueue<>();
        PriorityQueue<Integer> dire = new PriorityQueue<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll(), direIndex = dire.poll();
            if (radiantIndex < direIndex) {
                radiant.offer(radiantIndex + n);
            }else {
                dire.offer(direIndex + n);
            }
        }
        return !radiant.isEmpty() ? "Radiant" : "Dire";

    }
}
