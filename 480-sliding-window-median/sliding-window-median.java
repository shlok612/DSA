class Solution {

    PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> large = new PriorityQueue<>();

    HashMap<Integer, Integer> delayed = new HashMap<>();

    int smallSize = 0;
    int largeSize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        double[] ans = new double[n - k + 1];

        // First window
        for (int i = 0; i < k; i++) {
            add(nums[i]);
        }

        ans[0] = getMedian();

        // Slide window
        for (int i = k; i < n; i++) {

            // Remove nums[i-k]
            remove(nums[i - k]);

            // Add nums[i]
            add(nums[i]);

            ans[i - k + 1] = getMedian();
        }

        return ans;
    }

    private void add(int num) {

        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
            smallSize++;
        } else {
            large.offer(num);
            largeSize++;
        }

        rebalance();
    }

    private void remove(int num) {

        delayed.put(num, delayed.getOrDefault(num, 0) + 1);

        if (num <= small.peek()) {
            smallSize--;
        } else {
            largeSize--;
        }

        clean(small);
        clean(large);

        rebalance();
    }

    private void rebalance() {

        // small can have at most one more element than large
        if (smallSize > largeSize + 1) {

            large.offer(small.poll());

            smallSize--;
            largeSize++;

            clean(small);

        } else if (smallSize < largeSize) {

            small.offer(large.poll());

            largeSize--;
            smallSize++;

            clean(large);
        }
    }

    private void clean(PriorityQueue<Integer> pq) {

        while (!pq.isEmpty()) {

            int num = pq.peek();

            if (!delayed.containsKey(num)) {
                break;
            }

            int count = delayed.get(num);

            if (count == 1) {
                delayed.remove(num);
            } else {
                delayed.put(num, count - 1);
            }

            pq.poll();
        }
    }

    private double getMedian() {

        if (smallSize > largeSize) {
            return small.peek();
        }

        return ((double) small.peek() + (double) large.peek()) / 2.0;
    }
}