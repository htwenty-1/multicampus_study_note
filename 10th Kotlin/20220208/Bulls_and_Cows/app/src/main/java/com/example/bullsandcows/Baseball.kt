package com.example.bullsandcows

class Baseball {

    var randomNumber:IntArray = IntArray(3)
    var clear:Boolean = false

    constructor() {
        clear = false
    }

    fun random() {

        // 중복숫자 멋있게 없애기
        val switch = BooleanArray(10)
        for (i in switch.indices) {
            switch[i] = false
        }

        var w = 0
        while(w < 3) {
            val r: Int = (Math.random() * 10).toInt()    // 0 ~ 9
            if (!switch[r]) {
                // 스위치가 모두 false 였는데 r번째가 false면 true로
                switch[r] = true
                randomNumber[w] = r + 1                 // 1 ~ 10
                w++
            }
        }

        for(i in randomNumber.indices) {
            println("random number[$i] = ${randomNumber[i]}")
        }

        /* 이렇게 작성할 수도 있지만 배열의 크기가 늘어나면 코드가 길어져서 비효율적이다!
        while(true) {
            randomNumber[0] = (Math.random() * 10).toInt() + 1      // 1부터 10 사이의 숫자
            randomNumber[1] = (Math.random() * 10).toInt() + 1
            randomNumber[2] = (Math.random() * 10).toInt() + 1

            if(randomNumber[0] != randomNumber[1] &&
                    randomNumber[0] != randomNumber[2] &&
                    randomNumber[1] != randomNumber[2]) {
                break
            }
        }
        */
    }

    // 입력받은 숫자와 랜덤숫자 비교해서 strike와 ball 판정
    fun finding(userNumber:Array<Int>) : Result {
        var strike:Int = 0
        var ball:Int = 0

        // ball
        for (i in userNumber.indices) {
            for (j in userNumber.indices) {
                if (userNumber[i] == randomNumber[j] && i != j) {
                    ball++
                }
            }
        }

        // strike
        for (i in userNumber.indices) {
            if (userNumber[i] == randomNumber[i]) {
                strike++
            }
        }

        return Result(strike, ball)

    }

    // 결과
    fun resultString():String {
        if(clear == true) {
            return "Congratulations!"
        } else {
            return "Retry!"
        }
    }

}

class Result(val strike:Int, val ball:Int) {

}