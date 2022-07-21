package my.anna.helloworld

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat

class ColorManager(private val mainActivity: MainActivity) {

    private val editText: EditText = mainActivity.findViewById(R.id.editText)
    private val textView: TextView = mainActivity.findViewById(R.id.textView)
    private val buttonChangeColor: Button = mainActivity.findViewById(R.id.buttonChangeColor)
    private val buttonChangeText: Button = mainActivity.findViewById(R.id.buttonChangeText)
    private val backgroundView: View = mainActivity.findViewById(R.id.backgroundView)

    fun changeColors(){
        if(textView.currentTextColor==ContextCompat.getColor(mainActivity, R.color.nice_view_text)){
            setDarkColors()
        } else {
            setNiceColors()
        }
    }

    fun setDefaultColors(){
        setNiceColors()
    }

    private fun setNiceColors(){
        textView.setTextColor(ContextCompat.getColor(mainActivity, R.color.nice_view_text))
        backgroundView.setBackgroundColor(ContextCompat.getColor(mainActivity,R.color.nice_background))
        buttonChangeColor.setBackgroundResource(R.drawable.rounded_button_nice)
        buttonChangeColor.setTextColor(ContextCompat.getColor(mainActivity,R.color.nice_button_text))
        buttonChangeText.setBackgroundResource(R.drawable.rounded_button_nice)
        buttonChangeText.setTextColor(ContextCompat.getColor(mainActivity,R.color.nice_button_text))
        editText.setHintTextColor(ContextCompat.getColor(mainActivity,R.color.nice_hint))
        editText.backgroundTintList=ContextCompat.getColorStateList(mainActivity, R.color.nice_hint)
        editText.setTextColor(ContextCompat.getColor(mainActivity,R.color.nice_view_text))
    }

    private fun setDarkColors(){
        textView.setTextColor(ContextCompat.getColor(mainActivity, R.color.dark_view_text))
        backgroundView.setBackgroundColor(ContextCompat.getColor(mainActivity,R.color.dark_background))
        buttonChangeColor.setBackgroundResource(R.drawable.rounded_button_dark)
        buttonChangeColor.setTextColor(ContextCompat.getColor(mainActivity,R.color.dark_button_text))
        buttonChangeText.setBackgroundResource(R.drawable.rounded_button_dark)
        buttonChangeText.setTextColor(ContextCompat.getColor(mainActivity,R.color.dark_button_text))
        editText.setHintTextColor(ContextCompat.getColor(mainActivity,R.color.dark_hint))
        editText.backgroundTintList=ContextCompat.getColorStateList(mainActivity, R.color.dark_hint)
        editText.setTextColor(ContextCompat.getColor(mainActivity,R.color.dark_view_text))
    }
}