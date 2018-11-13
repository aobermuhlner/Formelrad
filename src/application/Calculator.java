package application;

/**
 * Berechnet das Formelrad
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {
	private double leistung;
	private double spannung;
	private double strom;
	private double widerstand;
	
	public Calculator(double leistung, double spannung, double strom, double widerstand) {
		super();
		this.leistung = leistung;
		this.spannung = spannung;
		this.strom = strom;
		this.widerstand = widerstand;
	}
	
	public double getLeistung() {    
            leistung = spannung * strom;
		return leistung;
	}
	
	public double getSpannung() {
		return spannung;
	}

	public double getStrom() {
		return strom;
	}

	public double getWiderstand() {
		return widerstand;
	}

	@Override
	public String toString() {
		return "Calculator [leistung=" + leistung + 
				", spannung=" + spannung + 
				", strom=" + strom + 
				", widerstand="	+ widerstand + "]";
	}

	public void calculate() {
            
		
                
                
	}
	
	/* Hier die Methoden mit den Formlen hinzuf�gen
	 */
        public double iAusPundR(double p, double r){
            return java.lang.Math.sqrt((p/r));
        }
        public double iAusRundU(double r, double u) {
            double result = u/r;
            System.out.println("The result of ampere from volt (" + u + ") and ohm (" + r + ") is " + result);
            return result;
        }
	
}
