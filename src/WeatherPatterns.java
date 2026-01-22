/**
 * The class WeatherPatterns finds the longest span of days in which
 * each day’s temperature is higher than on the previous day in that sequence.
 *
 * @author Zach Blick
 * @author Surya De Datta
 */

public class WeatherPatterns
{
    /**
     * Longest Warming Trend
     * @param temperatures
     * @return the longest run of days with increasing temperatures
     */
    public static int longestWarmingTrend(int[] temperatures)
    {
        // Makes an adjacency matrix of temperatures in a [from][to] format
        boolean[][] matrix = new boolean[temperatures.length][temperatures.length];
        for (int i = 0; i < temperatures.length; i++)
        {
            for(int j = i + 1; j < temperatures.length; j++)
            {
                // Inputs a true boolean value in the matrix at all temperatures greater after a given temperature/node
                if(temperatures[j] > temperatures[i])
                {
                    matrix[i][j] = true;
                }
            }
        }
        // Creates an array to store the longest runs up to previous temperatures
        int[] memory = new int[temperatures.length];
        int finalMax = 1;
        // Determines the maximum run in the entire temperatures "graph"
        for(int vertex = 0; vertex < temperatures.length; vertex++)
        {
            int len = LongestPathTo(vertex, matrix, memory);
            finalMax = Math.max(len, finalMax);
        }
        return finalMax;
    }

    public static int LongestPathTo(int vertex, boolean[][] matrix, int[] memory)
    {
        // Memoization
        if(memory[vertex] != 0)
        {
            return memory[vertex];
        }
        int maxLen = 1;
        // Look at all vertices that come before a given vertex/temperature
        for (int i = 0; i < vertex; i++)
        {
            // If an edge is present between i and vertex
            // vertex can follow i in an increasing temperature sequence
            if(matrix[i][vertex] == true)
            {
                // Computes the longest path of increasing temps that ends in i and adds 1 to reach vertex
                int candidate = LongestPathTo(i, matrix, memory) + 1;
                maxLen = Math.max(candidate, maxLen);
            }
        }
        // Ensures we don't recompute the value for a given temperature
        memory[vertex] = maxLen;
        return maxLen;
    }
}
