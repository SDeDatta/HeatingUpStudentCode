import java.util.ArrayList;

/**
 * The class WeatherPatterns finds the longest span of days in which
 * each day’s temperature is higher than on the previous day in that sequence.
 *
 * @author Zach Blick
 * @author Surya De Datta
 */

public class WeatherPatterns {
    private final int MIN_TEMP = -50;
    private final int MAX_TEMP = 130;


    /**
     * Longest Warming Trend
     * @param temperatures
     * @return the longest run of days with increasing temperatures
     */
    public static int longestWarmingTrend(int[] temperatures) {
        // TODO: Write your code here!
       /* int[] nodes = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++)
        {
            nodes[i] = temperatures[i];
        }
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for(int j = 0; j < temperatures.length; j++)
        {
            edges.add(new ArrayList<>());
        }
        for(int k = 0; k < temperatures.length; k++)
        {
            for(int z = k + 1; z < temperatures.length; z++)
            {
                if(temperatures[z] > temperatures[k])
                {
                    edges.get(k).add(z);
                }
            }
        }*/
        // some sort of run through where I calculate the shortest jump from a given node that can be made
        // List of temperatures much longer than potential temperatures
        // best stores longest warming trend that ends at each temperature possible
        int best[] = new int[181];
        int ans = 0;
        for(int i = 0; i < temperatures.length; i++)
        {
            // Gets onto 0 to 181 scale
            int index = temperatures[i] + 50;
            int prevMax = 0;
            if(best[i] > prevMax)
            {
                prevMax = best[i];
            }
            int bestI = prevMax + 1;
            /*if(bestI > best[i])
            {
                best[i] = bestI;
            }*/
            if(bestI > ans)
            {
                ans = bestI;
            }
        }
        return ans;
    }
}
