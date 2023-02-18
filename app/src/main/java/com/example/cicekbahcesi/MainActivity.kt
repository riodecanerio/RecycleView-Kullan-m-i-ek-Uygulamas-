package com.example.cicekbahcesi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import com.example.cicekbahcesi.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cicek_karti.view.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var constList=ArrayList<Cicekler>()
    var adapter:CiceklerAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        constList.add(Cicekler("Gül","Açıklama",R.drawable.gul))
        constList.add(Cicekler("Kasimpati","Açıklama",R.drawable.kasimpati))
        constList.add(Cicekler("Lale","Açıklama",R.drawable.lale))
        constList.add(Cicekler("Menekşe","Açıklama",R.drawable.menekse))
        constList.add(Cicekler("Nergis","Açıklama",R.drawable.nergis))
        constList.add(Cicekler("Orkide","Açıklama",R.drawable.orkide))
        constList.add(Cicekler("Ortanca","Açıklama",R.drawable.ortanca))
        constList.add(Cicekler("Papatya","Açıklama",R.drawable.papatya))

        adapter=CiceklerAdapter(this, constList)
        listView.adapter=adapter

    }

    class CiceklerAdapter: BaseAdapter {
        var constList=ArrayList<Cicekler>()
        var context:Context?=null

        constructor(context: Context, constList:ArrayList<Cicekler>) : super() {
            this.constList = constList
            this.context = context
        }


        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var posCicekler = constList[position]
            var inflator =context!!.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var cicekKarti =inflator.inflate(R.layout.cicek_karti,null)
            cicekKarti.kartAdi.text=posCicekler.constAdi
            cicekKarti.kartAciklama.text=posCicekler.constAciklama
            cicekKarti.kartResim.setImageResource(posCicekler.constResim!!)

            return cicekKarti
        }

        override fun getItem(position: Int): Any {
            return constList[position]
        }


        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return constList.size
        }



    }

}