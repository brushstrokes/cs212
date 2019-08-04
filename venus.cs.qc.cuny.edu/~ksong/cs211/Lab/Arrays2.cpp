#include <iostream>
#include <string>

int main()
{
    
    // Arrays we've used so far require a specific size when being created.
    // ex) int a[20]; // an array named "a" of size 20 that stores integers
    
    // However, what if we don't know what size to put in the array?
    // Our set size might be too big, or too small.
    
    // Ans: Use dynamically allocated arrays (dynamic arrays).
    
    int size;
    std::cout << "Enter a size: ";
    std::cin >> size;
    
    int *a = new int[size];
    // Writing "int a[size]" is absolutely illegal.
    // If size is too big, it might cause stack overflow.
    std::cout << a << std::endl;
    
    delete[] a;
    // When you're done using your dynamic array, destroy/removing it from the heap to free memory.
    // Follow the above syntax. Make sure to use the "delete" keyword followed by the two square brackets "[]".
    // This is different from "delete a". (May still compile, but how it behaves is different for each compiler.)
    // Note: The "delete" keyword is used to free the allocated memory. It doesn't remove the variable a.
    // You can reuse "a" to point to a different thing.
    
}

