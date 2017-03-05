package data.processing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProcessShop {
	
	public void process() throws IOException {
		List<ShopInfo> shops = new ArrayList<ShopInfo>();
		Set<String> citys = new HashSet<String>();
		BufferedReader br = new BufferedReader(new FileReader("F:\\datacompetition\\dataset\\shop_info.txt"));
		String line = br.readLine();
		while ((line = br.readLine())!=null) {
			ShopInfo info = ShopInfo.parser(line);
			shops.add(info);
			citys.add(info.cityName);
		}
		br.close();
		System.out.println(citys.size());
		BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\datacompetition\\dataset\\city.txt"));
		int i=1;
		for (String string : citys) {
			bw.append((i++) +","+string+"\n");
		}
		bw.close();
		
		
	}
	
	public static void main(String[] args) throws IOException {
		ProcessShop processShop = new ProcessShop();
		processShop.process();
	}

}
