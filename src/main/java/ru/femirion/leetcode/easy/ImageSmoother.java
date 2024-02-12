package ru.femirion.leetcode.easy;

/**
 * 661. Image Smoother
 * https://leetcode.com/problems/image-smoother/description/
 */
public class ImageSmoother {

    /**
     * Runtime 4 ms Beats 95.04% of users with Java
     * Memory 45.68 MB Beats 5.53% of users with Java
     */
    public int[][] imageSmoother(int[][] img) {
        int[][] result = new int[img.length][img[0].length];

        for (int i = 0; i < img.length - 1; i++) {
            for (int j = 0; j < img[i].length - 1; j++) {
                int upperLimit = Math.max(0, j - 1);
                int bottomLimit = Math.min(img[0].length - 1, j + 1);
                int leftLimit = Math.max(0, i - 1);
                int rightLimit = Math.min(i + 1, img.length - 1);

                int sum = 0;
                int count = 0;
                for (int n = leftLimit; n <= rightLimit; n++) {
                    for (int m = upperLimit ; m <= bottomLimit; m++) {
                        System.out.println("i=" + i + " j=" + j +" n=" + n + " m=" + m);
                        sum = sum + img[n][m];
                        count++;
                    }
                }
                int median = sum / count;
                result[i][j] = median;
            }
        }
        return result;
    }
}
