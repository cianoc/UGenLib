Nearest_Even {
    *kr {
        arg val;
        var val_floor, val_ceil, res, distance;
        val_floor = val.floor;
        val_ceil = val.ceil;
        res = Select.kr (val % 2,
            [ val_floor, val_ceil ],
        );
        distance = (val - res).abs;
        ^[ res, distance ];
    }
}

Nearest_Odd {
    *kr {
        arg val;
        var val_floor, val_ceil, res, distance;
        val_floor = val.floor;
        val_ceil = val.ceil;
        res = Select.kr (val + 1 % 2,
            [ val_floor, val_ceil ],
        );
        distance = (val - res).abs;
        ^[ res, distance ];
    }
}