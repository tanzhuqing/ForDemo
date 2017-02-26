package com.tzq.lr.v1;

import java.util.Arrays;

public class LogRegression {

	public static void main(String[] args) {
		LogRegression lr = new LogRegression();
		Instances instances = new Instances();
		lr.train(instances, 0.01f, 68, (short)2);
		

	}
	
	public void train(Instances instances,float step, int maxIt,short algorithm){
		float[][] datas = instances.datas;
		float[] labels = instances.labels;
		int size = datas.length;
		int dim = datas[0].length;
		float[] w = new float[dim];
		
		for (int i = 0; i < dim; i++) {
			w[i] = 1;
		}
		
		switch (algorithm) {
		// batch gradient descent
		case 1:
			for (int i = 0; i < maxIt; i++) {
				// to output
				float[] out = new float[size];
				for (int j = 0; j < size; j++) {
					float lire = innerProduct(w,datas[j]);
					out[j] = sigmoid(lire);
				}
				for (int j = 0; j < dim; j++) {
					float sum = 0;
					for (int k = 0; k < size; k++) {
						sum += (labels[k] - out[k]) * datas[k][j];
					}
					w[j] = w[j] + step * sum;
				}
				System.out.println(Arrays.toString(w));
			}
			break;
		// random gradient descent
		case 2:
			for (int i = 0; i < maxIt; i++) {
				for (int j = 0; j < size; j++) {
					float lire = innerProduct(w, datas[j]);
					float out = sigmoid(lire);
					float error = labels[j] - out;
					for (int k = 0; k < dim; k++) {
						w[k] += step * error * datas[j][k];
					}
				}
				System.out.println(Arrays.toString(w));
			}
           
		default:
			break;
		}
	}
	/**
	 * 
	 * @param w
	 * @param x
	 * @return 
	 */
	private float innerProduct(float[] w, float[] x){
		float sum = 0;
		for (int i = 0; i < w.length; i++) {
			sum += w[i]*x[i];
		}
		return sum;
	}

	private float sigmoid(float src){
		return (float)(1.0 / (1 + Math.exp(-src)));
	}
	
}
