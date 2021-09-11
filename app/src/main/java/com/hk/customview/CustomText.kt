package com.hk.customview

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

class CustomText : androidx.appcompat.widget.AppCompatTextView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet): super(context, attrs)
}