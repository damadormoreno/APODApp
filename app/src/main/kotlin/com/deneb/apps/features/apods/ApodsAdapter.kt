package com.deneb.apps.features.apods

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.deneb.apps.R
import com.deneb.apps.core.extension.inflate
import com.deneb.apps.core.extension.loadFromUrl
import kotlinx.android.synthetic.main.row_apod.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import javax.inject.Inject
import kotlin.properties.Delegates
import com.deneb.apps.core.extension.extractYTId
import com.deneb.apps.core.extension.setTypefaceQuickSandBold
import com.deneb.apps.core.navigation.Navigator


class ApodsAdapter
@Inject constructor(): RecyclerView.Adapter<ApodsAdapter.ViewHolder>() {

    internal var collection: List<ApodView> by Delegates.observable(emptyList()) {
        _, _, _ -> notifyDataSetChanged()
    }

    internal var clickListener: (ApodView) -> Unit = { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(parent.inflate(R.layout.row_apod))

    override fun getItemCount(): Int = collection.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(collection[position], clickListener)
        if (collection.size == position + 1) {
            //TODO: Cargar más apods
            Log.d("Cargar", "Llamada")
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(apodView: ApodView, clickListener: (ApodView) -> Unit) {
            if (apodView.media_type.equals("video")) {
                itemView.ivYTPlayer.visibility = View.VISIBLE
                itemView.ivApod.loadFromUrl("http://img.youtube.com/vi/${apodView.url.extractYTId()}/mqdefault.jpg")
            } else {
                itemView.ivYTPlayer.visibility = View.GONE
                itemView.ivApod.loadFromUrl(apodView.url)
            }
            itemView.tvTitle.text = apodView.title
            itemView.tvTitle.setTypefaceQuickSandBold()
            itemView.setOnClickListener {
                clickListener(apodView)
            }
        }

    }
}