package com.telran.cars.data.repository;

import com.telran.cars.data.dto.CommentPostDto;
import com.telran.cars.data.dto.ImageDto;

import io.reactivex.Completable;

public interface CommentFilterImageLoggerRepository {
    //Comment_Controller
    Completable addNewComment(String token, CommentPostDto content, String serialNumber);
    Completable getLatestComment();

    //Filter_Update_Controller
    Completable updateTimerFilters(Integer minute);

    //Image_Download_Controller
    Completable downloadImage(ImageDto image);

    //Logger_Controller
    Completable getLoggers(String password);
}
