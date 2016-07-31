package com.ecode.ecar.common.enumeration.car;

import com.ecode.ecar.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by matuszewski on 31/07/16.
 */
public enum CarGearEnumMapper {

    FIRST(R.string.gear_first),
    SECOND(R.string.gear_second),
    THIRD(R.string.gear_third),
    FOURTH(R.string.gear_fourth),
    FIFTH(R.string.gear_fifth),
    SIXTH(R.string.gear_sixth),
    SEVENTH(R.string.gear_seventh),
    EIGHTH(R.string.gear_eighth),
    NEUTRAL(R.string.gear_neutral),
    REVERSE(R.string.gear_reverse);

    private int carGearNumber;

    CarGearEnumMapper(int carGearNumber) {
        this.carGearNumber = carGearNumber;
    }

    public static int getMappedGearValue(int value){
        return CarGearEnumMapper.values()[value].carGearNumber;
    }
}
