# Take name and age as input
name = input("Please enter your name: ")
age = int (input("Please enter your age: "))
age_more = 100-age
year = 2025+age_more
print("In the year " + str(year) + " You will be 100 year old")
print(f"Dear {name} you are 100 in the year {year}")