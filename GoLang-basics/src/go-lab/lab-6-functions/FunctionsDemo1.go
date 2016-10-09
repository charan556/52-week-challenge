package main

import (
	"fmt"
)

func sum(a int, b int) int {
	return a + b
}

func vals() (int, int) {
	return 3, 7
}

func sums(a, b, c int) int {
	return a + b + c
}

func add(nums ...int) {
	total := 0
	for _, num := range nums {
		total += num
	}
	fmt.Println(total)
}

func main() {
	a, b := vals()
	res := sum(a, b)
	fmt.Println("Sum : ", res)
}
