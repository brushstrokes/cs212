#ifndef DATE_H
#define DATE_H

class Date {
    int month, day, year;
    
public:
    Date();
    Date(int m, int d, int y);
    
    int getDay();
    int getMonth();
    int getYear();
    
    void input();
    void output();
};

#endif
