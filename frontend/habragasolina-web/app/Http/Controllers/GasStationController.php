<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

class GasStationController extends Controller
{
    public function index()
    {

        $response = Http::get('http://localhost:8080/gasstation/availability');


        if ($response->successful()) {
            $gasStations = $response->json(); 
            return view('main', compact('gasStations')); 
        }

        return view ('main', ['gasStations' => []]); 
    }
}
