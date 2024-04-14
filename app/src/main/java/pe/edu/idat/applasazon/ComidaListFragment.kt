package pe.edu.idat.applasazon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import pe.edu.idat.applasazon.Adapter.ComidaAdapter
import pe.edu.idat.applasazon.Models.ComidaModel


class ComidaListFragment : Fragment() {

    private lateinit var dbref: DatabaseReference
    private lateinit var comidaRecyclerView: RecyclerView
    private lateinit var comidaArrayList: ArrayList<ComidaModel>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el diseño para este fragmento
        val view = inflater.inflate(R.layout.fragment_comida_list, container, false)

        // Inicializa los componentes del RecyclerView
        comidaRecyclerView = view.findViewById(R.id.rvcomida)
        comidaRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        comidaRecyclerView.setHasFixedSize(true)
        comidaArrayList = arrayListOf<ComidaModel>()

        // Inicia la carga de datos
        getComidaData()

        return view
    }

    private fun getComidaData() {
        dbref = FirebaseDatabase.getInstance().getReference("menu")
        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    comidaArrayList.clear()
                    for (comidaSnapshot in snapshot.children) {
                        val comida = comidaSnapshot.getValue(ComidaModel::class.java)
                        comidaArrayList.add(comida!!)
                    }
                    comidaRecyclerView.adapter = ComidaAdapter(requireContext(), comidaArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Manejo de errores
            }
        })
    }



}