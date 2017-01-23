package com.example.mypc.reshimbandh.Modal;

import android.widget.ImageView;

/**
 * Created by my pc on 19-11-2016.
 */

public class Dataobject {
    private String fullname;
    private String profile_image_url;
    private String dist;
    private String discription;
    private int image1,image2,image3,profile_image;

    public Dataobject(String name, String desc,int profile_imageView,int imageView1,int imageView2,int imageView3) {
        fullname = name;
        discription = desc;
        profile_image = profile_imageView;
        image1 = imageView1;
        image2 = imageView2;
        image3 = imageView3;
    }

    public String getFullname() {
        return fullname;
    }

    public int get_profile_image() {
        return profile_image;
    }

    public int getimage1() {
        return image1;
    }

    public int getimage2() {
        return image2;
    }

    public int getimage3() {
        return image3;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public String getDiscription() {
        return discription;
    }

    public String getDist() {
        return dist;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }
}
