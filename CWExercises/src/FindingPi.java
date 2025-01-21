// Rational approximation
class RationalApx {
	int num;	// numerator
	int den;	// denominator
	int prec;	// how many decimal places the approximation is good out to
	
	RationalApx(){ this(0,1, 0); }
	
	RationalApx(int n, int d, int p){
		num = n;
		den = d;
		prec = p;
	}

	boolean equals(int n, int d, int p){
		return num==n && den==d && prec==p;
	}

	boolean equals(RationalApx other){
		return equals(other.num, other.den, other.prec);
	}
}

public class FindingPi {
	public static RationalApx run(int maxInt){
		var result = new RationalApx();

		// Place your code here..
		double pi = Math.PI;
		String piStr = String.valueOf(pi);
		double minDiff = Double.MAX_VALUE; 
		int bestD = 0;
		int bestN = 0;
		int bestP = 0;
		
        for (int d = 1; d < maxInt; d++) {
            int startN = (int) (d * pi);
            int endN = Math.min((int) (d * pi), maxInt);
            
            for (int n = startN - 1; n <= endN + 1; n++) {
                double approx = (double) n / d;
                double diff = Math.abs(pi - approx);
                
	        	if(diff < minDiff) {
	        		minDiff = diff;
	        		bestD = d;
	        		bestN = n;
	                String approxStr = String.valueOf(approx);
	                int p = 0;
	                
	                for (int i = 0; i < Math.min(piStr.length(), approxStr.length()); i++) {
	                    if (piStr.charAt(i) == approxStr.charAt(i)) {
	                        p++;
	                    } 
	                    else {
	                        break;
	                    }
	                }
	                bestP = p-2;
	            }
	        }
        }
        result.num = bestN;
        result.den = bestD;
        result.prec = bestP;
        return result;
	}
}