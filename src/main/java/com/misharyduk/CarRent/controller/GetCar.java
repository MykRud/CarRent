package com.misharyduk.CarRent.controller;

import com.misharyduk.CarRent.model.Car;
import com.misharyduk.CarRent.model.Comment;
import com.misharyduk.CarRent.service.CarService;
import com.misharyduk.CarRent.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GetCar {
    @Autowired
    private CarService carService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/car")
    public ModelAndView getCar(@RequestParam int id){
        ModelAndView mv = new ModelAndView("car-view");
        Car car = carService.getCar(id);
        mv.addObject("car", car);
        mv.addObject("comments", commentService.getCommentsByCar(car.getId()));
        mv.addObject("comment", new Comment());
        return mv;
    }
}
