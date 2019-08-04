void reverse(int n) {
    if (n == 0) {
        return;
    }
    
    cout << n % 10;
    reverse(n / 10);
}


int reverse(int n) {
    if (n < 10) {
        return n;
    }
    int temp = n;
    int base = 1;
    while (temp > 10) {
        base *= 10;
        temp /= 10;
    }
    return base * (n % 10) + reverse(n / 10);
}


int addDigits(int n) {
    if (n < 10)
        return n;
        
    int sum = 0;
    while (n > 0) {
        sum += n % 10;
        n /= 10;
    }
    return addDigits(sum);
}


int fibonacci(int n) {
    if (n == 1 || n == 2)
        return 1;
    return fibonacci(n - 1) + fibonacci(n - 2);
}