package ch24

import kotlin.math.ceil

class P98_2 {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val parkingLogs: MutableMap<String, Int> = mutableMapOf()  // 출입 내역
        val parkingTimes: MutableMap<String, Int> = mutableMapOf() // 누적 주차 시간

        // 누적 주차 시간 계산
        for (record in records) {
            val log = record.split(" ")
            val time = log[0].split(":")
            if (log[2] == "IN") {
                parkingLogs[log[1]] = time[0].toInt() * 60 + time[1].toInt()
            } else {
                // 출차일 때 분 단위로 시간을 계산하고 기존에 시간이 있다면 누적
                val elapsedTime = time[0].toInt() * 60 + time[1].toInt() - parkingLogs[log[1]]!!
                parkingTimes[log[1]] = parkingTimes.getOrDefault(log[1], 0) + elapsedTime
                parkingLogs.remove(log[1])
            }
        }

        // 남아 있는 내역은 23:59로 계산
        for (log in parkingLogs)
            parkingTimes[log.key] = parkingTimes.getOrDefault(log.key, 0) + 23 * 60 + 59 - log.value

        // 키만 추출하여 정수형 기준으로 정렬
        val parkingTimesByKey: List<String> = ArrayList(parkingTimes.keys).sortedWith(naturalOrder())

        // 정렬 키 기준으로 비용 계산하여 정답 구성
        val answer = IntArray(parkingTimesByKey.size)
        for ((i, k) in parkingTimesByKey.withIndex()) {
            // 기본 시간 이내인 경우 기본 요금
            val fee = if (parkingTimes[k]!! <= fees[0])
                fees[1]
            else {
                // 초과분은 단위 시간당 단위 요금으로 계산
                fees[1] +
                        ceil((parkingTimes[k]!! - fees[0]) / fees[2].toDouble()).toInt() * fees[3]
            }
            answer[i] = fee
        }
        return answer
    }
}