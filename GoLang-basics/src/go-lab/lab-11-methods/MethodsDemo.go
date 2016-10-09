package main

import (
	"fmt"
)

type rectange struct {
	width, height int
}

func (r *rectange) area() int {
	return r.width * r.height
}

func (r rectange) perimeter() int {
	return 2*r.height + 2*r.width
}

func main() {
	r := rectange{height: 10, width: 10}

	fmt.Println("area: ", r.area())
	fmt.Println("perimter: ", r.perimeter())
}
