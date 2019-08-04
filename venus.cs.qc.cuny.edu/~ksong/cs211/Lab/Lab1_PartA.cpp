#include <iostream>
#include <cstring>

int main() {
    
    // Declare a C-string of size 50
    char cStr[50];
    
    // Prompt the User for a line of text of length 10 or more
    std::cout << "Enter a line of text of length 10+: ";
    std::cin.getline(cStr, 50);
    // Note: getline stores the last char in the array (at index 49) for the null character
    
    // Continues to prompt and store the User's input
    // until User enters a string of length at least 10
    while (strlen(cStr) < 10) {
        std::cout << "Incorrect length. Try again: ";
        std::cin.getline(cStr, 50);
    }
    
    // Retrieve the length of the string
    int len = strlen(cStr);
    
    // Print the C-string and the length
    std::cout << "Entry: \"" << cStr << "\" | Length: " << len << std::endl;
    
    // Find the start and end indices
    int mid = (len / 2);
    int start, stop = mid + 2;
    if (len % 2 == 0)
        start = mid - 3;
    else
        start = mid - 2;
    
    // Create a char array to store the sub-c-string
    // Max size of 7, since even length = 6 + 1 (null char)
    char subStr[7];
    subStr[5] = '\0';
    subStr[6] = '\0';
    
    // Copy over the substring to the new array
    for (int i = start, j = 0; i <= stop; i++, j++) {
        if (cStr[i] == ' ')
            subStr[j] = '*';
        else
            subStr[j] = cStr[i];
    }
    
    std::cout << subStr << "\n";

}