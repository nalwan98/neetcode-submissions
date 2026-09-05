class Twitter {

    Map<Integer, Set<Integer>> followersList;
    PriorityQueue<int[]> maxHeap;
    int time;
    public Twitter() {
        followersList = new HashMap<>();
        maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        followersList.put(userId, followersList.getOrDefault(userId, new HashSet<>()));
        int[] tweet = new int[]{time, tweetId, userId};
        maxHeap.offer(tweet);
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        followersList.put(userId, followersList.getOrDefault(userId, new HashSet<>()));
        int count = 0;
        List<Integer> res = new ArrayList<>();
        List<int[]> ret = new ArrayList<>();
        while(maxHeap.size()>0 && count<10){
            int[] curr = maxHeap.poll();
            if(curr[2] == userId || followersList.get(userId).contains(curr[2])){
                res.add(curr[1]);
                count++;
            }
            ret.add(curr);
        }
        for(int[] arr: ret){
            maxHeap.offer(arr);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followersList.put(followerId, followersList.getOrDefault(followerId, new HashSet<>()));
        followersList.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followersList.get(followerId).remove(followeeId);
    }
}
