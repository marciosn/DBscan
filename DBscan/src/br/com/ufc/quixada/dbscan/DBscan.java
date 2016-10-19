package br.com.ufc.quixada.dbscan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.ufc.quixada.dbscan.model.Point;
import br.com.ufc.quixada.dbscan.utils.Utils;

public class DBscan {
	
	public static void main(String[] args) {
		String path = "C:/DBscan/input/SegundaReduzido2.csv";
		
		try {
			new DBscan().run(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 public void run(String pathCSV) throws IOException {
		 Utils utils = new Utils();
			String csvFile = pathCSV;
			BufferedReader br = null;
			String line = "";
			String cvsSplitBy = ";";
			String[] result = null;
			
			List<Point> dataSet = new ArrayList<>();
			Point point = null;
			try {
				
				br = new BufferedReader(new FileReader(csvFile));
				while ((line = br.readLine()) != null) {
					result = line.split(cvsSplitBy);
					
					Integer idTaxi = Integer.valueOf(result[0]);
					Timestamp time = utils.getTime(result[1]);
					Long latitude = (long) Double.parseDouble(result[2]);
					Long longitude = (long) Double.parseDouble(result[3]);
					
					point = new Point();
					point.setIdTaxi(idTaxi);
					point.setTime(time);
					point.setLatitude(latitude);
					point.setLongitude(longitude);
									
					System.out.println("->" + point.toString());
					dataSet.add(point);
				}
				
			for (Point p : dataSet) {
				//utils.regionQuery(0, p, dataSet);
			}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			System.out.println("Sucesso!");
		  }
}
