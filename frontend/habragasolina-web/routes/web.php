<?php
use App\Http\Controllers\GasStationController;
use Illuminate\Support\Facades\Route;

Route::get('/', [GasStationController::class, 'index']);
Route::get('/login');
Route::get('/admin-page', function () {
    $data = [
        [
            "id" => 1,
            "name" => "Gasolina Especial"
        ],
        [
            "id" => 2,
            "name" => "Gasolina Premium"
        ]
    ];

    return view('admin-page', compact('data'));
});
