package org.codecakes.bawc_app.data;

import com.squareup.picasso.Picasso;

import org.codecakes.bawc_app.model.Course;

import java.util.ArrayList;

public class CourseData {

    private String[] courseNames = {"Course 1", "Course 2",
    "Course 3", "Course 4", "Course 5", "Course 6", "Course 7"};

    public ArrayList<Course> courseList(){
        ArrayList<Course> list = new ArrayList<>();
        for (int i =0; i < courseNames.length; i++) {
            Course course = new Course(courseNames[i], courseNames[i]
                    .replace(" ", "").toLowerCase(), "chef");
            list.add(course);
        }
        return list;

    }
}
