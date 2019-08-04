#ifndef PERSON_H
#define PERSON_H

#include <string>
#include "Date.h"

class Person {
    Date birthday;
    std::string name;

public:
    Person();
    Person(Date &b, std::string n);
    
    Date getBirthday();
    std::string getName();
    void input();
    void output();
};

#endif
