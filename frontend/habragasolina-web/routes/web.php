<?php

use App\Http\Controllers\LoginController;
use App\Http\Controllers\GasStationController;
use Illuminate\Support\Facades\Route;

Route::get('/', [GasStationController::class, 'index']);
Route::get('/login', function () {
    return view('login'); // Asegúrate de tener el archivo resources/views/login.blade.php
})->name('login');

// Acción del login
Route::post('/login', [LoginController::class, 'login'])->name('login.action');

