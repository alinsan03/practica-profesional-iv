<?php
use App\Http\Controllers\GasStationController;
use App\Http\Controllers\AdminPageController;
use App\Http\Controllers\GasStationLoginController;
use Illuminate\Support\Facades\Route;

Route::get('/', [GasStationController::class, 'index']);
Route::get('/gas-station-login', [GasStationLoginController::class, 'index']);
Route::get('/admin-page', [AdminPageController::class, 'index']);
