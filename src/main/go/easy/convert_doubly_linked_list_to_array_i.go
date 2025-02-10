package easy

/*
*

3263. Convert Doubly Linked List to Array I
https://leetcode.com/problems/convert-doubly-linked-list-to-array-i/description/
Runtime 0 ms Beats 100.00%
Memory 5.12 MB Beats 10.87%
*/
func toArray(head *Node) []int {
	var result = make([]int, 0)
	for head != nil {
		result = append(result, head.Val)
		head = head.Next
	}
	return result
}
