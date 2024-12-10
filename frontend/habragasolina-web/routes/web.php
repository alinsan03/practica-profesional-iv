<?php

use Illuminate\Support\Facades\Route;


Route::get('/', function () {
    $data = [
        [
            "name" => "Prueba",
            "location" => "Por ahi",
            "gasolina" => 1,
            "dateGasolina" => "2024-12-04T00:00:00",
            "premium" => 2,
            "datePremium" => "2024-12-01T00:00:00",
            "diesel" => 3,
            "dateDiesel" => "2024-12-04T00:00:00",
        ],
        [
            "name" => "Dragon",
            "location" => "El Alto",
            "gasolina" => null,
            "dateGasolina" => null,
            "premium" => null,
            "datePremium" => null,
            "diesel" => null,
            "dateDiesel" => null,
        ]
    ];
    
    return view('main', compact('data'));
});