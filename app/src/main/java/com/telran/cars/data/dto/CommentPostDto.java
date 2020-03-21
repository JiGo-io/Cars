package com.telran.cars.data.dto;

public class CommentPostDto {
    private String post;

    public CommentPostDto(String post) {
        this.post = post;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "CommentPostDto{" +
                "post='" + post + '\'' +
                '}';
    }
}
