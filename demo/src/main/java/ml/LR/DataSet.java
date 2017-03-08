package ml.LR;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataSet {
	
	public static List<Instance> readDataSet(String filePath) throws IOException {
		List<Instance> res = new ArrayList<Instance>();
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String line = br.readLine();
		while ((line = br.readLine())!=null) {
			String[] lines = line.split(",");
			double[] x = new double[lines.length-1];
			for (int i = 0; i < x.length; i++) {
				x[i] = Double.parseDouble(lines[i]);
			}
			int label = Integer.parseInt(lines[lines.length-1]);
			res.add(new Instance(label, x));
		}
		br.close();
		return res;
	}
}
