package a3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleHistogram {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// Set up scanner for input from console.
		
		Scanner scan = new Scanner(System.in);
		System.out.println("start");
		
		//This section reads the number of bars from the user and reads in all data points
		int numberOfBars = scan.nextInt();
		boolean hasEnded = false;
		ArrayList<Integer> data = new ArrayList<Integer>();
		while (true) {
			String nextDataPoint = scan.next();
			if (nextDataPoint.equals("end")) { // if they type "end", break the loop
				break;
			} else {
				int dataAdd = Integer.parseInt(nextDataPoint); //
				data.add(dataAdd);
			}
		}
		
		double min = Integer.MAX_VALUE;
		double max = Integer.MIN_VALUE;
		double sum = 0;
		for (int i = 0; i < data.size(); i++) {
			sum += data.get(i);
			if (data.get(i) < min) {
				min = data.get(i);
			} else if (data.get(i) > max) {
				max = data.get(i);
			}
		}
		double avg = sum / data.size();
		int distancePerBin = (int)((max - min) / numberOfBars + 0.5);
		
		//System.out.println(distancePerBin);
		
		int bins[] = new int[numberOfBars];
		
		for (int i = 0; i < bins.length; i++) {
			bins[i] = (int) min + (distancePerBin * (i + 1));
		}
		
		
		int[] binSizes = new int[numberOfBars];
		
		for (int i = 0; i < data.size(); i++) {
			for (int z = 0; z < bins.length; z++) {
				if (data.get(i) < bins[z]) {
					binSizes[z]++;
					break;
				}
			}
		}
		
		
		System.out.println("Num bins: " + numberOfBars);
		System.out.println("Min: " + min);
		System.out.println("Max: " + max);
		System.out.println("Avg: " + avg);
		System.out.println();
		
		
		for (int i = 0; i < numberOfBars; i++) {
			System.out.print(bins[i]-distancePerBin -1 + "-" + (bins[i]-1) +"|");
			int counter = binSizes[i];
			if (data.size() > 100) {
				counter = (int)(counter / 25);
			}
			
			for (int z = 0; z < counter; z++) {
				System.out.print("*-");
			}
			System.out.print("[" + binSizes[i] + "]");
			System.out.println();
		}
		
		//System.out.println(binSizes[5]);
		
		
		
	}
}
