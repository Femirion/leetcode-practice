package easy

/*
*
3110. Score of a String
https://leetcode.com/problems/score-of-a-string/description/
Runtime 0 ms Beats 100.00%
Memory 4.16 MB Beats 9.20%
*/
func scoreOfString(s string) int {
	result := 0

	for i := 0; i < len(s)-1; i++ {
		result = result + (abs(int(s[i+1]), int(s[i])))
	}

	return result
}

func abs(x, y int) int {
	diff := x - y
	if 0 <= diff {
		return diff
	}
	return -diff
}
