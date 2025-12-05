# Activity 2 - Odd or Even Numbers
# Ask the user for a number.
number = int(input("Please Enter a number : "))
abc = number % 2
if abc == 1:
    print(f"The number {number} is an odd number")
else:
    print(f"The number {number} is an even number")