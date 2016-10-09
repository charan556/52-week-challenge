package main

import (
	"fmt"
)

func main() {
	m := make(map[string]int)

	m["key1"] = 1
	m["key2"] = 12

	fmt.Println("MAP: ", m)

	_, prs := m["key2"] //this way we can identify whether key is present or not
	fmt.Println("prs: ", prs)

	delete(m, "key2")
	fmt.Println("MAP after key2 deletion:", m)

}
