package com.example.hariharanm.profilio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;

public class DetailActivity extends AppCompatActivity {
    public static final String Name_Value = "Name";
    public static final String Description = "Description";
    public static final String Url = "Url";
    public static final int Request_Code = 1001;
    protected List<Course> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        data = DataProvider.getData();
        ArrayAdapter<Course> courseArrayAdapter = new CourseArrayAdapter(this,0,data);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(courseArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Course course = data.get(position);
                displayContent(course);
            }
        });
    }

    private void displayContent(Course course) {
        Intent intent = new Intent(this,DisplayActivity.class);
        intent.putExtra(Name_Value,course.getName());
        intent.putExtra(Description,course.getDescription());
        intent.putExtra(Url,course.getUrl());
        startActivityForResult(intent, Request_Code);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class CourseArrayAdapter extends ArrayAdapter<Course>{

        Context context;
        List<Course> objects;

        public CourseArrayAdapter(Context context, int resource, List<Course> objects) {
            super(context, resource, objects);

                this.context=context;
                this.objects=objects;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Course course = objects.get(position);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.course_item,null);

            TextView tv = (TextView) view.findViewById(R.id.Tvtitle);
            tv.setText(course.getName());

            ImageView iv = (ImageView) view.findViewById(R.id.imageCourse);
            int res = context.getResources().getIdentifier("image_"+course.getCourseNumber(),"drawable",context.getPackageName());
            iv.setImageResource(res);

            return view;
        }
    }
}
