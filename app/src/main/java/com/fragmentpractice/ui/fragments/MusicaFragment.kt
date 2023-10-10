package com.fragmentpractice.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fragmentpractice.R
import com.fragmentpractice.adapter.SongAdapter
import com.fragmentpractice.model.Song


class MusicaFragment : Fragment() {
    // TODO: Rename and change types of parameters
   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_musica, container, false)
        val rvMusica: RecyclerView = view.findViewById(R.id.rvMusica)
        rvMusica.layoutManager = LinearLayoutManager(requireContext())
        rvMusica.adapter = SongAdapter(listSongMusic())
        return view
    }

    private fun listSongMusic(): List<Song>{
        val lstSong: ArrayList<Song> = ArrayList()
        lstSong.add(Song(1,R.drawable.intheend,"In the End", "Hybrid Theory","10,000","3:36"))
        lstSong.add(Song(2,R.drawable.numb,"Numb", "Meteora","9,000","3:05"))
        lstSong.add(Song(3,R.drawable.whativedone,"What I´ve Done", "Minutes to Midnight","8,300","7:36"))
        lstSong.add(Song(4,R.drawable.onestepcloser,"One Step Closer", "Hybrid Theory","24,000","6:36"))
        lstSong.add(Song(5,R.drawable.castleofglass,"Castle Of Glass", "Living THings","30,000","5:36"))

    return lstSong
    }
}