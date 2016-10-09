package main

import (
	"fmt"
	"io/ioutil"
)

func display() {
	bs, err := ioutil.ReadFile("test.txt")
	if err != nil {
		return
	}
	str := string(bs)
	fmt.Println(str)
}
