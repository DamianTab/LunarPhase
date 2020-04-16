package com.example.lunarphase

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.Serializable
import java.time.LocalDate
import kotlin.math.round
import com.example.lunarphase.R.drawable as d


class Moon : Serializable {

    var isNorthSide: Boolean = true
    @RequiresApi(Build.VERSION_CODES.O)
    var date: LocalDate = LocalDate.now()
    var algorithm: Algorithm = Algorithm.Simple

    var northBeginningPhasePhotos: List<Int> = listOf(
        d.n_b_0_4,
        d.n_b_2_8,
        d.n_b_7_3,
        d.n_b_13_5,
        d.n_b_21,
        d.n_b_29_5,
        d.n_b_38_6,
        d.n_b_48,
        d.n_b_57_4,
        d.n_b_66_7,
        d.n_b_75_4,
        d.n_b_83_3,
        d.n_b_90,
        d.n_b_95_3,
        d.n_b_98_7
    )
    var northEndingPhasePhotos: List<Int> = listOf(
        d.n_e_0_1,
        d.n_e_1_2,
        d.n_e_4_5,
        d.n_e_10,
        d.n_e_17_5,
        d.n_e_26_8,
        d.n_e_37_3,
        d.n_e_48_6,
        d.n_e_60,
        d.n_e_71,
        d.n_e_80_8,
        d.n_e_89,
        d.n_e_95,
        d.n_e_98_7,
        d.n_e_99_9
    )
    var southBeginningPhasePhotos: List<Int> = listOf(
        d.s_b_0_1,
        d.s_b_1_4,
        d.s_b_5_4,
        d.s_b_11_7,
        d.s_b_19_7,
        d.s_b_28_9,
        d.s_b_38_7,
        d.s_b_48_7,
        d.s_b_58_5,
        d.s_b_67_7,
        d.s_b_76_2,
        d.s_b_83_8,
        d.s_b_90_1,
        d.s_b_95,
        d.s_b_98_3,
        d.s_b_99_8
    )
    var southEndingPhasePhotos: List<Int> = listOf(
        d.s_e_0_1,
        d.s_e_0_2,
        d.s_e_0_4,
        d.s_e_3,
        d.s_e_8_3,
        d.s_e_15_9,
        d.s_e_25_4,
        d.s_e_36_1,
        d.s_e_47_4,
        d.s_e_58_5,
        d.s_e_69_1,
        d.s_e_78_5,
        d.s_e_86_4,
        d.s_e_92_7,
        d.s_e_97,
        d.s_e_99_4
    )

    fun receivePhotoId(phaseDay: Double): Int {
        return if (phaseDay <= 15) {
            if (isNorthSide) {
                northBeginningPhasePhotos[normalizeLength(phaseDay, northBeginningPhasePhotos)]
            } else {
                southBeginningPhasePhotos[normalizeLength(phaseDay, southBeginningPhasePhotos)]
            }
        } else {
            if (isNorthSide) {
                northEndingPhasePhotos[normalizeLength(phaseDay, northEndingPhasePhotos)]
            } else {
                southEndingPhasePhotos[normalizeLength(phaseDay, southEndingPhasePhotos)]
            }
        }
    }

    private fun normalizeLength(phaseDay: Double, list: List<Int>): Int {
        return round(phaseDay / 29 * list.size).toInt()
    }
}

