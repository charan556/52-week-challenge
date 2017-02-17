while True:
    try:
        x = int(input("Please enter a number"))
        print(x)
        break
    except ValueError:
        print("Oops !! thats not a number.. Try again")


    