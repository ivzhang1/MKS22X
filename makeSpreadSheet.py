f = open("spreadsheet.txt", "r")

g = open("spreadsheet.csv", "w")

for line in f.readlines():
    g.write(line)
    

