#include <iostream>
using std::cout;
using std::endl;
using std::ios;

class Sale
{
public:
    Sale( );
    Sale(double thePrice);
    double getPrice( ) const;
    void setPrice(double newPrice);
    virtual double bill( ) const;
    double savings(const Sale& other) const;
    //Returns the savings if you buy other instead of the calling object.
private:
    double price;
};
    
bool operator < (const Sale& first, const Sale& second);
//Compares two sales to see which is larger.

/* Implementation */

Sale::Sale( ) : price(0)
{
    //Intentionally empty
}

Sale::Sale(double thePrice)
{
    if (thePrice >= 0)
        price = thePrice;
    else
    {
        cout << "Error: Cannot have a negative price!\n";
        exit(1);
    }
}

double Sale::bill( ) const
{
    return price;
}

double Sale::getPrice( ) const
{
    return price;
}

void Sale::setPrice(double newPrice)
{
    if (newPrice >= 0)
        price = newPrice;
    else
    {
        cout << "Error: Cannot have a negative price!\n";
        exit(1);

    }
}

double Sale::savings(const Sale& other) const
{
    return (bill( ) - other.bill( ));
}

bool operator < (const Sale& first, const Sale& second)
{
    return (first.bill( ) < second.bill( ));
}


class DiscountSale : public Sale
{

public:
    DiscountSale( );
    DiscountSale(double thePrice, double theDiscount);
    //Discount is expressed as a percent of the price.
    //A negative discount is a price increase.
    double getDiscount( ) const;
    void setDiscount(double newDiscount);
    double bill( ) const;
private:
    double discount;
};

/* Implementation */

DiscountSale::DiscountSale( ) : Sale( ), discount(0)
{
    //Intentionally empty
}

DiscountSale::DiscountSale(double thePrice, double theDiscount)
            : Sale(thePrice), discount(theDiscount)
{
    //Intentionally empty
}

double DiscountSale::getDiscount( ) const
{
    return discount;
}

void DiscountSale::setDiscount(double newDiscount)
{
    discount = newDiscount;
}

double DiscountSale::bill( ) const
{
    double fraction = discount/100;
    return (1 - fraction)*getPrice( );
}


int main() {
    Sale simple(10.00);
    DiscountSale discount(11.00, 10);
    
    // Ensures doubles print in two decimal points.
    cout.setf(ios::fixed);
    cout.setf(ios::showpoint);
    cout.precision(2);
    
    if (discount < simple) {
        cout << "Discounted item is cheaper." << endl;
        cout << "Savings is $" << simple.savings(discount) << endl;
    }
    else
        cout << "Discount item is not cheaper." << endl;
}