package ru.femirion.leetcode.easy;

/**
 * 832. Flipping an Image
 * https://leetcode.com/problems/flipping-an-image/description/
 */
public class FlippingAnImage {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 44.82 MB Beats 5.96% of users with Java
     */
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int p = 0;
            int q = image[i].length - 1;
            while (p <= q) {
                int tmp = image[i][p];
                image[i][p] = reverse(image[i][q]);
                image[i][q] = reverse(tmp);
                p++;
                q--;
            }
        }
        return image;
    }

    private int reverse(int num) {
        return num == 0 ? 1 : 0;
    }
}
