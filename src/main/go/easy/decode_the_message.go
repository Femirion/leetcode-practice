package easy

import "strings"

/**
2325. Decode the Message
https://leetcode.com/problems/decode-the-message/description/
Runtime 0 ms Beats 100.00%
Memory 4.5 MB Beats 80.00%
*/

func decodeMessage(key string, message string) string {
	chars := make(map[rune]rune)
	chars[' '] = ' '

	char := 'a'
	j := 0
	for i := 0; i < 26 && j < len(key); {
		var c = rune(key[j])
		if c == ' ' {
			j++
			continue
		}
		if _, exists := chars[c]; !exists {
			chars[c] = char
			char++
			i++
		}
		j++
	}

	var sb strings.Builder

	for _, c := range message {
		sb.WriteRune(chars[c])
	}

	return sb.String()
}
