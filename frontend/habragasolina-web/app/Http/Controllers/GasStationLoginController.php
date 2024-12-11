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

    public function login(Request $request)
    {
        $apiUrl = 'http://localhost:8080/users/login'; // Replace with your API endpoint
        $response = Http::post($apiUrl, [
            'username' => $request->username,
            'password' => $request->password,
        ]);

        if ($response->ok()) {
            $data = $response->json();
            return redirect()->route('adminpage')->with([
                'name' => $data['name'],
                'idGasStation' => $data['id_gas_station'],
            ]);
        } else {
            return redirect()->back()->withErrors(['message' => 'Invalid credentials']);
        }
    }
}
