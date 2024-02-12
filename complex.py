class Complex:
    
    def __init__(self, real, imaginary):
        self.real=real
        self.imaginary=imaginary

    def __add__(self, other):
        if isinstance(other, float):
            return Complex(self.real+other, self.imaginary)
        elif isinstance(other, Complex):
            return Complex(self.real+other.real, self.imaginary+other.imaginary)
        else:
            raise TypeError
        
    def __radd__(self, other):
        return self+other

    def __sub__(self, other):
        if isinstance(other, float):
            return Complex(self.real-other, self.imaginary)
        elif isinstance(other, Complex):
            return Complex(self.real-other.real, self.imaginary-other.imaginary)
        else:
            raise TypeError

    def __rsub__(self, other):
        if isinstance(other, float):
            return Complex(other-self.real, -1*self.imaginary)
        else:
            raise TypeError

    def __mul__(self, other):
        if isinstance(other, float):
            return Complex(self.real*other, self.imaginary*other)
        elif isinstance(other, Complex): #(5+3i)(3+2i)=15+10i+9i+6i^2=15+10i+9i-6
            first=self.real*other.real
            outer=self.real*other.imaginary
            inner=self.imaginary*other.real
            last=self.imaginary*other.imaginary*-1
            return Complex(first+last, outer+inner)
        else:
            raise TypeError
        
    def __rmul__(self, other):
        return self*other

    def __truediv__(self, other):
        if isinstance(other, float):
            return Complex(self.real/other, self.imaginary/other)
        elif isinstance(other, Complex):  #(5+3i)/(3+2i)=[(5+3i)(3-2i)]/(9+4)
            numerator=Complex(self.real, self.imaginary)
            conjugate=Complex(other.real, other.imaginary*-1)
            denominator=(other.real**2)+(other.imaginary**2)
            numerator=numerator*conjugate
            return numerator/denominator
        else:
            raise TypeError

    def __rtruediv__(self, other):
        if isinstance(other, float): # 2/(5+3i)=(10-6i)/25+9
            denominator=(self.real**2)+(self.imaginary**2)
            conjugate=Complex(self.real, self.imaginary*-1)
            numerator=other*conjugate
            return numerator/denominator
        else:
            raise TypeError
    
    def __str__(self):
        return '(' + str(self.real) + " + " + str(self.imaginary) + "i)"
    

if __name__ == '__main__':

    a = Complex(1.1, 2.1)
    b = Complex(3.1, 4.1)

    i = 5.1

    print('%s + %s = %s' % (a, b, a + b))
    print('%s - %s = %s' % (a, b, a - b))
    print('%s * %s = %s' % (a, b, a * b))
    print('%s / %s = %s' % (a, b, a / b))

    print('%s + %i = %s' % (a, i, a + i))
    print('%s - %i = %s' % (a, i, a - i))
    print('%s * %i = %s' % (a, i, a * i))
    print('%s / %i = %s' % (a, i, a / i))

    print('%i + %s = %s' % (i, a, i + a))
    print('%i - %s = %s' % (i, a, i - a))
    print('%i * %s = %s' % (i, a, i * a))
    print('%i / %s = %s' % (i, a, i / a))
