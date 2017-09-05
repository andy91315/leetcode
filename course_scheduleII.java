class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];

        //build graph
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
        	map.put(i, new ArrayList<Integer>());
        }
        for (int[] prerequisite : prerequisites) {
        	indegree[prerequisite[0]]++;
        	map.get(prerequisite[1]).add(prerequisite[0]);
        }

        for (int i = 0; i < indegree.length; i++) {
        	if (indegree[i] == 0) {
        		queue.offer(i);
        	}
        }

        int count = 0;
        while (!queue.isEmpty()) {
        	int cur = queue.poll();
        	result[count++] = cur;
        	List<Integer> next = map.get(cur);
        	for (int i = 0; i < next.size(); i++) {
        		int nei = next.get(i);
        		if (--indegree[nei] == 0) {
        			queue.offer(nei);
        		}
        	}
        }
        if (count != numCourses) {
        	return new int[0];
        }
        return result;
    }
}