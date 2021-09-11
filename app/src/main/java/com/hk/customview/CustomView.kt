package com.hk.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat

class CustomView(context: Context, attrs: AttributeSet): View(context,attrs) {

    private var paint: Paint = Paint()
    var centerOfX =  340F
    var centerOfY =  340F
    var radiusOfCircleView =  140F
    init {
        paint.color = ContextCompat.getColor(context,android.R.color.holo_green_light)
        paint.strokeWidth = 40f
        paint.style = Paint.Style.STROKE// Constructor Call
    }
    override fun onDraw(canvas: Canvas?) {
        canvas?.drawCircle(centerOfX,centerOfY,radiusOfCircleView,paint)
        super.onDraw(canvas)
    }
}