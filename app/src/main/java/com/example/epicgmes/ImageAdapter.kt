package com.example.epicgmes

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(
    private val imagens: List<Int>,
    private val precos: List<String>
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    class ImageViewHolder(
        val imageView: ImageView,
        val textViewPreco: TextView,
        itemView: View
    ) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageViewHolder {

        val layout = LinearLayout(parent.context)
        layout.orientation = LinearLayout.VERTICAL

        // CORREÇÃO: a página precisa ocupar todo o ViewPager2
        layout.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        val imagem = ImageView(parent.context)

        imagem.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            0,
            1f
        )

        imagem.scaleType = ImageView.ScaleType.CENTER_CROP

        val preco = TextView(parent.context)

        preco.textSize = 18f

        layout.addView(imagem)
        layout.addView(preco)

        return ImageViewHolder(imagem, preco, layout)
    }

    override fun onBindViewHolder(
        holder: ImageViewHolder,
        position: Int
    ) {
        holder.imageView.setImageResource(imagens[position])
        holder.textViewPreco.text = precos[position]
    }

    override fun getItemCount(): Int {
        return imagens.size
    }
}
