import java.io.*;
import java.util.*;

 class MinReservationTable {
	static int minReservationTables(int[][] reservationStartEndTimes) {

Arrays.sort(reservationStartEndTimes, Comparator.comparingInt(o -> o[0]));

int startTime=reservationStartEndTimes[0][0];
int endTime= reservationStartEndTimes[0][1];

int tableCount=1;

TreeSet<Integer> endTimeSet = new TreeSet<>();
endTimeSet.add(endTime);

for(int i=1; i<reservationStartEndTimes.length;i++) {
	
	int newGuestStartTime = reservationStartEndTimes[i][0];
	endTimeSet.add(reservationStartEndTimes[i][1]);
	
	if(newGuestStartTime<=endTime) {
		
		tableCount++;
		if(reservationStartEndTimes[i][1] < endTime) {
			
			endTime = reservationStartEndTimes[i][1];
		}
	
	} else if(newGuestStartTime > endTime) {
		
		if(endTimeSet.size()>0) {
			
			endTimeSet.remove(endTimeSet.first());
		}
		endTime = endTimeSet.first();	
	}
	}

  return tableCount;
	}

	// DO NOT MODIFY ANYTHING BELOW THIS LINE!!

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine().trim());
		int[][] reservationStartEndTimeList = new int[n][2];
		String[] reservationStartEndTimes = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			String[] reservationStartEndTime = reservationStartEndTimes[i].split(",");
			for (int j = 0; j < reservationStartEndTime.length; j++) {
				reservationStartEndTimeList[i][j] = Integer.parseInt(reservationStartEndTime[j]);
			}
		}

		int out = minReservationTables(reservationStartEndTimeList);
		System.out.println(out);

		wr.close();
		br.close();
	}
}