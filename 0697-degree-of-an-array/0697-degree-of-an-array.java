class Solution {
    public int findShortestSubArray(int[] nums) {
        int n = nums.length;

        int[] freq = new int[50000];
        int[] first = new int[50000];
        int[] last = new int[50000];

        for (int i = 0; i < 50000; i++) {
            first[i] = -1;
        }

        int degree = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            if (first[x] == -1) {
                first[x] = i;
            }

            freq[x]++;
            last[x] = i;

            degree = Math.max(degree, freq[x]);
        }

        int answer = n;

        // Find shortest range for elements having maximum frequency
        for (int x = 0; x < 50000; x++) {
            if (freq[x] == degree) {
                int length = last[x] - first[x] + 1;
                answer = Math.min(answer, length);
            }
        }

        return answer;
    }
}