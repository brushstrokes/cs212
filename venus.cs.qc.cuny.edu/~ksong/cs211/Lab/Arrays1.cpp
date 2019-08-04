#include <iostream>

int main() {

    std::cout << sizeof(int) << "\n";
    // prints the size of an int in bytes
    
    int a[3] = {1, 2, 3};
    // arrays behave as a pointer to the first index
    // This array is made on the stack
    
    std::cout << a << "\n";
    // prints the address of "a" at index 0
    // Addresses are stored in hexadecimal form (base 16).
    
    std::cout << a + 1 << "\n";
    // prints the address of "a" at index 1
    
    std::cout << *(a + 1) << "\n";
    // uses the dereferencing operator * to retrieve the value stored at address (a + 1)

    int *p = a; // creates a pointer that points to the address of a
    p[2] = 10; // changes the value at index 2 to 10
    std::cout << a[2];

}

