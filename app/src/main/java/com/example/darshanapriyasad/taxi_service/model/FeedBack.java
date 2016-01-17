package com.example.darshanapriyasad.taxi_service.model;

/**
 * Created by Darshana Priyasad on 1/16/2016.
 */
public class FeedBack {


    private String user_id;
    private String feedback;
    private String comment;

    public FeedBack(String user_id, String feedback, String comment) {
        this.setUser_id(user_id);
        this.setFeedback(feedback);
        this.setComment(comment);
    }

    public FeedBack() {
    }


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
