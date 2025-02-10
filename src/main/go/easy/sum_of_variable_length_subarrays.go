package easy

/*
*
3427. Sum of Variable Length Subarrays
https://leetcode.com/problems/sum-of-variable-length-subarrays/description/
Runtime 0 ms Beats 100.00%
Memory 4.96 MB Beats 35.78%
*/
func subarraySum(nums []int) int {
	prefixSum := make([]int, len(nums)+1)

	sum := 0
	for i := 0; i < len(nums); i++ {
		sum = sum + nums[i]
		prefixSum[i+1] = sum
	}

	result := 0
	for i := 0; i < len(nums); i++ {
		maxIdx := i - nums[i]
		if maxIdx < 0 {
			maxIdx = 0
		}

		if maxIdx != i {
			result = result + (prefixSum[i+1] - prefixSum[maxIdx])
		} else {
			result = result + nums[i]
		}

	}

	return result
}
