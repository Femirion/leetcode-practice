package easy

/**
2728. Count Houses in a Circular Street
https://leetcode.com/problems/count-houses-in-a-circular-street/description/
Runtime 10 ms Beats 50.00%
Memory 6.51 MB Beats
-%
*/

type Street interface {
	OpenDoor()
	CloseDoor()
	IsDoorOpen() bool
	MoveRight()
	MoveLeft()
}

func houseCount(street Street, k int) int {
	for i := 0; i < k; i++ {
		street.CloseDoor()
		street.MoveRight()
	}

	street.OpenDoor()
	street.MoveRight()

	count := 0
	for i := 0; i < k; i++ {
		count++
		if street.IsDoorOpen() {
			break
		} else {
			street.MoveRight()
		}
	}
	return count
}
