package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ed_name = findViewById<EditText>(R.id.ed_name)
        val tv_text = findViewById<TextView>(R.id.tv_text)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        val tv_winner = findViewById<TextView>(R.id.tv_winner)
        val tv_mmora = findViewById<TextView>(R.id.tv_mmora)
        val tv_cmora = findViewById<TextView>(R.id.tv_cmora)
        val btn_scissor = findViewById<RadioButton>(R.id.btn_scissor)
        val btn_stone = findViewById<RadioButton>(R.id.btn_stone)
        val btn_paper = findViewById<RadioButton>(R.id.btn_paper)
        val btn_mora = findViewById<Button>(R.id.btn_mora)

        btn_mora.setOnClickListener{
            if (ed_name.length()<1)
                tv_text.text = ("請輸入玩家名稱");
            else {
                tv_name.text = (String.format("名字\n%s", ed_name.getText().toString()));
                if (btn_scissor.isChecked)
                    tv_mmora.text = ("我方出拳\n剪刀")
                else if (btn_stone.isChecked)
                    tv_mmora.text = ("我方出拳\n石頭")
                else
                    tv_mmora.text = ("電腦出拳\n布")

                var app1 = (Math.random()*3).toInt()
                if (app1 ==0)
                    tv_cmora.text = ("電腦出拳\n剪刀")
                else if (app1 ==1)
                    tv_cmora.text = ("電腦出拳\n石頭")
                else tv_cmora.setText("電腦出拳\n布")
                if (btn_scissor.isChecked()&& app1 == 2 ||
                    btn_stone.isChecked() && app1 == 0 ||
                    btn_paper.isChecked() && app1 ==1 ){
                    tv_winner.text = (
                            """
                            勝利者
                            ${ed_name.getText()}
                            """.trimIndent())
                    tv_text.text = ("恭喜你獲勝!!")
                }
                else if (btn_scissor.isChecked() && app1 == 1 ||
                    btn_stone.isChecked() && app1 == 2 ||
                    btn_paper.isChecked() && app1 == 0
                ) {
                    tv_winner.setText("勝利者\n電腦")
                    tv_text.setText("可惜,電腦獲勝了!")
                } else {
                    tv_winner.setText("勝利者\n平手")
                    tv_text.setText("平局,請再試一次!")
                }


            }
        }
    }
}