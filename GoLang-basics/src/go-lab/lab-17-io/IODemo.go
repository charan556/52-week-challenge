package main

import (
	"fmt"
	"os"
)

func main() {

	file, err := os.Create("test.txt")
	if err != nil {
		return
	}
	defer file.Close()
	file.WriteString("This is demo text 212")

	file2, err := os.Open("test.txt")
	if err != nil {
		return
	}

	defer file2.Close()

	stat, err := file.Stat()
	if err != nil {
		return
	}
	// read the file
	bs := make([]byte, stat.Size())
	_, err = file2.Read(bs)
	if err != nil {
		return
	}

	str := string(bs)
	fmt.Println(str)

}
