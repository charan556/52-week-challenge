package main

import (
	"fmt"
)

func main() {
	s := make([]string, 3)
	fmt.Println("emp:", s)

	s[0] = "a"
	s[1] = "b"
	s[2] = "c"

	fmt.Println("Set: ", s)
	fmt.Println("Set: ", s[2])

	s = append(s, "d")
	fmt.Println("After appending d, Set: ", s)

	c := make([]string, len(s))
	copy(c, s)

	fmt.Println("CSET: ", c)

	twodSlice := make([][]int, 3)
	for i := 0; i < 3; i++ {
		innerLen := i + i
		twodSlice[i] = make([]int, innerLen)
		for j := 0; j < innerLen; j++ {
			twodSlice[i][j] = i + j
		}
	}
	fmt.Println("2d: ", twodSlice)
}
