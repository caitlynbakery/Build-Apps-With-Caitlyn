package org.codecakes.bawc_app.model;

import android.content.Context;

public class Course {
    private String courseName;
    private String courseImage;
    private String authorImage;

    public Course(String courseName, String courseImage, String authorImage) {
        this.courseName = courseName;
        this.courseImage = courseImage;
        this.authorImage = authorImage;
    }

    public int getImageResourceId(Context context){
        return context.getResources().getIdentifier(this.courseImage,
                "drawable", context.getPackageName());
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public String getAuthorImage() {
        return authorImage;
    }

    public void setAuthorImage(String authorImage) {
        this.authorImage = authorImage;
    }




}
