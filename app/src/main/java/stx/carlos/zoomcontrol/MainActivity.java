package stx.carlos.zoomcontrol;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ZoomControls;

public class MainActivity
	extends Activity
{
	ImageView image;
	ZoomControls zoomControls;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		image = findViewById(R.id.image);
		zoomControls = findViewById(R.id.simpleZoomControl);
		zoomControls.hide();

		image.setOnTouchListener(new View.OnTouchListener()
		{
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent)
			{
				zoomControls.show();
				return false;
			}
		});

		zoomControls.setOnZoomInClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				float x = image.getScaleX();
				float y = image.getScaleY();

				image.setScaleX( x + 1);
				image.setScaleY( y + 1);
				zoomControls.hide();
			}
		});

		zoomControls.setOnZoomOutClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				float x = image.getScaleX();
				float y = image.getScaleY();

				image.setScaleX( x - 1);
				image.setScaleY( y - 1);
				zoomControls.hide();
			}
		});
	}
}