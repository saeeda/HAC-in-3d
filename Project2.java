package hacluster;


import java.util.ArrayList;

import javax.vecmath.Point3f;

public class Project2 {
	public static void main(String[] args){
		
		int	NUMBER_OF_POINTS = 200;
		float xMax = 100;
		float yMax = 100;
		float zMax = 100;
		int scheme = 1;
		ArrayList<Integer[]> hacResult;
		Point3f[] sPrime;
		Generate3DPoints g3DP = new Generate3DPoints(xMax, yMax, zMax, NUMBER_OF_POINTS, scheme);

/*		for (int i = 0; i < NUMBER_OF_POINTS; i++){
			System.out.println("ptf["+i+"] = new Point3f" + g3DP.ptf[i].toString()+ ";");
		}*/
		
		sPrime = g3DP.outLiers(g3DP.ptf, 95, 300);
		for (int i = 0; i < g3DP.NUMBER_OF_INLIER_POINTS ; i++){
			System.out.println("3D point " + i + " " + sPrime[i].toString());
		}
		
		HACluster hac = new HACluster(sPrime);
		hacResult = hac.distanceCluster(8, 0);		// k cluster, merge by use of distance definition zero
													// k should not be less than 2.
		for(int i = 0; i < hacResult.size(); i++){
			System.out.print("Cluster " + i + " = ");
			for (Integer I : hacResult.get(i)){
				System.out.print(sPrime[I] +", " );
			}
			System.out.println();
		}
		System.out.println("\nAverage Silhoette Coefficient = "+hac.asCoefficient());
		System.out.print("\nIn general, the value of the silhouette coefficient varies between -1 and 1. ");
		System.out.println("We want the silhouette coefficient to be close to 1.");
	}
	
}
