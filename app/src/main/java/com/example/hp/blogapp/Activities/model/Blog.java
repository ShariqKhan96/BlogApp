package com.example.hp.blogapp.Activities.model;

/**
 * Created by hp on 6/28/2018.
 */

public class Blog {

   public String userName;
   public String date;
   public String userImageUrl;
   public String blogImageUrl;
   public String blogCaption;
   public String likes;
   public String comments;

    public Blog(String userName, String date, String userImageUrl, String blogImageUrl, String blogCaption, String likes, String comments) {
        this.userName = userName;
        this.date = date;
        this.userImageUrl = userImageUrl;
        this.blogImageUrl = blogImageUrl;
        this.blogCaption = blogCaption;
        this.likes = likes;
        this.comments = comments;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    public String getBlogImageUrl() {
        return blogImageUrl;
    }

    public void setBlogImageUrl(String blogImageUrl) {
        this.blogImageUrl = blogImageUrl;
    }

    public String getBlogCaption() {
        return blogCaption;
    }

    public void setBlogCaption(String blogCaption) {
        this.blogCaption = blogCaption;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
