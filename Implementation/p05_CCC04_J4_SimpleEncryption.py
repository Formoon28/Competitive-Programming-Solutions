# https://dmoj.ca/problem/ccc04j4

def encodeChar(char, shiftKey):
    shiftKey = ord(shiftKey)-65
    char = ord(char)-65

    finalShift = (char+shiftKey)%26
    return chr(65 + finalShift)


keyword = input()
originalString = input()

for i in range(len(originalString)):
    if ord(originalString[i]) < 65 or ord(originalString[i]) > 90:
        originalString = originalString[:i] + " " + originalString[i+1:]

originalString = originalString.replace(" ", "")

encryptedString = ""
for i in range(len(originalString)):
    encryptedString += encodeChar(originalString[i], keyword[i%len(keyword)])

print(encryptedString)
