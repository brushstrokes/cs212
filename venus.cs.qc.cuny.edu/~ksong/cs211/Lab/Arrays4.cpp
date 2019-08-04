#include <iostream>
#include <string>

int main()
{

    // Multidimensional array arithmetic
    
    int a[3][4]; // 3 x 4 (3 rows, 4 cols) 2D array
    
    int num = 0;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 4; j++) {
            a[i][j] = num++;
            std::cout << a[i][j] << " ";
        }
        std::cout << std::endl;
    }
    
    std::cout << a << std::endl;
    // prints the address at a[0][0]
    
    std::cout << a + 1 << std::endl;
    // prints the address at a[1][0]
    
    std::cout << *a + 1 << std::endl;
    // prints the address at a[0][1]
    
    std::cout << **(a + 1) << std::endl;
    // prints the value at a[1][0]
    
    std::cout << &a << std::endl;
    // prints the address of the entire array (which is a[0][0])
    
    std::cout << &a + 1 << std::endl;
    

}

