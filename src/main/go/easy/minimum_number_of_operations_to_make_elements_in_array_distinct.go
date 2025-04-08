package easy

/*
*
3396. Minimum Number of Operations to Make Elements in Array Distinct
https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/
Runtime 0 ms Beats 100.00%
Memory 4.92 MB Beats 67.44%
*/
func minimumOperations(nums []int) int {
	result := 0
	existedNums := [101]int{}
	existedNums[nums[0]] = 1

	for idx := 1; idx < len(nums); idx++ {
		if existedNums[nums[idx]] != 0 {
			tmp := (existedNums[nums[idx]] / 3) + 1
			if result < tmp {
				result = tmp
			}
		}
		existedNums[nums[idx]] = idx
	}

	return result
}
