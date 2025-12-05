user1 = input("Enter your name: ")
user2 = input("Enter your name: ")

while True:
    ans1 = input(f"{user1}, make a choice: rock, paper or scissors? ").lower()
    ans2 = input(f"{user2}, make a choice: rock, paper or scissors? ").lower()

    if ans1 == ans2:
        print("The game is a tie!!")
    elif ans1 == "rock":
        if ans2 == "scissors":
            print(f"{user1} wins!")
        else:  # ans2 == "paper"
            print(f"{user2} wins!")
    elif ans1 == "scissors":
        if ans2 == "paper":
            print(f"{user1} wins!")
        else:  # ans2 == "rock"
            print(f"{user2} wins!")
    elif ans1 == "paper":
        if ans2 == "rock":
            print(f"{user1} wins!")
        else:  # ans2 == "scissors"
            print(f"{user2} wins!")
    else:
        print("Invalid input!")
        continue  # Skip the play again question if input was invalid

    again = input("Do you want to play again? (yes/no): ").lower()
    if again != "yes":
        print("Thanks for playing!")
        break