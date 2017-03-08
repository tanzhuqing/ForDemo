package ml.LR;

public class Instance {
	private int label;
	private double[] x;
	
	
	public Instance(int label, double[] x) {
		super();
		this.label = label;
		this.x = x;
	}
	public int getLabel() {
		return label;
	}
	public double[] getX() {
		return x;
	}


}
