package com.misharyduk.CarRent.controller;

import com.misharyduk.CarRent.model.Comment;
import com.misharyduk.CarRent.service.CarService;
import com.misharyduk.CarRent.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddComment {

    @Autowired
    private CommentService commentService;
    @Autowired
    private CarService carService;

    @RequestMapping("/add-comment")
    public ModelAndView addComment(@ModelAttribute Comment comment,
                                   @RequestParam("car_id") int car_id){
        comment.setCar(carService.getCar(car_id));
        commentService.addComment(comment);
        return new ModelAndView("redirect:/car?id="+car_id);
    }

}
