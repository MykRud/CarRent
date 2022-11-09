package com.misharyduk.CarRent.dao;

import com.misharyduk.CarRent.model.Comment;

import java.util.List;

public interface CommentDao {
    Comment getComment(int id);

    List<Comment> getCommentsByCar(int car_id);

    List<Comment> getComments();

    void addComment(Comment comment);
}
