package com.hk.customview

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.google.android.material.button.MaterialButton


@SuppressLint("ResourceAsColor")
class HKButton(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    init {
        val inflater = context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.hk_button, this, true)
        val attributeArray: TypedArray = context.theme.obtainStyledAttributes(
            attrs, R.styleable.HKButton, 0, 0)
        val hkButtonStyle: HKButtonStyle
        attributeArray.let {
            setStyle(
                hkButtonStyle {
                    backgroundColor = it.getColor(R.styleable.HKButton_backgroundColor, -1)
                    backgroundAlpha = it.getColor(R.styleable.HKButton_backgroundAlpha, -1)
                    isBorder = it.getBoolean(R.styleable.HKButton_isBorder, false)
                    borderColor = it.getColor(R.styleable.HKButton_borderColor, -1)
                    borderStroke = it.getColor(R.styleable.HKButton_borderStroke, -1)
                    borderAlpha = it.getColor(R.styleable.HKButton_borderAlpha, -1)
                    isIcon = it.getBoolean(R.styleable.HKButton_isIcon, false)
                }
            )
        }
        attributeArray.recycle()
    }

    private fun setStyle(hkButtonStyle: HKButtonStyle) {
        (getChildAt(0) as MaterialButton).run {
            hkButtonStyle.backgroundColor?.let {
                this.setBackgroundColor(it)
                this.text = "Hare Krsna"
            }
        }
    }
}

class HKButtonStyle {
    var backgroundColor: Int? = null
    var backgroundAlpha: Int? = null
    var isBorder: Boolean? = null
    var borderColor: Int? = null
    var borderStroke: Int? = null
    var borderAlpha: Int? = null
    var isIcon: Boolean? = null
}

fun hkButtonStyle(lambda : HKButtonStyle.() -> (Unit)) : HKButtonStyle {
    val hkButtonStyle = HKButtonStyle()
    hkButtonStyle.lambda()
    return hkButtonStyle
}