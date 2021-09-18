package com.hk.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat

class CustomView(context: Context, attrs: AttributeSet): View(context,attrs) {

    private var centerOfX =  340F
    private var centerOfY =  340F
    private var radiusOfCircleView =  140F
    override fun onDraw(canvas: Canvas?) {
        filledCircle(canvas)
        strokeCircle(canvas)
        drawRectangle(canvas)
        drawOneSideRoundAndOnseSideTriangleButton(canvas)
        //canvas.drawColor()
        super.onDraw(canvas)
    }

    private fun drawOneSideRoundAndOnseSideTriangleButton(canvas: Canvas?) {
        val paint = Paint().apply {
            color = ContextCompat.getColor(context,android.R.color.holo_blue_bright)
            strokeWidth = 10f
            style = Paint.Style.FILL
            isAntiAlias = true
        }
        canvas?.drawLines(
                floatArrayOf(200F, 1000F, 500F, 1000F,
                200F, 1000F, 200F, 1200F,
                200F, 1200F, 500F, 1200F),
                paint
        )
        //canvas?.drawRect(RectF(200F, 1000F, 600F, 1200F), paint)
        canvas?.drawArc(RectF(200F, 1000F, 700F, 1200F), 300F, 120F, false, paint)
    }

    private fun drawRectangle(canvas: Canvas?) {
        val paint = Paint().apply {
            color = ContextCompat.getColor(context,android.R.color.holo_green_light)
            strokeWidth = 40f
            style = Paint.Style.FILL
        }
        //canvas?.drawRect(RectF(700F, 700F, 900F, 900F), paint)
        //canvas?.drawRect(RectF(200F, 1000F, 600F, 1200F), paint)
//        RectF(200F, 1000F, 760F, 1200F)
//        canvas?.drawArc(RectF(700F, 700F, 900F, 900F), 270F, 180F, true, paint)
    }

    private fun filledCircle(canvas: Canvas?) {
        val paint = Paint().apply {
            color = ContextCompat.getColor(context,android.R.color.holo_green_light)
            strokeWidth = 40f
            style = Paint.Style.FILL
        }
        canvas?.drawCircle(centerOfX,centerOfY,radiusOfCircleView,paint)
    }

    private fun strokeCircle(canvas: Canvas?) {
        val paint = Paint().apply {
            color = ContextCompat.getColor(context,android.R.color.holo_blue_light)
            strokeWidth = 40f
            style = Paint.Style.STROKE
        }
        canvas?.drawCircle(centerOfX,centerOfY,radiusOfCircleView,paint)
    }
}