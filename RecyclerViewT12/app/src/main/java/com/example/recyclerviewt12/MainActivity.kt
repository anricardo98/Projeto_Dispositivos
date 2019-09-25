package com.example.recyclerviewt12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private  var messages = mutableListOf<Message>()
    private var adapter =
        MessageAdapter(messages, this::onMessageItemClick )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
        //return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if(id == R.id.adicionar_add){
            var intent = Intent(this, Main2Activity::class.java)
            intent.putExtra("titulo", "")
            intent.putExtra("Texto", "")
            startActivityForResult(intent, 10)
            return true
        } else{
            return super.onOptionsItemSelected(item)
        }

    }
    fun initRecyclerView(){
        rvMessages.adapter = adapter

        val layoutMAnager = LinearLayoutManager(this)

        rvMessages.layoutManager = layoutMAnager

    }

    fun addMessage(titulo: String?, texto: String?){
        val message = Message(
            titulo,
            texto
        )
        messages.add(message)
        adapter.notifyItemInserted(messages.lastIndex)
    }

    fun onMessageItemClick(message: Message){
        val intent = Intent(this, Main2Activity::class.java)
        intent.putExtra("titulo", message.title)
        intent.putExtra("Texto", message.text)
        startActivityForResult(intent, 20)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 10){
            val title = data?.getStringExtra("titulo")
            val content = data?.getStringExtra("Conteudo")
            addMessage(title, content)

        }else if (requestCode == 20){
            var content = data?.getStringExtra("Conteudo")

        }
    }
}
