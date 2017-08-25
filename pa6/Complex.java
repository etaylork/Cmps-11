//-----------------------------------------------------------------------------
// Complex.java
// Represents complex numbers as a pair of doubles
//
// pa6
// Fill in the function definitions below. See class notes, or the project 
// description for the definitions of the complex arithmetic operations.
//-----------------------------------------------------------------------------

class Complex{

   //--------------------------------------------------------------------------
   // Private Data Fields 
   //--------------------------------------------------------------------------
   private double re;
   private double im;
   
   //--------------------------------------------------------------------------
   // Public Constant Fields 
   //--------------------------------------------------------------------------
   public static final Complex ONE = Complex.valueOf(1,0);
   public static final Complex ZERO = Complex.valueOf(0,0);
   public static final Complex I = Complex.valueOf(0,1);

   //--------------------------------------------------------------------------
   // Constructors 
   //--------------------------------------------------------------------------
   Complex(double a, double b){
      this.re = a;
      this.im = b;
   }

   Complex(double a){
      this.re = a;
      this.im = 0;
   }

   Complex(String s){
      // Fill in this constructor.
      // It should accept expressions like "-2+3i", "2-3i", "3", "5i", etc..
      // Throw a NumberFormatException if s cannot be parsed as Complex.
      double[] C = Complex.parseComplex(s);
      try{

         this.re = C[0];
         this.im = C[1];

      }catch(NumberFormatException ex){
         System.out.println("The expression entered was not a complex number.");
      }
   }

   //---------------------------------------------------------------------------
   // Public methods 
   //---------------------------------------------------------------------------

   // Complex arithmetic -------------------------------------------------------

   // copy()
   // Return a new Complex equal to this Complex
   Complex copy(){
      // Fill in
      return new Complex(this.re, this.im);
   }
   
   // add()
   // Return a new Complex representing the sum this plus z.
   Complex add(Complex z){
      // Fill in
      double c = this.re + z.re;
      double d = this.im + z.im;
      return new Complex(c,d);

   }
   
   // negate()
   // Return a new Complex representing the negative of this.
   Complex negate(){
      // Fill in
      double a = this.re * -1;
      double b = this.im * -1;
      return new Complex(a,b);
   }

   // sub()
   // Return a new Complex representing the difference this minus z.
   Complex sub(Complex z){
      // Fill in
      double a = this.re - z.re;
      double b = this.im - z.im;
      return new Complex(a,b);

   }

   //mult()
   // Return a new Complex representing the product this times z.
   Complex mult(Complex z){
      // Fill in
      double x = (this.re * z.re) - (this.im * z.im);
      double w = (this.re * z.im) + (this.im * z.re);
      return new Complex(x, w);
   }

   // recip()
   // Return a new Complex representing the reciprocal of this.
   // Throw an ArithmeticException with appropriate message if 
   // this.equals(Complex.ZERO).
   Complex recip(){
      // Fill in
      if (this.equals(Complex.ZERO)){
            throw new NumberFormatException("the reciprocal of zero is zero.");
         }
      
      double a = (this.re/(Math.pow(this.re,2) + Math.pow(this.im,2)));
      double b = (-1*this.im)/(Math.pow(this.re,2) + Math.pow(this.im,2));
      
      return new Complex(a,b);

   }

   // div()
   // Return a new Complex representing the quotient of this by z.
   // Throw an ArithmeticException with appropriate message if 
   // z.equals(Complex.ZERO).
   Complex div(Complex z){
      // Fill in
      if (z.equals(Complex.ZERO)){
            throw new NumberFormatException("Cannot divided by zero.");
         }
      double a = z.re;
      double b = z.im;
      double c = this.re;
      double d = this.im;
      double w = ((a*c)+(b*d))/(Math.pow(z.re,2) + Math.pow(z.im,2));
      double y = ((a*d)-(b*c))/(Math.pow(z.re,2) + Math.pow(z.im,2));
      return new Complex(w,y);
   }

   // conj()
   // Return a new Complex representing the conjugate of this Complex.
   Complex conj(){
       //Fill in
      double a = this.re;
      double b = -1*this.im;
      return new Complex(a,b);
   }
   
   // Re()
   // Return the real part of this.
   double Re(){
      return re;
   }

   // Im()
   // Return the imaginary part of this.
   double Im(){
      return im;
   }

   // abs()
   // Return the modulus of this Complex, i.e. the distance between 
   // points (0, 0) and (re, im).
   double abs(){
      // Fill in
      double a = Math.pow(re,2) + Math.pow(im,2);
      double z = Math.sqrt(a);
      return z; 
   }

   // arg()
   // Return the argument of this Complex, i.e. the angle this Complex
   // makes with positive real axis.
   double arg(){
      return Math.atan2(im, re);
   }

   // Other functions ---------------------------------------------------------
   
   // toString()
   // Return a String representation of this Complex.
   // The String returned will be readable by the constructor Complex(String s)
   public String toString(){
      // Fill in
      if(this.re == 0){
         return(this.im +"i");
      }else if(this.im == 0){
         return(String.valueOf(this.re));
      }
      else if(this.im < 0){
         return(this.re + "" + this.im + "i");
      }else
         return(this.re + "+" + this.im + "i");
   }

   // equals()
   // Return true iff this and obj have the same real and imaginary parts.
   public boolean equals(Object obj){
      // Fill in
      if(obj instanceof Complex){
         Complex test = (Complex) obj;
         return this.re == test.re && this.im == test.im;
      }
      return false; 
   }

   // valueOf()
   // Return a new Complex with real part a and imaginary part b.
   static Complex valueOf(double a, double b){
      // Fill in
      return new Complex(a,b);
   }

   // valueOf()
   // Return a new Complex with real part a and imaginary part 0.
   static Complex valueOf(double a){
      // Fill in
      return new Complex(a);
   }

   // valueOf()
   // Return a new Complex constructed from s.
   static Complex valueOf(String s){
      // Fill in
      return new Complex(s);
   }

   static double[] parseComplex(String str){
      double[] part = new double[2];
      String s = str.trim();
      String NUM = "(\\d+\\.\\d*|\\.?\\d+)";
      String SGN = "[+-]?";
      String OP =  "\\s*[+-]\\s*";
      String I =   "i";
      String OR =  "|";
      String REAL = SGN+NUM;
      String IMAG = SGN+NUM+"?"+I;
      String COMP = REAL+OR+
                    IMAG+OR+
                    REAL+OP+NUM+"?"+I;
      
      if( !s.matches(COMP) ){
         throw new NumberFormatException(
                   "Cannot parse input string \""+s+"\" as Complex");
      }
      s = s.replaceAll("\\s","");     
      if( s.matches(REAL) ){
         part[0] = Double.parseDouble(s);
         part[1] = 0;
      }else if( s.matches(SGN+I) ){
         part[0] = 0;
         part[1] = Double.parseDouble( s.replace( I, "1.0" ) );
      }else if( s.matches(IMAG) ){
         part[0] = 0;
         part[1] = Double.parseDouble( s.replace( I , "" ) );
      }else if( s.matches(REAL+OP+I) ){
         part[0] = Double.parseDouble( s.replaceAll( "("+REAL+")"+OP+".+" , "$1" ) );
         part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+")"+I , "$1"+"1.0" ) );
      }else{   //  s.matches(REAL+OP+NUM+I) 
         part[0] = Double.parseDouble( s.replaceAll( "("+REAL+").+"  , "$1" ) );
         part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+NUM+")"+I , "$1" ) );
      }
      return part;
   }

}