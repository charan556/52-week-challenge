package main

import (
	"encoding/gob"
	"fmt"
	"net"
)

func server() {

	listen, err := net.Listen("tcp", ":9999")
	if err != nil {
		fmt.Println(err)
		return
	}
	for {
		connect, err := listen.Accept()
		if err != nil {
			fmt.Println(err)
			return
		}

		var msg string
		err2 := gob.NewDecoder(connect).Decode(&msg)
		if err2 != nil {
			fmt.Println(err2)
		} else {
			fmt.Println("received: ", msg)
		}
		connect.Close()
	}
}

func client() {
	c, err := net.Dial("tcp", "localhost:9999")
	if err != nil {
		fmt.Println(err)
		return
	}
	msg := "Hello connect"
	err = gob.NewEncoder(c).Encode(msg)
	c.Close()
}

func main() {
	go server()
	go client()

	var input string
	fmt.Scanln(input)
}
