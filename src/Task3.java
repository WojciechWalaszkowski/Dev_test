import java.util.*;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        int numOfSeparatedGraphs = 1;

        // Example: vertices1[0] and vertices2[0] is a connection
        ArrayList<Integer> vertices1 = new ArrayList<>();
        ArrayList<Integer> vertices2 = new ArrayList<>();

        // Connections in the currently checked graph
        ArrayList<Integer> graph = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        /*Scanner sc = new Scanner("""
                3
                2 3
                1 2
                5 6
                """);*/

        try {
            int n = sc.nextInt();

            if (n <= 0)
            {
                throw new ArithmeticException("Input should be positive integers.");
            }

            int[][] pairs = new int[n][2];

            for (int num_pair = 0; num_pair < n; num_pair++){
                int vertex1 = sc.nextInt();
                int vertex2 = sc.nextInt();

                if (vertex1<= 0 || vertex2 <= 0)
                {
                    throw new ArithmeticException("Input should be positive integers.");
                }

                //If the first value of vertex would be higher than the second one, swap them
                if (vertex2 <= vertex1){
                    vertex2 += vertex1;
                    vertex1 = vertex2 - vertex1;
                    vertex2 -= vertex1;
                }
                pairs[num_pair][0] = vertex1;
                pairs[num_pair][1] = vertex2;
            }

            // Sort array in ascending order based on the lower (first) value of vertex
            Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
            for(int[] pair:pairs){
                vertices1.add(pair[0]);
                vertices2.add(pair[1]);
            }

            // Position - index of found connection
            int position;
            // Currently checked vertex in graph
            int vertex = 0;

            // Add connection in the currently checked graph
            graph.add(vertices1.get(vertex));
            graph.add(vertices2.get(vertex));
            // Remove connection from the list
            vertices1.remove(vertex);
            vertices2.remove(vertex);

            // Detect new graphs
            while (vertices1.size() > 0){
                // Enlarge the current graph, remove connection from the list
                while (vertices1.contains(graph.get(vertex))){
                    position = vertices1.indexOf(graph.get(vertex));
                    graph.add(vertices2.get(position));
                    vertices1.remove(position);
                    vertices2.remove(position);
                }
                // Enlarge the current graph, remove connection from the list
                while (vertices2.contains(graph.get(vertex))){
                    position = vertices2.indexOf(graph.get(vertex));
                    graph.add(vertices1.get(position));
                    vertices1.remove(position);
                    vertices2.remove(position);
                }
                vertex++;

                // New graph
                if (vertex == graph.size()){
                    numOfSeparatedGraphs++;
                    vertex = 0;
                    graph.clear();
                    graph.add(vertices1.get(vertex));
                    graph.add(vertices2.get(vertex));
                    vertices1.remove(vertex);
                    vertices2.remove(vertex);
                }
            }
            System.out.println(numOfSeparatedGraphs);
        }
        catch (InputMismatchException e){
                System.out.println("Expected input: positive number");
        }
    }
}
