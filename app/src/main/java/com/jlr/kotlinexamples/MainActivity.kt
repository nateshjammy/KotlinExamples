package com.jlr.kotlinexamples

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val inputString = "Hello World"
        characterCount(inputString)


        /*
        *
        * list --- add only  - read only access
        *
        * mutableList - add remove - read and write access
        *
        * */

        val languageList  = listOf("java", "kotlin")

        val listOfVehicleNames: List<String> = emptyList()

        //toMutableList convert to MutableList
        listOfVehicleNames.toMutableList().add("honda")


        //array list

        val arrayList:ArrayList<String> = ArrayList()
        arrayList.add("payton")
        arrayList.addAll(languageList)



        val mutableLanguage: MutableList<String> = mutableListOf("java", "kotlin", "dart")

        val mutableList = mutableListOf<String>()
        mutableList.add("java")

        val personList = mutableListOf<Person>()
        personList.add(Person("Natesh",26,"Male",false))
        personList.add(Person("balaji",25,"Male",false))
        personList.add(Person("mani",24,"Male",false))
        personList.add(Person("venkatesh",18,"Male",false))
        personList.add(Person("ram",19,"Male",true))
        personList.add(Person("asin",80,"Female",false))
        personList.add(Person("ninethara",90,"Female",false))



        if(personList.size == 7){
            personList.add(Person("sachin",50,"male",false))
        }

        val sortedList = personList.sortedBy { it.age }

        val filteredList: List<Person> = personList.filter { it.connected }





        /*
        * remove First index
        * */

       //personList.removeFirst()

        /*
        * remove First index
        * */
       // personList.removeLast()

        personList.filter { it.age >= 50 }


        val filtered = personList.filter { it.age >= 50 && it.sex == "Female" }

        replaceOrder(personList)

        stack()

        linkedList()

        oddEvenNumberList()

        findSumofArray()

        addNumberinArray()

       /* val numberList:ArrayList<Int> = ArrayList()
        for(i in 1..100){
            numberList.add(i)
        }


        numberList.forEach {
            if(it % 2 == 0){
                Log.d("numberList  Even:","$it")

            }else{
                Log.d("numberList  odd:","$it")

            }
        }*/


        for (item in personList){
            Log.d("personList is:","$item")
        }

    }


    fun addNumberinArray(){

        /*
        *    Input: l1 = [2,4,3], l2 = [5,6,4]
        *    Output: [7,0,8]
        *    Explanation: 342 + 465 = 807.
        *
        * */


        /*
        *
        *
        *  logic     3 * 10  + 4 *10  + 2
        * */

        val numberL1 = arrayOf(2,4,3).reversedArray() // 3,4,2
        val numberL2 = arrayOf(5,6,4).reversedArray() // 4,6,5

        val sum  = (numberL1.get(0) * 10 + numberL1.get(1)) * 10 + numberL1.get(2)  +
                (numberL2.get(0) * 10 + numberL2.get(1)) * 10 + numberL2.get(2)

        Log.d("addNumberinArray is:","$sum")

    }


    fun findSumofArray(){
        /*
        *
        * Input: nums = [2,7,11,15], target = 9    Output: [0,1]
        *
        * */

        val  number = arrayOf(2,7,1,15)
        val target = 9
        val result = mutableListOf<Int>()

        for (i in 0 until number.size) {

            for (j in i +1 until number.size){

                if(number[i]  + number[j] == target){

                    result.add(i)
                    result.add(j)

                }
            }
        }
        result.forEach {
            Log.d("findToSumofArray is:","${it}")
        }
    }

    fun replaceOrder(list: MutableList<Person>): MutableList<Person> {

        list.forEach {
            if(it.connected){
                list.set(0,it)
            }

        }
        list.forEach {
            Log.d("NANA","$it")
        }

/*        for (i in 0 until list.size) {
            val value = list[i]
            if (value.connected) {
                list[i] = value
            }
        }
        list.forEach {
            Log.d("NANA","$it")
        }*/

        return list
    }
    private fun characterCount(inputString: String) {

        /* null check
        * !! - exception through
        * ? - statement block
        * */

        // output Hello World  : h:1 e:1 l:3 o:2 w:1 r:1 d:1
        val charMap = HashMap<Char,Int>()
        val charArray = inputString.toCharArray()

        charArray.forEach {
            if(charMap.containsKey(it)){
                charMap[it] = charMap[it] !! + 1
            }else{
                charMap[it] = 1
            }
        }
        charMap.forEach {
            Log.d("characterCount : ","$it")
        }
    }

    /*
    * pop - last pushed value (last in first out)
    * push - push in to list
    *
    * */

    private fun stack(){

        val  stackList = Stack<Int>()


        stackList.push(1)
        stackList.push(2)
        stackList.push(3)
        stackList.push(4)

        Log.d("stack element:","$stackList")


        val popElement  = stackList.removeFirst() // remove first position
        //val popElement  = stackList.pop() // remove last added value
        //val popElement  = stackList.removeElement(3) // remove particular value

        Log.d("Popped element:","$popElement")
        Log.d("stack element after Remove :","$stackList")

    }

    private fun oddEvenNumberList(){
        val numberList =  listOf(2,5,7,9,11,13,16)

        //output 2, 16, 11, 13, 7, 13, 9

        val result = mutableListOf<Int>()

        val evenNumber = numberList.filter { it % 2 == 0 }.forEach {
            result.add(it)
        }
        val oddNumber = numberList.filter { it % 2 != 0 }.forEach{
            result.add(it)
        }
        result.set(2,11)
        result.set(3,13)
        result.set(4,7)
        result.set(5,13)
        result.set(6,9)

        Log.d("result element:","$result")

    }


    private fun linkedList(){

        //https://www.youtube.com/watch?v=e4hDgvoXqsQ&list=PLYM2_EX_xVvX7_AmNY-Deacp3rT3MIXnE&index=5

        val linkedList = LinkedList<Int>()
    }

}