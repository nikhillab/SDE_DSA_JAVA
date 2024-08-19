class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum = 0, rsum = 0, msum = 0;
        for (var i = 0; i < k; i++)
            lsum += cardPoints[i];

        msum = lsum;
        var ridx = cardPoints.length - 1;
        for (var i = k - 1; i >= 0; i--) {
            lsum -= cardPoints[i];
            rsum += cardPoints[ridx];
            ridx--;
            msum = Math.max(msum, lsum + rsum);
        }

        return msum;
    }
}
