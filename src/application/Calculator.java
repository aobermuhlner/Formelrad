package application;


import java.util.Objects;
import java.util.stream.Stream;

/**
 * Berechnet das Formelrad
 * @author Adrian Obermühlner
 */
public class Calculator {
	private Double leistung;
	private Double spannung;
	private Double strom;
	private Double widerstand;
	
	public Calculator(double leistung, double spannung, double strom, double widerstand) {
		super();
		this.leistung = leistung;
		this.spannung = spannung;
		this.strom = strom;
		this.widerstand = widerstand;
	}
	
	public double getLeistung() {    
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

	public boolean calculate() {
        long filledFieldsAmount = Stream.of(leistung, spannung, strom, widerstand)
                .filter(Objects::nonNull)
                .count();

		if (leistung != null && spannung != null) {
			strom = iAusPundU(spannung, leistung);
			widerstand = rAusUundP(spannung, leistung);
		} else if (leistung != null && strom != null) {
			spannung = uAusPUndI(leistung, strom);
			widerstand = rAusPundI(leistung, strom);
		} else if (leistung != null && widerstand != null) {
			spannung = uAusPundR(leistung, widerstand);
			strom = iAusRundU(widerstand, leistung);
		} else if (spannung != null && strom != null) {
			leistung = pAusUundI(spannung, strom);
			widerstand = rAusUundI(spannung, strom);
		} else if (spannung != null && widerstand != null) {
			leistung = pAusUundR(spannung, widerstand);
			strom = iAusRundU(widerstand, spannung);
		} else if (strom != null && widerstand != null) {
			leistung = pAusIundR(strom, widerstand);
			spannung = uAusRundI(widerstand, strom);
		} else {
			throw new RuntimeException("Not enough args");
		}

        return filledFieldsAmount < 3;
    }
	
	/* Hier die Methoden mit den Formlen hinzuf�gen
	 */

	public double iAusPundU(double p, double u){
            double result = p/u;
            System.out.println("The result of ampere from volt (" + u + ") and watt (" + p + ") is " + result);
             return result;
        } 
        public double iAusPundR(double p, double r){
            double result = java.lang.Math.sqrt((p/r));
            System.out.println("The result of ampere from ohm (" + r + ") and watt (" + p + ") is " + result);
             return result;
        }
        public double iAusRundU(double r, double u) {
            double result = u/r;
            System.out.println("The result of ampere from volt (" + u + ") and ohm (" + r + ") is " + result);
            return result;
        }
        //Watt
        private double pAusIundR(double i, double r) {
            double result = r * Math.pow(i, 2);
            System.out.println("Result of watt from ampere (" + r + ") and ohm (" + i + ") is " + result);
        return result;
	}

	private double pAusUundI(double u, double i) {
            double result = u * i;
            System.out.println("Result of watt from volt (" + u + ") and ampere (" + i + ") is " + result);
        return result;
        }
        private double pAusUundR(double u, double r) {
            double result = Math.pow(u, 2) / r;
            System.out.println("Result of watt from volt (" + u + ") and ohm (" + r + ") is " + result);
        return result;
        }

	private double uAusRundI(double r, double i) {
		double result = r * i;
		System.out.println("Result of volt from ohm (" + r + ") and ampere (" + i + ") is " + result);
		return result;
	}

	private double uAusPUndI(double p, double i) {
		double result = p / i;
		System.out.println("Result of volt from watt (" + p + ") and ampere (" + i + ") is " + result);
		return result;
	}

	private double uAusPundR(double p, double r) {
		double result = Math.sqrt(p * r);
		System.out.println("Result of volt from watt (" + p + ") and ohm (" + r + ") is " + result);
		return result;
	}
        //Ohm
        private double rAusUundI(double u, double i) {
		double result = u/i;
        System.out.println("Result of ohm from volt (" + u + ") and ampere (" + i + ") is " + result);
        return result;
	}
        private double rAusPundI(double p, double i) {
		double result =  p/Math.pow(i, 2);
        System.out.println("Result of ohm from watt (" + p + ") and ampere (" + i + ") is " + result);
        return result;
    }

	private double rAusUundP(double u, double p) {
		double result = Math.pow(u, 2)/p;
        System.out.println("Result of ohm from volt (" + u + ") and watt (" + p + ") is " + result);
        return result;
    }
}
