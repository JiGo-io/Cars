package com.telran.cars.data.provider.web;

import com.telran.cars.data.dto.BookedCarsDtoForUser;
import com.telran.cars.data.dto.CarForUsersDto;
import com.telran.cars.data.dto.CarFullDto;
import com.telran.cars.data.dto.CarFullUploadRequestDto;
import com.telran.cars.data.dto.CarsFiltersDto;
import com.telran.cars.data.dto.CommentDto;
import com.telran.cars.data.dto.CommentPostDto;
import com.telran.cars.data.dto.ImageDto;
import com.telran.cars.data.dto.JsonNode;
import com.telran.cars.data.dto.OwnerCarDtoForCar;
import com.telran.cars.data.dto.PageResponseWithFilter;
import com.telran.cars.data.dto.RegistrationDto;
import com.telran.cars.data.dto.ReservedPeriodDto;
import com.telran.cars.data.dto.UserBaseDto;
import com.telran.cars.data.dto.UserDtoForUser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiRx {




    //Car_Controller
    @GET("/car")
    Single<Response<CarFullDto>> getCarById(@Query("serial_number") String serialNumber);

    @POST("/car")
    Single<Response<CarFullDto>> addNewCar(@Header("Authorization") String token,
                                           @Body CarFullUploadRequestDto dto);

    @PUT("/car")
    Single<Response<CarFullDto>> carUpdate(@Header("Authorization") String token,
                                           @Body CarFullUploadRequestDto dto,
                                           @Query("serial_number") String serialNumber);

    @DELETE("/car")
    Single<Response> carDelete(@Header("Authorization") String token,
                               @Query("serial_number") String serialNumber);

    @GET("/car/best")
    Single<Response<CarForUsersDto[]>> getThreeBestCar();

    @GET("/user/cars")
    Single<Response<CarFullDto>> getOwnerCars(@Header("Authorization") String token);

    @GET("/user/cars/car")
    Single<Response<CarFullDto>> getOwnerCarBySn(@Header("Authorization") String token,
                                                 @Query("serial_number") String serialNumber);

    @GET("/user/cars/periods")
    Single<Response<CarFullDto>> getOwnerBookedPeriods(@Header("Authorization") String token,
                                                       @Query("serial_number") String serialNumber);

    //Car_Filter_Controller
    @GET("/filters")
    Single<Response<JsonNode>> getFilters();

    @GET("/search")
    Single<Response<CarForUsersDto[]>> getCarByDateLocationPrice(@Query("ascending") Boolean ascending,
                                                               @Query("current_page") Integer currentPage,
                                                               @Query("end_date") String endDate,
                                                               @Query("items_on_page") Integer itemsOnPage,
                                                               @Query("latitude") Number latitude,
                                                               @Query("longitude") Number longitude,
                                                               @Query("max_amount") Number maxAmount,
                                                               @Query("min_amount") Number minAmount,
                                                               @Query("start_date") String startDate);

    @GET("/search/all")
    Single<Response<PageResponseWithFilter>> searchAllContains(@Query("ascending") Boolean ascending,
                                                               @Query("current_page") Integer currentPage,
                                                               @Query("end_date") String endDate,
                                                               @Query("engine") String engine,
                                                               @Query("fuel") String fuel,
                                                               @Query("gear") String gear,
                                                               @Query("items_on_page") Integer itemsOnPage,
                                                               @Query("latitude") Number latitude,
                                                               @Query("longitude") Number longitude,
                                                               @Query("make") String make,
                                                               @Query("max_amount") Number maxAmount,
                                                               @Query("min_amount") Number minAmount,
                                                               @Query("model") String model,
                                                               @Query("radius") Number radius,
                                                               @Query("start_date") String startDate,
                                                               @Query("wheels_drive") String wheelsDrive,
                                                               @Query("year") String year);

    @GET("/search/filters")
    Single<Response<CarsFiltersDto[]>> getCarByFilter(@Query("current_page") Integer currentPage,
                                                    @Query("fuel") String fuel,
                                                    @Query("gear") String gear,
                                                    @Query("items_on_page") Integer itemsOnPage,
                                                    @Query("make") String make,
                                                    @Query("model") String model,
                                                    @Query("wheels_drive") String wheelsDrive,
                                                    @Query("year") String year);

    @GET("/search/geo")
    Single<Response<CarsFiltersDto[]>> getCarByLocation(@Query("current_page") Integer currentPage,
                                                      @Query("items_on_page") Integer itemsOnPage,
                                                      @Query("latitude") Number latitude,
                                                      @Query("longitude") Number longitude,
                                                      @Query("radius") Number radius);

    //Comment_Controller
    @POST("/comment")
    Single<Response<CommentDto>> addNewComment(@Header("Authorization") String token,
                                               @Body CommentPostDto content,
                                               @Query("serial_number") String serialNumber);

    @GET("/comments")
    Single<Response<CommentDto[]>> getLatestComment();

    //Filter_Update_Controller
    @POST("/filter/update")
    Single<Response> updateTimerFilters(@Query("minute") Integer minute);

    //Image_Download_Controller
    @POST("/image")
    Single<Response<ImageDto>> downloadImage(@Body ImageDto image);

    //Logger_Controller
    @GET("/logger")
    Single<Response<String>> getLoggers(@Query("password") String password);

    //Reservation_Controller
    @POST("/car/payment")
    Single<Response> paymentForRegistration(@Header("Authorization") String token,
                                            @Query("bookedId") String bookedId);

    @POST("/car/reservation")
    Single<Response<CarFullDto>> reservationCarById(@Header("Authorization") String token,
                                                    @Body RegistrationDto dto,
                                                    @Query("serial_number") String serialNumber);

    @DELETE("/car/reservation")
    Single<Response<CarFullDto>> reservationCancellation(@Header("Authorization") String token,
                                                         @Query("serial_number") String serialNumber,
                                                         @Query("start_date_time") String startDateTime);

    @POST("/user/free")
    Single<Response<OwnerCarDtoForCar>> unlockCarById(@Header("Authorization") String token,
                                                      @Body ReservedPeriodDto[] dto,
                                                      @Query("serial_number") String serialNumber);

    @POST("/user/reservation")
    Single<Response<OwnerCarDtoForCar>> lockCarById(@Header("Authorization") String token,
                                             @Body ReservedPeriodDto[] dto,
                                             @Query("serial_number") String serialNumber);

    //User_Controller
    @POST("/activate/{code}")
    Single<Response<String>> activateUser(@Path("code") String code);

    @POST("/registration")
    Single<Response<UserDtoForUser>> registration(@Header("Authorization") String token,
                                                  @Body RegistrationDto registrationDto);

    @PUT("/user")
    Single<Response<UserDtoForUser>> updateUser(@HeaderMap Map<String, String> headers,
                                                @Body UserBaseDto userBaseDto);

    @DELETE("/user")
    Single<Response> deleteUser(@Header("Authorization") String token);

    @GET("/user/booked")
    Single<Response <ArrayList<BookedCarsDtoForUser>>> getBookedList(@Header("Authorization") String token);

    @GET("/user/invoice")
    Single<Response> getInvoice(@Header("Authorization") String token,
                                @Query("order_id") String orderId);

    @GET("/user/login")
    Single<Response<UserDtoForUser>> authorizationUser(@Header("Authorization") String token);

    @POST("/user/verify")
    Single<Response> remindPassword(@Header("Return-path") String token);
}
