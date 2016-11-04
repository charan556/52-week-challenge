package main

import "fmt"

func explode() {
	// Cause a panic.
	panic("WRONG")
}

func main() {
	// Handle errors in defer func with recover.
	defer func() {
		if err := recover(); err != nil {
			// Handle our error.
			fmt.Println("FIX")
			fmt.Println("ERR", err)
		}
	}()
	// This causes an error.
	explode()
}
