<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

class AdminPageController extends Controller
{
    public function index()
    {

        $response = Http::get('http://localhost:8080/fueltype');


        if ($response->successful()) {
            $fueltypes = $response->json(); 
            return view('admin-page', compact('fueltypes')); 
        }

        return view ('admin-page', ['fueltypes' => []]); 
    }
    public function postStatus(Request $request)
    {
        $request->validate([
            'idGasStation' => 'required|integer',
            'idFuelType' => 'required|integer',
            'idStatus' => 'required|integer',
        ]);

        logger('Datos recibidos:', $request->all());

        // Datos para enviar a la API de Spring Boot
        $idGasStation = $request->input('idGasStation');
        
        $data = [
            'idFuelType' => $request->input('idFuelType'),
            'idStatus' => $request->input('idStatus'),
        ];

        logger('Datos enviados a Spring Boot:', $data);

        $response = Http::post('http://localhost:8080/gasstation/'. $idGasStation .'/availability', $data);


        if ($response->successful()) {
            return response()->json([
                'mensaje' => 'Estado actualizado correctamente',
                'respuesta_api' => $response->json(),
            ]);
        }

        return response()->json([
            'error' => 'Error al actualizar el estado en la API de Spring Boot',
            'detalle' => $response->body(),
        ], $response->status());
    }
}
