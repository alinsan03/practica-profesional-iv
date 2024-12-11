<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

class GasStationLoginController extends Controller
{
    public function index()
    {
        return view('gas-station-login');
    }

    public function login()
    {

    }
}
