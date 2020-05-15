package leetcode_cn.april;

import java.util.List;
import java.util.Set;

/**
 * @Description
 * @Author ericning@wezhuiyi.com
 * @Date 2020/4/13 22:07
 **/
public class TODO_Twitter {
    /**
     * Initialize your data structure here.
     */
    public TODO_Twitter() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {

    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        return null;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {

    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {

    }

    public static class Tweet {
        private int userId;
        private int tweetId;

    }

    public static class User {
        private int userId;
        private Set<Integer> followeeIds;

        public User(int userId, Set<Integer> followeeIds) {
            this.userId = userId;
            this.followeeIds = followeeIds;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
