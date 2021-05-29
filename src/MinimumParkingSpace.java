import java.util.Arrays;
import java.util.Comparator;

public class MinimumParkingSpace {

	public static void main(String[] args) {
		
		//int [][] parkingTime = {{5,10},{0,20},{25,40},{35,45}};
		//int [][] parkingTime = {{5,10},{0,30},{25,40},{35,45},{43,60}};
		int [][] parkingTime = {{0,35},{35,40},{40,43},{45,60}};
		
		int minSpace = minParkingSlots(parkingTime);
		System.out.println("Minimum Parking Slot needed "+ minSpace);
		
	}
		
	private static int minParkingSlots(int[][] parkingSlot) {

		// code here
		//{0,20}
		//{5,10}
		//{25,40}
		//{35,45}
		
		int beginTime = parkingSlot[0][0];
		int endTime= parkingSlot[0][1]; 
		int minSlot = 1;

		Arrays.sort(parkingSlot, Comparator.comparingInt(o -> o[0]));
		for (int i = 1; i < 4; i++) {

			for (int j = 0; j < 2; j++) {

				if(j==1) {
					
					if(parkingSlot[i][1]<=endTime) {
						minSlot = minSlot+1;
					} else {
						
						endTime= parkingSlot[i][1];
					}
					
				}
				//System.out.print(parkingSlot[i][j] + " ");
			}
			
			System.out.println();
		}
		return minSlot;
	}
}
					
		
		
		
		
		
		
		
		
		
		
		
		
		
	