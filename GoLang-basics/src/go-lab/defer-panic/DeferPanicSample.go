package main

import "fmt"

func main2() {
	letUsPanic()
}

func letUsPanic() {
	defer func() {
		if e := recover(); e != nil {
			// e is the interface{} typed-value we passed to panic()
			fmt.Println("Whoops: ", e) // Prints "Whoops: boom!"
		}
	}()
	panic("boom!")
	fmt.Println("This will never be called")
}
