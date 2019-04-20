package org.codecakes.bawc_app.controller;

import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.codecakes.bawc_app.R;
import org.codecakes.bawc_app.data.CourseData;
import org.codecakes.bawc_app.model.Course;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private int courseId;
    private Course course;
    private ImageView courseImageView;
    private TextView courseTitle;
    private InputMethodManager inputMethodManager;
    private LinearLayout revealView;
    private boolean isEditTextVisible = false;

    private FloatingActionButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setUpUI();
        loadCourse();



    }

    private void loadCourse() {
        course = new CourseData().courseList().get(getIntent().getExtras().getInt("course_id"));

        Log.d("COURSE", Integer.toString(course.getImageResourceId(this)));
        // The reason this didn't work before is the transparency of the background
        // was set to 0 in content_details.xml
        // The 85 prefix sets the transparency to 50%  android:background="#85000000"
        courseImageView.setImageResource(course.getImageResourceId(this));

        courseTitle.setText(course.getCourseName());
    }

    private void setUpUI() {
        inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        courseImageView = findViewById(R.id.detailsCourseImage);
        courseTitle = findViewById(R.id.detailsCourseTitle);

        revealView = findViewById(R.id.revealView);
        revealView.setVisibility(View.INVISIBLE);
        isEditTextVisible = false;

        button = (FloatingActionButton) findViewById(R.id.detailsAddButton);


    }

    @Override
    public void onClick(View v) {
        
    }
}
