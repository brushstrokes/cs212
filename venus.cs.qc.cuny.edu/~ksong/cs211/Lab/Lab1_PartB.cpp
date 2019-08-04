#include <iostream>
#include <string>
#include <algorithm>

int main() {

    std::string s;
    
    std::cout << "Enter a line of text of length 10+: ";
    std::getline(std::cin, s);
    
    while (s.length() < 10) {
        std::cout << "Incorrect length. Try again: ";
        std::getline(std::cin, s);
    }
    
    // Retrieve the length of the string
    int len = s.length();
    
    // Print the C-string and the length
    std::cout << "Entry: \"" << s << "\" | Length: " << len << std::endl;
    
    // Find the start and end indices
    int mid = (len / 2);
    int start, stop;
    if (len % 2 == 0) {
        start = mid - 3;
        stop = 6;
    }
    else {
        start = mid - 2;
        stop = 5;
    }
    
    // Use the substr method from the string class
    // first parameter indicates the starting index
    // second parameter indicates how many characters to take
    std::string subStr = s.substr(start, stop);
    replace(subStr.begin(), subStr.end(), ' ', '*');
    
    std::cout << subStr << "\n";
}
    