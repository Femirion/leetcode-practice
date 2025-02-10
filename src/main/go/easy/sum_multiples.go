package easy

/**
2652. Sum Multiples
https://leetcode.com/problems/sum-multiples/description/
Runtime 0 ms Beats 100.00%
Memory 4.06 MB Beats 58.06%
*/

func sumOfMultiples(n int) int {
	result := 0

	for i := 3; i <= n; i++ {
		if i%3 == 0 || i%5 == 0 || i%7 == 0 {
			result = result + i
		}
	}

	return result
}
