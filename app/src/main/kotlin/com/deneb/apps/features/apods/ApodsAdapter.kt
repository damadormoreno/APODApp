package com.deneb.apps.features.apods

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.deneb.apps.R
import com.deneb.apps.core.extension.inflate
import com.deneb.apps.core.extension.loadFromUrl
import kotlinx.android.synthetic.main.row_apod.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

class ApodsAdapter
@Inject constructor(): RecyclerView.Adapter<ApodsAdapter.ViewHolder>() {

    internal var collection: List<ApodView> by Delegates.observable(emptyList()) {
        _, _, _ -> notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(parent.inflate(R.layout.row_apod))

    override fun getItemCount(): Int = collection.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(collection[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(apodView: ApodView) {
            itemView.ivApod.loadFromUrl(apodView.url)
            itemView.tvTitle.text = apodView.title
        }
    }


}