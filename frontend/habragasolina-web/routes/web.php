<?php
use App\Http\Controllers\GasStationController;
use App\Http\Controllers\AdminPageController;
use Illuminate\Support\Facades\Route;

Route::get('/', [GasStationController::class, 'index']);
Route::get('/login');
Route::get('/admin-page', [AdminPageController::class, 'index']);
Route::post('/admin-page', [AdminPageController::class, 'postStatus']);