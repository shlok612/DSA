class Solution {
    public String originalDigits(String s) {

        int[] f = new int[26];

        for (char c : s.toCharArray()) {
            f[c - 'a']++;
        }

        String[] digits = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
        };

        char[] ids = {'z', 'o', 'w', 'h', 'u', 'f', 'x', 's', 'g', 'i'};

        int[] order = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};

        int[] digitCount = new int[10];

        for (int i : order) {
            int count = f[ids[i] - 'a'];

            for (char d : digits[i].toCharArray()) {
                f[d - 'a'] -= count;
            }

            digitCount[i] = count;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < digitCount[i]; j++) {
                sb.append(i);
            }
        }

        return sb.toString();
    }
}