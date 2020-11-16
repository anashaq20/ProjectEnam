package upnvjt.android.projectenam

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import androidx.appcompat.view.menu.ListMenuItemView
import kotlinx.android.synthetic.main.activity_phone_detail.view.*
import kotlinx.android.synthetic.main.contact_list_item.*
import kotlinx.android.synthetic.main.contact_list_item.view.*
import java.util.zip.Inflater


class ContactAdapter (val phoneItemList: List<PhoneData>, val clickListener : (PhoneData) -> Unit) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.contact_list_item, parent, false)
        return PartViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).ikat(phoneItemList[position], clickListener)
    }

    override fun getItemCount() = phoneItemList.size

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun ikat(phone : PhoneData, clickListener: (PhoneData) -> Unit) {
            itemView.tv_part_item_name.text = phone.contactName
            itemView.tv_part_id.text = phone.phone.toString()
            itemView.run { setOnClickListener{clickListener(phone)} }
        }

    }

}