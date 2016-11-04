package main

import (
	"fmt"
)

func main() {
	nums := []int{2, 3, 4}
	sum := 0
	for _, num := range nums {
		sum += num
	}

	fmt.Println("Sum: ", sum)

	fmt.Println("---- demo1 -----")
	for i, num := range nums {
		if num == 3 {
			fmt.Println("index: ", i)
		}
	}

	fmt.Println("---- demo2 -----")
	kvs := map[string]string{"a": "apple", "b": "banana"}
	for k, v := range kvs {
		fmt.Printf("%s -> %s\n", k, v)
	}

	fmt.Println("---- demo3 ----- string acts as range index")
	for i := range "charanvallala" {
		fmt.Println(i)
	}

	fmt.Println("---- demo4 -----")
	for i, c := range "charan" {
		fmt.Println(i, c)
	}

}
