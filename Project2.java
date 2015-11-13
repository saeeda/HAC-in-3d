import java.util.ArrayList;
import java.util.List;

import javax.vecmath.Point3f;

public class Project2 {
	public static void main(String[] args){
		
		int	NUMBER_OF_POINTS = 20;
		float xMax = 100;
		float yMax = 100;
		float zMax = 100;
		int scheme = 1;
		Point3f[] sPrime;
		Generate3DPoints g3DP = new Generate3DPoints(xMax, yMax, zMax, NUMBER_OF_POINTS, scheme);

/*		for (int i = 0; i < NUMBER_OF_POINTS; i++){
			System.out.println("ptf["+i+"] = new Point3f" + g3DP.ptf[i].toString()+ ";");
		}*/
		
		sPrime = g3DP.outLiers(g3DP.ptf, 80, 150);
		for (int i = 0; i < g3DP.NUMBER_OF_INLIER_POINTS ; i++){
			System.out.println("3D point " + i + " " + sPrime[i].toString());
		}
	}
	
}
