package easy

/**
2965. Find Missing and Repeated Values
https://leetcode.com/problems/find-missing-and-repeated-values/description/
Runtime 0 ms Beats 100.00%
Memory 8.19 MB Beats 71.88%
*/

func findMissingAndRepeatedValues(grid [][]int) []int {
	result := []int{}
	n := len(grid)
	nums := make([]int, n*n+1)

	for i := range grid {
		for j := range grid[i] {
			if nums[grid[i][j]] != 0 {
				result = append(result, grid[i][j])
			} else {
				nums[grid[i][j]] = 1
			}
		}
	}

	for i, val := range nums {
		if val == 0 && i != 0 {
			result = append(result, i)
			return result
		}
	}

	return result
}
