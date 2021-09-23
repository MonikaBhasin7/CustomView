package com.hk.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.view.View.MeasureSpec
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


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredWidth = 1500
        val desiredHeight = 1500
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        println("widthMode - $widthMode")
        println("widthSize - $widthSize")
        println("heightMode - $heightMode")
        println("heightSize - $widthMode")

        val width: Int
        val height: Int

        //Measure Width
        width = when (widthMode) {
            MeasureSpec.EXACTLY -> {
                //Must be this size
                widthSize
            }
            MeasureSpec.AT_MOST -> {
                //Can't be bigger than...
                Math.min(desiredWidth, widthSize)
            }
            else -> {
                //Be whatever you want
                desiredWidth
            }
        }

        /* Measure Height */
        height = when (heightMode) {
            MeasureSpec.EXACTLY -> {
                //Must be this size
                heightSize
            }
            MeasureSpec.AT_MOST -> {
                //Can't be bigger than...
                Math.min(desiredHeight, heightSize)
            }
            else -> {
                //Be whatever you want
                desiredHeight
            }
        }

        //MUST CALL THIS
        setMeasuredDimension(width, height)
    }
}