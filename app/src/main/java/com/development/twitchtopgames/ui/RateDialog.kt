package com.development.twitchtopgames.ui

import android.app.Dialog
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.development.twitchtopgames.R

class RateDialog() : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.setTitle("Оценить приложение")
        return inflater.inflate(R.layout.rate_form, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, R.style.ThemeOverlay_AppCompat)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rate: RatingBar = view.findViewById(R.id.ratingBar)
        val comment: EditText = view.findViewById(R.id.comment)
        val rateBtn = view.findViewById<Button>(R.id.rate_btn)
        rateBtn.setOnClickListener {
            Toast.makeText(
                activity,
                "Отзыв отправлен. Оценка ${rate.rating}. Комментарий: ${comment.text}",
                Toast.LENGTH_LONG
            ).show()
            dialog?.dismiss()
        }
    }
}