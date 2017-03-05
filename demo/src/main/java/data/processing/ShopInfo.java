package data.processing;

public class ShopInfo {
	int shopId;
	String cityName;
	int locationId;
	int perPay;
	int score;
	int commentCnt;
	int shopLevel;
	String c1Name;
	String c2Name;
	String c3Name;
	
	public String toString() {
		return shopId+","+cityName+","+locationId+","+perPay+","+score+","+commentCnt+","+shopLevel+","+c1Name+","+c2Name+","+c3Name;
	}
	
	public static ShopInfo parser(String line) {
		ShopInfo info = new ShopInfo();
		String[] lines = line.split(",");
		int index=0;
		info.shopId = Integer.parseInt(lines[index++]);
		info.cityName = lines[index++];
		info.locationId = Integer.parseInt(lines[index++]);
		info.perPay = lines[index].equals("")?0:Integer.parseInt(lines[index++]);
		info.score = lines[index].equals("")?0:Integer.parseInt(lines[index++]);
		info.commentCnt = lines[index].equals("")?0:Integer.parseInt(lines[index++]);
		info.shopLevel = lines[index].equals("")?0:Integer.parseInt(lines[index++]);
		info.c1Name = lines[index++];
		info.c2Name = lines[index++];
		if (!line.endsWith(",")) {
			info.c3Name = lines[index++];
		}else {
			info.c3Name = "";
		}
		
		return info;
	}

}
