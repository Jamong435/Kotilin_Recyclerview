package com.kim9212.ex91kotlinrecyclerviewapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_view.view.*

class MyAdapter constructor(val context: Context, var items: ArrayList<ItemVO>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val layoutInflater = LayoutInflater.from(context)
        val itemView = layoutInflater.inflate(R.layout.recycler_view, parent, false)
        val vh = VH(itemView)
        return vh


    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val vh = holder as VH//코틀린 형변환 연산자 as

        val item = items.get(position)
        vh.itemView.tvTitle.setText(item.title)
        //vh.itemView.tvmsg.setText(item.msg)//원래 vh에 다써야하는데 여기다가 그냥 쫙써버림

        //코틀린에서는 세터를싫어해서 멤버변수(property)로지정해놨음
        vh.itemView.tvmsg.text = item.msg
        //glide와 같은역활을하는 picasso라이브러리 사용
        Picasso.get().load(item.img).into(vh.itemView.iv)

        //코틀린에서는 이 위치에서 itemView의 클릭이벤트 처리함.
//        vh.itemView.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(v: View?) {
//                //아이템의상세정보페이지 화면으로 이동
//
//            }
//
//        })


    }

    inner class VH constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            //자바에서는 이생성자에서 getlayoutpositon메소드로 클릭한 아이템
            //코틀린에서는 getlayoutpostion()대신에 이아답터에 멤버변수로
            //근데 layoutpositon 속성값이 언제나나 항상-1dla..
            //이곳에서 클릭위치를찾을수가없음
            //그래서 아이템의 위치정보가 존재하는 bindviewholder()에서 실행
            itemView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    val intent = Intent(context, ItemActivity::class.java)
                    intent.putExtra("title", items.get(layoutPosition).title)
                    intent.putExtra("title", items.get(layoutPosition).msg)
                    intent.putExtra("title", items.get(layoutPosition).img)
                  context.startActivity(intent)
                }
            })
//        }

        }
    }

}

//inner clas ViewHolder클래스: itemView안의 뷰들을 관리하는 클래스스


