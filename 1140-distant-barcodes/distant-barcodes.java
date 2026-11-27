import java.util.*;

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        // 1. Count frequencies using a HashMap
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        int maxNum = 0;

        for (int num : barcodes) {
            int count = freqMap.getOrDefault(num, 0) + 1;
            freqMap.put(num, count);
            
            // Track the most frequent barcode
            if (count > maxFreq) {
                maxFreq = count;
                maxNum = num;
            }
        }

        int n = barcodes.length;
        int[] result = new int[n];
        int index = 0;

        // 2. Place the most frequent number at even indices first (0, 2, 4...)
        while (freqMap.get(maxNum) > 0) {
            result[index] = maxNum;
            index += 2;
            freqMap.put(maxNum, freqMap.get(maxNum) - 1);
        }

        // 3. Iterate through the remaining entries in the HashMap
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            while (count > 0) {
                // Wrap around to odd indices (1, 3, 5...) once even indices are full
                if (index >= n) {
                    index = 1;
                }
                result[index] = num;
                index += 2;
                count--;
            }
        }

        return result;
    }
}