package hacluster;

import java.util.ArrayList;

import javax.vecmath.Point3f;


public class HACluster {
	public ArrayList<Integer[]> galaxy;
	public Point3f[] points;
	public HACluster() {
		galaxy = new ArrayList<Integer[]>();
		
	}
	public HACluster(Point3f[] spPoints){
		this();
		this.points = spPoints;
		Integer number = spPoints.length;
		for (Integer i = 0; i < number;i++ ){
			Integer[] cl = new Integer[1];
			cl[0] = i;
			galaxy.add(cl);
		}
//		System.out.println(number);
	}
	
	/*
	 * calculates the distance between current instance of cluster, 
	 * with the clIn cluster. Merge until k cluster is remained.
	 * k should not be less than 2
	 * */
	public ArrayList<Integer[]> distanceCluster(int k, Integer distanceDef){
		
		switch (distanceDef){

		case 1:		// nearest two points
			System.out.println("\n\t HAC, metrics used: nearest points distance\n");
			distanceClNear(k);
			break;
		case 2:		// farthest two points
			System.out.println("\n\t HAC, metrics used: farthest points distance\n");
			distanceClFar(k);
			break;
		case 3: 	// average distance between points
			System.out.println("\n\t HAC, metrics used: average distance\n");
			distanceClAvg(k);
			break;
		default:		// distance between center 
			System.out.println("\n\t HAC, metrics used: distance between centers\n");
			distanceClCenter(k);
		}
		System.out.println("\n\t Algorithm resulted in " + galaxy.size() + " clusters.\n" );
		return galaxy;
	}
	/*
	 * merge sub-clusters based on distance between center of two cluster
	 * */
	private void distanceClCenter(int k){
		float dist = 0.0f;		// minimum distance 
		float tmpDist = 0.0f;

		do{
		Integer clOne = 0;	// first cluster to merge
		Integer clTwo = 1;	// second cluster to merge with the first cluster
		dist = clCenter(galaxy.get(clOne)).distance(clCenter(galaxy.get(clTwo)));
		for(Integer i = 0; i < galaxy.size(); i++){
			for(Integer j = i+1; j < galaxy.size(); j++ ){
				tmpDist = clCenter(galaxy.get(i)).distance(clCenter(galaxy.get(j)));
				if (tmpDist < dist){
					clOne = i;
					clTwo = j;
					dist = tmpDist;
				}
//				System.out.println("distance "+ i +" =" + clCenter(galaxy.get(i))+ ", +"+j+"+ = " + clCenter(galaxy.get(j)));
			}
		}
		System.out.println("According to Center, the smallest Distance is between clusters "
				+ clOne + clCenter(galaxy.get(clOne))
				+ " and " + clTwo + clCenter(galaxy.get(clTwo)) + " equal to " 
				+ dist);
//		points[0].distanceSquared(points[1]);
		
//		System.out.print(clCenter(galaxy.get(0)).toString());
		clMerge(clOne, clTwo);
		}while (galaxy.size() > k);
//		return dist;
	}
	private void distanceClNear(int k){
		float dist;
		float tmpDist;
		
		do{
			Integer clOne = 0;	// first cluster to merge
			Integer clTwo = 1;	// second cluster to merge with the first cluster
			dist = 0.0f;
			Integer[] K = new Integer[galaxy.get(0).length];
			Integer[] L = new Integer[galaxy.get(1).length];
			K = galaxy.get(0);
			L = galaxy.get(1);
			dist = points[K[0]].distance(points[L[0]]);

			for(Integer i = 0; i < galaxy.size(); i++){
				for(Integer j = i+1; j < galaxy.size(); j++ ){
					for(Integer I: galaxy.get(i)){
						for(Integer J : galaxy.get(j)){
							tmpDist = points[I].distance(points[J]);
							if (tmpDist < dist){
								clOne = i;
								clTwo = j;
								dist = tmpDist;
							}
						}
					}
 
				}
			}
			System.out.println("According to Nearest points, the smallest distance between cluster "
					+ clOne + " and " + clTwo + " is equal to " + dist);
			clMerge(clOne, clTwo);
		}while (galaxy.size() > k);
	}
	private void distanceClFar(int k){
		float dist;
		float tmpDist;
		
		do{
			Integer clOne = 0;	// first cluster to merge
			Integer clTwo = 1;	// second cluster to merge with the first cluster
			dist = 0.0f;
			Integer[] K = new Integer[galaxy.get(0).length];
			Integer[] L = new Integer[galaxy.get(1).length];
			K = galaxy.get(0);
			L = galaxy.get(1);
			dist = points[K[0]].distance(points[L[0]]);

			for(Integer i = 0; i < galaxy.size(); i++){
				for(Integer j = i+1; j < galaxy.size(); j++ ){
					for(Integer I: galaxy.get(i)){
						for(Integer J : galaxy.get(j)){
							tmpDist = points[I].distance(points[J]);
							if (tmpDist > dist){
								clOne = i;
								clTwo = j;
								dist = tmpDist;
							}
						}
					}
 
				}
			}
			System.out.println("According to Farthest points, the smallest distance between cluster "
					+ clOne + " and " + clTwo + " is equal to " + dist);
			clMerge(clOne, clTwo);
		}while (galaxy.size() > k);

	}
	/*
	 * Unweighted Pair Group Method with Arithmetic Mean
	 * The distance between any two clusters is the mean distance between 
	 * elements of each cluster
	*/
	private void distanceClAvg(int k){
		float dist;
		float tmpDist;

		do{
			Integer clOne = 0;	// first cluster to merge
			Integer clTwo = 1;	// second cluster to merge with the first cluster
			dist = 0.0f;
			for(Integer I: galaxy.get(0)){
				for(Integer J : galaxy.get(1)){
					dist += points[I].distance(points[J]);
				}
			}
			dist = dist / (galaxy.get(0).length * galaxy.get(1).length);

			for(Integer i = 0; i < galaxy.size(); i++){
				for(Integer j = i+1; j < galaxy.size(); j++ ){
					tmpDist = 0.0f;
					for(Integer I: galaxy.get(i)){
						for(Integer J : galaxy.get(j)){
							tmpDist += points[I].distance(points[J]);
						}
					}
					tmpDist = tmpDist / (galaxy.get(i).length * galaxy.get(j).length);

					if (tmpDist < dist){
						clOne = i;
						clTwo = j;
						dist = tmpDist;
					} 
				}
			}
			System.out.println("According to Average, the smallest distance between cluster "
					+ clOne + " and " + clTwo + " is equal to " + dist);
			clMerge(clOne, clTwo);
		}while (galaxy.size() > k);

	}
	/*
	 * Calculate center of a cluster based on Integer Array of points indexes
	 * */
	private Point3f clCenter(Integer[] In){
		Point3f p;
		float sumX, sumY, sumZ;
		sumX = 0;
		sumY = 0;
		sumZ = 0;
		for(Integer I : In){
			sumX += points[I].x;
			sumY += points[I].y;
			sumZ += points[I].z;
		}
		sumX = sumX / In.length;		// calculate average x based on sumX
		sumY = sumY / In.length;		// calculate average y based on sumY
		sumZ = sumZ / In.length;		// calculate average z based on sumZ
		p = new Point3f(sumX, sumY, sumZ);
		return p;
		
	}
	/*
	 * Merges two sub cluster into a bigger sub cluster 
	 * */
	private void clMerge(Integer one, Integer two){
		Integer oneL = galaxy.get(one).length;
		Integer twoL = galaxy.get(two).length;
		Integer[] I = new Integer[ oneL + twoL ];

		System.arraycopy(galaxy.get(one), 0, I, 0, oneL);
		System.arraycopy(galaxy.get(two), 0, I, oneL, twoL);

//		galaxy.remove(one);
		if (one < two){
			galaxy.remove((int)two);
			galaxy.remove((int)one);
		}else{
			galaxy.remove((int)one);
			galaxy.remove((int)two);
		}
		galaxy.add(I);
		
		System.out.println("Cluster " + one + " and " + two + " are merged.");
		
	}
	/*
	 * Measure Average Silhouette Coefficient
	 * for the galaxy field of the class
	 * and return average silhouette coefficient
	 * */
	public float asCoefficient(){
		float asc = 0.0f;
		float s;
		float a;
		float b = 0.0f;
		float minb = 0.0f;
		
		for(Integer i = 0; i < galaxy.size(); i++){
			a = 0.0f;
			s = 0.0f;
			for(Integer I: galaxy.get(i)){
				if (galaxy.get(i).length > 1) {
					for (Integer J : galaxy.get(i)) {
						a += points[I].distance(points[J]);
					}
					a = a / (galaxy.get(i).length - 1);
				}
				for(Integer k = 0; k < galaxy.size(); k++){
					b = 0.0f;
					if(k.equals(i)){
						continue;
					}
					for (Integer M : galaxy.get(k) ){
						b += points[I].distance(points[M]);
					}
					b = b / (galaxy.get(k).length);
					if ((i == 0 && k == 1) || (i != 0 && k == 0)){
						minb = b;
					}
					if (b < minb){
						minb = b;
					}
					
				}
				if (a > minb){
					s = (minb - a) / a;
				}else{
					s = (minb - a) / minb;
				}
				asc += s;
			}
		}
		asc = asc / points.length;
		return asc;
	}
}












