package com.telran.cars.data.dto;

public class CommentDto {
    private String first_name;
    private String second_name;
    private String post_date;
    private String post;
    private String photo;

    public CommentDto(String first_name, String second_name, String post_date, String post, String photo) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.post_date = post_date;
        this.post = post;
        this.photo = photo;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public String getPost_date() {
        return post_date;
    }

    public String getPost() {
        return post;
    }

    public String getPhoto() {
        return photo;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", post_date='" + post_date + '\'' +
                ", post='" + post + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
