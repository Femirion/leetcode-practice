package easy

/*
*
2520. Count the Digits That Divide a Number
https://leetcode.com/problems/count-the-digits-that-divide-a-number/description/
Runtime 0 ms Beats 100.00%
Memory 3.86 MB Beats 74.58%
*/
func countDigits(num int) int {
	tmp := num
	digits := [10]int{0}
	for 0 < tmp {
		digit := tmp % 10
		digits[digit]++
		tmp = tmp / 10
	}

	result := 0
	for i := range digits {
		digit := digits[i]
		if digit != 0 && num%i == 0 {
			result = result + digit
		}
	}

	return result
}
