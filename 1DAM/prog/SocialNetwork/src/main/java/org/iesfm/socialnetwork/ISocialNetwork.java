package org.iesfm.socialnetwork;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public interface ISocialNetwork {

    TreeSet<Post> getWallPostsByUsername (String username);

    TreeSet<Post> getWallPostsByTag (String username, String tag);

    TreeSet<Post> addWallPosts (String username, String message, String date, HashSet<String> tags);

    LinkedList<Post> findAuthorWallPosts (String username);

    User createUser(String username);
}
