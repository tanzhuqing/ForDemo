package com.tzq.lr.v1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Instances {
	public float[][] datas;
	public float[] labels;
	public Instances() {
		datas = new float[100][];
		labels = new float[100];
		try {
			File file = new File("./data/data1");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			int index = 0;
			while ((line = br.readLine())!= null) {
				String[] lines = line.split("   ");
				float d1 = Float.parseFloat(lines[0]);
				float d2 = Float.parseFloat(lines[1]);
				float d3 = Float.parseFloat(lines[2]);
				datas[index] = new float[]{d1,d2};
				labels[index] = d3;
				index ++;
			}
			br.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
   
	
}
