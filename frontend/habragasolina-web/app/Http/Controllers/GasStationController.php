<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http; // Usamos Http para hacer peticiones HTTP

class GasStationController extends Controller
{
    public function index()
    {
        // Llamada al API del backend
        $response = Http::get('http://localhost:8080/gasstations/availability');

        // Verificamos si la respuesta fue exitosa
        if ($response->successful()) {
            $gasStations = $response->json(); // Convertimos la respuesta a un array JSON
            return view('welcome', compact('gasStations')); // Pasamos los datos a la vista.
        }

        return view('welcome', ['gasStations' => []]); // En caso de error, pasamos un array vacío
    }
}
