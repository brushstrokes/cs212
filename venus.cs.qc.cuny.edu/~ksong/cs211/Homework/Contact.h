/* Header File */

#include <string>
using std::string;

#ifndef CONTACT_H
#define CONTACT_H

class Contact {
public:
    // Constructors
    Contact();
    Contact(string l, string f, string a, string p, string e);
    
    // Accessor (get) functions
    string getLastName();
    string getFirstName();
    string getAddress();
    string getPhoneNumber();
    string getEmail();
    
    // Mutator (set) functions
    void setLastName(string l);
    void setFirstName(string f);
    void setAddress(string a);
    void setPhoneNumber(string p);
    void setEmail(string e);
    
    void input();
    void output();

private:
    string lastName, firstName, address, phoneNumber, email;
};
#endif
