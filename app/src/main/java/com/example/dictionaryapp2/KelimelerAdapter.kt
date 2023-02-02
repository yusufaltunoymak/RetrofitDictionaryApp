package com.example.dictionaryapp2

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionaryapp2.databinding.CardTasarimBinding

class KelimelerAdapter(val kelimelerListesi : ArrayList<Kelimeler>) : RecyclerView.Adapter<KelimelerAdapter.KelimelerHolder>() {

    class KelimelerHolder(val binding : CardTasarimBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KelimelerHolder {
       val binding = CardTasarimBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return KelimelerHolder(binding)
    }

    override fun onBindViewHolder(holder: KelimelerHolder, position: Int) {
        val kelime = kelimelerListesi.get(position)
        holder.binding.textViewIngilizce.text = kelime.ingilizce
        holder.binding.textViewTurkce.text = kelime.turkce
        holder.binding.kelimeCard.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetayActivity::class.java)
            intent.putExtra("nesne",kelime)
            holder.itemView.context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
       return kelimelerListesi.size
    }
}