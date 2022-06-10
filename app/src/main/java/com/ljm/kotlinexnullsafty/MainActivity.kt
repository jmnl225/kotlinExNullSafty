package com.ljm.kotlinexnullsafty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main()
        println(test("test"))
    }

    private fun main(){
        var neverNull: String = "This can't be null"
        neverNull = null // String임이 명시되어있기때문에 null이 될 수 없음

        var nullable: String? = "You can keep a null here"
        nullable = null// ?이 붙어있으므로 null 가능

        var inferredNonNull = "The compiler assumes non-null"
        inferredNonNull = null // inferred type이므로 컴파일에러

        fun strLength(notNull: String): Int{
            return notNull.length
        }

        strLength(neverNull)
        strLength(nullable)
    }

    private fun test(maybeString: String?): String{
        return if (maybeString != null && maybeString.length > 0){
            "String of length ${maybeString.length}"
        }else "Empty or null String"
    }

}