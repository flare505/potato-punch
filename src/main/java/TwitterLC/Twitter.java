package TwitterLC;

import java.util.*;

public class Twitter {

    //followerId(userId) -> followeeIds
    private Map<Integer, Set<Integer>> followMap;
    // userId -> tweetIds
    private Map<Integer, HashMap<Integer, Tweet>> tweets;

    public Twitter() {
        followMap = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Map<Integer, Tweet> tweetByUserId = tweets.getOrDefault(userId, new HashMap<>());
        tweetByUserId.put(tweetByUserId.size(), new Tweet(tweetId, userId, System.currentTimeMillis()));
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followeesByUserId = followMap.getOrDefault(userId, new HashSet<>());
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> (int) (b.timestamp - a.timestamp));
        List<Tweet> feedTweets = new ArrayList<>();
        for (Integer followeeId : followeesByUserId) {
            Map<Integer, Tweet> tweetByFollowee = tweets.getOrDefault(userId, new HashMap<>());
            if (tweetByFollowee != null) {
//                pq.add(tweetsOfFollowee)
            }
        }
        return null;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> followeesByFollowerId = followMap.get(followerId);
        if (followeesByFollowerId == null) {
            followeesByFollowerId = new HashSet<>();
            followeesByFollowerId.add(followerId);
            followMap.put(followeeId, followeesByFollowerId);
        }
        followeesByFollowerId.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followersByFolloweeId = followMap.getOrDefault(followeeId, new HashSet<>());
        followersByFolloweeId.remove(followerId);
    }

    public class Tweet{
        int tweetId;
        int userId;
        long timestamp;

        public Tweet(int tweetId, int userId, long timestamp) {
            this.tweetId = tweetId;
            this.userId = userId;
            this.timestamp = timestamp;
        }
    }
}