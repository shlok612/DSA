
class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> al = new ArrayList<>();

        for (int i : nums) {
            insert(al, i);
        }

        return al.size();
    }

    public void insert(ArrayList<Integer> al, int n) {
        int low = 0;
        int high = al.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (al.get(mid) < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (low == al.size()) {
            al.add(n);
        } else {
            al.set(low, n);
        }
    }
}