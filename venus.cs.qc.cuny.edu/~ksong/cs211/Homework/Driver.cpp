/* Driver File */

#include "Contact.h" // include just the header file

int main() {

	Contact c1; // default constructor
	Contact c2("Smith", "Jane", "123 Elm Street", "7189974444", "jane@somewhere.com");
	
	// Contact c3(); // incorrect, does not call the default constructor
	
	c1.input();
	c1.output();
}