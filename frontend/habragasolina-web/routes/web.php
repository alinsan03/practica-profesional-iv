<?php
use App\Http\Controllers\GasStationController;

Route::get('/', [GasStationController::class, 'index']);
