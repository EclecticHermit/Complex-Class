#include <iostream>

using namespace std;

struct Complex
{
	double real, imaginary;
	
	Complex()
	{
		real=0;
		imaginary=0;
	}
	Complex(double real)
	{
		this->real=real;
		imaginary=0;
	}
	Complex(double real, double imaginary)	
	{
		this->real=real;
		this->imaginary=imaginary;
	}
	
	
	void operator=(Complex comp)
	{
		real=comp.real;
		imaginary=comp.imaginary;
	}
	
	
	Complex operator+(const double& number)const
	{
		return Complex(real+number, imaginary);
	}
	Complex operator+(const Complex& comp)const
	{
		return Complex(real+comp.real, imaginary+comp.imaginary);
	}
	Complex operator-(const double& number)const 
	{
		return Complex(real-number, imaginary);
	}
	Complex operator-(const Complex& comp)const
	{
		return Complex(real-comp.real, imaginary-comp.imaginary);
	}
	Complex operator*(const double& number)const 
	{
		return Complex(real*number, imaginary*number);
	}
	Complex operator*(const Complex& comp)const //(5+3i)(3+2i)=15+10i+9i+6i^2=15+10i+9i-6
	{
		double first=real*comp.real;
		double outer=real*comp.imaginary;
		double inner=imaginary*comp.real;
		double last=imaginary*comp.imaginary*-1;
		return Complex(first+last,outer+inner);
	}
	Complex operator/(const double& number)const 
	{
		return Complex(real/number,imaginary/number);
	}
	Complex operator/(const Complex& comp)const //(5+3i)/(3+2i)=[(5+3i)(3-2i)]/(9+4)
	{
		Complex numerator(real,imaginary),conjugate(comp.real,comp.imaginary*-1);
		double denominator=(comp.real*comp.real)+(comp.imaginary*comp.imaginary);
		numerator=numerator*conjugate;
		return numerator/denominator;
	}
	
	
	friend Complex operator+(const double& number, const Complex& comp)
	{	
		return Complex(number+comp.real, comp.imaginary);
	}
	friend Complex operator-(const double& number, const Complex& comp) //5-(3+i)=5-3-i
	{
		return Complex(number-comp.real, -1*comp.imaginary);
	}
	friend Complex operator*(const double& number, const Complex& comp)
	{
		return Complex(number*comp.real, number*comp.imaginary);
	}
	friend Complex operator/(const double& number, const Complex& comp) // 2/(5+3i)=(10-6i)/25+9
	{
		double denominator=(comp.real*comp.real)+(comp.imaginary*comp.imaginary);
		Complex numerator(0,0), conjugate(comp.real,comp.imaginary*-1);
		numerator=number*conjugate;
		return numerator/denominator;
	}
	
	friend ostream& operator<<(ostream& stream, const Complex& comp)
	{
		stream <<'('<<comp.real<<" + "<<comp.imaginary<<'i'<<')';
		return stream;
	}
};


int main(int argc, char**argv)
{
	const Complex a(1.1,2.1), b(3.1,4.1); const double i=5.1;

    cout << a << " + " << b << " = " << a + b << endl;
    cout << a << " - " << b << " = " << a - b << endl;
    cout << a << " * " << b << " = " << a * b << endl;
    cout << a << " / " << b << " = " << a / b << endl;

    cout << a << " + " << i << " = " << a + i << endl;
    cout << a << " - " << i << " = " << a - i << endl;
    cout << a << " * " << i << " = " << a * i << endl;
    cout << a << " / " << i << " = " << a / i << endl;

    cout << i << " + " << a << " = " << i + a << endl;
    cout << i << " - " << a << " = " << i - a << endl;
    cout << i << " * " << a << " = " << i * a << endl;
    cout << i << " / " << a << " = " << i / a << endl;
}
