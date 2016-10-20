package br.com.ufc.quixada.dbscan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufc.quixada.dbscan.data.RetrieveData;
import br.com.ufc.quixada.dbscan.model.Cluster;
import br.com.ufc.quixada.dbscan.model.Point;
import br.com.ufc.quixada.dbscan.utils.Utils;

public class DBscan {
	
	public static void main(String[] args) {
		/*String path = "C:/DBscan/input/SegundaReduzido2.csv";*/
		/*String path = "/home/lionel/Dropbox/Topicos/SegundaConjuntoTeste.csv";*/
		String path = "/home/lionel/Dropbox/Topicos/SegundaReduzido4.csv";
		
		System.out.println("################ Começou #############");
		
		try {
			List<Point> dataSet = new RetrieveData().getDataSetFromFile(path);
			runDBscan(dataSet, 0.001, 10);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void runDBscan(List<Point> dataSet, double eps, int minPts){
		Utils utils = new Utils();
		ExpandCluster expandCluster = new ExpandCluster();
		Cluster cluster = null;
		List<Point> neighborPts = new ArrayList<>();
		
		int i = 0;
		for (Point point : dataSet) {
			if (!point.isVisit()) {
				point.setVisit(true);
				
				neighborPts = utils.regionQuery(eps, point, dataSet);
				
				if (neighborPts.size()  < minPts) {
					point.setNoise(true);
				} else {
					cluster = new Cluster();
					cluster.setIdCluster(i);
					expandCluster.expandCluster(point, neighborPts, cluster, eps, minPts, dataSet);
				}
			}
			i++;
		}
		System.out.println("*************************Terminou****************");
	} 
}
