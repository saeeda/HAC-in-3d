import java.util.ArrayList;
import java.util.Random;

import javax.vecmath.*;

public class Generate3DPoints{
	public static int TARGET_CLUSTERS = 5; // number of clusters we are targeting for the various "schemes"
	public static int NUMBER_OF_POINTS; // number of points we want
	public static float SPACE_BETWEEN = 100; // space between clusters for scheme 1
	public Point3f[] ptf;
	public static int NUMBER_OF_INLIER_POINTS;
	
	public Generate3DPoints(){

	}
	public Generate3DPoints(float xMax, float yMax, float zMax, 
			int numberOfPoints, int scheme) {
		Random r = new Random();
		ptf = new Point3f[numberOfPoints];
		int clustergroup;
		int intervalX = (int)(xMax/ TARGET_CLUSTERS);
		int intervalY = (int)(yMax/ TARGET_CLUSTERS);
		int intervalZ = (int)(zMax/ TARGET_CLUSTERS);
		float x, y, z;
		NUMBER_OF_POINTS = numberOfPoints;

/*		for (int i = 0;i < numberOfPoints; i++) {
			clustergroup = i / (numberOfPoints / TARGET_CLUSTERS);
			x = (float) (intervalX*clustergroup + (float)SPACE_BETWEEN * clustergroup) + (float)r.nextInt(intervalX);
			y = (float) (intervalY*clustergroup + (float)SPACE_BETWEEN * clustergroup) + (float)r.nextInt(intervalY);
			z = (float) (intervalZ*clustergroup + (float)SPACE_BETWEEN * clustergroup) + (float)r.nextInt(intervalZ);

			ptf[i] = new Point3f(x, y, z);
			//			System.out.println("Generate3DPoints ptf[i] %3.5f %3.5f %3.5f%n",ptf[i].x, ptf[i].y, ptf[i].z);

		}*/
		
		ptf[0] = new Point3f(8, 17, 13);
//		ptf[0] = new Point3f(1000, 1000, 1000);
		ptf[1] = new Point3f(12, 4, 14);
		ptf[2] = new Point3f(15, 15, 0);
		ptf[3] = new Point3f(13, 13, 10);
		ptf[4] = new Point3f(2, 10, 2);
		ptf[5] = new Point3f(9, 14, 4);
//		
		ptf[6] = new Point3f(14, 7, 15);
		ptf[7] = new Point3f(19, 12, 10);
		ptf[8] = new Point3f(11, 14, 0);
		ptf[9] = new Point3f(0, 11, 9);
		ptf[10] = new Point3f(8, 12, 2);
		ptf[11] = new Point3f(0, 4, 1);
		ptf[12] = new Point3f(9, 12, 0);
		ptf[13] = new Point3f(8, 15, 7);
		ptf[14] = new Point3f(10, 14, 7);
		ptf[15] = new Point3f(10, 1, 11);
		ptf[16] = new Point3f(3, 4, 18);
		ptf[17] = new Point3f(6, 3, 19);
		ptf[18] = new Point3f(5, 18, 19);
		ptf[19] = new Point3f(19, 4, 14);
//		ptf[19] = new Point3f(1001, 1001, 1001);
/*		ptf[20] = new Point3f(14, 15, 4);
		ptf[21] = new Point3f(11, 2, 7);
		ptf[22] = new Point3f(5, 18, 13);
		ptf[23] = new Point3f(8, 5, 9);
		ptf[24] = new Point3f(6, 19, 5);
		ptf[25] = new Point3f(6, 0, 8);
		ptf[26] = new Point3f(8, 3, 11);
		ptf[27] = new Point3f(3, 13, 10);
		ptf[28] = new Point3f(17, 6, 8);
		ptf[29] = new Point3f(5, 13, 19);
		ptf[30] = new Point3f(16, 11, 16);
		ptf[31] = new Point3f(14, 16, 13);
		ptf[32] = new Point3f(8, 6, 12);
		ptf[33] = new Point3f(3, 10, 4);
		ptf[34] = new Point3f(7, 6, 19);
		ptf[35] = new Point3f(8, 19, 12);
		ptf[36] = new Point3f(19, 0, 10);
		ptf[37] = new Point3f(16, 7, 1);
		ptf[38] = new Point3f(4, 4, 14);
		ptf[39] = new Point3f(16, 14, 14);
		ptf[40] = new Point3f(135, 127, 137);
		ptf[41] = new Point3f(138, 121, 128);
		ptf[42] = new Point3f(139, 138, 139);
		ptf[43] = new Point3f(130, 132, 139);
		ptf[44] = new Point3f(127, 133, 133);
		ptf[45] = new Point3f(136, 134, 127);
		ptf[46] = new Point3f(121, 122, 136);
		ptf[47] = new Point3f(126, 132, 127);
		ptf[48] = new Point3f(122, 136, 123);
		ptf[49] = new Point3f(128, 136, 122);
		ptf[50] = new Point3f(126, 129, 137);
		ptf[51] = new Point3f(138, 132, 128);
		ptf[52] = new Point3f(137, 127, 130);
		ptf[53] = new Point3f(139, 124, 123);
		ptf[54] = new Point3f(131, 127, 128);
		ptf[55] = new Point3f(131, 132, 130);
		ptf[56] = new Point3f(121, 131, 121);
		ptf[57] = new Point3f(120, 125, 130);
		ptf[58] = new Point3f(128, 126, 129);
		ptf[59] = new Point3f(131, 126, 134);
		ptf[60] = new Point3f(125, 122, 132);
		ptf[61] = new Point3f(135, 128, 124);
		ptf[62] = new Point3f(123, 128, 129);
		ptf[63] = new Point3f(125, 136, 135);
		ptf[64] = new Point3f(138, 124, 124);
		ptf[65] = new Point3f(128, 138, 130);
		ptf[66] = new Point3f(135, 125, 122);
		ptf[67] = new Point3f(137, 132, 120);
		ptf[68] = new Point3f(124, 124, 133);
		ptf[69] = new Point3f(135, 124, 132);
		ptf[70] = new Point3f(121, 121, 132);
		ptf[71] = new Point3f(125, 129, 127);
		ptf[72] = new Point3f(136, 127, 131);
		ptf[73] = new Point3f(124, 127, 132);
		ptf[74] = new Point3f(122, 126, 126);
		ptf[75] = new Point3f(122, 126, 123);
		ptf[76] = new Point3f(123, 123, 131);
		ptf[77] = new Point3f(139, 134, 129);
		ptf[78] = new Point3f(138, 129, 135);
		ptf[79] = new Point3f(133, 128, 122);
		ptf[80] = new Point3f(243, 255, 240);
		ptf[81] = new Point3f(259, 249, 255);
		ptf[82] = new Point3f(252, 253, 249);
		ptf[83] = new Point3f(248, 240, 246);
		ptf[84] = new Point3f(241, 255, 247);
		ptf[85] = new Point3f(248, 256, 240);
		ptf[86] = new Point3f(258, 251, 241);
		ptf[87] = new Point3f(256, 251, 246);
		ptf[88] = new Point3f(248, 258, 259);
		ptf[89] = new Point3f(258, 248, 259);
		ptf[90] = new Point3f(248, 253, 245);
		ptf[91] = new Point3f(241, 247, 242);
		ptf[92] = new Point3f(256, 241, 258);
		ptf[93] = new Point3f(258, 254, 257);
		ptf[94] = new Point3f(254, 255, 242);
		ptf[95] = new Point3f(249, 259, 254);
		ptf[96] = new Point3f(256, 247, 257);
		ptf[97] = new Point3f(258, 259, 242);
//		ptf[98] = new Point3f(259, 241, 249);
		ptf[98] = new Point3f(1000, 1000, 1000);
		ptf[99] = new Point3f(252, 255, 240);
		ptf[100] = new Point3f(246, 259, 246);
		ptf[101] = new Point3f(250, 259, 242);
		ptf[102] = new Point3f(250, 254, 242);
		ptf[103] = new Point3f(245, 250, 249);
		ptf[104] = new Point3f(252, 258, 240);
		ptf[105] = new Point3f(255, 242, 252);
		ptf[106] = new Point3f(251, 251, 253);
		ptf[107] = new Point3f(258, 245, 242);
		ptf[108] = new Point3f(257, 242, 248);
		ptf[109] = new Point3f(257, 240, 252);
		ptf[110] = new Point3f(245, 247, 257);
		ptf[111] = new Point3f(241, 245, 248);
		ptf[112] = new Point3f(248, 257, 252);
		ptf[113] = new Point3f(253, 257, 253);
		ptf[114] = new Point3f(240, 258, 258);
		ptf[115] = new Point3f(247, 244, 242);
		ptf[116] = new Point3f(257, 243, 254);
		ptf[117] = new Point3f(259, 255, 254);
		ptf[118] = new Point3f(251, 253, 251);
		ptf[119] = new Point3f(246, 257, 253);
		ptf[120] = new Point3f(375, 366, 375);
		ptf[121] = new Point3f(374, 369, 378);
		ptf[122] = new Point3f(373, 376, 365);
		ptf[123] = new Point3f(374, 371, 369);
		ptf[124] = new Point3f(375, 371, 377);
		ptf[125] = new Point3f(361, 365, 366);
		ptf[126] = new Point3f(377, 371, 360);
		ptf[127] = new Point3f(370, 373, 379);
		ptf[128] = new Point3f(364, 366, 367);
		ptf[129] = new Point3f(363, 377, 376);
		ptf[130] = new Point3f(379, 373, 360);
		ptf[131] = new Point3f(377, 360, 370);
		ptf[132] = new Point3f(367, 364, 371);
		ptf[133] = new Point3f(373, 370, 367);
		ptf[134] = new Point3f(377, 371, 379);
		ptf[135] = new Point3f(376, 376, 363);
		ptf[136] = new Point3f(377, 370, 362);
		ptf[137] = new Point3f(360, 369, 365);
		ptf[138] = new Point3f(367, 366, 362);
		ptf[139] = new Point3f(367, 364, 370);
		ptf[140] = new Point3f(371, 366, 377);
		ptf[141] = new Point3f(365, 379, 366);
		ptf[142] = new Point3f(363, 360, 369);
		ptf[143] = new Point3f(368, 378, 371);
		ptf[144] = new Point3f(362, 377, 363);
		ptf[145] = new Point3f(375, 365, 365);
		ptf[146] = new Point3f(370, 379, 361);
		ptf[147] = new Point3f(365, 377, 367);
		ptf[148] = new Point3f(362, 376, 364);
		ptf[149] = new Point3f(372, 374, 377);
		ptf[150] = new Point3f(368, 372, 370);
		ptf[151] = new Point3f(366, 367, 373);
		ptf[152] = new Point3f(362, 376, 373);
		ptf[153] = new Point3f(369, 361, 379);
		ptf[154] = new Point3f(379, 378, 374);
		ptf[155] = new Point3f(374, 378, 373);
		ptf[156] = new Point3f(369, 365, 370);
		ptf[157] = new Point3f(369, 375, 367);
		ptf[158] = new Point3f(372, 364, 374);
		ptf[159] = new Point3f(370, 373, 373);
		ptf[160] = new Point3f(483, 487, 482);
		ptf[161] = new Point3f(486, 489, 486);
		ptf[162] = new Point3f(494, 498, 495);
		ptf[163] = new Point3f(499, 491, 484);
		ptf[164] = new Point3f(486, 483, 493);
		ptf[165] = new Point3f(494, 498, 498);
		ptf[166] = new Point3f(492, 485, 487);
		ptf[167] = new Point3f(495, 497, 494);
		ptf[168] = new Point3f(484, 485, 484);
		ptf[169] = new Point3f(489, 493, 481);
		ptf[170] = new Point3f(497, 486, 486);
//		ptf[171] = new Point3f(489, 481, 492);
		ptf[171] = new Point3f(1489, 1481, 1492);
		ptf[172] = new Point3f(480, 496, 493);
		ptf[173] = new Point3f(483, 490, 493);
		ptf[174] = new Point3f(495, 496, 492);
		ptf[175] = new Point3f(498, 484, 480);
		ptf[176] = new Point3f(493, 492, 490);
		ptf[177] = new Point3f(498, 484, 489);
		ptf[178] = new Point3f(486, 488, 499);
		ptf[179] = new Point3f(483, 481, 484);
		ptf[180] = new Point3f(495, 492, 485);
		ptf[181] = new Point3f(490, 491, 492);
		ptf[182] = new Point3f(495, 486, 487);
		ptf[183] = new Point3f(494, 493, 497);
		ptf[184] = new Point3f(496, 495, 490);
		ptf[185] = new Point3f(484, 487, 490);
		ptf[186] = new Point3f(481, 483, 492);
		ptf[187] = new Point3f(493, 492, 489);
		ptf[188] = new Point3f(491, 493, 481);
		ptf[189] = new Point3f(497, 482, 496);
		ptf[190] = new Point3f(499, 499, 488);
		ptf[191] = new Point3f(483, 480, 493);
		ptf[192] = new Point3f(489, 484, 490);
		ptf[193] = new Point3f(491, 498, 494);
		ptf[194] = new Point3f(497, 487, 485);
		ptf[195] = new Point3f(496, 496, 489);
		ptf[196] = new Point3f(488, 481, 496);
		ptf[197] = new Point3f(488, 483, 492);
		ptf[198] = new Point3f(489, 482, 487);
		ptf[199] = new Point3f(489, 487, 481);*/
		
	}
	
	/*
	 * calculate and print outliers in the given array of points
	 * */
	public Point3f[] outLiers(Point3f[] ptf, float portion, float distance){
		Point3f[] sPointsInput = ptf;
		Point3f[] sPointsOutput;
		Boolean outlierB = false;
		int portionNum ;
		Integer inlierIndex = 0;
		ArrayList<Integer> olAL = new ArrayList<>();

		float thresholdF = distance*distance;
		for (Integer k = 0; k < NUMBER_OF_POINTS; k++){
			portionNum = (int)(NUMBER_OF_POINTS * portion/100);
			for (Integer i = 0; i < NUMBER_OF_POINTS; i ++){
				if (sPointsInput[k].distanceSquared(sPointsInput[i]) > thresholdF){
//					System.out.println(sPoints[k].distance(sPoints[i]));
					portionNum--;
					if (portionNum == 0){
						System.out.println("Outlier detected "+ k + " " + sPointsInput[k].toString());
						olAL.add(k);
						break;
					}
				}

			}
		}
		
		NUMBER_OF_INLIER_POINTS = NUMBER_OF_POINTS - olAL.size();
//		System.out.println(NUMBER_OF_INLIER_POINTS);

		sPointsOutput = new Point3f[NUMBER_OF_INLIER_POINTS];
		for (Integer k = 0; k < NUMBER_OF_POINTS; k++){
			outlierB = false;
			for (Integer j = 0; j < olAL.size(); j++){
				if (k == olAL.get(j)){
					outlierB = true;
					inlierIndex--;
//				System.out.println(k + inlierIndex);
				}
			}
			if (!outlierB){
//				System.out.println(inlierIndex + "<--" + k); 
				sPointsOutput[inlierIndex] = sPointsInput[k];
			}
			inlierIndex++;
			
		}
		if (NUMBER_OF_POINTS == NUMBER_OF_INLIER_POINTS){
			System.out.println("No outlier found.");
		}
		return sPointsOutput;
	}

}







