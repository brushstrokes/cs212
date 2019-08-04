#include <iostream>
#include <string>

int main()
{
    try {
        int size, *a;
        std::cout << "Enter the size of the array: ";
        std::cin >> size;
        if (size <= 0)
            throw size;
        
        for (int i = 0; i < size; i++) {
            int x;
            std::cout << "Enter a positive number: ";
            std::cin >> x;
            if (x <= 0)
                throw x;
        }
        delete[] a;
        
    } catch (int e) {
       std::cout << e << " is not a positive number." << "\n"; 
    }

}

