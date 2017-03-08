package ml.LR;

public class Util {

	public static double sigmod(double x) {
		return 1.0/(1.0 + Math.exp(-x));
	}
	
	public static double classify(double[] x,double[] weights,int n) {
		double log = 0.0;
		for (int i = 0; i < n; i++) {
			log += weights[i]*x[i];
		}
		return sigmod(log);
	}
}
