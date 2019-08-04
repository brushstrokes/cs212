#include <iostream>
using namespace std;

int main() {
   int x = 5;
   int* p = &x;        // declare an int pointer and assign x's address to it
   cout << p << endl;  // print the address that p is pointing to
   cout << *p << endl; // print the value that p is pointing to
   *p = 6;             // assign 6 to x
   cout << x << endl;  // print x (6)

   int& r = x;         // declare r as a reference to x
   r = 7;              // assign 7 to x
   cout << r;          // print x (7)
   return 0;
}