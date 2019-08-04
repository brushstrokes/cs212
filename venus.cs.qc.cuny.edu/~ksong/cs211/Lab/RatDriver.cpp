#include <iostream>

#include "Rat.cpp"
    // import the Rat class & functions

/*
 *  Use a separate Driver file to test your object(s).
 */
int main() {

	Rat z; // Calls the default, no-argument constructor
	std::cout << z.getNumer() << "/" << z.getDenom() << "\n";
		// Can't call z.numer, z.denom directly because they are
		// set to private.

	Rat i(2); // Calls the 1-parameter constructor
	std::cout << i.getNumer() << "/" << i.getDenom() << "\n";

	Rat r(2, 5); // Calls the 2-param constructor
	r.output();

	// Test the "normalize" function
	Rat n(-1, -5);
	n.normalize();
	n.output();

	Rat addRat = i.add(r);
	addRat.output();
}
