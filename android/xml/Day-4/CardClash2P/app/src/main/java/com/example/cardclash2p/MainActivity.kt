package com.example.cardclash2p

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var score1 = 0
    var score2 = 0
    var round = 1
    var turn = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val player_1_score_tv : TextView = findViewById(R.id.player_1_score_tv)
        val player_2_score_tv : TextView = findViewById(R.id.player_2_score_tv)
        val player_turns_tv : TextView = findViewById(R.id.player_turns_tv)
        val card1_iv : ImageView = findViewById(R.id.card1_iv)
        val card2_iv : ImageView = findViewById(R.id.card2_iv)
        val draw_card_btn : Button = findViewById(R.id.draw_card_btn)
        val round_tv : TextView = findViewById(R.id.round_tv)
        var card1 = 0
        var card2 = 0
        draw_card_btn.setOnClickListener {
            if(round == 1){
                score1 = 0
                score2 = 0
                updateScores(player_1_score_tv,player_2_score_tv,score1,score2)
            }
            round_tv.text = "$round / 5"
            val randomInt = (0..9).random()
            if (turn == 1){
                card1 = randomInt
                turn++
                draw_card_btn.text = "Player 2: Draw Card"
                player_turns_tv.text = "Player 2's Turn"
                changeCardNumber(card1_iv,randomInt)


            }else if(turn == 2){
                card2 = randomInt
                turn++
                draw_card_btn.text = "Go to round ${++round}"
                changeCardNumber(card2_iv,randomInt)
                player_turns_tv.setTextColor(Color.parseColor("#FFB13B"))
                if(card1 > card2){
                    player_turns_tv.text = "Player 1 Wins!! \nالف مبروك يخويا انت اللي كسبت الراوند دي"
                    score1 += 10
                }else if( card2 > card1 ){
                    player_turns_tv.text = "Player 2 Wins!! \nالف مبروك يخويا انت اللي كسبت الراوند دي"
                    score2 += 10
                }else {
                    score1 += 10 ; score2 += 10
                    player_turns_tv.text = "تعادل يخواتي الراوند دي ):"

                }
                updateScores(player_1_score_tv,player_2_score_tv,score1,score2)
                draw_card_btn


                if( round == 6 ){
                    if(score1 > score2){

                        draw_card_btn.text = "Player 1 is Wineer الف مبروك يخويا"
                        player_turns_tv.text = "We Have a wineer congrats Player 1"
                    }else if(score2 > score1){
                        draw_card_btn.text = "Player 2 is Wineer الف مبروك يخويا"
                        player_turns_tv.text = "We Have a wineer..\n\nCongrats Player 2!"
                        player_turns_tv.setTextColor(Color.parseColor("#FFDDB5"))
                    }else{
                        draw_card_btn.text = "متعادلين يخواتي مش لعبة اللي هتخسرنا بعض"
                        player_turns_tv.text = "Draw :)"
                    }
                    round = 1
                }
            }else{
                turn = 1
                card1_iv.setImageResource(R.drawable.question_mark_card)
                card2_iv.setImageResource(R.drawable.question_mark_card)
                draw_card_btn.text = "Player 1's Turn"
                player_turns_tv.setTextColor(Color.parseColor("#22D3EE"))
                player_turns_tv.text = "Player 1's Turn"
                round_tv.text = "$round/5"
            }
        }
    }
    fun changeCardNumber(cardIV : ImageView,randomInt: Int){
        when(randomInt){
            0 -> cardIV.setImageResource(R.drawable.card_0)
            1 -> cardIV.setImageResource(R.drawable.card_1)
            2 -> cardIV.setImageResource(R.drawable.card_2)
            3 -> cardIV.setImageResource(R.drawable.card_3)
            4 -> cardIV.setImageResource(R.drawable.card_4)
            5 -> cardIV.setImageResource(R.drawable.card_5)
            6 -> cardIV.setImageResource(R.drawable.card_6)
            7 -> cardIV.setImageResource(R.drawable.card_7)
            8 -> cardIV.setImageResource(R.drawable.card_8)
            9 -> cardIV.setImageResource(R.drawable.card_9)
        }
    }
    fun updateScores(player_1_score_tv : TextView, player_2_score_tv : TextView, score1 : Int, score2 : Int){
        player_1_score_tv.text = "Player 1: $score1"
        player_2_score_tv.text = "Player 2: $score2"
    }
}