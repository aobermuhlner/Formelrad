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
	
	public double getSpannung(double widerstand, double strom) {
            spannung = widerstand * strom;
            return spannung;
	}

	public double getStrom() {
            strom = spannung / widerstand;
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
		/* Hier auf Grund der vorhanden Werte entscheiden
		 * welche Methode unten aufgerufen werden muss.
		 */
	}
	
	/* Hier die Methoden mit den Formlen hinzuf�gen
	 */
	private double uFromRandI(double r, double i) {
		double result = r * i;
		System.out.println("Result of volt from ohm (" + r + ") and ampere (" + i + ") is " + result);
		return result;
	}

	private double UFromPAndI(double p, double i) {
		double result = p / i;
		System.out.println("Result of volt from watt (" + p + ") and ampere (" + i + ") is " + result);
		return result;
	}

	private double UFromPAndR(double p, double r) {
		double result = Math.sqrt(p * r);
		System.out.println("Result of volt from watt (" + p + ") and ohm (" + r + ") is " + result);
		return result;
	}
}
