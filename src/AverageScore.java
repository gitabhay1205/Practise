import java.util.*;

public class AverageScore {
    public static class PlayerStatisticsCollectorImpl implements PlayerStatisticsCollector {
    	
    	Map<String,Integer> totalScore = new HashMap<>();
    	Map<String,Integer> totalInings = new HashMap<>();
    	
        @Override
        public void putNewInnings(String player, int runs){
        	
        	if(totalScore.containsKey(player)) {
        		
        		totalInings.put(player, totalInings.get(player)+1);
        		totalScore.put(player, totalScore.get(player)+ runs);
  		
        	} else {
        		
        		totalInings.put(player,1);
        		totalScore.put(player, runs);
        	}
        }

        @Override
        public double getAverageRuns(String player){
            
        double averageScore = 0.0;
        averageScore = ((double)totalScore.get(player)/totalInings.get(player));
        return averageScore;
       
        }

        @Override
        public int getInningsCount(String player){
           
        	return totalInings.get(player);
    }
    }

    ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

    public interface PlayerStatisticsCollector {
        // This is an input. Make note of this player inning.  Runs is a non negative integer.
        void putNewInnings(String player, int runs);

        // Get the runs average(mathematical average) for a player
        double getAverageRuns(String player);

        // Get the total number of innings for the player
        int getInningsCount(String player);
    }

    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        int numLines = Integer.parseInt(scanner.nextLine());
        int currentLine = 0;
        while (currentLine++ < numLines) {
            final PlayerStatisticsCollector stats = new PlayerStatisticsCollectorImpl();
            final Set<String> players = new TreeSet<>();

            String line = scanner.nextLine();
            String[] inputs = line.split(",");
            for (int i = 0; i < inputs.length; ++i) {
                String[] tokens = inputs[i].split(" ");
                final String player = tokens[0];
                players.add(player);
                final int runs = Integer.parseInt(tokens[1]);

                stats.putNewInnings(player, runs);

            }

            for (String player : players) {
                System.out.println(
                        String.format("%s %.4f %d", player, stats.getAverageRuns(player), stats.getInningsCount(player)));
            }

        }
        scanner.close();

    }
}
