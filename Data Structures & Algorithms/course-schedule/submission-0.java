class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] prereqscount = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            map.put(i, new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++){
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            map.get(prereq).add(course);
            prereqscount[course]++;
        }
        
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(prereqscount[i]==0){
                q.add(i);
            }
        }

        int completed=0;
        while(!q.isEmpty()){
            int curcourse = q.poll();
            completed++;

            for(int course: map.get(curcourse)){
                prereqscount[course]--;
                if(prereqscount[course]==0){
                    q.add(course);
                }
            }
        }
        if(completed==numCourses){
            return true;
        }
        return false;
    }
}
