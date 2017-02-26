package ml.JavaForMl.kaggle.titanic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class ProcessData {
	
	public static void main(String[] args) throws IOException {
		INDArray nd = Nd4j.create(new float[]{1,2,3,4},new int[]{2,2});
		System.err.println(nd);
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
		    inputStream = new FileInputStream("train");
		    sc = new Scanner(inputStream, "UTF-8");
		    String name = sc.nextLine();
		    System.err.println(name);
		    
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        String[] lines = line.split(",");
		        	
		    }
		    // note that Scanner suppresses exceptions
		    if (sc.ioException() != null) {
		        throw sc.ioException();
		    }
		} finally {
		    if (inputStream != null) {
		        inputStream.close();
		    }
		    if (sc != null) {
		        sc.close();
		    }
		}
	}

}
