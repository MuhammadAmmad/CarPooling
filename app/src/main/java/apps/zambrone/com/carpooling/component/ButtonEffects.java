package apps.zambrone.com.carpooling.component;

import android.graphics.Color;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by Chamith on 16/01/2017.
 */

public class ButtonEffects {
    public static void buttonEffect(View view) {
        final Button button = (Button) view;


        button.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                Drawable buttonBackground;
                ColorDrawable buttonColor;
                int colorId = 0;
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                    {
                        buttonBackground = button.getBackground();
                        buttonColor = (ColorDrawable) button.getBackground();
                        colorId = buttonColor.getColor();
                        button.setBackgroundColor(Color.GRAY);
                    }
                    return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                    {
                        button.setBackgroundColor(colorId);
                    }
                    return true;
                }
                return false;
            }

        });
    }
}
