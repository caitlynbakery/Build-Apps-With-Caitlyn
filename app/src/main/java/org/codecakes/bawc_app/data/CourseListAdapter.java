package org.codecakes.bawc_app.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.codecakes.bawc_app.R;
import org.codecakes.bawc_app.model.Course;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.ViewHolder>
implements View.OnClickListener{

    private CourseData courseData = new CourseData();
    public OnItemClickListener itemClickListener;

    private ArrayList<Course> courseArrayList;
    @NonNull
    @Override
    public CourseListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View courseRow = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.course_row, viewGroup, false);
        return new ViewHolder(courseRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final CourseListAdapter.ViewHolder viewHolder, int i) {

        final Context context = viewHolder.courseTitle.getContext();

        Course course = courseData.courseList().get(i);
        viewHolder.courseTitle.setText(course.getCourseName());
        Picasso picasso = new Picasso.Builder(context).build();
        picasso.load(course.getImageResourceId(viewHolder.courseTitle.getContext()))
                .into(viewHolder.courseImageView);
        picasso.load(course.getImageResourceId(viewHolder.courseTitle.getContext()))
                .into(viewHolder.authorImageView);
//        Picasso.get().load(course.getImageResourceId(viewHolder.courseTitle.getContext()))
//            .into(viewHolder.courseImageView);
//        Picasso.get().load(course.getImageResourceId(viewHolder.courseTitle.getContext()))
//             .into(viewHolder.authorImageView);

        Bitmap photo = BitmapFactory.decodeResource(context.getResources(),
                course.getImageResourceId(context));
        Palette.from(photo).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                int bgColor = palette.getMutedColor(ContextCompat.getColor(context,
                        android.R.color.black));
                viewHolder.courseTitle.setBackgroundColor(bgColor);
                viewHolder.authorImageView.setBorderColor(bgColor);
            }
        });
    }

    @Override
    public int getItemCount() {
        return courseData.courseList().size();
    }

    public void setOnClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public TextView courseTitle;
        public ImageView courseImageView;
        public CircleImageView authorImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            courseTitle = itemView.findViewById(R.id.courseTitleId);
            courseImageView = itemView.findViewById(R.id.courseImageId);
            authorImageView = itemView.findViewById(R.id.authorImageId);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
