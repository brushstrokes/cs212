
#include <iostream>
#include <fstream>
#include <ctime>

int main() {

    /*
     *  Create an ofstream (output) object variable named "fout"
     *  and open/create a text file named "output.txt"
     *  Same as:    std::ofstream fout;
     *              fout.open("test.txt");
     */
    std::ofstream fout("output.txt");
    
    // Check whether file opened successfully
    if (fout.fail()) {
        std::cout << "File experienced an issue." << std::endl;
        exit(1);
    }
    
    // Randomize seed
    srand(time(0));
    
    // Write 200 numbers in a 20 x 10 array format to "output.txt"
    for (int i = 0; i < 20; i++) {
        for (int j = 0; j < 10; j++) {
            fout << rand() % 9999 + 1 << " ";
            // Write a random number between 1-9999 followed by a space,
            // note the use of fout, not cout
        }
        fout << "\n"; // Write a new line for next row
    }
    
    // Done writing, close the file output stream
    fout.close();
    
    // Create an input file stream, attempt to open "output.txt"
    std::ifstream fin("output.txt");
    if (fin.fail()) {
        std::cout << "File not found." << std::endl;
        exit(1);
    }
    
    // Since we want the transpose of the original array,
    // read the number and directly store it in the transposed array
    // thus, a 10x20 matrix is created
    int a[10][20];
    for (int r = 0; r < 20; r++) {
        for (int c = 0; c < 10; c++) {
            fin >> a[c][r];
            // Store the number read into the transpose matrix
            // by switching the row and col value
        }
    }
    
    // Print to the console
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 20; j++) {
            std::cout << a[i][j] << " ";
        }
        std::cout << std::endl;
    }
    
    std::cout << "Success!" << std::endl;
    fin.close();
    
}
