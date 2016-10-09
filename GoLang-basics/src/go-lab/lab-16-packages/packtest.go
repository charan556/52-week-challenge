package main

import (
	"fmt"
	"package-demo/mylib"
)

func main() {
	nums := []float64{1, 2, 3, 14}
	avg := mylib.Average(nums)
	fmt.Println(avg)
}
