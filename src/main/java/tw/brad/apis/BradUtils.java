package tw.brad.apis;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.SortedMap;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class BradUtils {
	public static String loadView() throws Exception {
		String source = "C:\\Users\\User\\eclipse-workspace\\BradWeb\\src\\main\\webapp\\views\\view1.html";
		File html = new File(source);
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(html));
		byte[] data = bin.readAllBytes();
		bin.close();
		
		return new String(data);
	}
	public static String loadView(String view) throws Exception {
		String source = String.format(
			"C:\\Users\\User\\eclipse-workspace\\BradWeb\\src\\main\\webapp\\views\\%s.html", view) ;
		File html = new File(source);
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(html));
		byte[] data = bin.readAllBytes();
		bin.close();
		
		return new String(data);
	}
	
	public static String calc(String sx, String sy, String op) {
		try {
			int x = Integer.parseInt(sx);
			int y = Integer.parseInt(sy);
			StringBuffer sb = new StringBuffer();
			switch(op) {
				case "1": sb.append(x + y); break;
				case "2": sb.append(x - y); break;
				case "3": sb.append(x * y); break;
				case "4": sb.append(x / y).append(" ...... ").append(x % y) ; break;
			}
			return sb.toString();
		}catch(Exception e) {
			return "";
		}
	}
	
	public static String createScore() {
		return (int)(Math.random()*101) + "";
	}
	
	public static SortedMap[] parseFood(String json) {
		JSONArray root = new JSONArray(json);
		TreeMap<String, String>[] foods = new TreeMap[root.length()];
		
		for (int i=0; i<root.length(); i++) {
			try {
				JSONObject food = root.getJSONObject(i);
				
				TreeMap<String, String> map = new TreeMap<String, String>();
				map.put("name", food.getString("Name"));
				map.put("tel", food.getString("Tel"));
				map.put("addr", food.getString("City")+food.getString("Town")+food.getString("Address"));
	
				foods[i] = map;
			}catch(Exception e) {
				System.out.println(e + ":" + i);
			}
		}
		//System.out.println(foods.length);
		return foods;
	}
	
	public static String order2JSON(SortedMap[] rows) {
		JSONObject root = new JSONObject();
		if (rows.length > 0) {
			root.put("customer", String.format("%s (%s)", 
					rows[0].getOrDefault("ContactName", ""), 
					rows[0].getOrDefault("CompanyName", "")));
			root.put("employee", String.format("%s %s", 
					rows[0].getOrDefault("FirstName", ""), 
					rows[0].getOrDefault("LastName", "")));
			
			double total = 0;
			JSONArray details = new JSONArray();
			for (SortedMap<String, String> row: rows) {
				JSONObject obj = new JSONObject();
				obj.put("pid", row.getOrDefault("ProductID", ""));
				obj.put("pname", row.getOrDefault("ProductName", ""));
				obj.put("price", row.getOrDefault("UnitPrice", ""));
				obj.put("qty", row.getOrDefault("Quantity", ""));
				
				double price = Double.parseDouble(obj.get("price").toString());
				int qty = Integer.parseInt(obj.get("qty").toString());
				double sum = price*qty;
				obj.put("sum", price*qty);
				
				total += sum;
				
				details.put(obj);
			}
			root.put("details", details);
			root.put("total", total);
		}
		return root.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
