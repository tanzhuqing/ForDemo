package ml.LR;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;



public class LogisticRegression {
	private double rate;
	private double[] weights;
	
	private int iterations = 3000;
	
	public LogisticRegression(int n) {
		this.rate = 0.0001;
		this.weights = new double[n];
	}

	public void trainInSGD(List<Instance> instances) {
		for (int i = 0; i < iterations; i++) {
			double lik = 0.0;
			for (Instance instance : instances) {
				double[] x = instance.getX();
				double predict = Util.classify(x, weights, weights.length);
				int label = instance.getLabel();
				for (int j = 0; j < weights.length; j++) {
					weights[j] = weights[j] + rate*(label-predict)*x[j];
				}
				lik += label * Math.log(Util.classify(x, weights, weights.length))+(1-label)*Math.log(1-Util.classify(x, weights, weights.length));
			}
			System.out.println("iteration: " + i + " " + Arrays.toString(weights) + " mle: " + lik);
		}
	}
	
	public static void main(String[] args) throws IOException {
		String filePath = "data/data";
		List<Instance> dataset = DataSet.readDataSet(filePath);
		LogisticRegression lr = new LogisticRegression(5);
		lr.trainInSGD(dataset);
		
	}
}
