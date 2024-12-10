<?php
use App\Http\Controllers\GasStationController;
use Illuminate\Support\Facades\Route;
Route::get('/', [GasStationController::class, 'index']);