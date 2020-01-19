package com.example.recyclerviewgetitemtest;

public class FavoriteModel {
    private int video_img;
    private String video_name;

    public FavoriteModel(int video_img, String video_name) {
        this.video_img = video_img;
        this.video_name = video_name;
    }


    public int getVideo_img() {
        return video_img;
    }

    public void setVideo_img(int video_img) {
        this.video_img = video_img;
    }

    public String getVideo_name() {
        return video_name;
    }

    public void setVideo_name(String video_name) {
        this.video_name = video_name;
    }
}
