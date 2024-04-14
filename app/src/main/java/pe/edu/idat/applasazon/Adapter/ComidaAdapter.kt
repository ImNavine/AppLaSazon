package pe.edu.idat.applasazon.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.edu.idat.applasazon.Models.ComidaModel
import pe.edu.idat.applasazon.R

class ComidaAdapter(private val context: Context,
    private val comidaList: ArrayList<ComidaModel>): RecyclerView.Adapter<ComidaAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvnomcomida : TextView = itemView.findViewById(R.id.tvnomcomida)
        val tvdescripcioncomida : TextView = itemView.findViewById(R.id.tvdescomida)
        val tvpreciocomida : TextView = itemView.findViewById(R.id.tvpreciocomida)
        val ivimage : ImageView = itemView.findViewById(R.id.ivcomida)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView  = LayoutInflater.from(parent.context).inflate(
            R.layout.comida_list,
            parent, false
        )
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return comidaList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem= comidaList[position]
        holder.tvnomcomida.text = currentitem.nombre
        holder.tvdescripcioncomida.text = currentitem.descripcion
        holder.tvpreciocomida.text = currentitem.precio.toString()

        Glide.with(context)
            .load(currentitem.image)
            .into(holder.ivimage)
    }
    }
