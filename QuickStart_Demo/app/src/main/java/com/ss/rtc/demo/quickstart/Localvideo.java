package com.ss.rtc.demo.quickstart;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.FileProvider;

import com.airbnb.lottie.LottieAnimationView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Localvideo extends Activity implements OnItemClickListener {

    private String cur_path = "/storage/emulated/0/DCIM/Camera";
    private List<Picture> listPictures;
    private LottieAnimationView lottieAnimationView;
    ListView listView;
    GridView mGridView;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);

            if (msg.what == 0) {
                List<Picture> listPictures = (List<Picture>) msg.obj;
                MyAdapter adapter = new MyAdapter(listPictures);
                mGridView.setAdapter(adapter);
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localvideo);
        lottieAnimationView = findViewById(R.id.lottieView2);
        lottieAnimationView.setAlpha(1f);
        lottieAnimationView.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator animatorout= ObjectAnimator.ofFloat(lottieAnimationView, "alpha",1.0f,0.0f);
                animatorout.setDuration(1000);
                animatorout.start();

            }
        },2000);
        loadVaule();
    }

    private void loadVaule() {
        File file = new File(cur_path);
        File[] files = file.listFiles();
        listPictures = new ArrayList<Picture>();
        for (int i = 0; i < files.length; i++) {
            Picture picture = new Picture();
            picture.setBitmap(getVideoThumbnail(files[i].getPath(), 200, 200, MediaStore.Images.Thumbnails.MICRO_KIND));
            picture.setPath(files[i].getPath());
            picture.setName(files[i].getName());
            if(files[i].getName().endsWith("mp4"))
            listPictures.add(picture);

        }
        mGridView = (GridView) findViewById(R.id.gridView);
        mGridView.setOnItemClickListener(this);
        Message msg = new Message();
        msg.what = 0;
        msg.obj = listPictures;

        handler.sendMessage(msg);

    }


    //获取视频的缩略图
    private Bitmap getVideoThumbnail(String videoPath, int width, int height, int kind) {
        Bitmap bitmap = null;
        // 获取视频的缩略图
        bitmap = ThumbnailUtils.createVideoThumbnail(videoPath, kind);
        bitmap = ThumbnailUtils.extractThumbnail(bitmap, width, height,
                ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
        return bitmap;
    }


    public class MyAdapter extends BaseAdapter {
        private List<Picture> listPictures;

        public MyAdapter(List<Picture> listPictures) {
            super();
            this.listPictures = listPictures;

        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return listPictures.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return listPictures.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View v, ViewGroup arg2) {
            // TODO Auto-generated method stu
            View view = getLayoutInflater().inflate(R.layout.localvideo_listview, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_show);
            TextView textView = (TextView) view.findViewById(R.id.tv_show);
            imageView.setImageBitmap(listPictures.get(position).getBitmap());
            textView.setText(listPictures.get(position).getPath());
            textView.setText(listPictures.get(position).getName());
            return view;

        }
    }


    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1,
                            int arg2, long arg3) {
        // TODO Auto-generated method stub
        Toast.makeText(getApplicationContext(), "点击了" + arg2,Toast.LENGTH_SHORT).show();
        playVideo(listPictures.get(arg2).getPath());
        Intent i = new Intent(getApplicationContext(), RTCRoomActivity.class);
        startActivity(i);
        Log.e("path", listPictures.get(arg2).getPath());
    }

    private void playVideo(String videoPath) {
					   Intent intent = new Intent(Intent.ACTION_VIEW);
					   String strend="";
					   if(videoPath.toLowerCase().endsWith(".mp4")){
						   strend="mp4";
					   }
					   intent.setDataAndType(Uri.parse(videoPath), "video/*");
					   startActivity(intent);
    }
}
