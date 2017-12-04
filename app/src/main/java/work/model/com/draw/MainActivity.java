package work.model.com.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CustomView1(this));
    }
    class CustomView1 extends View {
        Paint paint;
        public CustomView1(Context context) {
            super(context);
            paint= new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            paint.setStrokeWidth(20); // 线条宽度为 20 像素
              /*Style 具体来说有三种FILL, STROKE 和 FILL_AND_STROKE 。
             FILL 是填充模式，
             STROKE 是画线模式（即勾边模式），
             FILL_AND_STROKE 是两种模式一并使用：既画线又填充。
             它的默认值是 FILL，填充模式。*/
            paint.setStyle(Paint.Style.STROKE); // Style 修改为画线模式

            paint.setStrokeWidth(20);
            paint.setStrokeCap(Paint.Cap.ROUND);



        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawColor(Color.parseColor("#88880000"));
            canvas.drawCircle(300, 300, 200, paint);
            canvas.drawCircle(600, 300, 200, paint);
            canvas.drawRect(100, 100, 500, 500, paint);

            canvas.drawPoint(50, 50, paint);

            float[] points = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};
// 绘制四个点：(50, 50) (50, 100) (100, 50) (100, 100)
            canvas.drawPoints(points, 2 /* 跳过两个数，即前两个 0 */,
                    8 /* 一共绘制 8 个数（4 个点）*/, paint);


            paint.setStyle(Paint.Style.FILL);
            canvas.drawOval(50, 50, 350, 200, paint);

        }
    }
}
