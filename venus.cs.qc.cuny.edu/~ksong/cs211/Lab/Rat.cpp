// Example program
#include <iostream>

class Rat {
    
public:
    
    // Constructors
    Rat(int n, int d);
    Rat(int n);
    Rat();
    
    // accessor functions
    int getNumer();
    int getDenom();
    
    // set functions
    void setNumer(int n);
    void setDenom(int d);
    
    // member functions
    void normalize();
    bool checkDenom();
    Rat add(Rat r);
    void output();
    
private:
    int numer, denom;
};

Rat::Rat (int n, int d) {
    setNumer(n);
    setDenom(d);
}

Rat::Rat (int n) {
    setNumer(n);
    setDenom(1);
}

Rat::Rat() {
    setNumer(0);
    setDenom(1);
}

void Rat::setNumer(int n) {
    numer = n;
}

void Rat::setDenom(int d) {
    if (d == 0)
        exit(1);
    denom = d;
}

int Rat::getDenom() {
    return denom;
}

int Rat::getNumer() {
    return numer;
}

void Rat::normalize() {
    if (getNumer() < 0 && getDenom() < 0) {
        setNumer(-getNumer());
        setDenom(-getDenom());
    }
}

bool Rat::checkDenom() {
    if (getDenom() == 0) {
        return false;
    }
    return true;
}

Rat Rat::add(Rat r) {
    // Note: Function does not simply the new fraction
    
    Rat newRat;
    newRat.setNumer( getNumer() * r.getDenom() + r.getNumer() * getDenom() );
    newRat.setDenom( getDenom() * r.getDenom() );
    return newRat;
}

void Rat::output() {
    std::cout << getNumer() << "/" << getDenom() << "\n";
}

