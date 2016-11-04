package main

import (
	"fmt"
)

func main() {
	c()
}
func a() {
	i := 0
	defer fmt.Println(i)
	i++
	fmt.Println(i)
	return
}
func b() {
	for i := 0; i < 4; i++ {
		defer fmt.Println(i)
	}
}
func c() (i int) {
	defer func() { i++ }()
	return 1
}
