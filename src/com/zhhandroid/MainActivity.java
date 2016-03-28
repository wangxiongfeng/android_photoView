package com.zhhandroid;

import java.io.IOException;
import java.io.InputStream;

import com.nostra13.universalimageloader.core.ImageLoader;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;
import uk.co.senab.photoview.PhotoViewAttacher.OnPhotoTapListener;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	private PhotoView iv_photo1;
	private PhotoView iv_photo2;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv_photo1 = (PhotoView) findViewById(R.id.iv_photo1);
		iv_photo2 = (PhotoView) findViewById(R.id.iv_photo2);
        localImage();
	    netImage();
	    
	}

/** 
 * ���ر���ͼƬ  
 * 
 */
	private void localImage() {
//		 ���ر���ͼƬ�����Ŵ���
		 try {
//		 ͼƬ��assetĿ¼��	 
		 InputStream is = getAssets().open("photo2.jpg");
		 Bitmap bm = BitmapFactory.decodeStream(is);
		 iv_photo1.setImageBitmap(bm);
		 is.close();
		 } catch (IOException e) {
		 e.printStackTrace();
		 }
		
	}
	/**
	 * ��������ͼƬ
	 */
	private void netImage() {
		ImageLoader loader = ImageLoader.getInstance();
		loader.displayImage("https://www.baidu.com/img/bdlogo.png", iv_photo2);
		iv_photo2.setOnPhotoTapListener(new OnPhotoTapListener() {
			
			@Override
			public void onPhotoTap(View arg0, float arg1, float arg2) {
				Toast.makeText(MainActivity.this, "ͼƬ�������", 10).show();
			}
		});
		
	}
	

	
}
