public class Complex 
{
	double real=0; double imaginary=0;
	
	Complex()
	{
		real=0;
		imaginary=0;
	}
	Complex(double real)
	{
		this.real=real;
		imaginary=0;
	}
	Complex(double real, double imaginary)	
	{
		this.real=real;
		this.imaginary=imaginary;
	}
	
	void assign(Complex comp)
	{
		real=comp.real;
		imaginary=comp.imaginary;
	}
	Complex add(double number)
	{
		Complex a = new Complex(real+number, imaginary);
		return a;
	}
	Complex add(Complex comp)
	{
		Complex a = new Complex(real+comp.real, imaginary+comp.imaginary);
		return a;
	}
	Complex subtract(double number) 
	{
		Complex a=new Complex(real-number, imaginary);
		return a;
	}
	Complex subtract(Complex comp)
	{
		Complex a=new Complex(real-comp.real, imaginary-comp.imaginary);
		return a;
	}
	Complex multiply(double number) 
	{
		Complex a=new Complex(real*number, imaginary*number);
		return a;
	}
	Complex multiply(Complex comp) //(5+3i)(3+2i)=15+10i+9i+6i^2=15+10i+9i-6
	{
		double first=real*comp.real;
		double outer=real*comp.imaginary;
		double inner=imaginary*comp.real;
		double last=imaginary*comp.imaginary*-1;
		Complex a=new Complex(first+last,outer+inner);
		return a;
	}
	Complex divide(double number) 
	{
		Complex a=new Complex(real/number,imaginary/number);
		return a;
	}
	Complex divide(Complex comp) //(5+3i)/(3+2i)=[(5+3i)(3-2i)]/(9+4)
	{
		Complex numerator=new Complex(real,imaginary); Complex conjugate=new Complex(comp.real,comp.imaginary*-1);
		double denominator=(comp.real*comp.real)+(comp.imaginary*comp.imaginary);
		numerator=numerator.multiply(conjugate);
		Complex a=new Complex();
		a=numerator.divide(denominator);
		return a;
	}
	static Complex add(double number, Complex comp)
	{
		Complex a=new Complex(number+comp.real, comp.imaginary);
		return a;
	}
	static Complex subtract(double number, Complex comp) //5-(3+i)=5-3-i
	{
		Complex a=new Complex(number-comp.real, -1*comp.imaginary);
		return a;
	}
	static Complex multiply(double number, Complex comp)
	{
		Complex a=new Complex(number*comp.real, number*comp.imaginary);
		return a;
	}
	static Complex divide(double number, Complex comp) // 2/(5+3i)=(10-6i)/25+9
	{
		double denominator=(comp.real*comp.real)+(comp.imaginary*comp.imaginary);
		Complex numerator=new Complex(); Complex conjugate=new Complex(comp.real,comp.imaginary*-1);
		numerator=multiply(number, conjugate);
		Complex a=new Complex();
		a=numerator.divide(denominator);
		return a;
	}
	
	public String toString()
	{
		return"(" + real + " + " + imaginary + "i)";
	}
	
	public static void main(String[] args)
	{
		 Complex a = new Complex(1.1, 2.1);
	     Complex b = new Complex(3.1, 4.1);

	     double i = 5.1;

	     System.out.println(a + " + " + b + " = " + a.add(b));
	     System.out.println(a + " - " + b + " = " + a.subtract(b));
	     System.out.println(a + " * " + b + " = " + a.multiply(b));
	     System.out.println(a + " / " + b + " = " + a.divide(b));

	     System.out.println(a + " + " + i + " = " + a.add(i));
	     System.out.println(a + " - " + i + " = " + a.subtract(i));
	     System.out.println(a + " * " + i + " = " + a.multiply(i));
	     System.out.println(a + " / " + i + " = " + a.divide(i));
	     
	     System.out.println(i + " + " + a + " = " + add(i,a));
	     System.out.println(i + " - " + a + " = " + subtract(i,a));
	     System.out.println(i + " * " + a + " = " + multiply(i,a));
	     System.out.println(i + " / " + a + " = " + divide(i,a));
	}
}
