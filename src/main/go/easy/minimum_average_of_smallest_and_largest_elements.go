package easy

import (
	"math"
	"sort"
)

/**
3194. Minimum Average of Smallest and Largest Elements
https://leetcode.com/problems/minimum-average-of-smallest-and-largest-elements/description/
Runtime 0 ms Beats 100.00%
Memory 4.46 MB Beats 51.28%
*/

func minimumAverage(nums []int) float64 {
	result := math.MaxFloat64

	sort.Ints(nums)
	p := 0
	q := len(nums) - 1

	total := 0
	for _, e := range nums {
		total = total + e
	}

	count := len(nums)
	for p < q {
		diff := nums[p] + nums[q]
		total -= diff
		count -= 2
		tmp := float64(total) / float64(count)
		if tmp < result {
			result = tmp
		}
		tmpDiff := float64(diff) / 2
		if tmpDiff < result {
			result = tmpDiff
		}
		p++
		q--
	}

	return result
}
