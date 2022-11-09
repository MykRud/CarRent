package com.misharyduk.CarRent.service;

import com.misharyduk.CarRent.dao.CarDao;
import com.misharyduk.CarRent.dao.CommentDao;
import com.misharyduk.CarRent.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;

    public Comment getComment(int id){
        return commentDao.getComment(id);
    }

    public List<Comment> getCommentsByCar(int car_id){
        return commentDao.getCommentsByCar(car_id);
    }

    public List<Comment> getComments(){
        return commentDao.getComments();
    }

    public void addComment(Comment comment){
        commentDao.addComment(comment);
    }
}
