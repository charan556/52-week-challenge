package main

import (
	"fmt"
)

type person struct {
	name string
	age  int
}

func main() {
	fmt.Println(person{"Bob", 20})
	fmt.Println(person{name: "charan", age: 12})
	fmt.Println(person{name: "ishaan"})
	fmt.Println(&person{name: "chetan", age: 22})

	s := person{name: "ashok", age: 55}
	fmt.Println(s.name)

	sp := &s
	fmt.Println(sp.age)

	sp.age = 30
	fmt.Println(sp)

}
