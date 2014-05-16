package com.fewlaps.android.grec;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.zxing.Result;
import com.google.zxing.client.android.CaptureActivity;

public class ScanQRActivity extends CaptureActivity {

	private static final String EXPECTED_RESULT = "42";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_qr);
        
        ImageView idea = (ImageView) findViewById(R.id.idea);
        idea.startAnimation(AnimationUtils.loadAnimation(this, R.anim.blink));

        findViewById(R.id.fakeButton).setOnClickListener(new OnClickListener() {
			
        	@Override
			public void onClick(View arg0) {
        		ScanQRActivity.this.startActivity(new Intent(ScanQRActivity.this, EscletxaActivity.class));
			}
		});
    }
    
    @Override 
    public void handleDecode(Result rawResult, Bitmap barcode) 
    {
    	if(rawResult.getText().equals(EXPECTED_RESULT)){
    		startActivity(new Intent(this, EscletxaActivity.class));
    	}
    }
    
//	@Override
//	public void onBackPressed() {
//		//No fem res
//	}
}