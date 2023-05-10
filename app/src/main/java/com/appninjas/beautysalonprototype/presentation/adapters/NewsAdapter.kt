package com.appninjas.beautysalonprototype.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appninjas.beautysalonprototype.databinding.NewsItemBinding
import com.appninjas.domain.model.News
import com.squareup.picasso.Picasso
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class NewsAdapter(private val newsList: ArrayList<News>) : RecyclerView.Adapter<NewsAdapter.Holder>() {

    inner class Holder(view: View, private val binding: NewsItemBinding) : RecyclerView.ViewHolder(view) {
        fun bind(model: News) {
            with(binding) {
                newsTitleText.text = model.newsTitle
                newsDate.text = detectDate(model.newsDate)
                Picasso.get().load(model.imageUrl).into(binding.newsImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = NewsItemBinding.inflate(LayoutInflater.from(parent.context))
        return Holder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount(): Int = newsList.size

    private fun detectDate(inputDate: String): String {
        val dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE
        val date = LocalDate.parse(inputDate, dateFormatter)

        val today = LocalDate.now()
        val yesterday = today.minusDays(1)

        return if (today == date) {
            "Сегодня"
        } else if (date == yesterday) {
            "Вчера"
        } else {
            inputDate
        }
    }

}