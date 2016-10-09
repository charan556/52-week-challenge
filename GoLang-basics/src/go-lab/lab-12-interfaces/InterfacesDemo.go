package main

import (
	"fmt"
	"math"
)

type geometry interface {
	area() float64
}

// class
type circle struct {
	radius float64
}

// method of class circle
func (c circle) area() float64 {
	return math.Pi * c.radius * c.radius
}

func measure(g geometry) {
	fmt.Println(g)
	fmt.Println(g.area())
}

func main() {
	c := circle{radius: 10}
	fmt.Println(c.area())
	measure(c)

}
