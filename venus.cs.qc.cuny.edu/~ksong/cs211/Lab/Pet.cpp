#include <iostream>
using namespace std;

class Pet {
public:
    string name;
    virtual void print() const {
        cout << "Name: " << name << endl;
    }
};

class Dog : public Pet {
public:
    string breed;
    void print() const {
        cout << "Name: " << name << endl;
        cout << "Breed: " << breed << endl;
    }
};

int main()
{
    
    Dog vdog;
    Pet vpet;
    vdog.name = "Tiny";
    vdog.breed = "Great Dane";
    vpet = vdog;
    vpet.print();
    
    /*
    Pet *ppet;
    Dog *pdog;
    
    pdog = new Dog;
    pdog->name = "Tiny";
    pdog->breed = "Great Dane";
    ppet = pdog;
    ppet->print();
    */
    
}

