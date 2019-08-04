#include <iostream>
#include "Date.h"

/* Constructors */

Date::Date() {
    month = 1;
    day = 1;
    year = 1900;
}
// another way to write the above is to use "member initialization list",
// which is initializing variables directly in the function declaration.
// Example:
// Date::Date() : month(1), day(1), year(1900) {};

Date::Date(int m, int d, int y) : month(m), day(d), year(y) {
}

/* more member functions */

void Date::input() {
    std::cout << "Enter month: ";
    std::cin >> month;
    std::cout << "Enter day: ";
    std::cin >> day;
    std::cout << "Enter year: ";
    std::cin >> year;
}
void Date::output() {
    std::cout << month << "/" << day << "/" << year << "\n";
}
