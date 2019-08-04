#include <iostream>
#include <string>
#include "Person.h"

Person::Person() {
    Date d;
    birthday = d;
    name = "Default";
}

Person::Person(Date &b, std::string n) {
    birthday = b;
    name = n;
}

Date Person::getBirthday() {
    return birthday;
}
std::string Person::getName() {
    return name;
}

void Person::input() {
    std::cout << "Enter name: ";
    std::getline(std::cin, name);
        // (1)  We prefer to use mutator functions for error checking.
        //      However, member variables can be modified directly as well.
        //      "name" is a member variable from the Person class.
        // (2)  May need to use std::cin.ignore() in the main function
        //      when calling the input function again due to "getline"
    std::cout << "Entering birthday." << "\n";
    birthday.input();
}

void Person::output() {
    std::cout << name << "'s date of birth: ";
    birthday.output();
}
