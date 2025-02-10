package easy

/*
*
3264. Final Array State After K Multiplication Operations I
https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/description/
Runtime 0 ms Beats 100.00%
Memory 5.24 MB Beats 75.12%
*/
func getFinalState(nums []int, k int, multiplier int) []int {

	for i := 0; i < k; i++ {
		min := nums[0]
		idx := 0

		for j := 0; j < len(nums); j++ {
			if nums[j] < min {
				min = nums[j]
				idx = j
			}
		}
		nums[idx] = nums[idx] * multiplier
	}

	return nums
}
