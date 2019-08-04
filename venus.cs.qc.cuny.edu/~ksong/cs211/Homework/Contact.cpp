/* Implementation File */

#include <iostream>
#include <string>
#include <cstdlib>
#include "Contact.h"

using std::string;
using std::cout;
using std::cin;

// Default constructor
Contact::Contact() {
	setLastName("Default");
	setFirstName("Default");
	setAddress("Default");
	setPhoneNumber("1234567890");
	setEmail("default@company.com");
}

Contact::Contact(string l, string f, string a, string p, string e) {
	setLastName(l); // lastName = l;
	setFirstName(f);
	setAddress(a);
	setPhoneNumber(p); // phoneNumber = p; **INVALID
	setEmail(e);
}

// accessor methods
string Contact::getLastName() {
	return lastName;
}
string Contact::getFirstName() {
	return firstName;
}
string Contact::getAddress() {
	return address;
}
string Contact::getPhoneNumber() {
	return phoneNumber;
}
string Contact::getEmail() {
	return email;
}

// mutator methods
void Contact::setLastName(string l) {
	lastName = l;
}
void Contact::setFirstName(string f) {
	firstName = f;
}
void Contact::setAddress(string a) {
	address = a;
}
void Contact::setPhoneNumber(string p) {
	if (p.length() != 10) {
		cout << "Invalid phone number.\n";
		exit(1);
	}
	phoneNumber = p;
}

void Contact::setEmail(string e) {
	if (e.find("@") == (int) -1) {
		cout << "Invalid email.\n";
		exit(1);
	}
	email = e;
}

void Contact::input() {
	
	string f, l, a, p, e;
	cout << "Enter first name: ";
	cin >> f;
	cout << "Enter last name: ";
	cin >> l;
	cin.ignore();
	cout << "Enter address: ";
	std::getline(cin, a);
	cout << "Enter phone number: ";
	cin >> p;
	cout << "Enter email: ";
	cin >> e;
	
	setFirstName(f);
	setLastName(l);
	setAddress(a);
	setPhoneNumber(p);
	setEmail(e);
	
}

void Contact::output() {
	cout << "****** Contact Info: ******\n";
	cout << "Name: " << firstName << " " << lastName << "\n";
	cout << "Address: " << address << "\n"; // std::endl;
	cout << "Phone number: " << phoneNumber << "\n";
	cout << "Email: " << email << "\n\n";
}
