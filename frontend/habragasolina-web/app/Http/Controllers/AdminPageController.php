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

    public function updateStatus(Request $request)
    {
        // Validate the form inputs
        $request->validate([
            'idGasStation' => 'required|integer',
            'idFuelType' => 'required|integer',
            'idStatus' => 'required|integer',
        ]);

        $apiUrl = 'http://localhost:8080/gasstation/' . $request->idGasStation  . '/availability';
        $response = Http::post($apiUrl, [
            'idFuelType' => $request->idFuelType,
            'idStatus' => $request->idStatus,
        ]);

        if ($response->ok()) {
            return redirect()->back()->with('success', 'Estado actualizado correctamente.');
        } else {
            return redirect()->back()->withErrors(['message' => 'Invalid values']);
        }
    }
}
