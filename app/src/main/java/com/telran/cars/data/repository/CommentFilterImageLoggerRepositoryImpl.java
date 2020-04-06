package com.telran.cars.data.repository;

import android.util.Log;

import com.telran.cars.data.dto.CommentDto;
import com.telran.cars.data.dto.CommentPostDto;
import com.telran.cars.data.dto.ImageDto;
import com.telran.cars.data.provider.store.StoreProvider;
import com.telran.cars.data.provider.web.ApiRx;

import java.io.IOException;

import io.reactivex.Completable;
import retrofit2.Response;

public class CommentFilterImageLoggerRepositoryImpl implements CommentFilterImageLoggerRepository {
    private static final String TAG = "CommentFilterImageLoggerRepository";
    private ApiRx api;
    private StoreProvider storeProvider;

    public CommentFilterImageLoggerRepositoryImpl(ApiRx api, StoreProvider storeProvider) {
        this.api = api;
        this.storeProvider = storeProvider;
    }

    @Override
    public Completable addNewComment(String token, CommentPostDto content, String serialNumber) {
        return Completable.fromSingle(
                api.addNewComment(token, content, serialNumber).doOnSuccess(this::onAddNewCommentSuccess)
        );
    }

    @Override
    public Completable getLatestComment() {
        return Completable.fromSingle(
                api.getLatestComment().doOnSuccess(this::onGetLatestCommentSuccess)
        );
    }

    @Override
    public Completable updateTimerFilters(Integer minute) {
        return Completable.fromSingle(
                api.updateTimerFilters(minute).doOnSuccess(this::onUpdateTimerFiltersSuccess)
        );
    }

    @Override
    public Completable downloadImage(ImageDto image) {
        return Completable.fromSingle(
                api.downloadImage(image).doOnSuccess(this::onDownloadImageSuccess)
        );
    }


    private void onAddNewCommentSuccess(Response<CommentDto> response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onAddNewCommentSuccess: " + response.body().toString());
        } else if (response.code() == 400 || response.code() == 401 || response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onAddNewCommentSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

    private void onGetLatestCommentSuccess(Response<CommentDto[]> response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onGetLatestCommentSuccess: " + response.body().toString());
        } else if (response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onGetLatestCommentSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

    private void onUpdateTimerFiltersSuccess(Response response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onUpdateTimerFiltersSuccess: " + response.body().toString());
        } else if (response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onUpdateTimerFiltersSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

    private void onDownloadImageSuccess(Response<ImageDto> response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onDownloadImageSuccess: " + response.body().toString());
        } else if (response.code() == 400 || response.code() == 401) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onDownloadImageSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

}
