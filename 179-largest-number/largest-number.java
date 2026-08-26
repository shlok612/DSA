class Solution {
    public String largestNumber(int[] nums) {

        String[] numbers = new String[nums.length];

        // Convert integers to strings
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = String.valueOf(nums[i]);
        }

        // Custom sorting
        Arrays.sort(numbers, (a, b) -> {
            String ab = a + b;
            String ba = b + a;

            return ba.compareTo(ab);
        });

        // If the largest number is 0, answer should be "0"
        if (numbers[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (String s : numbers) {
            sb.append(s);
        }

        return sb.toString();
    }
}