package com.kim9212.ex91kotlinrecyclerviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //대량의데이터 property[멤버변수]
    var items= ArrayList<ItemVO>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //원래는 서버에서 데이터를 읽어와야하지만 시간상 그냥 대량의데이타추가


        items.add(ItemVO("sam","icandothis allday",R.drawable.background1))
        items.add(ItemVO("ni","bye allday",R.drawable.background1))
        items.add(ItemVO("fid","hello allday",R.drawable.background1))
        items.add(ItemVO("risk","i need allday",R.drawable.background1))
        items.add(ItemVO("golf","allday",R.drawable.background1))
        items.add(ItemVO("bravo","yahoo",R.drawable.background1))
        items.add(ItemVO("rosa","android hi",R.drawable.background1))
        items.add(ItemVO("sam","icandothis allday",R.drawable.background1))
        items.add(ItemVO("ni","bye allday",R.drawable.background1))
        items.add(ItemVO("fid","hello allday",R.drawable.background1))
        items.add(ItemVO("risk","i need allday",R.drawable.background1))
        items.add(ItemVO("golf","allday",R.drawable.background1))
        items.add(ItemVO("bravo","yahoo",R.drawable.background1))
        items.add(ItemVO("rosa","android hi",R.drawable.background1))

        //코틀린의 Recycler는 setAdapter()를 사용하지않고
        //recyclerview 프로퍼티로서 adpater을 가지고있음
        //그래서 아답터를 굳이 멤버변수로 만들필요가없음.
        recycler.adapter= MyAdapter(this,items)
        //리사이클러뷰에 레이아웃메니저를붙이지않음
        recycler.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }

    override fun onResume() {
        super.onResume()
        //리사이클러뷰 갱신하기
        //recycler.adapter.notifyDataSetChanged()
        //리싸이커러뷰안에 아답터는 이미 가지고있기때문에 이 아답터에 들어있는값으 null아닌지 확인을해야한다

        //멤버변수가 null인지 체크하는기능이있음 실행하는 키워드!
        //!!null 에러가나지않음음
       recycler.adapter!!.notifyDataSetChanged()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_aa-> Toast.makeText(this,"aa",Toast.LENGTH_SHORT).show()
            R.id.menu_bb-> Toast.makeText(this,"bb",Toast.LENGTH_SHORT).show()


        }


        return super.onOptionsItemSelected(item)
    }




}