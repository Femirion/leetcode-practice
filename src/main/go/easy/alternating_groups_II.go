package easy

/**

3208. Alternating Groups II
https://leetcode.com/problems/alternating-groups-ii/description/

Runtime 108 ms Beats 33.33%
Memory 11.70 MB Beats 20.00%
*/

func numberOfAlternatingGroups(colors []int, k int) int {
	start := 0
	end := 1
	result := 0
	prevColor := colors[0]
	for i := 1; i < len(colors)+k-1; i++ {
		var idx int
		if i < len(colors) {
			idx = i
		} else {
			idx = i - len(colors)
		}
		curColor := colors[idx]
		if prevColor == curColor {
			start = end
			end++
		} else {
			if end-start < k {
				end++
			}
			if end-start == k {
				result++
				end++
				start++
			}
		}
		prevColor = curColor
	}
	return result
}
