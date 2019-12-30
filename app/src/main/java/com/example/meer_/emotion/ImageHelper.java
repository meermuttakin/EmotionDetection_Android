package com.example.meer_.emotion;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.microsoft.projectoxford.emotion.contract.FaceRectangle;

public class ImageHelper {

    public static Bitmap drawReactOnBitmap(Bitmap mBitmap, FaceRectangle faceRectangle, String status) {
        Bitmap bitmap = mBitmap.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(8);

        canvas.drawRect(faceRectangle.left,
                faceRectangle.top,
                faceRectangle.left + faceRectangle.width,
                faceRectangle.top + faceRectangle.height,
                paint);
        int cX = faceRectangle.left + faceRectangle.width;
        int cY = faceRectangle.top + faceRectangle.height;

        drawTextOnBitmap(canvas, 50, cX / 2 + cX / 5, cY + 70, Color.WHITE, status);

        return bitmap;
    }

        private static void drawTextOnBitmap(Canvas canvas, int textSize, int cX, int cY, int color,String status)
        {
            Paint paintt = new Paint();
            paintt.setAntiAlias(true);
            paintt.setStyle(Paint.Style.FILL);
            paintt.setTextSize(textSize);

            canvas.drawText(status,cX,cY,paintt);

        }

}


