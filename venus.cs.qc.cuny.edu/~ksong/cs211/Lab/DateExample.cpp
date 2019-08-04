#include <iostream>
using namespace std;

class Date {
public:
	/* 
	 * Accessor functions:
	 * Function name should be get + name of the data member
	 * return type should be the same as the data member
	 * 0 parameters
	 */
	int getMonth();
	int getDay();
	int getYear();

	/*
	 * Mutator functions:
	 * Function name should be set + name of the data member
	 * return type should be void
	 * 1 parameter, same type as data member
	 */
	void setMonth(int m);
	void setDay(int d);
	void setYear(int y);

private:
	int month, day, year;
};

void Date::setMonth(int m) {
		if (m < 1 || m > 12) {
			cout << "Illegal Month." << endl;
			exit(1);
		}
		month = m;
	}

void Date::setDay(int d) {
    if (d < 1 || d > 31) {
    	cout << "Illegal Day." << endl;
    	exit(1);
    }
    day = d;
}

void Date::setYear(int y) {
	if (y < 1) {
		cout << "Illegal Year." << endl;
		exit(1);
	}
	year = y;
}

int Date::getMonth() {
	return month;
}

int Date::getDay() {
	return day;
}

int Date::getYear() {
	return year;
}

int main() {
    
    Date d; // Good
    //d.month; // Illegal!
    
    d.setMonth(2);
    d.setDay(20);
    d.setYear(2018);
    
    cout << d.getMonth() << "/" << d.getDay() << "/" << d.getYear() << endl;
    
}

