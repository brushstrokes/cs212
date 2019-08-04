#include <iostream>
#include <string>

// Can't have integer arrays as return types.
// int[] doubler ( ... ) would be invalid.
// Instead, have the pointer to the array as the return type.
int* doubler (int a[], int size) {
    int * temp = new int[size];
    for (int i = 0; i < size; i++) {
        temp[i] = 2*a[i];
    }
    return temp;
}

int main()
{
    int a[] = {1, 2, 3, 4, 5};
    int *b;
    
    b = doubler (a, 5);
    
    std::cout << "Array a:\n";
    for (int i = 0; i < 5; i++) {
        std::cout << a[i] << " ";
    }
    std::cout << "\n";
    
    for (int i = 0; i < 5; i++) {
        std::cout << b[i] << " ";
    }
    
    delete[] b; // don't forget to delete b.
    return 0;
}

