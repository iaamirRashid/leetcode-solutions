class Solution {
   static class Info {
        int v, cost, stops;
        public Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }

    public int cheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Step 1: Graph initialization
        ArrayList<int[]> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Step 2: Graph filling (expanded way)
        for (int i = 0; i < flights.length; i++) {
            int srcCity = flights[i][0];
            int destCity = flights[i][1];
            int price = flights[i][2];

            // Destination + price ka pair banao
            int[] destPricePair = new int[]{destCity, price};

            // Source city ke adjacency list me add karo
            graph[srcCity].add(destPricePair);
        }

        // Step 3: Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 4: BFS queue
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0)); // city, cost, stops

        // Step 5: BFS traversal
        while (!q.isEmpty()) {
            Info curr = q.remove();

            if (curr.stops > k) continue; // stop limit exceed

            for (int[] neighbor : graph[curr.v]) {
                int nextCity = neighbor[0];
                int price = neighbor[1];

                if (curr.cost + price < dist[nextCity]) {
                    dist[nextCity] = curr.cost + price;
                    q.add(new Info(nextCity, dist[nextCity], curr.stops + 1));
                }
            }
        }

        // Step 6: Return answer
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        return cheapestPrice(n, flights, src, dst, k);
    }
}