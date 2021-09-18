package com.hk.customview

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
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

        attributeArray.let {
            setStyle(
                hkButtonStyle {
                    text = it.getString(R.styleable.HKButton_text)
                    backgroundColor = it.getColor(R.styleable.HKButton_backgroundColor, -1)
                    backgroundAlpha = it.getColor(R.styleable.HKButton_backgroundAlpha, -1)
                    isBorder = it.getBoolean(R.styleable.HKButton_isBorder, false)
                    borderColor = it.getColor(R.styleable.HKButton_borderColor, -1)
                    borderStroke = it.getColor(R.styleable.HKButton_borderStroke, -1)
                    isIcon = it.getBoolean(R.styleable.HKButton_isIcon, false)
                    rippleColor = it.getColor(R.styleable.HKButton_rippleColor, -1)
                    iconPosition = IconPosition.values()[it.getInt(R.styleable.HKButton_iconPosition, 0)]
                    iconDrawable = it.getDrawable(R.styleable.HKButton_iconDrawable)
                }
            )
        }
        attributeArray.recycle()
    }

    enum class IconPosition {
        RIGHT, LEFT
    }

    private fun setStyle(hkButtonStyle: HKButtonStyle) {
        (getChildAt(0) as MaterialButton).run {
            hkButtonStyle.backgroundColor?.let {
                this.setBackgroundColor(it)
            }
            hkButtonStyle.text?.let {
                this.text = it
            }
            hkButtonStyle.isBorder?.let { isBorder ->
                if(isBorder) {
                    hkButtonStyle.borderColor?.let {
                        if(it!=-1) {
                            this.strokeColor = ColorStateList.valueOf(it)
                        }
                    }
                    hkButtonStyle.borderStroke?.let {
                        if(it!=-1) {
                            this.strokeWidth = it
                        }
                    }
                }
            }
            hkButtonStyle.rippleColor?.let {
                if(it != -1) {
                    this.rippleColor = ColorStateList.valueOf(it)
                }
            }
            hkButtonStyle.isIcon?.let { isIcon ->
                if(isIcon) {
                    hkButtonStyle.iconDrawable?.let {
                        this.icon = it
                        this.iconGravity = MaterialButton.ICON_GRAVITY_START
                    }
                }
            }
        }
    }
}

class HKButtonStyle {
    var text: String? = null
    var backgroundColor: Int? = null
    var backgroundAlpha: Int? = null
    var isBorder: Boolean? = null
    var borderColor: Int? = null
    var borderStroke: Int? = null
    var isIcon: Boolean? = null
    var rippleColor: Int? = null
    var iconDrawable: Drawable? = null
    var iconPosition : HKButton.IconPosition? = null
}

fun hkButtonStyle(lambda : HKButtonStyle.() -> (Unit)) : HKButtonStyle {
    val hkButtonStyle = HKButtonStyle()
    hkButtonStyle.lambda()
    return hkButtonStyle
}