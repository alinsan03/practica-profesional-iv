<?php
use App\Http\Controllers\GasStationController;
use App\Http\Controllers\AdminPageController;
use App\Http\Controllers\GasStationLoginController;
use Illuminate\Support\Facades\Route;

Route::get('/', [GasStationController::class, 'index'])->name('main');;
Route::get('/gas-station-login', [GasStationLoginController::class, 'index'])->name('gasstationlogin');;
Route::post('/gas-station-login/login', [GasStationLoginController::class, 'login'])->name('login');
Route::get('/admin-page', [AdminPageController::class, 'index'])->name('adminpage');;
Route::post('/admin-page/update-status', [AdminPageController::class, 'updateStatus'])->name('updateStatus');
