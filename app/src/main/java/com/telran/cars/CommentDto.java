package com.telran.cars;

class CommentDto {
    private String first_name;
    private String photo;
    private String post;
    private String post_date;
    private String second_name;

    public CommentDto(String first_name, String photo, String post, String post_date, String second_name) {
        this.first_name = first_name;
        this.photo = photo;
        this.post = post;
        this.post_date = post_date;
        this.second_name = second_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPost_date() {
        return post_date;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "first_name='" + first_name + '\'' +
                ", photo='" + photo + '\'' +
                ", post='" + post + '\'' +
                ", post_date='" + post_date + '\'' +
                ", second_name='" + second_name + '\'' +
                '}';
    }
}
